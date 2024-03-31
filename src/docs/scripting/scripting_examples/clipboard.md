## Copy link to clipboard
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
def link = node.link.text
if (link) {
	textUtils.copyToClipboard(node.link.text)
	c.statusInfo = "Hyperlink Copied."
} else {
	c.statusInfo = "no link in ${node.text}"
}
```

