// This file contains Freeplane API reference for Groovy scripting.

/*
  AttributesRO
*/

/*
For the following code examples you can paste the following branch in Freeplane.
Select and copy the following lines and paste as a branch from the selected node in your mind map.

Sample Branch 01
	item A: Attributes
		item A1
		+	myAttribute	my text value
		+	aaa	v_aaa
		item A2
		+	otherAttribute	aaa
		item A3
		item A4
		+	aaa	first
		+	bbb	second
		+	aaa	third
		+	aaa	fourth
	item B
	item C

 */

// Returns "true", if the selected node contains an attribute key that is equal to "aaa". Returns "false", otherwise.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns true
        node "item A2" returns false
        node "item A3" returns false
        node "item A4" returns true
 */
node.attributes.containsKey("aaa")

// Returns the index of the first attribute with the name "aaa" if one exists or -1 otherwise.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns 1 (it's the second attribute)
        node "item A2" returns -1
        node "item A3" returns -1
        node "item A4" returns 0 (the first one is in the first attribute's position)
 */
node.attributes.findFirst("aaa")

// Returns the attribute value at the index 1.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns 'v_aaa'
        node "item A2" returns exception: "org.freeplane.plugin.script.ExecuteScriptException: Array index out of range: 1, Array index out of range: 1"
        node "item A3" returns exception: "org.freeplane.plugin.script.ExecuteScriptException: Array index out of range: 1, Array index out of range: 1"
        node "item A4" returns 'second'
 */
node.attributes.get(1)

//  Returns the values of all the attributes that has the key equal to "aaa".
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns [v_aaa]
        node "item A2" returns []
        node "item A3" returns []
        node "item A4" returns [first, third, fourth]
 */
node.attributes.getAll("aaa")

// Returns the first value of an attribute with the name "aaa" or null otherwise.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns v_aaa
        node "item A2" returns null
        node "item A3" returns null
        node "item A4" returns first
 */
node.attributes.getFirst("aaa")

// Returns the attribute key at the index 1.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns aaa
        node "item A2" returns exception: "org.freeplane.plugin.script.ExecuteScriptException: Array index out of range: 1, Array index out of range: 1"
        node "item A3" returns exception: "org.freeplane.plugin.script.ExecuteScriptException: Array index out of range: 1, Array index out of range: 1"
        node "item A4" returns bbb
 */
node.attributes.getKey(1)

// Returns all attributes as a map.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns {myAttribute=my text value, aaa=v_aaa}
        node "item A2" returns {otherAttribute=aaa}
        node "item A3" returns {}
        node "item A4" returns {aaa=fourth, bbb=second}  // (note that it takes for aaa the value of the last attribute)
 */
node.attributes.map

// Returns all attribute names in the proper sequence.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns [myAttribute, aaa]
        node "item A2" returns [otherAttribute]
        node "item A3" returns []
        node "item A4" returns [aaa, bbb, aaa, aaa]
 */
node.attributes.names

// Returns "true", if the selected node has no attributes. Returns "false", otherwise.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns false
        node "item A2" returns false
        node "item A3" returns true
        node "item A4" returns false
*/
 node.attributes.empty

// Returns the number of attributes.
/*
    using "Sample Branch 01":
    selecting
        node "item A1" returns 2
        node "item A2" returns 1
        node "item A3" returns 0
        node "item A4" returns 4
*/
node.attributes.size()

/*
  Attributes
*/

// Adds an attribute with key "aaa" and value "xxx", no matter if an attribute with the given name already exists.

node.attributes.add("aaa", "xxx")

// Adds an attribute with key "aaa", value "8", with formatting pattern "0.0", no matter if an attribute with the given name already exists.

node.attributes.add("aaa", "8", "0.0")

// Removes all attributes of the selected node.

node.attributes.clear()

// Optimizes widths of attribute view columns according to contents.

node.attributes.optimizeWidths()

// Removes the attribute at the index 1.

node.attributes.remove(1)

// Removes all attributes with name "aaa".

node.attributes.removeAll("aaa")

// Sets "xxx" as the value of the attribute at index 1.

node.attributes.set(1,"xxx")

// Sets "aaa" as the key, and "xxx" as the value of the attribute at index 1.

node.attributes.set(1, "aaa", "xxx")

// Sets "aaa" as the key, "8" as the value, and "0.0" as the format pattern of the attribute at index 1.

node.attributes.set(1, "aaa", "8", "0.0")

// Adds an attribute with key "aaa" and value "xxx" if there is no attribute with the given key or changes the value of the first attribute with the given key.

node.attributes.set("aaa", "xxx")

// Sets "0.0" as the format pattern to the attribute at index 1.

node.attributes.setFormat(1, "0.0")

/*
  BorderRO
*/

// Retrieves the color of the border.

node.style.border.color

// Retrieves the color code of the border.

node.style.border.colorCode

// Retrieves the dash pattern of the border.

node.style.border.dash

// Checks if the border uses the edge color. Returns true if it does, false otherwise.

node.style.border.usesEdgeColor

// Checks if the border uses the edge dash pattern. Returns true if it does, false otherwise.

node.style.border.usesEdgeDash

// Checks if the border uses the edge width. Returns true if it does, false otherwise.

node.style.border.usesEdgeWidth

// Retrieves the width of the border.

node.style.border.width

// Checks if the border color is set. Returns true if it is, false otherwise.

node.style.border.colorSet

// Checks if the dash pattern of the border is set. Returns true if it is, false otherwise.

node.style.border.dashSet

// Checks if the use of edge color for the border is set. Returns true if it is, false otherwise.

node.style.border.usesEdgeColorSet

// Checks if the use of edge dash for the border is set. Returns true if it is, false otherwise.

node.style.border.usesEdgeDashSet

// Checks if the use of edge width for the border is set. Returns true if it is, false otherwise.

node.style.border.usesEdgeWidthSet

// Checks if the width of the border is set. Returns true if it is, false otherwise.

node.style.border.widthSet

/*
  Border
*/

// Sets the color of the border to java.awt.Color.YELLOW.

node.style.border.color = java.awt.Color.YELLOW

// Sets the color of the border using an RGB string.

node.style.border.colorCode = "#ffff00ff"

// Sets the dash pattern of the border to "CLOSE_DOTS".

node.style.border.dash = "CLOSE_DOTS"

// Sets whether the border color matches the edge color.

node.style.border.usesEdgeColor = true

// Sets whether the border dash pattern matches the edge dash pattern.

node.style.border.usesEdgeDash = true

// Sets whether the border width matches the edge width.

node.style.border.usesEdgeWidth = true

// Sets the width of the border in integer format.

node.style.border.width = 8

// Sets the width of the border as a string.

node.style.border.width = "8"

// Sets the width of the border as a Quantity object with LengthUnit.

node.style.border.width = "8pt"

/*
  Cloud
*/

// Returns the color of the cloud set to the selected node.

node.cloud.color

// Returns the color code of the cloud set to the selected node.

node.cloud.colorCode

// Returns "true" if the selected node has a cloud enabled.

node.cloud.enabled

// Returns the shape of the cloud set to the selected node.

node.cloud.shape

// Sets "YELLOW" as the color of the selected node cloud.

node.cloud.color = java.awt.Color.YELLOW

// Sets "#ffff00ff" as the color code of the selected node cloud.

node.cloud.colorCode = "#ffff00ff"

// Enables a cloud in the selected node.

node.cloud.enabled = true

// Sets "STAR" as the shape of the selected node cloud.

node.cloud.shape = "STAR"

/*
  FreeplaneVersion
*/

// Returns the Maj number of the Freeplane version.

c.freeplaneVersion.maj

// Returns the Mid number of the Freeplane version.

c.freeplaneVersion.mid

// Returns the Min number of the Freeplane version.

c.freeplaneVersion.min

// Returns the Freeplane version.

c.freeplaneVersion.num

// Returns the Freeplane revision number.

c.freeplaneVersion.revision

// Returns "true" if the Freeplane version is final.

c.freeplaneVersion.final

// Returns the Freeplane version number as a string.

c.freeplaneVersion.numberToString()

/*
  ConditionalStyleRO
*/

// Retrieves the simple name of the condition class of the conditional style applied to the map and located at index 0.

map.conditionalStyles.findAll().conditionClassSimpleName[0]

// Retrieves the script associated with  the conditional style applied to the map and located at index 0.

map.conditionalStyles.findAll().script[0]

// Retrieves the name of the conditional style applied to the map and located at index 0.

map.conditionalStyles.findAll().styleName[0]

// Checks if there is a script condition associated with the conditional style applied to the map and located at index 0.

map.conditionalStyles.findAll().get(0).hasScriptCondition()

// Checks if the conditional style applied to the map and located at index 0 is active. Returns true if it is, false otherwise.

map.conditionalStyles.findAll().active[0]

// Checks if the conditional style applied to the map and located at index 0 is always applied. Returns true if it is, false otherwise.

map.conditionalStyles.findAll().always[0]

// Checks if the conditional style applied to the map and located at index 0 is the last one in the sequence. Returns true if it is, false otherwise.

map.conditionalStyles.findAll().last[0]

/*
  ConditionalStyle
*/

// Moves the conditional style of position 0 to position 1.

map.conditionalStyles.findAll().get(0).moveTo(1)

// Removes the conditional style of position 0.

map.conditionalStyles.findAll().get(0).remove()

// Sets the active state of the conditional style of position 0.

map.conditionalStyles.findAll().active[0] = true

// Sets whether the conditional style currently in position 0 gets as the last one in the sequence.

map.conditionalStyles.findAll().last[0] = true

// Sets the script for the conditional style of position 0.

map.conditionalStyles.findAll().script[0] = "script example"

// Sets "aaa" as the name of the style for the conditional style of position 0.

map.conditionalStyles.findAll().styleName[0] = "aaa"

/*
  ConnectorRO
  
  The examples refer to the connectors that leave the currently selected node, so they use connectorsOut. In order to reference the connectors that are reaching the node, use connectorsIn instead of connectorsOut. 
*/

// Returns the color of the connectors.

node.connectorsOut.color

// Returns the color code of the connectors.

node.connectorsOut.colorCode

// Returns the end inclination of the connectors.

node.connectorsOut.endInclination

// Returns the font family of the label of the connectors.

node.connectorsOut.labelFontFamily

// Returns the font size of the label of the connectors.

node.connectorsOut.labelFontSize

// Returns the middle label of the connectors.

node.connectorsOut.middleLabel

// Returns the opacity of the connectors.

node.connectorsOut.opacity

// Returns the shape of the connectors.

node.connectorsOut.shape

// Returns the source node of the connectors.

node.connectorsOut.source

// Returns the label of the source node of the connectors.

node.connectorsOut.sourceLabel

// Returns the start inclination of the connectors.

node.connectorsOut.startInclination

// Returns the target node of the connectors.

node.connectorsOut.target

// Returns the label of the target node of the connectors.

node.connectorsOut.targetLabel

// Returns the width of the connectors.

node.connectorsOut.width

/*
  Connector
*/

// Sets to java.awt.Color.YELLOW the color of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].color = java.awt.Color.YELLOW

// Sets "#ffff00ff" as the color of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].colorCode = "#ffff00ff"

// Sets the dash array pattern of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].dashArray = "CLOSE_DOTS"

// Sets whether to show an arrow at the end of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].endArrow = true

// Sets the inclination points of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].setInclination([5,6], [7,8])

// Sets the font family for the label of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].labelFontFamily = "Arial"

// Sets the font size for the label of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].labelFontSize = 8

// Sets the middle label of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].middleLabel = "aaa"

// Sets to 8 the opacity of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].opacity = 8

// Sets to "LINEAR_PATH" the shape of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].shape = "LINEAR_PATH"

// Sets whether the outside connector located at index 0 of the selected node simulates an edge.

node.connectorsOut[0].simulatesEdge = true

// Sets the label at the source of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].sourceLabel = "aaa"

// Sets whether to show an arrow at the start of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].startArrow = true

// Sets the label at the target of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].targetLabel = "aaa"

// Sets the width of the outside connector located at index 0 of the selected node.

node.connectorsOut[0].width = 8

/*
  ControllerRO
*/

// Exports the specified mind map to a file 'C:/t.png' in the PNG format, with an option to overwrite existing files.

boolean overwriteExistingFile = true
c.export(node.map, new File('C:/t.png'), 'Portable Network Graphic (PNG) (.png)', overwriteExistingFile)

// Finds nodes matching the condition node core is equal to "aaa", with options to include ancestors and descendants in the search set to true.

c.find(true, true, { it.text == "aaa" })

// Finds nodes matching the condition node core is equal to "aaa".

c.find{ it.text == "aaa" }

// Finds all nodes.

c.findAll()

// Finds all nodes in a depth-first manner.

c.findAllDepthFirst()

// Retrieves descriptions of all available export types.

c.exportTypeDescriptions

// Retrieves the version of Freeplane being used.

c.freeplaneVersion

// Retrieves the currently selected node.

c.selected

// Retrieves all selected nodes, as a List.

c.selecteds

// Retrieves the sorted selection of nodes, excluding the nodes that are descendants of other selected nodes.

c.getSortedSelection(true)

// Retrieves the user directory path.

c.userDirectory

// Retrieves the root node of the current view.

c.viewRoot

// Retrieves the current zoom level.

c.zoom

// Checks if the current mode is interactive. Returns true if it is, false otherwise.

c.interactive

/*
  Controller
*/

// Centers the view on the specified node. In the example, the node of ID ID_313704791.

c.centerOnNode(ID_313704791)

// Deactivates the undo functionality.

c.deactivateUndo()

// Opens the specified node for editing. In the example, the node of ID ID_313704791.

c.edit(ID_313704791)

// Opens the specified node for editing in a popup window. In the example, the node of ID ID_313704791.

c.editInPopup(ID_313704791)

// Retrieves the main thread executor service.

c.mainThreadExecutorService

// Retrieves a list of currently open mind maps.

c.openMindMaps

// Creates a new mind map from the template file "Example Template.mm", located at "C:/Example Template.mm".

c.newMapFromTemplate(new File("C:/Example Template.mm"))

// Creates a new mind map.

c.newMindMap()

// Performs a redo action.

c.redo()

// Selects the collection of nodes "someNodes".

someNodes = [] + ID_313704791 + ID_1260664080
c.select(someNodes)

// Selects the node with ID ID_313704791.

c.select(ID_313704791)

// Selects all nodes in the branch of the node with ID ID_313704791.

c.selectBranch(ID_313704791)

// Selects multiple nodes from the collection someNodes.

someNodes = [] + ID_313704791 + ID_1260664080
c.select(someNodes)

// Sets status information to be displayed.

c.setStatusInfo("hi there!")

// Sets status information to the standard info panel.

c.setStatusInfo("standard", "hi there!")

// Sets status information to the standard info panel and an icon "button_ok".

c.setStatusInfo("standard", "hi there!", "button_ok")

// Sets the zoom level to the specified ratio.

c.setZoom(8)

// Performs an undo action.

c.undo()

/*
  EdgeRO
*/

// Returns the color of the edge.

node.style.edge.color

// Returns the color code of the edge.

node.style.edge.colorCode

// Returns the line type of the edge.

node.style.edge.dash

// Returns the style (type) of the edge.

node.style.edge.type

// Returns the width of the edge.

node.style.edge.width

// Returns "true" if the edge color is set.

node.style.edge.colorSet

// Returns "true" if the edge line type is set.

node.style.edge.dashSet

// Returns "true" if the edge style (type) is set.

node.style.edge.typeSet

// Returns "true" if the edge width is set.

node.style.edge.widthSet

/*
  Edge
*/

// Sets "java.awt.Color.YELLOW" as the edge color.

node.style.edge.color = java.awt.Color.YELLOW

// Sets "#ffff00ff" as the edge color code.

node.style.edge.colorCode = "#ffff00ff"

// Sets "CLOSE_DOTS" as the edge line type.

node.style.edge.dash = "CLOSE_DOTS"

// Sets "linear" as the edge style.

node.style.edge.type = "linear"

// Sets 2 as the edge width.

node.style.edge.width = 2

/*
  FontRO
*/

// Returns the name of the font of the currently selected node.

node.style.font.name

// Returns the size of the font of the currently selected node.

node.style.font.size

// Returns "true" if the font of the currently selected node is bold.

node.style.font.bold

// Returns "true" if the font of the currently selected node is set to bold.

node.style.font.boldSet

// Returns "true" if the font of the currently selected node is italic.

node.style.font.italic

// Returns "true" if the font of the currently selected node is set to italic.

node.style.font.italicSet

// Returns "true" if the name of the font of the currently selected node is set.

node.style.font.nameSet

// Returns "true" if the size of the font of the currently selected node is set.

node.style.font.sizeSet

// Returns "true" if the font of the currently selected node is striked through.

node.style.font.strikedThrough

// Returns "true" if the font of the currently selected node is set to strike through.

node.style.font.strikedThroughSet

/*
  Font
*/

// Resets the "bold" property of font the selected node.

node.style.font.resetBold()

// Resets the "italic" property of font the selected node.

node.style.font.resetItalic()

// Resets the "name" property (i.e., the name of the font) of the font of the selected node.

node.style.font.resetName()

// Resets the "size" property of the font ogf the selected node.

node.style.font.resetSize()

// Resets the "Strike Through" property of the of the selected node.

node.style.font.resetStrikedThrough()

// Sets the font of the selected node to bold.

node.style.font.bold = true

// Sets the font of the selected node to italic.

node.style.font.italic = true

// Sets the name of the font of the selected node to "Arial".

node.style.font.name = "Arial"

// Sets the font of the selected node to size 20.

node.style.font.size = 20

// Sets the font of the selected node to strike through.

node.style.font.strikedThrough = true

/*
  IconsRO
*/

// Returns "true" if the selected node contains the icon "button_ok".

node.icons.contains("button_ok")

// Returns the icon located at the index 1 in the selected node.

node.icons[1]

// Returns the first icon that exists in the selected node.

node.icons.first

// Returns all the icons that exist in the selected node.

node.icons.icons

// Returns the urls of all the icons that exist in the selected node.

node.icons.urls

// Returns the number of icons that exist in the selected node.

node.icons.size()

/*
  Icons
*/

// Adds the icon "button_ok" to the node.

node.icons.add("button_ok")

// Removes all the icon that currently exist in the node.

node.icons.clear()

// Removes the icon at index 1.

node.icons.remove(1)

// Removes the first "button_ok" icon at that exists in the node.

node.icons.remove("button_ok")

/*
  ConditionalStyles
*/

// add a node conditional style to the end of the table
node.conditionalStyles.add(
        true, // isActive
        "node.text == 'Sunday'", // script
        'important', // styleName
        false) // isLast (aka stop)

// Adds an existing ConditionalStyleRO object. In the example, the ConditionalStyleRO object from the parent node.

node.conditionalStyles.add(node.parent.conditionalStyles.findAll())

// insert a node conditional style at the beginning of the table, with the condition "always"

node.conditionalStyles.insert(0, true, null, 'defaultstyle.floating', false)

// Inserts a copy of conditionalStyle at the specified position. It can be used to copy a conditional style between nodes or between maps. In the example, the conditional style located at index 0 of the parent of the selected node is inserted.

parentConditionalStyle = node.parent.conditionalStyles[0]
conditionalStyles.insert(0, parentConditionalStyle)

// move the third map conditional style to the top of the table

map.conditionalStyles.move(2, 0)

// remove the first map conditional style from the table

map.conditionalStyles.remove(0)

/*
  LinkRO
*/

// Retrieves the file associated with the link.

node.link.file

// Retrieves the node associated with the link.

link.node

// Retrieves the text of the link.

link.text

// Retrieves the URI of the link.

link.uri

/*
  Link
*/

// Removes the link.

link.remove()

// Sets the file associated with the link.

link.file = new File("C:/aaa.png")

// Sets the node associated with the link.

link.node = ID_1943538647

// Sets the text (stringified URI) for the link.

link.text = "http://www.google.com"

// Sets the URI for the link.

node.link.uri = new URI('http://www.google.com')

/*
  MindMapRO
*/

// Returns the background color of the map.

node.map.backgroundColor

// Returns HTML color spec like #ff0000 (red) or #222222 (darkgray).

node.map.backgroundColorCode

// Returns the filename of the map as a java.io.File object if available or null otherwise.

node.map.file

// Returns the title of the map.

node.map.name

// Returns the node that is the root of the map.

node.map.root

// Returns a list with the user defined styles names of the map.

node.map.userDefinedStylesNames

// Returns "true" if the map is saved.

node.map.saved

/*
  MindMap
*/

// Closes the mind map, with options to force close and allow interaction.

mindMap.close(true, false)

// Evaluates all formulas in the mind map.

mindMap.evaluateAllFormulas()

// Evaluates only the outdated formulas in the mind map.

mindMap.evaluateOutdatedFormulas()

// Filters nodes in the mind map with text core "aaa", don't show ancestors and show descendants.

node.map.filter(true, false){ it.text.contains("aaa") }

// Retrieves the list of listeners attached to the mind map.

mindMap.listeners

// Retrieves the storage mechanism of the mind map.

mindMap.storage

// Hides nodes in the mind map with text core "aaa", don't hide ancestors and hide descendants.

mindMap.hide(false, true){ it.text.contains("aaa") }

// Redoes the last filter applied to the mind map.

mindMap.redoFilter()

// Saves the mind map, and allow interaction during saving.

mindMap.save(allowInteraction)

// Saves the mind map as a new file.

mindMap.saveAs(new File('C:/new mindmap.mm'))

// Sets the background color of the mind map.

mindMap.backgroundColor = java.awt.Color.YELLOW

// Sets the background color of the mind map using an RGB string.

mindMap.backgroundColorCode = "#ffff00ff"

// Sets "aaa" as the name (title) of the mind map.

mindMap.name = "aaa"

// Sets the saved state of the mind map.

mindMap.saved = true

// Undoes the last filter applied to the mind map.

mindMap.undoFilter()

/*
  NodeGeometryRO
*/

// Returns the horizontal margin of the selected node.

node.geometry.horizontalMargin

// Returns "true" if the selected node has the property "uniform" activated.

node.geometry.isUniform

// Returns the shape of the selected node.

node.geometry.shape

// Returns the vertical margin of the selected node.

node.geometry.verticalMargin

/*
  NodeRO
*/

// Retrieves all descendants of the selected node.

node.allAt("**")

// Retrieves the parent node.

node.at("..")

// Finds nodes matching the condition node core is equal to "aaa", with options to include ancestors and descendants in the search set to true.

node.find(true, true, { it.text == "aaa" })

// Finds nodes matching the condition node core is equal to "aaa".

node.find{ it.text == "aaa" }

// Finds all descendant nodes.

node.findAll()

// Finds all descendant nodes in a depth-first manner.

node.findAllDepthFirst()

// Retrieves the alias of the node.

node.alias

// Retrieves the value of the attribute with the specified name.

node.getAt("aaa")

// Retrieves a map of all attributes of the node.

node.attributes

// Retrieves the base distance to children as a Length object.

node.baseDistanceToChildrenAsLength

// Returns a BASE64 encoded node text as a binary object

node.binary

// Retrieves the branch as a text outline.

node.branchAsTextOutline

// Retrieves the layout of the child nodes.

node.childNodesLayout

// Retrieves the position of the child node ID_1725317136.

node.getChildPosition(ID_1725317136)

// Retrieves a list of child nodes.

node.children

// Retrieves the cloud of the node.

node.cloud

// Retrieves a list of conditional styles applied to the node.

node.conditionalStyles

// Retrieves a list of connectors incoming to this node.

node.connectorsIn

// Retrieves a list of connectors outgoing from this node.

node.connectorsOut

// Retrieves the count of nodes sharing the same content (i.e., clones).

node.countNodesSharingContent

// Retrieves the count of nodes sharing the same content and subtree (i.e., clones).

node.countNodesSharingContentAndSubtree

// Returns the date that the node was created.

node.createdAt

// Returns the text of the details as a Convertible.

node.details

// Returns details content type.

node.detailsContentType

// Returns the raw HTML text of the details if there is any or null otherwise.

node.detailsText

// Plain or HTML text of this node after possible transformation (formula evaluation, formatting, ...)

node.displayedText

// Returns the format string of the formatter if available and null otherwise.

node.format

// Returns true if node details are hidden.

node.hideDetails

// Returns the horizontal shift of the node.

node.horizontalShift

// Returns the horizontal shift of the node, as length.

node.horizontalShiftAsLength

// Returns the horizontal shift of the node, in screen pixels.

node.horizontalShiftInScreenPixels

// Returns the node text as HTML markup.

node.htmlText

// Returns a reference to an accessor object for icons of this node.

node.icons

// Returns the node id.

node.id

// Returns true if the node can be accessed using global accessor

node.isGlobal

// Returns time that the node was last modified.

node.lastModifiedAt

// Returns the layout orientation of the node.

node.layoutOrientation

// Returns a reference to an accessor object for link properties of this node.

node.link

// Returns the mind map this node belongs to.

node.mindMap

// Returns the minimal distance between children.

node.minimalDistanceBetweenChildren

// Returns the minimal distance between children, as length.

node.minimalDistanceBetweenChildrenAsLength

// Returns the minimal distance between children, in screen pixels.

node.minimalDistanceBetweenChildrenInScreenPixels

// Returns the next node with respect to this node in depth-first order. Returns null if this node is the only one in the map.

node.next

// Returns the node level. As it's set to false, then only nodes that are matched by the current filter are counted.

node.getNodeLevel(false)

// Returns the count of nodes sharing their content (i.e., clones) with this node.

node.nodesSharingContent

// Returns the nodes sharing their content and subtree (i.e., clones) with this node.

node.nodesSharingContentAndSubtree

// Returns the text of the note as a Convertible.

node.note

// Returns note content type.

node.noteContentType

// Returns the HTML text of the node.

node.noteText

// Returns the object that's displayed as the node text - normally the raw text of this node (then this method is equivalent to getText())

node.object

// Returns the parent node.

node.parent

// Returns a list of all nodes starting from this node upto (and including) the root node.

node.pathToRoot

// Returns the plain text content of the node. Plain text after removal of possible HTML markup.

node.plainText

// Gets the previous sibling of the current node in the tree structure. I.e., returns the previous node with respect to this node in depth-first order.

node.previous

// Retrieves the reminder associated with the node, if any.

node.reminder

// Returns plain text of this node after possible transformation and forced text shortening (e.g., a minimized node).

node.shortText

// Returns the side of the root node where the node is located.

node.sideAtRoot

// Retrieves the style of the node.

node.style

// Returns the text of the node core. Raw text of this node which might be plain or HTML text. Possible transformations (formula evaluation, formatting, ...) are not applied.

node.text

// Returns a conversion of the node to a num, if possible.

node.to.num

// Returns a conversion of the node to a date, if possible.

node.to.date

// Returns a conversion of the node to a string.

node.to.string

// Returns a conversion of the node to a text.

node.to.text

// Returns a conversion of the node to the kind of object that fits best. Uses the following priority ranking to determine the type of the text: null; Long; Double; Date; String

node.to.object

// Returns the text of the node after applying any transformations like scripts or formulas. Plain or HTML text of this node after possible transformation (formula evaluation, formatting, ...).

node.transformedText

// Retrieves the value of the node.

node.value

// Returns the vertical shift of the node.

node.verticalShift

// Returns the vertical shift of the node as Length.

node.verticalShiftAsLength

// Returns the vertical shift of the node in screen pixels.

node.verticalShiftInScreenPixels

// Returns if the node has style "ex1".

node.hasStyle("ex1")

// Returns true if p is a parent, or grandparent, ... of this node, or if it is equal to this node; returns false otherwise.

node.isDescendantOf(p)

// Checks if the node is folded. Returns true if it is, false otherwise.

node.folded

// Checks if the node is a free node. Returns true if it is, false otherwise.

node.free

// Checks if the node is a leaf node (has no children). Returns true if it is, false otherwise.

node.leaf

// Checks if the node is minimized. Returns true if it is, false otherwise.

node.minimized

// Checks if the node is the root of the map. Returns true if it is, false otherwise.

node.root

// Checks if the node is at the top or position. Returns true if it is, false otherwise.

node.topOrLeft

// Checks if the node is at the top or left position when the parent is the Root in a map view. Returns true if it is, false otherwise.

node.isTopOrLeftOnViewsWithRoot(node.parent)

// Checks if the node is visible. Returns true if it is, false otherwise.

node.visible

// Checks if the node is visible in views that have the specified root node. In the example, returns true, because the specified node is the parent.

node.isVisibleOnViewsWithRoot(node.parent)

/*
  Node
*/

node.addConnectorTo(ID_1429940931)

// Adds a connector to another node specified as a Node object. In the example, the parent of the selected node.

node.addConnectorTo(node.parent)

// Appends a clone of the specified node (without its subtree) to this node. In the example, the cloned node is ID_1429940931.

node.appendAsCloneWithoutSubtree(ID_1429940931)

// Appends a clone of the specified node (including its subtree) to this node. In the example, the cloned node is ID_1429940931.

node.appendAsCloneWithSubtree(ID_1429940931)

// Appends the branch of the specified node (in the example, node ID_1429940931) as a copy to this node.

node.appendBranch(ID_1429940931)

// Appends a copy of the specified node (in the example, node ID_1429940931) as a child to this node.

node.appendChild(ID_1429940931)

// Appends an outline text as a branch to this node. The example has a first node "aaa" and a child node "bbb".

node.appendTextOutlineAsBranch(
        """
        aaa
            bbb
        """
)

// Creates a new child node under the current node.

node.createChild()

// Creates a new child node at the index position 1 under the current node.

node.createChild(1)

// Creates a new child node with the given value under the current node. In the example, the string "aaa".

node.createChild("aaa")

// Decrypts the content of the node using the password "acb123".

node.decrypt("acb123")

// Deletes the current node.

node.delete()

// Encrypts the content of the node using the password "acb123".

node.encrypt("acb123")

// Retrieves the geometry information of the node.

node.geometry

// Checks if the node has encryption enabled. Returns true if it does, false otherwise.

node.hasEncryption()

// Checks if the node is currently encrypted. Returns true if it is, false otherwise.

node.encrypted

// Moves the node to become a child of the specified node (in the example, node ID_1429940931).

node.moveTo(ID_1429940931)

// Moves the node to a specific position (in the example, position index 1) under the specified parent node (in the example, node ID_1429940931).

node.moveTo(ID_1429940931, 1)

// Inserts the node(s) copied from clipboard as clone(s).

node.pasteAsClone()

// Sets or updates the value (in the example, value "xxx") of an attribute with the specified name (in the example, attribute "aaa") for this node.

node.putAt("aaa", "xxx")

// Removes the specified connector from the node. In the example, first is created a list of the ConnectorsOut, then the connector at index 1 of this list is removed.

listOfConnectorsOut = []
listOfConnectorsOut += node.connectorsOut
node.removeConnector(a[1])

// Removes encryption from the node using the specified password.

node.removeEncryption("abc123")

// Sets an alias for the node.

node.alias = "aaa"

// Clear all attributes and sets attributes for the node using a map of key-value pairs. In the example, sets attribute "aaa", with value "xxx", and attribute "bbb", with value "yyy".

node.attributes = ["aaa" : "xxx", "bbb" : "yyy"]

// Sets the base distance to children nodes in integer format. In the example, 8.

node.baseDistanceToChildren = 8

// Sets the base distance to children nodes as a string. In the example, 8.

node.baseDistanceToChildren = "8"

// Sets the base distance to children nodes as a Quantity object with LengthUnit. In the example, 8pt.

node.baseDistanceToChildren = "8pt"

// Sets binary data for the node. Converts data to a BASE64 encoded string and sets it as this node's text. In the example, "aaa".

node.binary = "aaa"

// Sets the layout for the child nodes as "TOPTOBOTTOM_LEFT_BOTTOM".

node.childNodesLayout = "TOPTOBOTTOM_LEFT_BOTTOM"

// Sets the creation date of the node to "2010-12-20".

node.createdAt = Date.parse("yyyy-MM-dd","2010-12-20")

// Sets the node text to a default formatted datetime object. In the example, the current date and time.

node.dateTime = new Date()

// Sets the details of the node to "aaa".

node.details = "aaa"

// Sets the content type of the node's details to "latex".

node.detailsContentType = "latex"

// Sets the details text of the node, in HTML format, to "aaa".

node.detailsText = "aaa"

// Sets the folded state of the node as true.

node.folded = true

// Sets the format of the node as 'STANDARD_FORMAT'.

node.format = 'STANDARD_FORMAT'

// Sets whether the node is free (not attached to the main map).

node.free = true

// Sets whether to hide the details of the node.

node.hideDetails = true

// Sets the horizontal shift of the node in integer format.

node.horizontalShift = 8

// Sets the horizontal shift of the node as a string.

node.horizontalShift = "8"

// Sets the horizontal shift of the node as a Quantity object with LengthUnit.

node.horizontalShift = "8pt"

// Sets the global status of the node to true.

node.isGlobal = true

// Sets the last modified date of the node to "2010-12-20".

node.lastModifiedAt = Date.parse("yyyy-MM-dd","2010-12-20")

// Sets the minimal distance between children nodes in integer format.

node.minimalDistanceBetweenChildren = 8

// Sets the minimal distance between children nodes as a string.

node.minimalDistanceBetweenChildren = "8"

// Sets the minimal distance between children nodes as a Quantity object with LengthUnit.

node.minimalDistanceBetweenChildren = "8pt"

// Sets whether the node is minimized.

node.minimized = true

// Sets the note of the node as "aaa".

node.note = "aaa"

// Sets the content type of the node's note as "latex".

node.noteContentType = "latex"

// Sets the note text of the node, in HTML format, to "aaa".

node.noteText = "aaa"

// Sets an object associated with the node. In the example, the integer 8.

node.object = 8

// Sets the side of the node at the root as "TOP_OR_LEFT".

node.sideAtRoot = "TOP_OR_LEFT"

// Sets the text of the node to "aaa".

node.text = "aaa"

// Sets the vertical shift of the node in integer format.

node.verticalShift = 8

// Sets the vertical shift of the node as a string.

node.verticalShift = "8"

// Sets the vertical shift of the node as a Quantity object with LengthUnit.

node.verticalShift = "8pt"

// Sorts the children of the node according to the specified comparator. In the example, creation date.

node.sortChildrenBy{ it.getCreatedAt() }

/*
  NodeStyleRO
*/

// Returns all style names/translation keys active for the node.

node.style.allActiveStyles

// Returns the name of the background color of the selected node.

node.style.backgroundColor

// Returns HTML color spec like #ff0000 (red) or #222222 (darkgray).

node.style.backgroundColorCode

// Returns the CSS code set to the selected node.

node.style.css

// Returns the horizontal text alignment of the selected node.

node.style.horizontalTextAlignment

// Returns max node width set to the selected node.

node.style.maxNodeWidth

// Returns min node width set to the selected node.

node.style.minNodeWidth

// Returns the name of the node's style if set or null otherwise.

node.style.name

// Returns the style node of the style set to the selected node.

node.style.styleNode

// Returns the text color of the selected node.

node.style.textColor

// Returns code of the text color of the selected node.

node.style.textColorCode

// Returns "true" if the background color of the selected node is set.

node.style.backgroundColorSet

// Returns "true" if CSS of the selected node is set.

node.style.cssSet

// Returns "true" if the "floating" property of the selected node is set.

node.style.floating

// Returns "true" if the "Horizontal Text Alignment" property of the selected node is set.

node.style.horizontalTextAlignmentSet

// Returns "true" if the "Max Node Width" property of the selected node is set.

node.style.maxNodeWidthSet

// Returns "true" if the "Min Node Width" property of the selected node is set.

node.style.minNodeWidthSet

// Returns "true" if the "Numbering" property of the selected node is enabled.

node.style.numberingEnabled

// Returns "true" if the "Text Color" property of the selected node is set.

node.style.textColorSet

/*
  NodeStyle
*/

// Sets "YELLOW" as the background color of the selected node.

node.style.backgroundColor = java.awt.Color.YELLOW

// Sets "#ffff00ff" as the background color of the selected node.

node.style.backgroundColorCode = "#ffff00ff"

// Sets "aaa" as the CSS of the selected node.

node.style.css = "aaa"

// Sets the "floating" property of the selected node as true.

node.style.floating = "true"

// Sets the "Horizontal Text Alignment" property of the selected node as "LEFT".

node.style.horizontalTextAlignment = "LEFT"

// Sets the "Max Node Width" property of the selected node as 3 px.

node.style.maxNodeWidth = 3

// Sets the "Max Node Width" property of the selected node as 2 cm.

node.style.maxNodeWidth = "2 cm"

// Sets the "Min Node Width" property of the selected node as 3 px.

node.style.minNodeWidth = 3

// Sets the "Min Node Width" property of the selected node as 2 cm.

node.style.minNodeWidth = "2 cm"

// Sets the style "aaa" as the style of the selected node.

node.style.name = "aaa"

// Sets the "numbering" property of the selected node as true.

node.style.numberingEnabled = true

// Sets "YELLOW" as the text color of the selected node.

node.style.textColor = java.awt.Color.YELLOW

// Sets "#ffff00ff" as the text color of the selected node.

node.style.textColorCode = "#ffff00ff"
