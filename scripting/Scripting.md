Freeplane's builtin functionality can be extended by [Groovy](http://groovy-lang.org/) and [JavaScript](http://en.wikipedia.org/wiki/JavaScript) scripts. Starting with Freeplane 1.3.5_05 you can use [many other languages](Scripting!_Other_languages.md), e.g Python. This page gives a first impression what you can do with Groovy scripting and helps to get started.

With Freeplane scripting you can

* write your own functions and use them from the menu or via keyboard shortcuts,
* use [formulas](Formulas.md) in your map to compute stuff like in Excel, and
* create [add-ons](../getting-started/Add-ons_(install).md) to share it with other users,
* have [init scripts](Init_scripts.md) executed on startup that changes Freeplane's behavior (since Freeplane 1.5).

Most people use scripting to automate otherwise tedious procedures like creating a node with a special style and some standard attributes. But much more is possible with scripting.

<br> __TOC__ 

[External Groovy scripts](External_script_file_execution.md) can be integrated simply by placing them in the *scripts* subdirectory of the Freeplane homedir. Such scripts can be used like any other built-in function of Freeplane.

After some preparation we'll create the first script.

### Preparation

A newly installed Freeplane installation is almost ready for scripting:

* The <tt>scripts</tt> directory is created in the *User Configuration Folder* which you can open via *Tools > Open user directory*. It's empty, initially.
* This directory is automatically searched for ".groovy" files on startup.
* Scripting is disabled by default, but we'll fix that in a minute.

