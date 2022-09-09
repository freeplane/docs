<!-- toc -->

In [this forum](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4384594) storment74 (Stefan) posed some questions on how to improve the menu structure of Freeplane. <br><br>

In the following I would like to invite you in helping to think over the menu structure of FP. I will follow a process way of thinking, and ask you  not to jump to the end result. Also, no decisions are final until the last step, the extreme being the decision that nothing will change  if the end result is not evaluated as better than the current situation. Besides, it is to the programmers to make the decision to implement the result.

Once context menu’s are in place one might ask why one would need a  top level menu. Fundamental and practical reasons I could think of are:

* To create toplevel objects. Once created each has a context menu for relevant functions of it, including creating the components (subobjects) it exists of and deleting itself.  Each subobject has its own contextmenu.
* To apply a certain function simultaneously to a set of selected objects (e.g. delete object); however this functionality could also be connected to the contextmenu (e.g. not only delete itself, but all selected objects).
* To help new users orient and find their way without knowing which contextmenu’s might exist and how to select them. This could be solved  with a toplevel menu containing a hierarchical list op contextmenu’s, possibly with descriptions how to find/select and use these.
* People expect particular menu’s because familiarity with common programs.

Keeping this in mind I propose to evaluate the current menus and first strip it to the bare minumum from a functional point of view, before adding duplicate menu items for practical reasons. I also propose to evaluate the possible advantage of applying the mechanism of the node Properties Panel more broadly as a priciple to give intuitive, quick and broad access to related functions. I propose to adress these subjects one by one, in a process like way.


# Object hierarchy showing menus and context menus in Freeplane
[thumb| 
[[Media:FP-object-hierarchy_02.mm| **This mindmap**](File:FP-object-hierarchy.jpg.md) ]]

[**This mindmap**](Media:FP-object-hierarchy_02.mm.md) shows the the logical objects in Freeplane and their relations. Each object can consist of child objects, indicated by has_a relations. Some of these child objects are menus. Context menus are menus which open if right-clicked on the parent object. 
<br><br>
The mindmap shows a.o. which objects have contextmenus. The benefit of context menus is (1) they only show functions which apply to the parent object; and (2) these functions are available within 2 mouse clicks.
<br><br><br><br>

# Process step 1
**Goal:** strip all functions from the main menu bar which concern a selected node, node component (text, details, attributes, note), edge or connector. Kept are functions related to the mindmap as a whole.<br>

[**This mindmap**](Media:CurrentMainMenuWithIconsShowingLev.mm.md) contains the starting point, the items of the main menu bar of **FP 1.2.3_03**. With green OK-icons is shown which menu items are top level functions which have effect on the mindmap as a whole and not on specific subobjects. With numbered icons is shown which items concern subobject: 1 means node object, 2 means edge object and 3 means node text object. If two icons are shown, there are two possibilities. A question mark icon symbolizes an item for which a decision still has to be made. <br><br>
<mm>[parameters startCollapsedToLevel=1](CurrentMainMenuWithIconsShowingLev.mm.md) </mm>

[**This mindmap**](Media:CurrentMainMenuWithIconsShowingLev_Nam.mm.md)is a proposal is from ldmpub-nospam for the file menu.
<mm>[parameters startCollapsedToLevel=1](CurrentMainMenuWithIconsShowingLev_Nam.mm.md) </mm>
 

[**This mindmap**](Media:CurrentMainMenuStripped.mm.md) shows the main menu stripped from items relating to subobjects (numbered icons). Different branches show the items related to node object (=1) the items related to the edge object (2) and the items related to node text object (3). <br><br>
<mm>[parameters startCollapsedToLevel=1](CurrentMainMenuStripped.mm.md) </mm>

Before proceding to the next step, I would like to ask if you would put the icons in the same way ? How do you position the question marks ? Please, give your comment in [this forum](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4398409).

# Procedure for contributing

* Please, give your comment in [this forum](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4398409).
* Small modifications proposed in the forum will be added by the moderator to the relevant mindmap.
* Mindmaps can be uploaded to this wiki. If you do, publish the map in the discussion page, last contribution on top. For each upload published in de discussion page, specify iso-date followed by your name and keyword of the map content. Next give a short description of the publication and a link to the uploaded mindmap

<!-- ({Category:Menu}) -->

