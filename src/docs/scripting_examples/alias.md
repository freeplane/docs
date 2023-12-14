## Alias
First, set an alias for a node. right click, choose "Set node alias" and type "alias1".
Then, in another node, you can reference the first node using the following code:
```groovy
node.details=node.at("/**/~alias1").text
```

