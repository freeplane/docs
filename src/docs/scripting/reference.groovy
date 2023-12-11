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

node.style.font.isBold()

// Returns "true" if the font of the currently selected node is set to bold.

node.style.font.isBoldSet()

// Returns "true" if the font of the currently selected node is italic.

node.style.font.isItalic()

// Returns "true" if the font of the currently selected node is set to italic.

node.style.font.isItalicSet()

// Returns "true" if the name of the font of the currently selected node is set.

node.style.font.isNameSet()

// Returns "true" if the size of the font of the currently selected node is set.

node.style.font.isSizeSet()

// Returns "true" if the font of the currently selected node is striked through.

node.style.font.isStrikedThrough()

// Returns "true" if the font of the currently selected node is set to strike through.

node.style.font.isStrikedThroughSet()

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

node.icons.getAt(1)

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
  MindMapRO
*/

// Returns the background color of the map.

node.map.getBackgroundColor()

// Returns HTML color spec like #ff0000 (red) or #222222 (darkgray).

node.map.getBackgroundColorCode()

// Returns the filenname of the map as a java.io.File object if available or null otherwise.

node.map.getFile()

// Returns the title of the map.

node.map.getName()

// Returns the node that is the root of the map.

node.map.getRoot()

// Returns a list with the user defined styles names of the map.

node.map.getUserDefinedStylesNames()

// Returns "true" if the map is saved.

node.map.isSaved()
