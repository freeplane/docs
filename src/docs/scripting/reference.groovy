// This file contains Freeplane API reference for Groovy scripting.

/*
  AttributesRO
*/

// Returns "true", if the selected node contains an attribute key that is equal to "aaa". Returns "false", otherwise.

node.attributes.containsKey("aaa")

// Returns the index of the first attribute with the name "aaa" if one exists or -1 otherwise.

node.attributes.findFirst("aaa")

// Returns the attribute value at the index 1.

node.attributes.get(1)

//  Returns the values of all the attributes that has the key equal to "aaa".

node.attributes.getAll("aaa")

// Returns the first value of an attribute with the name "aaa" or null otherwise.

node.attributes.getFirst("aaa")

// Returns the attribute key at the index 1.

node.attributes.getKey(1)

// Returns all attributes as a map.

node.attributes.map

// Returns all attribute names in the proper sequence.

node.attributes.names

// Returns "true", if the selected node has no attributes. Returns "false", otherwise.

node.attributes.empty

// Returns the number of attributes.

node.attributes.size()

