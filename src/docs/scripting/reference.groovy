// This file contains Freeplane API reference for Groovy scripting.

/*
  AttributeCondition #todo: [euu2021: I don't understand what it does.]
*/

/*
  AttributesRO
*/

// Returns "true", if the selected node contains an attribute key that is equal to "aaa". Returns "false", otherwise.

node.attributes.containsKey("aaa")

// Returns the index of the first attribute with the name "aaa" if one exists or -1 otherwise.

node.attributes.findFirst("aaa")

// findValues(AttributeCondition condition) #todo

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

// #todo: [euu2021: I don't understand what this method bellow does.]

node.attributes.transformed

// Returns all values as a list of Convertible. #todo: [euu2021: I don't understand what it does.]

node.attributes.values

// Returns "true", if the selected node has no attributes. Returns "false", otherwise.

node.attributes.empty

// Returns the number of attributes.

node.attributes.size()

/*
  Attributes [euu: I already have the methods, so please skip this one]
*/
