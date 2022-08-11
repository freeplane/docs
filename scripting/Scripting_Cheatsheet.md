## How to reference a node

```
node.mindMap.root.text = "this" //root node
```
```
node.parent.text = "this" //parent of the selected node
```
```
node.text = "this" //selected node
```
```
node.at("~1").text = "this" //first child of the selected node
```
```
node.allAt("*").each {
	it.text = "this"
} //all children of the selected node
```
```
node.allAt("*").text = "this" //first child of the selected node
```
```
node.findAll().each {
	it.text = "this"
} //the whole branch of the selected node
```

See more at the methods at() and allAt() under NodeRO, in the API

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
