## Select children nodes

This scripts select the children nodes of the selected nodes.

```groovy
// @ExecutionModes({ON_SINGLE_NODE})
def toSelect = c.selecteds.collect{ node -> node.find {it.parent == node} }.sum()
c.selectMultipleNodes(toSelect)
```

