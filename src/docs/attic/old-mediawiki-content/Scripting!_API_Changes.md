<!-- toc -->

The [Scripting API](Scripting_API.md), which is defined by the [org.freeplane.plugin.script.proxy.Proxy](http://www.freeplane.org/doc/api/org/freeplane/plugin/script/proxy/Proxy.html) interface and is [documented as JavaDoc](http://www.freeplane.org/doc/api/), will evolve over time but Freeplane's developers will do whatever possible to keep new API versions downward compatible. On the other hand there might be changes in parts of the Freeplane code that are not part of the official API but on which some scripts might depend nevertheless. This mostly applies to the [utility classes](Scripting!_Freeplane_Utility_Classes.md).

Changes to the API are indicated per method by version numbers in the [JavaDoc of the Proxy class](http://www.freeplane.org/doc/api/org/freeplane/plugin/script/proxy/Proxy.html).

Here a possibly incomplete list of changes from 1.3 to 1.5:

* node.attributes.containsKey(String)
* node.attributes.optimizeWidths()
* node.icons.addAll(Collection<String>)
* node.icons.addAll(otherNode.icons)
* node.link.remove()
* node.sortChildrenBy{ Closure }
* support units like mm, cm, pt for lengths and dimensions
* c.select(Collection<Node>)
* c.getOpenMaps()
* textUtils.setClipboardContentsToHtml()

Clones

* c.pasteAsClone()
* node.appendAsCloneWithSubtree(NodeRO toBeCloned)
* node.appendAsCloneWithoutSubtree(NodeRO toBeCloned)
* node.getCountNodesSharingContent()
* node.getCountNodesSharingContentAndSubtree()
* node.getNodesSharingContent()
* node.getNodesSharingContentAndSubtree()


<!-- ({Category:Script}) -->

