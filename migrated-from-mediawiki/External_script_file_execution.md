## Setting the External Script Directories Search Path

There is a mechanism to load and execute scripts from *script directories* matching a given name scheme (hardcoded: <tt>".*\.groovy"</tt>). 

Starting with Freeplane 1.2 you do not have to configure the script search path since 'scripts' is the default (see below where that is).

1. The list of *script directories* is configurable by selecting <tt>tools->Preferences ...</tt> from the menu, and then in the resulting <tt>Preferences</tt> window, click the <tt>Scripting</tt> button. 
2. In the <tt>Script search path (separate entries by ;;)</tt> text box, you can specify additional pathes where Freeplane can search for Groovy Scripts.
### Windows
Specify your path as you would normally in windows, just be sure to add a <tt>;;</tt> at the end of the path you add to the existing script path.
#### Example
If you wanted the default <tt>%USERPROFILE%\.freeplane\scripts</tt> directory, and also wanted to use <tt>C:\temp</tt> you would set :
    <tt>scripts;;C:\temp;;</tt>

### Linux, MacOS X
(todo)

(default: <tt>scripts</tt>, i.e. directory <tt>scripts</tt> in the freeplane user home).

## Adding external libraries
If your script needs external libraries (.jar or .class files) add the directory containing them to the "Script classpath", see [example scripts](Scripting.md).

## Executing Scripts
* Matching scripts are listed in the menu <tt>Extra->Scripts</tt>.

## Hot Key Assignment to Execution of Scripts

* Due to the flexible standard hotkey assignment it's possible to create hotkeys for these scripts.

For each script there is a submenu with three menu entries (see [Scripting](Scripting.md) for instructions how this can be controlled by the script writer).:
* *Execute for one selected node*: This will invoke the script for one selected node (arbitrarily choosen), i.e. if three nodes are selected, it will be executed once, with the <tt>node</tt> variable set to one of the selected nodes. Since setting of <tt>node</tt> is not really predictable this variable should not be used. 
* *Execute for all selected nodes*: This will invoke the script on every selected node, i.e. if three nodes are selected, it will be executed three times, once for each node with the *node* variable set to the respective node. 
* *Execute for all selected nodes, recursively*: This will invoke the script on every selected node and recursively on all of its children.
    * *Note:* If a node and a child node are both selected, then the script is invoked on the child node twice. 
* To execute a script *on all nodes* in a map one has to select the root node and execute the script *recursively*.

## Script Error Logging
* Errors while loading or while execution of scripts are handled by error message popups. (See resources <tt>ExecuteScriptError.text</tt> and <tt>ReadScriptError.text</tt>.)

<!-- ({Category:Script}) -->

