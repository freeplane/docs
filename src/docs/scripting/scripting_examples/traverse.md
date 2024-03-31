## Created+ Modified HTML Table
Create an HTML Table of "created" and "modified" dates of all subnodes, from the selected node. Save the result to current node's note.

```groovy
def date_format(date) {
    return date ? date.format('yyyy-MM-dd HH:mm:ss'): 'N/A'
}

def node_to_html_table(starting_node) {
    def table = "<html><body><table><tr><th>Node</th><th>Created</th><th>Modified</th></tr>"
    starting_node.findAll().each { n -> table += "<tr><td>${n.text}</td><td>${date_format(n.getCreatedAt())}</td><td>${date_format(n.getLastModifiedAt())}</td></tr>" }
    table += "</table></body></html>"
    return table
}

node.note = node_to_html_table(node)
```

## Count number of nodes with the word "ok" in the entire map.
```groovy
def matches = c.find{ it.text.contains('ok') }
c.statusInfo = matches.size() + " nodes contain 'ok'"
```

## Create a child node with all icons of all subnodes
```groovy
def usedIcons = node.findAll()*.icons*.icons.flatten().unique().sort()
node.createChild("<-- all icons'").icons.addAll(usedIcons)
```
