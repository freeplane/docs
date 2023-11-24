<!-- toc -->

# Styles

A style is a bundle of [formatting](formatting-maps-and-nodes.md) properties and icons, saved under a style name. 
Styles are saved in the map itself.

> Note: Styles' properties can be viewed and changed in `Format->Manage Styles->Edit stles (Ctrl+F11)` → [style editing](#style-editing)

Freeplane has several predefined styles, like `Default`, `Floating node` or `Important`, as well as `Automatic level styles` like `Level 1`, `Level 2`.
A template might have additional styles, and any mind map created from such a template will inherit the template styles. 
Moreover, any mind map can have its own additional styles and/or delete some of the inherited ones.

A style can be applied to a selected node by choosing the style in `Toolbar` on in `Tool panel`.

![](../images/style_in_Toolbar_and_Tool_panel-1'10'2.png ':size=200')

By default, a node has no style assigned and Freeplane uses `Default` to format the node.

It's worth to note that there can be several styles active for a node.
The most common scenario is that `Automatic level styles` are enabled in a map, usually painting each level a different color.
Still, each node can be explicitly assigned a style, e.g. `Important`. 
Then formatting properties from both `Level` and `Important` will blend.

![](../images/apply_level_styles_and_explicitly_applied_style-1'10'2.png ':size=200')

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

> Note: `Selected style` is only in effect if `Preferences->Defaits->Selection colors->Display selected nodes in bubbles` is off.

`Default` is the base layer. 
Whatever property is set on that layer will either shine through or be overwritten by the next layer put on top of `Default`.
If `Apply level styles` is enabled, any formatting property (e.g. background color) set on an `Automatic leve style` (e.g. `Level 1`), will override properties set on `Default`.
An `explicitly applied style` will overwrite the former two, and will be overwritten by `node individual formatting`, if set.

## Style editing

To manage styles you need first to open the styles editor: `Styles->Edit styles`.\
Result: a map containing all styles is displayed.

![](../images/style_editing_dialog-1'10'2.png ':size=200')

There you can modify all defined styles: either styles provided by default with Freeplane, or add/change your own styles. 
Note that's its allowed to remove default freeplane's styles.

**To add your own style:**

* in the styles editor, choose the style with the nearest format of the style you want to create, right click on this style, select in the contextual menu `Save as new style...`, enter new style name.\
  Result: a new style is added and appears in the user's styles branch.

You can now fully define the style with the formatting panel. 
Close the style editor. 
Your new style is available for immediate use in toolbar's style list. 
Tip: you can also create a new style from a main map's node with the command `Styles->New style from selection`.

**To rename a user style:**

* in the styles editor, select you style, right click, select in the contextual menu `Save as new style...`, enter the new name you want, remove the old style entry.

**To change the display order of styles in the main toolbar styles list:**

* in the styles editor, move up / down branchs or styles.

### Pre-defined styles

Some predefined styles are available in Freeplane. 
You can either use them "as they are" or change them as it's convient for you. 
Two pre-defined styles named "Details" and "Notes" have a particular behaviour because they are used  to format Node Details and Node Notes:

* Font and colors of node details is controlled by style "Details"
* Font of notes (not the color) is controlled by style "Notes".

### Other style features

* menu `Styles->Copy styles...` imports, in the current map, styles from an other mindmap.
* menu `Styles->Redefine style` redefine node style based on current node formats. It changes formats of all nodes using this style.

## Making styles available to other mind maps

For a style to be available in other mind maps, it needs to be saved in a template → [templates](templates.md)
