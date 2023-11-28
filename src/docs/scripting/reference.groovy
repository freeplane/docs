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

/*
  Attributes
*/

// Adds an attribute with key "aaa" and value "xxx", no matter if an attribute with the given name already exists.

node.attributes.add("aaa", "xxx")

// Adds an attribute with key "aaa", value "8", with formatting pattern "0.0", no matter if an attribute with the given name already exists.

node.attributes.add("aaa", "8", "0.0")

// Removes all attributes of the selected node.

node.attributes.clear()

// Optimizes widths of attribute view columns according to contents.

node.attributes.optimizeWidths()

// Removes the attribute at the index 1.

node.attributes.remove(1)

// Removes all attributes with name "aaa".

node.attributes.removeAll("aaa")

// Sets "xxx" as the value of the attribute at index 1.

node.attributes.set(1,"xxx")

// Sets "aaa" as the key, and "xxx" as the value of the attribute at index 1.

node.attributes.set(1, "aaa", "xxx")

// Sets "aaa" as the key, "8" as the value, and "0.0" as the format pattern of the attribute at index 1.

node.attributes.set(1, "aaa", "8", "0.0")

// Adds an attribute with key "aaa" and value "xxx" if there is no attribute with the given key or changes the value of the first attribute with the given key.

node.attributes.set("aaa", "xxx")

// Sets "0.0" as the format pattern to the attribute at index 1.

node.attributes.setFormat(1, "0.0")
