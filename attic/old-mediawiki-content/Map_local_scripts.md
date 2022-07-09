[Back to scripting overview](../scripting/Scripting.md) 

Map local scripts are a legacy from FreeMind that most experienced script developers don't use. But some people like them to test some bit of code quickly.

Map local scripts can be defined within a map as attributes of some node. These scripts are embedded within a map and can be easily shipped with a map. A special, builtin editor is used for script editing. 

In **preparation** for a quick intro on map local scripts create a new map with two nodes, "test 1" and "test 2", e.g. by pasting the following two lines onto the root of a new map: 

    test 1
    test 2

## Define a map local script

* Select the node "test 1". Let's attach a script to it. 
* From the menu select *Tools->Scripts->Script Editor*. 
* In the script editor's menus select *Actions/New Script*. An entry *script1* will be added to the upper left panel. 
* Write the following script in the upper right panel:
```groovy
println("1st script: " + node.text)
``` 

* Save and exit the script editor via the menu *Actions/Save and Exit*. 
* To check what happened make the attributes visible via menu *View/Attributes/Show All Attributes* (if necessary). You see that the script has been added to the map as an attribute with name <tt>script1</tt> and the script as its value. If you would add further scripts to the same node then these will be named <tt>script2</tt> and so forth.

Note that you may not rename the attribute. The script lookup relies on the attribute name: It has to start with "script". 

## Execute the script in the script editor

In the script editor's menus select *Actions/Run*. The following output will be printed in the lower (script output) panel: 

    1st script: test 1
    Result:null

That way you can test your scripts very easily. 

## Execute the script via the menu

* Save and exit the script editor via the menu *Actions/Save and Exit* if you haven't done it already. 
* Ensure that the node with the attached script is selected. 
* In the menu select *Tools/Scripts/Execute selected node scripts*. In the logfile (normally <tt>~/.freeplane/log.0</tt>) you will find two new lines:

    1st script: test 1
    Result:null

The *Execute selected node scripts* action requires you to have the script node selected. 

To circumvent this use the menu entry *Tools->Scripts->Execute all scripts*. This executes all map local scripts. 

To test how this works for multiple scripts let's create another map local script: 

* Select node "test 2" 
* Open the script editor again and create a script with a slightly different print message:

```groovy
println("2nd script: " + node.text)
``` 

* Save and exit the script editor. 
* Select *Tools/Scripts/Execute all scripts*. The result should something like this:

    STDOUT: 2nd script: test 2
    STDOUT: Result:null
    STDOUT: 1st script: test 1
    STDOUT: Result:null

Both scripts are executed. 

*Note:* Map local scripts will ever have their "node" variable set to the node the respective script is attached to. If you don't want that you have to use external scripts, see [Scripting](../scripting/Scripting.md) or [External script file execution](External_script_file_execution.md). External scripts allow to tune the way scripts are executed on which node.

## Signed scripts

Scripts may be signed for security considerations. 

*TODO: please fill out this gap* 

<!-- ({Category:Script}) -->

