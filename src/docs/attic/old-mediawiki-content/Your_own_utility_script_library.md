<!-- toc -->

Starting with **Freeplane preview version 1.3.2_02** all .groovy files in the script classpath directories are automatically compiled when Freeplane starts. The .class files are generated besides their .groovy source files in the classpath directories. Keep in mind that <tt>package</tt> declarations in the script files determine the location of the class files. See [scriptlib](http://www.freeplane.org/wiki/index.php?title=Add-ons_%28install%29#scriptlib) for some generic scripts and adding Help to your script.

## Extract often used functionality
This feature allows to keep your scripts and formulas more concise since you can define functionality that you often use in your scripts in a utility script/class. Let's assume that you want to create a map with a lot of formulas that compute sums over child nodes:
```groovy
=node.children.sum(0){ it['total'].num0 }
```
and that 50 times in a map as [in this map](http://www.freeplane.org/wiki/images/6/69/Example_-_General_Balance_form.mm). Put that into a utility script named <tt>FP.groovy</tt> and put it into the scripts classpath (see below):
<!-- name=FP -->
```groovy
def static childAttribSum(parentNode, attributeName) {
    parentNode.children.sum(0){ it[attributeName].num0 }
}
```

Then your formula will look nicer:
```groovy
=FP.childAttribSum(node, 'total')
```

Please Note:

* in order for the library functions to be used within your scripts, the library (file) name MUST start with a capital letter
* for utility functions you should think twice to find good function names to make it easier to remember what they do

## Notes
### Why 'static'?

If you forget the *static* in the function declaration then the simple rule *Classname.method(...)* won't work since non-static functions need an instance of the class in which they are defined, which is 'FP' in case of *FP.groovy*. In certain cases that might be what you want and it could work:
<!-- name=FP -->
```groovy
def nonStatic() {
    'blablabla'
}
```
Then you had to create a *FP* instance first and use that:
```groovy
def fp = new FP()
println fp.nonStatic()
```
or more concise:
```groovy
println new FP().nonStatic()
```

will print "blablabla".

### No 'node', no 'c'?

Unfortunately functions (static or not) have no access to the two central scripting entry points, *node* (for the currently selected node) and *c* (the 'Controller'). You can get around these restrictions by using the ScriptUtils, new in 1.3.2_03:
```groovy
import org.freeplane.plugin.script.proxy.ScriptUtils

def static test() {
    def node = ScriptUtils.node()
    def c = ScriptUtils.c()
    c.statusInfo = 'text of selected node is ' + node.text
}
```

## Make yourself at home
Let's assume you don't like the groovy way to sum over child values. Let's also assume that you like functions with UPPERCASE LETTERS. Then you will like the following function (>= 1.3.2_03):
```groovy
// use: println 'sum over children is ' + SUMC()
import org.freeplane.plugin.script.proxy.ScriptUtils

def static SUMC() {
    def node = ScriptUtils.node()
    node.children.sum(0)
}
```

## Define constants

You can also define constants that you often use. If you define them in one place it will be easier to change them if you like.
For example in a *Const.groovy* file :
```groovy
import groovy.transform.Field
@Field final static String company = 'Scripting Geeks Inc.'
@Field final static String stdDateFormat = 'yyyy/MM/dd_hhmm'
```
Or for the same result :
```groovy
class Const {
    final static String company = 'Scripting Geeks Inc.'
    final static String stdDateFormat = 'yyyy/MM/dd_hhmm'
}
```

Use it like this:
```groovy
node['started'] = format(new Date(), Const.stdDateFormat)
```

## Enable utility script compilation

Under *Tools->Preferences->Plugins->Script classpath* enter *lib*. - Relative paths will be interpreted as starting from the Freeplane user directory. So open that via *Tools->Open user directory* and create a directory *lib* in it. Put your scripts into this directory.

You can add multiple directories to the classpath. See the tooltip of the option in the preferences how to do that.

## How to name the script files

If you use lowercase names for your script, like *fp*, then Groovy will not find this class since it "thinks" that you are referring to a variable that it doesn't know and issue an error that it doesn't have matching attribute or method.
<!-- ({Category:Script}) -->

