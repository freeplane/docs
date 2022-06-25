<!-- introduction -->
# Many unsorted ideas related to Freeplane

### Getting started

Freeplane is very powerful and customizable, so we recommend you learn the basics before reading straight through all of the documentation, and be aware that you don't need to know about all of the advanced features and concepts to benefit from Freeplane. 
Have fun!

## Why Freeplane?

### What are mind maps?

Mind maps are diagrams and a visual way of associating topics, terms and smaller graphical elements.
This allows to get an overview about a topic as well as showing a certain degree of strucutre.
Spreading from the center outwards, they have a hierarchy (tree-style) and connect different aspects and elements.
Mind maps can therefore be used to structure topics, make outlines for texts, document brainstormings or serve as a knowledge-base.
The method of "mindmapping" and mind maps are coined by the british author and psychologist Tony Buzan († 2019).

### Why use mindmapping software?

### Why use Freeplane rather than other mindmapping software?

Freeplane is a mind mapping program with many overwhelming advantages and a small number of significant disadvantages when compared to similar programs.

#### Advantages:

* Completely free and open-source
* 15+ years of active development
* Frequent updates and improvements (on average, new development versions every 2 weeks)
* Cross-platform (Win, Mac, Linux)
* Can handle very large maps (10,000+ nodes) with good performance
* Supports add-ons, plug-ins, and custom scripting
* Open and well-documented API
* You own all your data in local files with open formats
* Extremely customizable
* Active community
* Allows full keyboard control
* Supports complex formatting and styling logic
* Supports text, number, and date/time data formats
* Supports formulas (not just display, but actual calculations on map data)
* Supports HTML, Markdown, and LaTex

#### Disadvantages:

* UI is very dated (if you can help us improve this, please contact us!)
* No mobile client (Freeplane API now supports mind maps as an event stream; if you want to help us develop a mobile client, please contact us!)
* Does not currently support real-time online collaborative editing (if you want to help us develop this capability, please contact us!)
* Does not support as wide a variety of layouts as some other programs, such as flowcharts, org-charts, and Gantt chart.
  We are open to developing these features if users identify them as needed.

Until recently, Freeplane has had one other significant disadvantage: documentation that was completely inadequate for conveying its immense functionality.
Freeplane can do so much, and gives the user so many options, that it can be overwhelming.
This documentation site is our ongoing attempt to address this concern!

### A note about types of mind mapping software

There are many applications with overlapping functions but different primary purposes.
You can make mind maps with Microsoft PowerPoint, but it is fundamentally a presentation program.
Freeplane is not fundamentally a diagramming program, or a team project management program, or a calendar program, but it can serve all of those needs to different degrees.

It is useful to know, however, that Freeplane is fundamentally a program designed to capture, organize, and manipulate information in mind maps, and to be highly customizable down to its basic functions, including scripting and add-on support.

## About this documentation

### How we think about documentation

### User levels

### Credits and contributors

#### Previous documents used to create this site include:

15 part Freeplane manual written by Elmer Perry, published online in Full Circle Magazine (www.fullcirclemagazine.org) under a Creative Commons Attribution—Share Alike 3.0 Unported license; parts available at https://fullcirclemagazine.org/tag/freeplane/

Manual de Freeplane [Freeplane Manual] written by Luis Javier Gonzalez Caballero aka kewapo, 2019

Materials previously hosted on www.freeplane.org

Documentation and tutorial mind maps distributed with Freeplane and accessible (currently or previously) through Freeplane's `Help` menu

## Understanding Freeplane concepts

### Mind map elements

Speaking generally, mind maps are made of two elements: nodes and connectors.
Nodes contain information, often put in a shape or "bubble", and connectors are lines that show relationships between information.

There are two main types of connectors in Freeplane that relate to two different ways people think of mind maps.
Traditionally, mind maps were primarily thought of as aids for brainstorming, and this led to a "whiteboard" model where the nodes quickly captured information and were placed and connected in a loose way to show general associations between ideas.
The focus was on information capture and creativity.

Mind mapping software, however, started to bring mind maps more of an "outlining" model, with increased focus on capturing information in order to organize it into more meaningful structures.
Freeplane, like most mind mapping software, defaults to this type of structured approach, although it supports both models quite well.

In Freeplane, these two models are reflected in two ways to connect nodes.
(Edges)[link] connect nodes in hierarchical relationships (sometimes referred to as family relationships) and reflect the "map as outline" approach.
(Connectors)[link] link nodes in looser ways that can be specified by the user with labels, reflecting a "map as whiteboard" approach.
We will call these "hierarchical" and "general" connections, but note that "general" refers to the broad variety of meanings that connectors can have, not that connectors can imply only vague relationships.
With labels, connectors can be extremely specific.

Hierarchical node connections (using edges) are not exclusive from general node connections (using connectors).
Maps can use both, and their functions overlap.
Yet this distinction can help users understand why Freeplane has both edges and connectors.

Although it supports many uses, Freeplane focuses on the "map as outline" model over the "map as whiteboard" model.
It emphasizes organization and manipulation of information more than diagramming flexibility.
Freeplane thus considers edges more fundamental than connectors, and will automatically connect all nodes with edges, while connectors must be added manually one-by-one.

(Like almost everything in Freeplane, this is a changeable default.
This documentation describes Freeplane based on its default settings, many of which can be changed in ways described elsewhere in the documentation).

