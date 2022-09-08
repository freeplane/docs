Nodes can be formatted depending on its content. The rules for automatic node formatting consist of a condition like the conditions used for filters and a style name. Thus node formatting can depend on its content, attributes, icons or level. They can be set using "Styles->Manage conditional styles".

Because each style may set only some of the formatting attributes the resulting node formatting is a sum of formats defined by explicitly set format, explicitly assigned style and all matching conditional styles.

So if there is more than one conditional style, all those styles are applied to the nodes that satisfy all those given conditions, and so each node will be formatted by a composition of multiple styles. Here if different styles set different properties, all of them are applied to a node; otherwise the upper style has higher priority.

However if "Stop" is checked in one conditional-style and the condition is satisfied, then all following styles are ignored and their conditions are not evaluated.



Demo video of Conditional Styles (with and without the STOP option), and a resume diagram

https://youtu.be/ayfifHlbyjc

![FreeplaneConditionalStyle_161113_222746.png}}](../images/FreeplaneConditionalStyle_161113_222746.png ':size=200')

<!-- ({Category:Documentation}) -->

