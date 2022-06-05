# Styles

A style is a bundle of [formatting](formatting-maps-and-nodes.md) properties, saved under a style name.

?> Styles' properties can be viewed and changed in `Format->Manage Styles->Edit stles (Ctrl+F11)` → [style editing](#style-editing)

Freeplane has several predefined styles, like `Default`, `Floating node` or `Important`, as well as `Automatic level styles` like `Level 1`, `Level 2`.
A template might have additional styles, and any mind map created from such a template will inherit the template styles. Moreover, any mind map can have its own additional styles and/or delete some of the inherited ones.

A style can be applied to a selected node by choosing the style in `Toolbar` on in `Tool panel`.

![](images/style_in_Toolbar_and_Tool_panel-1'10'2.png ':size=200')

By default, a node has no style assigned and Freeplane uses `Default` to format the node.
It's worth to note that there can be several styles active for a node.

The most common scenario is that `Automatic level styles` are enabled in a map, usually painting each level a different color.
Still, each node can be explicitly assigned a style, e.g. `Important`. Then style properties from both `Level ?` style and `Important` will blend.

![](images/apply_level_styles_and_explicitly_applied_style-1'10'2.png ':size=200')

To better understand how formatting using styles works, one needs to know that Freeplane uses a concept of layered Styles.

Here's the order of precedence in applying the different layers.

1. Character/word-level formatting
2. Selected style 
3. Node individual formatting, including "automatic edge color: on branch creation"
4. Explicitly applied style
5. Node conditional styles
6. Map conditional styles
7. Automatic edge color: for branches / levels / columns
8. Automatic level style
9. Default style

?> Note: `Selected style` is only in effect if `Preferences->Defaits->Selection colors->Display selected nodes in bubbles` is off

`Default` is the base layer. Whatever property is set on that layer will either shine through or be overwritten by the next layer put on top of `Default`.
If `Apply level styles` is enabled, any formatting property (e.g. background color) set on an `Automatic leve style` (e.g. `Level 1`), will override properties set on `Default`.
An `explicitly applied style` will overwrite the former two, and will be overwritten by `node individual formatting`, if set.

## Style editing

*TODO*

![](images/style_editing_dialog-1'10'2.png ':size=200')

## Making styles available to other mind maps

For a style to be available in other mind maps, it needs to be saved in a template → [templates](templates.md)
