## How to reference a node

In all the examples, the text of the referenced node is changed to `this`.

| Node               | Example                                |
| ------------------ | -------------------------------------- |
| Root               | node.mindMap.root.text = "this"        |
| Parent             | node.parent.text = "this"              |
| Selected Node      | node.text = "this"                     |
| All selected Nodes | node.text = "this"                     |
| First child        | node.children\[0\] = "this"            |
| All children       | node.children.each {it.text = "this"}  |
| The whole branch   | node.findAll().each {it.text = "this"} |


## Inspector

```
textUtils.copyToClipboard(node.icons.getAt(0)) //copy the name of the first icon to the clipboard
```
```
c.statusInfo = node.icons.getAt(0) 
```

## Condition tester

Another option is to use the Filter Toolbar, with the option Filter->Highlight all matching nodes, and compose a Script Filter directly in the toolbar
```
if (node.text == "this") {
	c.statusInfo = "yes"
}

else {
	c.statusInfo = "no"
}
```
