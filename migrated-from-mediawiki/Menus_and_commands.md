# Freeplane menus definition

## Introduction
Freeplane menus are defined in a XML file. This file defines:

* menus and commands available in menus
* contextual menus and commands
* toolbars
* keyboard shortcuts (sometimes also called accelerators).

This file allows any Freeplane's user with a basic technical knowledge to customized Freeplane user interface either to use a personnalized Freeplane or to suggest new menu structure to Freeplane community.

## Standard Menus file name and location
The file containing menus is named "mindmapmodemenu.xml". This file is included in Freeplane distribution and can be found in: `[FP_INSTALL_DIR]\core\org.freeplane.core\lib\freeplaneeditor.jar\xml`

| Usage                                             | File name           |
| ------------------------------------------------- | ------------------- |
| Full Freeplane mode                               | mindmapmodemenu.xml |
| Map view only mode                                | browsemodemenu.xml  |
| File browser mode                                 | filemodemenu.xml    |
| Style editor                                      | stylemodemenu.xml   |
| Applet menu (when map is published on a web site) | appletMenu.xml      |

Freeplane menus files

## Structure reference for Freeplane menus file (XML format)
To be completed by Freeplane developpers...

# How to customize Freeplane menus file ?

* Step 1 : get the standard menu file
    * Goto directory:`[FP_INSTALL_DIR]\resources\xml`  on the computer where you have installed Freeplane
    * Find file "mindmapmodemenu.xml"
* Step 2 : install the standard menu file as a personnal menu file
    * Launch Freeplane
    * Goto menu : Tools > Open user directory (the directory displayed should be something like : "...\Data\Freeplane\1.2.x")
    * There create one of the following sub-folders: `[USER_DIR]\resources\xml` or `[FP_INSTALL_DIR]\resources\xml`
    * Copy in the new sub-folder "xml" the file "mindmapmodemenu.xml" located at the end of Step 1
*Step 3 : modifying the content of your personnal menu file

    * Open the "mindmapmodemenu.xml" with a text editor (I suggest Notepad++), now you can perform the changes you want ... see below.

## Example of changes than can be performed in the Freeplane menu file
The simplest actions are to re-order commands in a menu, move commands from one menu to an other or add separator to group commands in a menu. You can perform these operations by a simple Cut/Paste of the XML content (in respect with XML structure) in your personnal "mindmapmodemenu.xml" file created through step 1 to 3 above. You can also perform other changes like adding submenus or add/remove/move toolbars icons or change keyboard shortcuts, see developper's reference above for more informations.
Don't forget : you need to restart Freeplane to reflect the changes made in FreePlane menus file.

# Rules applied to organize Freeplane menus
*Some rules have been established to organize and maintain Freeplane menu, see [Rules to build user friendly menus](Rules_to_build_user_friendly_menus.md).

<!-- ({Category:Menu}) -->
