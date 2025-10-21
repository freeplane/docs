<!-- toc -->

## Freeplane does not start

* Check that the java runtime environment is installed. Sun JRE 1.6 or later is recommended.
* Run freeplane.bat (under linux run freeplane.sh) from a shell and look at the output printed there.
If you can not understand the reasons for failure yourself, open a [bug request](https://sourceforge.net/apps/mantisbt/freeplane/set_project.php?project_id=1&make_default=false&ref=bug_report_page.php) and post there the output.

## Freeplane throws out-of-memory exception

You can increase memory available to Freeplane by setting Java VM option -Xmx to higher values

Examples:
`
-Xmx1024M (1024 MB)
-Xmx2G  (2 GB)
-Xmx8G  (8 GB)
`

Depending on your OS the configuration can be changed at different places.
### Windows

To change the maximum Java heap size, add the following line:

```
-Xmx4G
```

to the configuration files used by the Windows launcher:

* `freeplane.cfg` — for the graphical version
* `freeplaneConsole.cfg` — for the console version

They have no syntax like INI or XML — just raw command-line arguments passed directly to the JVM.

These files are located in the same directory as `freeplane.exe` and `freeplaneConsole.exe`, typically:

```
C:\Program Files\Freeplane\
```

If you start Freeplane using `freeplane.bat`, you need to configure this option directly in that script.

### Mac OS
Go to Application==> Left click on specific application (like Weka)==> Show Package Content==> Contents==>app

Edit file Freeplane.cfg ane replace any of lines 

````
java-options=-XX:MaxRAM=...
java-options=-XX:MaxRAMPercentage=...
java-options=-Xmx...
````

by line 

````
java-options=-Xmx4G
````

Save the changes.

### Linux

Edit freeplane.sh and replace -Xmx... by whatever value you need.

## Graphics Issues with the UI

Try disabling the DirectDraw pipeline by adding the following flag to your Freeplane options (freeplane.l4j.ini and freeplaneConsole.l4j.ini on Windows, freeplane.sh on Linux):

````
-Dsun.java2d.noddraw=true
````
For explanations and other configuration options you can try, see [this documentation](https://docs.oracle.com/en/java/javase/22/troubleshoot/java-2d-pipeline-rendering-and-properties.html#GUID-AAB8CC86-652B-4A78-83EB-CDC3F5677A48).

## Performance issues when scrolling/selecting nodes

Try to use OpenGL rendering instead of Direct3D by adding the following flag into your Freeplane options (freeplane.l4j.ini and freeplaneConsole.l4j.ini on Windows, freeplane.sh on Linux)

````
-Dsun.java2d.d3d=false
````

## Html text and images can not be pasted from Web pages in nodes and notes on Linux
It is a java issue on linux. Use Firefox for Windows with Wine.

## Nodes are not displayed properly on linux if the map is zoomed
Install the latest sun java from http://www.java.com/de/download/. The open jdk behaves buggy and is also significantly slower.

## I cannot find the spell check function
The spell checker has to be enabled, see the [Spell checker how-to](../user-documentation/Spell_checker.md).

## The editor freezes
Create an entry in [Bugs](https://sourceforge.net/p/freeplane/bugs/) and provide as much information as possible about the conditions under which the behavior occurs:

* Does it happen always if you do ...?
* Is there a dependency on the size of the loaded map(s)?
* Post the output of "java -version" (it contains the build number)
* Do you have something special in your environment?
* Is Freeplane consuming computation power when it freezes or not?
* Before the freeze, was there any activity in the [logfile](FAQ.md)? At least if there is anything suspicious, please post the logfile.
* Can you stop it with normal means (close window, send SIGTERM, ...)?
* Try a downgrade to an older Freeplane version - does that help?

It would be of great help in any case if you would provide a listing ("stacktrace") of what Freeplane is currently doing when it freezes by using the <tt>jstack</tt> tool. Find out the process id (PID) of the Freeplane Java process instance via *Taskmanager*, *top*, *ps* or whatever tool. Let's assume that the PID is 2345. Please post the output of

    jstack -l 2345

(You have to replace "2345" with the real PID.) For comparison also post the jstack output of Freeplane before the freeze (if possible). As you can easily check by inspecting the output it's pure technical stuff, nothing of your private mindmap is contained in it. Unfortunately you have to have the JDK installed to use jstack (the JRE wouldn't suffice). Please tell us, if you cannot install the JDK for some reason. - We might be able to help.

For more on <tt>jstack</tt> see its [Sun documentation](http://java.sun.com/javase/6/technotes/tools/share/jstack.html).


<!-- ({Category:Documentation}) ({Category:Needs_Updating}) -->

