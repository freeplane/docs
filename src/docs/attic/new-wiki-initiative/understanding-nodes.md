<!-- toc -->


# Understanding nodes
## Node elements
### Overview

Nodes are the fundamental element of mind maps.
Although nodes appear simple at first, they have many optional elements that can increase their functionality.

What appears to be the whole node at first is actually just the [node core](glossary.md#node-core).
If you create a new node and begin typing, the text is entered in the node core by default.
Beginning users generally limit their use of nodes to the node core.

Additional information can be stored in nodes outside the core as node details, node notes, and node attributes.

### Node core

The node core is the only part of the node that is always visible whenever the node itself is visible.
The node core can itself contain several types of information: text (including numbers), icons,  images, and links.

![Several Node cores in a mind map](images/node_core.png ':size=200')

The text in the node core can be interpreted or parsed by Freeplane in different ways, which can be set in the Format Panel drop-down menu `Core text->Format`.
To understand the implications of this setting, see (to be added).

### Node Details

### Node Notes

### Node Attributes

### Edges

### Connectors

Unlike edges, connectors must be added manually, one by one.
To add a connector, select two nodes, `right-click` for a context menu and select `Connect (Ctrl+L)`.
Another way is to `Ctrl+Shift + drag` one node onto another.
On some systems it's also possible to `right-click + drag` one node onto another.

Connectors' properties can be edited.
When you `right-click` a connector (it's best to select one of the connected nodes first), the **Connector** dialog appears.
Here you can set formatting properties individually or select a Style (or both), set labels' text and remove the connector.
*See also [Connector styles](#connector-styles) below.*

By default, a connector's shape is `Curve`①.
The other options are `Line`②, `Linear path`③ and `Simulate edge`④.
The last one does exactly that: simulates an edge between the nodes.
Freeplane achieves this by applying the formatting properties of the edge defined for the target node, ignoring the **Connector**-dialog properties.

![](images/connector_styles.png ':size=200')

The shape of `Curve`①. `Line`② and `Linear path`③ can be changed using curve-shaping of either end – just click on the line near a node (it's best to select the node first).
You will see handles appear.
By dragging your mouse up to ~50% of the distance between the nodes, the near handle is adjusted.
Going beyond ~50% or clicking near the middle adjusts both handles at once.
You'll often need to repeat your click-drag-release several times before you get the expected result, i.e. without affecting the far end.

![connectors](images/connectors.gif ':size=200')

#### Hidden connectors

Connector lines can be hidden: `Preferences…->Defaults->Connectors->Paint connectors behind nodes`

#### Go to a connected node

Like for clones, the right-click node menu item `Goto` list the other ends of Connectors.

#### Same-node connectors

Both ends of a connector can be attached to the same node, looping back to itself.
To create such a connector, `right-click` a single node and select `Connect (Ctrl+L)` or use any of the other methods described above.

When using `Line` as the type, the connector appears one-ended.
`Line` is often used to draw an arrow going out of a node into empty space (as seen in Freeplane `Help->Tutorial`).

#### Connector styles

Connectors use styles.
The concept is the same as for nodes *(see [Styles](styles.md))*, i.e. the bundle of connector formatting properties is saved as a connector style.
Technically, a connector style is part of a node style.
When a node style has a connector defined, like **Default** has, the style becomes also a connector style.

When a connector is added, a style is applied to it, which determines how the connector looks like.
By default, it's the **Default** style.
There's an option to apply a style based on the style defined on the source or the target node.
The option can be enabled in `Preferences (Ctrl+COMMA) -> Defaults -> Connectors -> Assigns node dependant styles to new connectors`.
The logic is the following:
if the source node has a style applied which has a connector defined, the style is applied to the connector;
otherwise, the target node is checked for the same.

The style of a connector can be switched in the **Connector** dialog.
To open it, `right-click` on a connector.
It's best to select a connected node first, to indicate which connector the dialog should open for.

## Types of nodes

In addition to standard nodes, there are some special types of nodes:

1. the root node
2. free nodes

![](images/nodes_root_node_free_nodes.png ':size=200')

### The root node
Every mind map begins with a central node called the root node.
Node levels are defined based on their distance from the root node.

### Free nodes

Free nodes are nodes that appear separate from the map hierarchy.
They are "free" because they can be freely positioned around the map.
They are not automatically positioned like other nodes and they generally do not affect other nodes when they are changed or moved.
Any node can be freed by enabling `Edit->Free positioned node (set/reset)`.

A special type of free node is a **Floating node**.
It can be added by `Ctrl+double-click` on the map background, or by `Insert->New node->New floating node`.
Note: although **Floating nodes** are positioned independently, technically, they are first-level nodes that are invisibly connected to the root node.
You can add children, parents, or siblings to free floating nodes, but you may get unexpected behaviors.

Technically, a **Floating node** is simply a node with three features:

* they are given the style `Floating node`, which connects to other nodes with invisible edges
* they have the toggle at menu item `Edit->Position node independently` set to "on"
* their oval positioning handle is filled and blue rather than unfilled and red

Other nodes can also be given the style `Floating node` and can be set to be positioned independently: `Edit->Free positioned node (set/reset)`.

### Clone nodes
### Node groups
#### Summary nodes

![](images/nodes_summary_nodes.png ':size=200')

Summary nodes have brackets that suggest that their content summarizes a group of sibling nodes.
Technically, summary nodes are specially marked sibling nodes of the summarized nodes.
Summary nodes can include other summary nodes within their brackets, creating the impression of a "reverse" map with branches joining rather than splitting.

Summary node brackets can be customized the usual way, by changing the edge formatting properties: width, line type, color.
The only exception is its shape (aka edge style) that isn't customizable.

#### Node clouds

## Node position

## Node view options

#### Hide nodes (per-node setting)

#### Show hidden nodes

#### Minimize nodes

#### Hide node details

#### Hide/show node attributes

#### Tool tips

## Other resources

