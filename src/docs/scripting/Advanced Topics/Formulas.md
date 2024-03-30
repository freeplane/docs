<!-- toc -->

Formulas are very similar to formulas in spreadsheet processors like Excel or OpenOffice Calc:

```groovy
 =2 + 3
```

Formulas, which are identified by the leading '=', are expressions that
are evaluated for display. That is their result is displayed instead of
the formula text. In case of <tt>=2 + 3</tt> this would be <tt>5</tt>. The formula
itself (<tt>=2 + 3</tt>) is only visible in the editor.

## Overview

Formulas can be defined in

* node texts
* attribute values
* notes

Formulas are evaluated as Groovy scripts. This fact defines the basic
syntax of formulas. But although Groovy is a full-blown programming
language simple things are very simple in Groovy like this:

```groovy
  = 3 * 2
```

gives <tt>6</tt>,

```groovy
  = (3 * 2) + " times"
```

gives <tt>6 times</tt>. Note that the space after the '=' is
optional.

Now something more complex:

```groovy
  = children.sum(""){ it.text }
```

gives the concatenation of all child node texts. By using <tt>sum("")</tt> instead of <tt>sum</tt> we set the start value to "" and ensure that the formula also works if the node has no children at all.

```groovy
  = children.sum(0){ it.to.num }
```

sums over the numerical values of the child nodes.

The following statement sums over the numerical values of the attribute <tt>item</tt> of all childrens. If one child does not have that attribute or if it isn't convertible to a number <tt>num0</tt> (or <tt>getNum0()</tt>) uses 0 instead (since 1.2.1_17).

```groovy
  = children.sum(0){ it['item'].num0 }
```

Formulas have access to a read-only variant of the [Scripting API](Scripting_API.md),
i.e. formulas may not change anything in a map. There are some
minor extensions to the Groovy language for formulas to improve the ease of
use, e.g. for simpler data type conversion.
Note that properties and methods of a formula node (like <tt>children</tt> or
<tt>text</tt>) are directly available to the formula, i.e. the leading
"node." can be left out.

## References

Formulas have access to all nodes in the map by

* navigating the hierarchy for instance via <tt>=node.children</tt>, <tt>=node.parent</tt> or <tt>=node.map.root</tt>
* searching the map via <tt>find</tt>, e.g. <tt>=node.find{ it.text == 'sum'}</tt>.
* direct references to a specific node by id like <tt>ID_172581364.to.num</tt>. To enter the id of a node double-click on the node while the formula editor is opened or use the function *Copy Node ID* in the context menu of a node.

Note that like in Excel you can easily create circular references if a node references itself (either directly or indirectly). 

```groovy
  = parent.children.sum{ it.to.text }
```

The circular reference is obviously due to navigating back and forth
in the hierarchy. Now an Example that more likely may occur to you
(paste the next lines into a map):

```groovy
  = "count nodes above 10: " + node.find { it.to.num > 10 }.size()
    = 10
    = 11
```

The result should be <tt>count nodes above 10: 1</tt> but the
<tt>find</tt> tries to evaluate itself since <tt>it.to</tt> involves a formula evaluation. This leads
to this error:

    Circular reference: The formula in node '= count nodes....' references itself.

To prevent that you should avoid formula evaluation in the argument to <tt>find</tt> like this:

```groovy
  = "count nodes matching '11': " + node.find { it.text == '11' }.size()
```

For analysis of complicated cases you will have to look up the logfile. Search for messages like this:

    WARNING: Circular reference detected! Traceback (innermost last):
    * ID_1323597872 = "count nodes above 10: " ... ->  "count nodes above 10: " + node.find { it.to.num > 10 }....
    -> * ID_1323597872 = "count nodes above 10: " ... ->  "count nodes above 10: " + node.find { it.to.num > 10 }....

The node that is causing the circular reference is highlighted by an asterisk. We see that the cycle is a direct one, i.e. the node is directly referencing itself. But it doesn't need to be so simple and there might be more nodes involved when you happen to see this kind of error.

Note that many problems with circular references arise from using
<tt>find</tt>. So here's one advice: Avoid <tt>find</tt> if you don't need it.

Also note that references between texts, notes and attributes of the same node do not result in a "circular reference" warning. On the other hand it doesn't matter which attribute, text or note is referenced by another node: cycles are detected only on the (coarse) node level.

## When formulas get too big: Build your own utility classes

Starting with Freeplane 1.3.2 all .groovy files in the script classpath directories are automatically compiled when Freeplane starts. See [Scripting! Your own utility library](Your_own_utility_script_library.md).

## Plus operator for nodes

Given the following map:

```groovy
 = children.sum()
   1
   2
```

This will result in "3" since the plus operator for nodes is defined as Node.to.num0 + Node.to.num0. While this is simple and nice in most cases you have to keep in mind that "+" is numeric only and will never concatenate strings.

## When the map is changed...