There is one last fundamental element to Freeplane mind maps: the map background, which is blank white by default, but can be customized in different ways.

Summary: the four basic Freeplane mind map elements are nodes, edges, connectors, and the map background

### Mind map structure

Nodes can be thought of as having levels, with first-level nodes being those nodes directly connected to the central node of the map (also known as the root node).
Nodes connected to first-level nodes are second-level nodes, being two "steps" away from the central node, and so on.

Discussion about node levels can be confusing because when users refer to higher-level nodes, they are usually talking about nodes closer to the root node, which have a lower level "number".
For example, a first-level node (level 1) is often thought of as higher level than a fourth-level node (level 4), even though four is more than one.
Possibly for this reason, node relations are  most commonly talked about using metaphors rather than numerical levels.
This documentation uses two main metaphors to discuss how nodes relate to each other: 1) a tree, and 2) family relations.
(These are sometimes combined in the notion of a "family tree").

#### Tree metaphor

The central node is called the root, like the root of a tree.
The first node connected to the root is the beginning of a branch.
The branch includes all nodes connected to that first branch node.
Branches can divide into smaller branches.
At the end of a branch are leaf nodes, which are the nodes farthest from the root node, and which have no higher-level nodes connected to them by edges.

The leaf nodes in a map are not all necessarily at the same level.
Any node that is at the highest level on its branch is a leaf node, but different branches might extend to a different number of levels.

(e.g. to be added)

#### Family relations

Higher-level and lower-level nodes are usually described in terms of family relationships.
A level one node is the parent of a level two node that is directly connected to it, and the level two node is the child of the level one node.

Child nodes that share a parent node are sibling nodes.

Sometimes, people refer to multiple levels using family terms (e.g. a node's grandparent or grandchildren), but the most common terms are parent, child, sibling, ancestor, and descendent.

Leaf nodes are more easily understood using family terms: leaf nodes are simply nodes with no children, and non-leaf nodes are any nodes with children.

Exception: free nodes (sometimes called "free positioned nodes") can be added to maps outside of the map hierarchy.
They are technically children of the root node, but do not follow normal node behaviors and are formatted differently.

### Map layout

Unlike some other programs, Freeplane focuses on mind maps that have a hierarchy of nodes connected in family relationships.
This one logical layout can be viewed in two ways in Freeplane:

- Freeplane defaults to a map where branches radiate outward from the root node in many directions, similar to spokes on a bicycle wheel.
This is the "normal view" (sometimes called a radial view).
	- Note: the user can keep all branches on one side of the root; see [link] for more information.
- The "outline view" lets you see the information in your map in a vertical list more like a traditional outline, with the root node at the top and branches below.

### How node formatting works in Freeplane

Freeplane has the capability for much more advanced formatting than most mind mapping programs, and thus formatting can become quite complex.
This section explain the basic logic of Freeplane formatting so you can understand these options and eventually learn to use the program's capabilities.

Nodes are formatted by looking at options we call formatting elements.
These elements include familiar ways to change text appearance, such as making text bold, changing text size, and using different fonts.
Mind maps also offer formatting options such as choosing node shape and edge color.

Each of these formatting elements has a value.
The element "bold" can have the value "on" or "off".
The element "font size" can have a wide range of numerical values.
To format map nodes, Freeplane looks at each of the relevant format elements, determines each element's value, and then formats the node accordingly.

Node formatting in Freeplane is more complicated than typical text formatting in other programs because, for maximum flexibility and functionality, formats can be set in four ways:

1. directly, manually, for each formatting element of an individual node
1. directly, by manually applying a saved combination of formatting element values, which we call a style
1. indirectly, by setting defaults that automatically apply styles to certain types of nodes according to program preferences
1. indirectly, by setting custom logical rules that determine the values a node will have based on conditional criteria

Regardless of how format is set, Freeplane looks in several places, in a certain order, to determine the value of various formatting elements so it can format the node.
For the basic user, Freeplane's formatting logic can be understood like this:

* Freeplane sets all of the formatting options to match the node's style (either Default or another style).
  (For more detail on how this works, see (Styles and Templates)[link].)
* Freeplane then checks if the user has set any specific formatting values for this individual node (e.g., "font size=12").
  If they have, Freeplane changes the formatting value for this node to the user setting.

(e.g. to be added)

For the advanced user, Freeplane's formatting logic is better described in this way: for each formatting element, Freeplane checks the values set at each location in following list.
It uses the value at the highest (topmost) level in this list where the element's value is set.

* formatting tags inside node core text (hidden from most users)
* values manually set at the individual node
* node conditional styles (values set by user-specified rules)
* map conditional styles (values set by user-specified rules)
* values defined by the node style (if other than Default)
* Default style values
* internal program values (invisible to end user)

(e.g. to be added)

It is important to understand that not all formatting elements are given values at each of these levels.
For example, a user might set an individual node to "bold = on" but change no other values.
In that case, when finding a value for a different element (like "font size") Freeplane simply checks the next lower level down and uses the first value for the element that it finds.

## Getting help

This documentation is a work in progress with a long way to go.
If your question is not answered here, see the resources listed in Freeplane under `Help->Web resources` for additional help.

Asking questions in the Freeplane forum will help us figure out the documentation areas we need to improve.

## Freeplane community

## Installing Freeplane

## Your first Freeplane map (tutorial)

