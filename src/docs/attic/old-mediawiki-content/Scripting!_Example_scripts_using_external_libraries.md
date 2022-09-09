With external Java libraries you can explore completely new application fields with Freeplane and accomplish amazing things. Remember: Groovy is fully Java compatible, i.e. you can use *any* available Java library.

# General installation instructions for external Java libraries

Java libraries normally come in form of <tt>.jar</tt> files which you have to make known to the application that wants to use them. Here's the way to do that in Freeplane:

1. only before 1.4: Create a folder <tt>lib</tt> in your Freeplane user directory

2. Copy the <tt>.jar</tt> file to that directory.

3. only before 1.4: Start Freeplane and add <tt>lib</tt> to *Preferences -> Plugins -> Scripting -> Script -> Script classpath*, and save.

4. Restart Freeplane

To install further <tt>.jar</tt> files in the future you just have to copy the <tt>.jar</tt> files to that <tt>lib</tt> directory and restart Freeplane.

# Database access: Oracle

Test script that shows how to connect to an Oracle database. Thanks to Pascal [for asking](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4606762).

**Installation instructions:**

1. Save the script to the scripts folder in your Freeplane user directory and edit <tt>USERNAME/PASSWORD</tt> and the rest of the database url appropriately.

2. Follow the instructions at the beginning of this chapter to install [ojdbc14-10.1.0.4.0.jar](http://www.google.com/search?q=oracle+jdbc+driver+download) (or later) to the <tt>lib</tt> directory in your Freeplane user directory

Required permissions: Execute script, read file, network access.
Requires Freeplane 1.2.

<!-- name=databaseTestOracle -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
import java.sql.Connection
import groovy.sql.Sql
import oracle.jdbc.pool.OracleDataSource

// def driver = Class.forName("oracle.jdbc.driver.OracleDriver")
// println driver.name

OracleDataSource ds = new OracleDataSource();
ds.setURL("jdbc:oracle:thin:USERNAME/PASSWORD@//localhost:1521/xe")
def sql = new Sql(ds.getConnection())

def mviews = node.map.root.createChild("materialized views")
sql.eachRow("select * from user_tables where table_name like 'MVIEW%'", { mviews.createChild(it.table_name)} );
```

Author: `boercher`

# Database access: MySQL

Test script that shows how to connect to a MySQL database. Thanks to [Pascal and Michel](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4606762).

**Installation instructions:**

1. Save the script to the scripts folder in your Freeplane user directory and edit database access properties appropriately.

2. Follow the instructions at the beginning of this chapter to install [mysql-connector-java-5.1.17-bin.jar](http://www.google.com/search?q=mysql+jdbc+driver+download) (or similar) to the <tt>lib</tt> directory in your Freeplane user directory

Required permissions: Execute script, read file, network access.
Requires Freeplane 1.2.

<!-- name=databaseTestMysql -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
import java.sql.Connection; 
import groovy.sql.Sql
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource; 

MysqlDataSource ds = new MysqlDataSource(); 

ds.setServerName("localhost"); 
ds.setUser("root"); 
ds.setPassword(""); 
ds.setDatabaseName("cdcol"); 

def sql = new Sql(ds.getConnection())

def titles = node.map.root.createChild("Titles") 
sql.eachRow("select * from cds"){
    titles.createChild(it.title)
}
```

Author: `megatop`, `boercher`

# Database access: SQLite

Test script that shows how to connect to a SQLite database.

**Installation instructions:**

1. Save the script to the scripts folder in your Freeplane user directory and edit database access properties appropriately.

2. Download [sqlite-jdbc-(VERSION).jar](https://www.google.de/?gws_rd=ssl#q=download+sqlite+jdbc) to the <tt>lib</tt> directory in your Freeplane user directory

Required permissions: Execute script, read+write file, network access.
Requires Freeplane 1.3.

<!-- name=databaseTestSqlite -->
```groovy
import java.sql.*;
import org.sqlite.*

try {
  SQLiteDataSource dataSource = new SQLiteDataSource();
  dataSource.setUrl("jdbc:sqlite:test.db");
  def connection = dataSource.getConnection()
  c.statusInfo = "Opened database successfully"
  // ...
} catch (Exception e) {
  e.printStackTrace()
} finally {
  if (connection != null)
    connection.close()
}
```

Author: `boercher`

# JFreeChart: Diagrams and Charts

Example how to use [JFreeChart](http://www.jfree.org/jfreechart) in Freeplane. Thanks to Michel [for asking](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4606762). See also [Gantt chart example](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4611142).

**Installation instructions:**

Follow the instructions at 
[the beginning of this chapter](https://www.freeplane.org/wiki/index.php/Scripting!_Example_scripts#General_installation_instructions_for_external_Java_libraries) 
to install <tt>jfreechart-<version>.jar</tt> and <tt>jcommon-<version>.jar</tt> [(download)](http://www.jfree.org/jfreechart/download.html) to the <tt>lib</tt> directory in your Freeplane user directory

Required permissions: Execute script, read file.
Requires Freeplane 1.2.

<!-- name=jfreechartTest -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.data.general.DefaultPieDataset
import groovy.swing.SwingBuilder
import java.awt.*
import javax.swing.WindowConstants as WC

def piedataset = new DefaultPieDataset();
piedataset.with {
     setValue "Apr", 10
     setValue "May", 30
     setValue "June", 40
}

def options = [true, true, true]
def chart = ChartFactory.createPieChart("Pie Chart Sample",
    piedataset, *options)
chart.backgroundPaint = Color.white
def swing = new SwingBuilder()
def frame = swing.frame(title:'Groovy PieChart',
        defaultCloseOperation:WC.EXIT_ON_CLOSE) {
    panel(id:'canvas') { widget(new ChartPanel(chart)) }
}
frame.pack()
frame.show()
```

Author: `boercher`

And here the script for Gantt chart generation
<!-- name=gantt -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
import groovy.swing.SwingBuilder

import javax.swing.WindowConstants as WC

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

// adapted from http://www.java2s.com/Code/Java/Chart/JFreeChartGanttDemo1.htm

// - - - Test Map: remove leading "// " and copy/paste it into an empty map - -
// Iteration 1
//   Design
//     2011-07-01
//     2011-07-08
//   Implement
//     2011-07-07
//     2011-07-15
//   Test
//     2011-07-12
//     2011-07-22
// Iteration 2
//   Design
//     2011-07-25
//     2011-08-01
//   Implement
//     2011-07-25
//     2011-08-10
//   Test
//     2011-08-01
//     2011-08-12
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

//
// main
//
final IntervalCategoryDataset dataset = createDataset();
final JFreeChart chart = createChart(dataset);

def swing = new SwingBuilder()
def dialog = swing.dialog(title:'Groovy Gantt', locationRelativeTo:ui.frame, owner:ui.frame
        , defaultCloseOperation:WC.DISPOSE_ON_CLOSE) {
    panel(id:'canvas') { widget(new ChartPanel(chart)) }
}
ui.addEscapeActionToDialog(dialog)
dialog.pack()
dialog.show()

// create task data from the map. Note the use of inject
// (see http://insidethemachine.wordpress.com/2009/01/25/injectgroovy/)
def IntervalCategoryDataset createDataset() {
    return node.map.root.children.inject(new TaskSeriesCollection()) { seriesCollection, seriesNode ->
        seriesCollection.add(seriesNode.children.inject(new TaskSeries(seriesNode.to.plain)) { series, taskNode ->
            // real live software will be a bit more permissive
            def dates = taskNode.children.collect{ dateNode -> dateNode.to.date }
            if (dates.size() != 2)
                throw new RuntimeException(taskNode + " does not have exactly 2 date children as expected")
            series.add(new Task(taskNode.to.plain, new SimpleTimePeriod(dates[0], dates[1])))
            series // this is a "return"
        })
        seriesCollection // this is a "return"
    }
}

def JFreeChart createChart(final IntervalCategoryDataset dataset) {
    return ChartFactory.createGanttChart(
        "Gantt Chart Demo"  // chart title
        , "Task"            // domain axis label
        , "Date"            // range axis label
        , dataset           // data
        , true              // include legend
        , true              // tooltips
        , false             // urls
    );
    return chart;
}
```


<!-- ({Category:Script}) -->

