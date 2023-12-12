## Add custom checkbox (switch between completed and not completed), with icons.
```groovy
// @ExecutionModes({ON_SELECTED_NODE})
if (node.icons.icons.contains("unchecked")) {
    node.icons.remove("unchecked")
    node.icons.add("button_ok")
} else {
    node.icons.remove("button_ok")
    node.icons.add("unchecked")
}
```


