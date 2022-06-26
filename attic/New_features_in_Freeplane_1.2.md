
The following describes the difference between Freeplane 1.1.3 and Freeplane 1.2.x. To load the development version 1.2.x go to the [preview area](http://www.freeplane.org/preview/).''

## New user configuration file folder location
If you are already a Freeplane user, you may want to transfer your previous settings to the new preview version. After installation you can copy your configuration files to the following folders depending on the OS you use:
* under (old) Windows: %appdata%\Freeplane\1.2.x 
* Windows 7: %user%\AppData\Roaming\Freeplane\1.2.x (Only visible if Show hidden files is turned ON)
* under Mac and Linux: ~/.freeplane/1.2.x 
* Portable Freeplane: [INSTALL]/Data/Freeplane/1.2.x

You can open this directory in a file manager via the Freeplane menu under *Tools -> Open User Directory*.

## The most important new features
### Implemented
* [Node styles](/docs/#/user-documentation/styles ':ignore') replace style patterns (like in text processors)
* [Conditional node styles](/docs/#/user-documentation/Conditional_node_styles ':ignore'): node formatting depends on its content and position
* [Map templates](Map_templates.md) for new maps (all previous maps can be used)
* [Menus and commands](Menus_and_commands.md) have been re-ordered to improve user efficiency (both to better integrate new features and to give a more "natural access" to already existing features)
* Properties panel - [Format tab](/docs/#/user-documentation/styles ':ignore')
* Hyperlinks for menu items
* Keyboard shortcut documentation: Map and HTML table generation added for the documentation map
* Check for newer auto save files on opening of a map
* Single instance mode: open files in existing program instance instead of opening a new one.
* Node level dependent filters
* Improvement in search and replace functions
* Different cloud shapes
* New icons for rating
* Automatic Edge Color 
* "Grid" for moving nodes (see Preferences>Behaviour, Behaviour section>Grid gap size)
* Copy and paste attributes
* Named filter conditions
* Connectors : different shapes, line types, width and transparency
* Progress icons (standard icon / 25% steps / available in menu "Icons") or external progress icon (clickable icon / 10% or 25% steps / also available in menu "Icons")
* You can now create "brackets" to add a graphical and text summary to some nodes, see <mm>[applet|sample brackets map](:Example-SummaryNodes.mm.md) </mm>
* Freeplane portable version (download and install file named *FreeplanePortable_X.paf.exe*)
* File -> Properties... dialog shows informations about the map (e.g. total number of nodes)
* add new icons in main and contextual menus to improve user efficiency
* [Formulas](/docs/#/scripting/Formulas ':ignore'): Use of formulas in node text, nodes and attributes (like in spreadsheet processors)
* Node numbering and Formats/templates as style attributes
* Parsing and formatting of numbers and dates in node texts and attribute values.
<noinclude>

## Other features
<!-- ({Category:Change log})({Features 1.2.x}) -->
