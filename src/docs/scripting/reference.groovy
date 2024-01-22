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