First create a new mindmap with this content (just copy 'n paste it into a new map): 

<pre>
test
  numbers
    1
    2
    3
  text
  text
  text ok
  text okay
</pre>

Then add some icons to the map - no matter how many and which icons. But we'll need them later. 


### Select an editor

You will need a text editor. For the first steps presented on this page any editor will do, such as Notepad on Windows (though [the free Notepad++](http://notepad-plus-plus.org)is much better), [Sublime Text](http://www.sublimetext.com/) or TextEdit on Mac OS X. You can find an overview of editors with Groovy support [on Stackoverflow](http://stackoverflow.com/questions/10864770/editor-for-groovy-and-grails) and on the [Groovy website](http://groovy-lang.org/ides.html).

Freeplane also has a small script editor built into it. It is reached through *Tools->Edit Script*. You can run the scripts directly in the editor and store them as attributes of the node you are working in. But such [map local scripts](Map_local_scripts.md) are most useful for quick tests since you can not write the scripts directly to ".groovy" files.

For ambitious scripting projects or if you have Java/Eclipse know-how you should have a look at the page on [Scripting environment setup](Scripting_environment_setup.md).


## The first script: HelloWorld.groovy

"Hello World" is the traditional first program when taking up a programming language. Let's create a Groovy Freeplane version of it:

* Create an empty Groovy script file named <tt>HelloWorld.groovy</tt> in your scripts directory (remember that you can get there via *Tools > Open user directory*). The suffix <tt>.groovy</tt> is mandatory.
* Open <tt>HelloWorld.groovy</tt> in an appropriate editor as detailed [above](#Create-a-script-and-integrate-it-into-Freeplane).  
* Copy the following script into the file and save it.
```groovy
node.text = "Hello World!"
```

* Now save your script in the editor and restart Freeplane since Freeplane will only find new scripts after a restart. Then you will find your new script in the Freeplane menu location *Tools-&gt;Scripts-&gt;Hello World*. You see three sub menus *Execute on one selected node*, *Execute on all selected nodes* and *Execute on all selected nodes, recursively*. Note: starting with FP version 1.5 there is no sub menu anymore. The execution mode is shown on mouse hover over the menu entry
* At *Tools->Preferences->Plugins->Scripting*<!--
    --><ul><!--
    -->  <li> set ''Script execution enabled'' to ''Yes''</li><!--
    -->  <li> enable ''Permit File/Read Operations (NOT recommended)'' - despite the warning.<!--
    --></ul><!--
    -->These changes take effect without restarting Freeplane and only need to be done once. For more details see [Scripting! Security considerations](Scripting!_Security_considerations.md).

* Execute the script by selecting *Tools-&gt;Scripts-&gt;Hello World-&gt;Execute on one selected node*. (Never mind the difference between the *Execute ...* variants; we'll come to that [later](#Execution_modes).)
* The text of the selected node will be changed to "Hello World!".
* To restore the original, press Ctrl-Z.
* If you like try the other "Execute..." menu items. Test the influence of selecting multiple nodes. Always press Ctrl-Z to revert the changes.

## Hello Controller

Every script is given the variables 

<table border="1" style="background-color:#E0E0E0;">
<tr>
<td>**node**</td>
<td>set to the currently selected node</td>
<tr>
<td>**c**</td>
<td>tool box for various tasks relating to the map or Freeplane altogether</td>
</tr>
</table>

These give access to the two most important bits of a map. In HelloWorld we used *node*, which gave access to the selected node.

Now we'll change HelloWorld.groovy to use the second, the Controller variable *c*:

* Copy the following script into the file and save it:
```groovy
c.statusInfo = "Hello World!"
```

* Execute the script by selecting *Tools-&gt;Scripts-&gt;Hello World-&gt;Execute on one selected node*.

The "Controller" manages the status bar. By assigning "Hello World!" to the Controller attribute "statusInfo" we are able to print text to the status bar.

### The scripting API
The variables *node* and *c* are "objects" with a list of *attributes* (like "text", "details" or "style") and *methods* that operate on the object, like "addConnector()", "createChild()" or "moveTo()". The "type" of the object decides on the list of attribute of attributes and methods an object has. "node" is of type [Proxy.Node](http://www.freeplane.org/doc/api/org/freeplane/plugin/script/proxy/Proxy.NodeRO.html) while "c" has the type [Proxy.Controller](http://www.freeplane.org/doc/api/org/freeplane/plugin/script/proxy/Proxy.Controller.html).

To get started with Freeplane scripting you have to get slowly accustomed to the Groovy syntax and the Freeplane specialities too. The types and objects that Freeplane supports are defined by [Freeplane's scripting API](Scripting_API.md). You can learn it step by step: Very little is required to write useful scripts.

An important resource is the built-in scripting documentation that is available via *Help->Scripting API*. Open it now and search for the *statusInfo* attribute at *Scripting API->Proxy->Controller->statusInfo: String (w)*. The text means: The Controller has an attribute *statusInfo* that only can be written to (*w*), that is you can't find out what is currently displayed on the status bar. The attribute has type *String* (either use "double quotes" or 'single quotes'). If you unfold the node you see *void setStatusInfo(String)*. That means that
```groovy
c.statusInfo = 'Hello World!'
```
and
```groovy
c.setStatusInfo('Hello World!')
```
are equivalent. But the first "attribute" style is preferable since it is clearer. The clickable links in the "Scripting API" map carry to the respective location in the [detailed API description](http://www.freeplane.org/doc/api) which might be a bit overwhelming at this point.


## Setting links

In the "Scripting API" map, near to statusInfo you find the *userDirectory* attribute. You can use it to add a link to this directory to your map. Create a new script file *addLink.groovy* in the script directory with the following content:
```groovy
node.link.file = c.userDirectory
```

Here an slightly extended version that adds an *external link* to the selected node(s) and creates a node with a *local link* back to its parent node:
```groovy
node.link.text = 'http://freeplane.org/wiki/index.php?title=Scripting'
```

This script creates a *local link* back to its parent node:
```groovy
node.link.node = node.parent
```

In the next section we'll see what the "@ExecutionModes" line is about.

## Execution modes

For each script we had three submenu entries of "Hello World". These entries are different with respect to multiple selected nodes: 

*In the case of *Execute on one selected node* a script is executed only once no matter how many nodes are selected. It's best to be used when only a single node is selected since in this case the <tt>node</tt> variable of the script is set to the selected node. If multiple nodes are selected then <tt>node</tt> is set to one of the nodes arbitrarily. That is, you shouldn't count on the selection if multiple nodes are selected.
*With *Execute on all selected nodes* it is called once for each selected node (with <tt>node</tt> set to the respective node) and with 
**Execute on all selected nodes, recursively* the selection will be implicitly extended by all child trees of the selected nodes.

If we chose *Execute on all selected nodes* for the first version of "Hello World" then the text of all selected nodes changed. - Probably what you expect. By adding the line
```groovy
// @ExecutionModes({ON_SELECTED_NODE})
```
all other choices would be suppressed.

The second "Hello World" version printed to the status bar. This only has to happen once so here *Execute on one selected node* is the right choice and we have to add the line 

```groovy
// @ExecutionModes({ON_SINGLE_NODE})
``` 

It's a good idea to put the "annotations" at the beginning of the script. (In section [Simple text replacement](#Simple-text-replacement-getIconName.groovy) we will see an exception.) ON_SELECTED_NODE_RECURSIVELY applies a script on any node in the branch that has a selected node as root. You can also enable more than one mode by concatening them with commas:

```groovy
// @ExecutionModes({ON_SELECTED_NODE, ON_SELECTED_NODE_RECURSIVELY})
``` 

Note that for Groovy this is a comment. - This line is only interpreted by Freeplane. Omitting the <tt>//</tt> will result in a Groovy compilation error. 

## Menu locations

Scripts can determine to which menu or submenu a script will be added. Even the menu title can be set (although the standard file name to menu title translation should be enough in most cases):

```groovy
// @ExecutionModes({on_single_node="/menu_bar/help[scripting_api_generator_title]"})
```

You can find out about the internal menu keys using the [Developer Tools > Menu item info](../getting-started/Add-ons_(install).md).

## Per node execution: addIcon.groovy

Now let's use the <tt>node</tt> variable again in our next script, <tt>addIcon.groovy</tt> (restart Freeplane to see it in the menu). This script will add the "button_ok" icon to any selected node:

```groovy
node.icons.add("button_ok")
// @ExecutionModes({ON_SELECTED_NODE})
``` 

This will add the "check" icon to each selected node. Hopefully it's clear that the execution mode *Execute on one selected node* makes no sense in this case. So let's remove this from the "Extra" menu:

```groovy
// @ExecutionModes({ON_SELECTED_NODE, ON_SELECTED_NODE_RECURSIVELY})
node.icons.add("button_ok")
``` 

(To see the change in the menu you have to restart Freeplane.)

We will extend this script now a little further to only set the icon if the node text contains the words "yes" or "OK" (case insensitively): 

```groovy
// @ExecutionModes({ON_SELECTED_NODE, ON_SELECTED_NODE_RECURSIVELY})
if (node.text.toLowerCase().matches(".*\\b(yes|ok)\\b.*"))
    node.icons.add("button_ok")
``` 

Note that <tt>node.text</tt> makes use of the special (compared to Java) attribute handling - see section [On Groovy properties and the Scripting API](#On-Groovy-properties-and-the-Scripting-API).

<br>

## The status bar again: getIconName.groovy

Finding the proper name of an icon may be a bit difficult. One way is to use the wanted icon in some map and to look it up in the sources. The XML for a node with an icon might look like that: 

&lt;node TEXT="done" ID="ID_789648746" CREATED="1239285242562" MODIFIED="1242658193277"&gt;\
&lt;icon BUILTIN="button_ok"/&gt;\
&lt;/node&gt;

This script writes the icon names of the selected node to the status bar:

```groovy
c.statusInfo = "Icons: " + node.icons.icons
```

Note: For built-in icons, the icon name is the same as the corresponding graphic file name, that may be found [here](https://freeplane.sourceforge.io/wiki/index.php/User_icons).

## Formulas

Starting with Freeplane 1.2 one use scripts as [Formulas](Formulas.md) directly in the node core like in Excel. Type this formula in the node core:

```groovy
= "Icons: " + node.icons.icons
``` 

This will display the result of the formula instead of the formula itself.

Notes: 

* The equal sign has to be the very first character in the script.
* On typing the equal sign as the first character a special script editor pops up which supports syntax highlighting.


## Data parsing and formatting

TODO: add text

```groovy
node.object = 40
def answer = node.to.num0 + 2
``` 

```groovy
node.text = '2013-02-15'
c.statusInfo = node.to.date + 1
``` 

```groovy
node.object = 42
node.format = '#.00'
``` 

```groovy
c.statusInfo = format(42, '#.00').toString()
```


## Navigation and iteration

Many useful scripts operate only on the current/selected node. But most scripts need to access multiple nodes. The scripting API provides methods for accessing special nodes:

* node.parent - parent node
* node.map.root - root of the map

For example this script prints the text of the parent node to the status bar:
```groovy
c.statusInfo = node.parent.text
``` 

Other methods return node lists:

* children - list of all children of a node, maybe empty
* c.findAll() - all nodes of the map in breath first order
* c.findDepthFirst() - all nodes of the map in depth first order
* c.find(<closure>) - all nodes for which <closure> returns *true*.

The use of this methods requires some knowledge of [Groovy collections](http://groovy-lang.org/Collections).


### Filtering
The most important concept is that of "closures", small code blocks that are used for filtering and modification of the element currently being iterated over. Let's start with filtering:
```groovy
def matches = c.find{ it.text.contains('ok') }
c.statusInfo = matches.size() + " nodes contain 'ok'"
``` 

The method *find* has a closure argument which is applied to all nodes in the map. All nodes for which the closure returns *true* are returned as a new list which is assigned to the *matches* variable. In the closure the "current item" has a default name *it*. As *c.find* iterates over nodes *it* is a Node that has the attribute *text* which is a String that has a method contains() returning true if *OK* is contained somewhere in the text, like in "grok" or "it's ok".


### Transformation

Many Groovy methods transform lists/collections into others:

```groovy
def squares = children.collect{ it.to.num0 * it.to.num0 }
```

and others transform lists into single values:

```groovy
def sumOfSquares = children.sum(0){ it.to.num0 * it.to.num0 }
```

When using *sum()* it's always a good idea to give it a start value since if the node had no children *sumOfSquares* would be *null* instead of *0*.

## Clones (since 1.5.5)

There are several methods to create clones of nodes and to act on the clones of a node. Note that cloning works symmetrically so we could better speak of shared nodes instead of clone and cloned since none of both is privileged. However each clone or shared node has a unique nodeId and may or not (depending on the share mode) have its own child nodes.

Add two clones of this node to the root node, one as single node, one including the branch starting at this node. Warning: before beta-1.5.5-pre03 appendAsCloneWithSubtree and appendAsCloneWithoutSubtree have reversed meaning!
```groovy
def root = node.map.root
def lonelyClone = root.appendAsCloneWithoutSubtree(node)
def childWithSubtree = root.appendAsCloneWithSubtree(node)
// add nodes to the clones
lonelyClone.createChild('a child not shared')
childWithSubtree.createChild('a shared child')
```

Mark a node with yellow background color if it has any clone:
```groovy
if (node.getCountNodesSharingContent() > 0)
    node.backgroundColorCode = '#ffff00'
```

Mark all nodes of a map having any clone:
```groovy
c.find{ it.getCountNodesSharingContent() > 0 }.each {
    it.backgroundColorCode = '#ffff00'
}
```
If you should be interested in clones that share also the subtree (and not only the core properties) filter for countNodesSharingContentAndSubtree instead of countNodesSharingContent.

Add a connector from node to all of its clones using property-access instead of method (nodesSharingContent instead of getNodesSharingContent()):
```groovy
node.nodesSharingContent.each { node.addConnectorTo(it) }
```

TODO: Tutorial ends here...

## Appendix

### Using external libraries

Some libraries are [already included](Scripting!_Included_libraries.md), but almost all other available Java libraries can be used. Place them in the <tt>lib</tt> directory in the <freeplane_userdir> which is already included in the "Script classpath" (see also Tools->Preferences->Plugins). All .class files and the content of all .jar files are automatically available in scripts and formulas.

Starting with Freeplane 1.3 [utility scripts](Scripting!_Freeplane_Utility_Classes.md) on the script classpath are compiled automatically.

You can also create [your own utility script library](Your_own_utility_script_library.md).

The add-on [**scriptlib**](http://www.freeplane.org/wiki/index.php/Add-ons_%28install%29#scriptlib) contains some libraries you can load and install. They include some node operations missing in the scripting API, file operations and a method to play audio with a hidden player.

### On Groovy

Although Groovy is more or less a superset of Java it would be a shame not to use the new opportunities Groovy provides. On the other hand there are notable differences between Groovy and Ruby. In this section some of the differences between Java, Groovy and Ruby will be listed.

#### Using external libraries from groovy scripts and formulas

Freeplane 1.7.4 and later also support groovy annotation <code>@grab</code> to add required libraries to your scripts. It means you do not need to place your libraries in lib folder and they are downloaded and managed by groovy itself. The whole dependency management in Groovy scripts is documented at http://docs.groovy-lang.org/latest/html/documentation/grape.html .

The following example shows using a cvs parsing library from https://github.com/xlson/groovycsv available at maven central repository

```groovy
@Grab('com.xlson.groovycsv:groovycsv:1.3')
import static com.xlson.groovycsv.CsvParser.parseCsv

def csv = '''Name,Lastname
Mark,Andersson
Pete,Hansen'''

def data = parseCsv(csv)
for(line in data) {
    node.createChild("$line.Name $line.Lastname")
}
```

#### On iteration

Groovy provides much improved ways to work on collections of data. This helps a lot in Freeplane scripting since most of the time you are working with collection of <tt>Node</tt> instances. From Java you might be used to this pattern:

```groovy
  // NEVER do that in Freeplane scripting!!!
  for (i = 0; i < c.selecteds.size()-1; i++) {
    aNode = c.selecteds[i]
    aNode.text = "Do it groovy instead!"
  }
```

But this code is not even ineffective in Freeplane scripting (since every "c.selecteds" call creates a new list with new wrapped Node instances!) but it might even lead to errors since the list might change on the way. The following is better...

```groovy
  // better, but still NOT GOOD
  def selected = c.selecteds
  for (i = 0; i < selected.size()-1; i++) {
    def aNode = selected[i]
    aNode.text = "Do it groovy instead!"
  }
```

Do yourself a favor and read this short [article on Groovy Collections](http://groovy-lang.org/Collections). Then you will see that the best way to do the same is

```groovy
// Good!
c.selecteds.each {
  it.text = "That's groovy!"
}
```
c.selecteds is only evaluated once and there are no redundant variables and method calls.

#### On Groovy properties and the Scripting API

If an object, e.g. <tt>Node node</tt>, has a method <tt>getXyz()</tt> then groovy allows to use <tt>node.xyz</tt>. If it also has a proper <tt>setXyz()</tt> method (proper in the sense of the JavaBeans specification) then the property is writable. 

Example of a read-only property: <syntaxhighlight lang="Groovy">
assert node.getId() == node.id
println("ok")

This will print "ok" into the logfile since the assertion is valid. 

Example of a read-write property: <syntaxhighlight lang="Groovy">
println(node.text)
node.text = "please note!"
println(node.text)

The second <tt>println</tt> will print the changed node text.

It's considered better style in Groovy if you use the properties instead of getters and setters. So better use
```groovy
c.statusInfo = "Icons: " + node.icons.icons
``` 
instead of
```groovy
c.setStatusInfo("Icons: " + node.getIcons().getIcons())
``` 

The menu item *Help -> Scripting API* shows the attributes instead of get/set methods where possible and indicates if the attributes are read-only, read-write or write-only.

#### The operator == means equals()

In Groovy the operator <tt>==</tt> is overridden to mean <tt>equals()</tt>. To check for identity use the method [is()](http://groovy-lang.org/groovy-jdk/java/lang/Object.html#is%28java.lang.Object%20other%29)

```groovy
Integer i = new Integer(3)
Integer j = new Integer(3)
assert i == j
assert ! i.is(j)
```

#### Caveat

Note that - unlike in [Ruby](http://www.ruby-lang.org/) - it's not allowed to omit the parens of a function without parameters in Groovy. So to get the number of children a node has, use <tt>node.children.size()</tt>, not <tt>node.children.size</tt>. The latter would be OK if <tt>java.util.List</tt> had a method <tt>getSize()</tt>.

<br>

## Wanted: Your participation!

It's very likely that scripting support lacking some functionality that would be useful for a large number of users. For this reason you are strongly encouraged to give feedback on issues you are having with scripting and on things you are missing. 

* For discussions use https://github.com/freeplane/freeplane/discussions
* Submit bugs and feature requests at https://github.com/freeplane/freeplane/issues
* Please share useful scripts at https://github.com/freeplane/freeplane/discussions

## What users say

* Advice for taking up scripting by [Quinbus](http://sourceforge.net/p/freeplane/discussion/758437/thread/4d367b8d/#3454) and [Miguel](http://sourceforge.net/p/freeplane/discussion/758437/thread/4d367b8d/#3454/451a).

## Further reading

This guide should have given you a quick overview over what can be done with scripts in Freeplane. Of course we have only scratched the surface. Here are some suggestions to dig further into Groovy / Freeplane scripting: 

* [groovy-learn.org](http://groovy-lang.org/learn.html) docs, books, presentation and  books for Groovy beginners
* [scripting API](http://www.freeplane.org/doc/api/)
* [Scripts collection](Scripts_collection.md) Learn by example
* [Freeplane utility classes](Scripting!_Freeplane_Utility_Classes.md) 
* [Libraries included in Freeplane](Scripting!_Included_libraries.md) 
* [Scripting! API Changes](Scripting!_API_Changes.md) 
* New: [Scripting! Other languages](Scripting!_Other_languages.md) - How to use other scripting languages like JavaScript or Python.

<!-- ({Category:Script}) -->

