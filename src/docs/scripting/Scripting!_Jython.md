# Hints for scripting Freeplane in Python/Jython

You may want to have this url http://www.freeplane.org/doc/api/ at hand.

## Attributes

    node.attributes.get(name) # no default value, returns None if non-existant
    node.attributes.set(name, value)
    if 'myAttrib' in node.attributes.names:
    ...

## Node Text, Details and Notes

    txt = node.text          # also available via node.getText()
    node.setText("new text") # can not assign to node.text
 
    details = node.getDetailsText()     # Question: would node.getDetails() be better?
    node.setDetails('new details text')
 
    note = node.getNoteText()           # Question: would node.getNote() be better?
    node.setNote('new note text')

<!-- ({Category:Script}) -->