Formulas are immediately updated when necessary. (Otherwise it's a bug that you should report.)

Formula evaluation is significantly more costly than many other
things that will happen during normal operation. To reduce the
overhead of formula evaluation Freeplane implements a dependency
tracking mechanism that takes care to only update those formulas that
reference a changed node.

But this mechanism could theoretically get fooled by complex Groovy expressions.
I can't give you an example currently but it's definitely possible.

So just in case the formula processor got confused somehow there's a
function <tt>Tools > Formulas > Evaluate all</tt> that re-evaluate the
whole map.


### Caching formula evaluation results

For continuous node visualization the properties of a node are queried much more often than they are changed. To avoid recalculation in this cases all evaluation results are stored/cached internally. This cache is initially filled on opening a map and emptied on unload of it.

For debugging purposes it is possible to switch off caching completely via the preferences page of the formula plugin. But keep in mind that this might severely impair application's performance, so don't switch caching off unless you really, really need that.


## Editor support for formulas

For editing of nodes containing a formula a special editor is used that provides the following features:

* Syntax highlighting: Support for standard Groovy expressions and node references.
* GUI-Support for referencing other nodes: Double click a node to insert a reference to it into the formula.
* GUI-Support for visualization of node references: If the cursor is in a node id the referenced node will be selected in the map. The tooltip of the editor will show the (transformed) text of the node in this case.

Note that the special editor will only be used if the node text *already starts* with an equal sign. The editor support will be further extended in the future, especially with code completion.

## Formatting

Formatting of numbers and dates in node core is available as an element of [styles](../../user-documentation/styles.md), that means that they are not formula specific. Formatting of attribute values, details and notes must be handled by setting the value to a formatted object via [format(Object, formatString)](http://docs.freeplane.org/api/org/freeplane/plugin/script/FreeplaneScriptBaseClass.html#format(java.lang.Object,%20java.lang.String) ). For more on data and formatting see [this page](Data_recognition_and_data_formats.md).


## Security

Formulas will have strict security limitations that can not be disabled via configuration. From formulas it's impossible to write to the file system or the network and you can not execute external programs. Read access is granted to Formulas only if you have enabled that for all scripts.


## Miscelleneous

*Richtext nodes* (in node texts and notes) are supported by stripping
all HTML clutter from the text before evaluation but using plaintext
is definitely preferable for formulas.

*Borders:* Formula nodes are marked with a green border. This can be changed at
*View->View settings->Highlight formulas*.

*Attribute Access:* Formulas provide simplified attribute access via the <tt>['name']</tt> operator:
```groovy
  = children.sum(0){ it['attrib_name'].num0 }
```

## Open issues

Please help to fix some open issues. Please leave your opinion on the discussion page or in the discussion forum.

### Named nodes

Node references by node id are effective and the referenced node can be easily inspected if viewed in the formula editor. But without the editor support the node ids don't make any sense for themselves.

Named nodes would allow to make references more readable. If for instance one "parameter node" with ID <tt>ID_241399282</tt> is used in many formulas in a map, then it would be good to give it a name, e.g. <tt>scale</tt> and to use <tt>N("scale").to.num</tt> instead of using <tt>ID_241399282.to.num</tt>.

Do you have an idea how such names should be defined? Is it enough to have named nodes or do we need named collections of nodes, too?

### Implementation of functions available in spreadsheet processors?

Spreadsheet processors have a large number of functions that are not directly supported by Freeplane (see [ODF specification](http://www.oasis-open.org/committees/tc_home.php?wg_abbrev=office#odf12)). Of course many of these functions are not easily translatable from tabulars to mindmaps but one might strive to provide as many as possible to increase portability of existing formulas to Freeplane.

What do you think, do we need implementations for functions like NOW(), SECOND(), PPMT(), RRI(), COLUMNS(), etc., even if Groovy equivalents exist? If you do you are encouraged to provide a Groovy class with appropriate static methods and we'll see how to integrate them into Freeplane.

## Limitations

* References to nodes in other maps.

## Further reads

* most important: [Scripting API](Scripting_API.md)
* [Scripting](../Learning%20Guides/Scripting.md)
* [Scripting_environment_setup](../Scripting%20Setup/Scripting_environment_setup.md)

## Example Maps

* [Scripting API improvements](Scripting-convertible-and-more.mm)
* [General Balance form.mm](http://www.freeplane.org/wiki/images/6/69/Example_-_General_Balance_form.mm) - requires at least 1.2.1_20.
* [Bayes Theorem in Control of Quality.mm](http://www.freeplane.org/wiki/index.php/File:Bayes_Theorem_in_Control_of_Quality_%28v.2_of_2_-_calculations_in_attributes%29.mm) - requires at least 1.2.4_03

## Videos

* [Expense Reporting in Freeplane](http://www.youtube.com/watch?v=qym9pG3AP4E)
<!-- ({Category:Documentation})({Category:Script}) -->

