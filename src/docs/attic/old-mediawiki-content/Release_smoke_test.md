<!-- toc -->

Every new version is uploaded to the project web space before it is released publicly. This allows team members or interested parties to check for the basic quality before each release. When it is reported that there are no major problems, the file will be released for further and public testing. 

Here is a basic check list for pre-release testing. This is not a comprehensive or systematic testing routine, it is a basic list that be carried out in a few minutes before each release: 

How to test Freeplane (test release) . This page has been updated for Freeplane 1.4.x.

## General functionality

If you can, have a look which new features have been added with current release and try them out as thoroughly as you can. Generally try to test the newer features. 

*Run Freeplane from shell script 

    * Make sure that there are no errors on the command line (especially OSGi errors)
*Close all existing maps (Ctrl+W) 
*Create new map (Ctrl+N) 
*Type some text into root and press Enter 
*Create new child (Insert) 
*Type text and enter 
*Add sibling (Enter) 
*Type a full paragraph of text and press Enter 
*Add some more children and siblings as above 
*It helps to add as much text as you can and work quickly so performance can be tested 
*Overwrite some nodes with new text 
*Copy and paste some text from the web or another editor 
*Fold and unfold some nodes 
*Apply some styes with F keys 
*Load calendar and append date (Ctrl+T) 
*Add a connector, label it and move it around. 
*Insert one or more images, resize and move the nodes around. 
*Save the map. 
*Create an attribute 
*Add some icons 
*Apply a filter 
*Select two nodes and join them (Ctrl+J) 
*Add a note. 
*Test undo and redo (Ctrl+Z and Ctrl+Y) 
*Arbitrarily move some nodes around 
*Save map, close Freeplane, reload Freeplane. 
*Select all nodes (Ctrl+A) 
*Select Format--&gt;Reset position 
*Save. Test done.

## Ribbons
TODO

## Clones
TODO

## Plugins
Unfortunately missing Export-Package:/Import-Package: are only detected at runtime, so we need to test carefully!

### Formula

* enter =1+2 in a node core
* make sure that syntax highlighting and '{'/'}' matching works

### JSyntaxPane
(only used jointly by Script/LaTeX)

### LaTeX

* enter "\latex $x_2=\frac{1}{3}$" in an node core and make sure that the formula is rendered
* make sure that syntax highlightying and '{'/'}' matching works
* enter "$x_2=\frac{1}{3}$"and set Format=LaTeX => make sure that the formula is rendered

### OpenMaps

* make sure that the menu actions are available
* Create an openmaps link for the current node, double-click an a location, click "done"
* click on the icon --> the map view must appear at the same location and zoom
* double click on a different location two times, click "done"
* Remove the openmaps location from the node --> the icon must disappear

### Scripting

* make sure that the menu actions are available
* Create a new script, make sure that syntax highlighting and '{'/'}' matching works
* run this script:
    c.statusInfo = node.value.getClass().name + ": " + new String(node.value)
--> must show *class org.freeplane.plugin.script.ConvertibleNodeText: <node text>* in status bar

* test a simple add-on

### SVG Plugin

* Export map to PDF --> look at the resulting PDF
* Export map to SVG --> look at the resulting SVG
    * known issue: LaTeX is not rendered in SVG output

<!-- ({Category:Coding}) -->

