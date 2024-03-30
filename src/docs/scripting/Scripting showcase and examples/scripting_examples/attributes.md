## Attributes

Set attributes:
```groovy
node["attribute_text"]="hello"
node["attribute_num"]=123
```

Get attributes:
```groovy
c.statusInfo = node["attribute_text"]
```

Get attributes properties:
```groovy
c.statusInfo = node.attributes.size()
```

Clear attributes:
```groovy
node.attributes = [:]
```
