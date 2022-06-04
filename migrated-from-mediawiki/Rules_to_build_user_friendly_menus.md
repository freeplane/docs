# Introduction
The purpose of this page is to describe **basic principles to build easy to use Menus for a rich mind map software called Freeplane** !

You can refer to [Menus: work in progress](Menus_and_commands.md) to follow and collaborate in the design of the new FreePlane menus structure.


# Rules to organize Main Menu

Main menu is the main bar of menus which gives access to all software features.

* (MM1) A Main Menu entry is created for each kind of operation (File / Edit / Display ...).
* (MM2) The Main Menu should be in a logical order inspired by other softwares best practices .

# Rules to organize Commands in menus

A command is available in menu, it executes an action.

* (CO1) In a Main Menu entry, items are grouped by type of operations (all commands to move nodes are at the same place).
* (CO2) Items are ordered logicaly (items used first at the beginning : ie "Create Node" then "Edit Node" then "Delete Node" or "Print Preview" then "Print". If no logical order can be found other rules can apply:
    * the most often used commands can be set in first position
    * order can also be set from particular to generic (ie: "Fold selected node" then "Fold all nodes of map")

# Use of Sub Menus

A submenu is a menu entry which opens an other menus.

* (SM1) Submenus are created to simplify long Main or contextual menus (i.e. more than 20 items in the menu).
* (SM2) Submenus should be limited to 3 levels (i.e. 3 clicks before displaying the wanted command).
* (SM3) A Submenu should contain 3 items or more.

# Rules to organize Contextual Menu

A contextual menu is a menu displayed only in a specific context (i.e. while on a node or on the map background).

Rules applied to build contextual menu :

* (CM1) in Contextual menu, order should be the same as in Main Menu (consistency for end-users). For instance Node Contextual menu is yet a copy of the Main Menu structure
* (CM2) Contextual menu should contain only very frequently used commands
* (CM3) 3 navigation levels are the maximum allowed in contextual menu.

# Node Contextual menu's benefits

* Limited mouse movements, don't need to go to Main Menu => quick access
* Simplified menus displaying only most used features => easy to use
* Available and fully fonctional while working on a map in full screen mode.

# Toolbars

* (TB1) The rules for toolbars are the same as for the Contextual menu: same order as Main-Menu, only frequently used commands.

# Legend

In this page :
* **MM** means Main Menu. 
* **CO** means Command. 
* **SM** means  Sub Menu. 
* **CM** means Contextual Menu.
* **TB** means Toolbar.  
* **XX#** means rules number # for subject XX.


<!-- ({Category:Menu}) -->
