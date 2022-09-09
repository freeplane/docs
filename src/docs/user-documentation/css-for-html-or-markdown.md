<!-- toc -->

# CSS For HTML/Markdown

_Since 1.9.12 (Dec 2021)_

HTML or Markdown content can be formatted using CSS.

## Quick Start by Example

To get you started quickly, here's a simple CSS example for Markdown content.

1. Insert a new node, adding the following text

```markdown
# My Heading 1

Some text in my paragraph

> A sample quote
```

2. Set the node's format to Markdown &ndash; `View->Controls->Tool panel->Format->Core Text->Format = Markdown`
3. Add the following CSS &ndash; `View->Controls->Tool panel->Format->Node Font->CSS->Edit CSS...`

```css
h1 {
  color: blue;
  font-weight: normal;
}
blockquote {
  color: green;
  font-style: italic;
}
```

4. As a result, in your node you should see a blue heading, a regular paragraph and a green italic quote.

## Sample Mind Map

Requires Freeplane 1.9.12 or higher

[Node_CSS_Functionality.mm](/user-documentation/Node_CSS_Functionality.mm ':ignore')

## CSS For Core Text

A node is formatted by CSS instructions in 2 cases:

1. When CSS is added to the node &ndash; `View->Controls->Tool panel->Format->Node Font->CSS->Edit CSS...`
2. When CSS is added to the Style applied to the node &ndash; `Format->Manage styles->Edit styles` | **a Style** | `Node Font->CSS->Edit CSS...`

When CSS is added to a node, CSS added to a Style (applied to the node) is ignored.

The following formatting properties can coexist with CSS-defined formatting:

* Node Color -> Text
* Node Color -> Background
* Node Font -> Font family
* Node Font -> Font size
* Node Font -> Bold
* Node Font -> Strike through
* Node Font -> Italic
* Node Font -> Text Alignment

Under the hood, these formatting properties are converted to CSS for `body` and applied alongside the CSS added to a Style or to a node.

> More about CSS
> * https://www.w3schools.com/css/
> * https://peterxjang.com/blog/modern-css-explained-for-dinosaurs.html

### Order Of CSS Application

Just like any web browser (Chrome, Firefox, Safari, etc), the Java library used by Freeplane has its own default CSS: https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/javax/swing/text/html/default.css

In addition to that, Freeplane adds its own CSS, overriding the formatting instructions from the Java default CSS:
```css
p { margin-top:0; }
table { border: 0; border-spacing: 0; }
th, td { border: 1px solid; }
```

Next, the CSS created based on formatting properties is used, overriding any previous instructions for `body`, and finally the CSS added to the Style or to the node is applied, overriding any other CSS instructions.

When CSS is added to **Default**, it affects <u>node-core</u> HTML/Markdown of all nodes where **Default** is applied.

When CSS is added to a **Style**, CSS added to **Default** is ignored for that **Style**.

When CSS is added to a node, CSS added to a **Style** (applied to the node) is ignored.

## CSS For Details And Note

CSS can be added to **Details** and to **Note**, making it possible to specify detailed formatting for their HTML/Markdown content.

+ `Format->Manage Styles->Edit styles` | **Details** | `Node Font->CSS->Edit CSS...`
+ `Format->Manage Styles->Edit styles` | **Note** | `Node Font->CSS->Edit CSS...`

CSS added to **Details** will affect <u>node-details</u> HTML/Markdown of all nodes in the map.<br>
Similarly, CSS added to **Note** will affect <u>note</u> HTML/Markdown of all nodes in the map.

Note that when CSS is added to **Default**, it is also applied to **Details** and **Note**.
To make **Details** or **Note** ignore CSS added to **Default** and use only its formatting properties, add "empty" CSS (e.g. a space) to **Details** or **Note** respectively.
This is because when CSS is added to a Style (here to **Details** or to **Note**), CSS added to **Default** is ignored for that Style.

## Example Of Markdown With CSS

Given the following Markdown document:

~~~markdown
# Heading 1
Regular text.
**Bold text.** *Italic text.* ***Both: bold and italic.***

A line (horizontal ruler) using underscores:
___

<s>Strike through</s> NB. using `~~deleted text~~` doesn't work in Freeplane (Java html/css renderer)

E.g. ~~deleted text~~

<u>Underlined text</u>

## Heading 2
> A quote, line 1.
> Line 2 of the quote (will be joined with line 1).
>> A quote within a quote

### Heading 3
Sample text with `an in-line piece of code`.

```groovy
// a Groovy code example - as a block of code
def name = 'Freeplane User'
"Hello, ${name}!"
```

    Another example of a block of code
    introduced as indented Markdown (with a tab or 4 spaces)

>     An example of a quote
>     containing a block of code
>     At least 5 spaces need to be used
> And it continues as a regular quote

#### Heading 4
A table

| # | Language | [Pangram](https://en.wikipedia.org/wiki/Pangram) |
|--|--|--|
| 1 | English | The quick brown fox jumps over the lazy dog |
| 2 | French | Portez ce vieux whisky au juge blond qui fume |
| 3 | German | Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich |
| 4 | Italian | Pranzo d'acqua fa volti sghembi |
| 5 | Spanish | Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú |

##### Heading 5
A list of items

* Item 1
* Item 2
* Item 3

###### Heading 6
A numbered list

1. Item A
2. Item B
3. Item C
~~~

and keeping in mind that it will be converted to the following HTML:

```html
<html>
<head></head>
<body>
    <h1 id="heading-1">Heading 1</h1>
    <p>Regular text. <strong>Bold text.</strong> <em>Italic text.</em> <strong><em>Both: bold and italic.</em></strong>
    </p>
    <p>A line (horizontal ruler) using underscores:</p>
    <hr>
    <p><s>Strike through</s> NB. using <code>~~deleted text~~</code> doesn&#39;t work in Freeplane (Java html/css
        renderer)</p>
    <p>E.g. <del>deleted text</del></p>
    <p><u>Underlined text</u></p>
    <h2 id="heading-2">Heading 2</h2>
    <blockquote>
        <p>A quote, line 1.
            Line 2 of the quote (will be joined with line 1).</p>
        <blockquote>
            <p>A quote within a quote</p>
        </blockquote>
    </blockquote>
    <h3 id="heading-3">Heading 3</h3>
    <p>Sample text with <code>an in-line piece of code</code>.</p>
    <pre><code class="lang-groovy">// a Groovy code example - as a block of code
def name = &#39;Freeplane User&#39;
&quot;Hello, ${name}!&quot;
</code></pre>
    <pre><code>Another example of a block of code
introduced as indented Markdown (with a tab or 4 spaces)
</code></pre>
    <blockquote>
        <pre><code>An example of a quote
containing a block of code
At least 5 spaces need to be used
</code></pre>
        <p>And it continues as a regular quote</p>
    </blockquote>
    <h4 id="heading-4">Heading 4</h4>
    <p>A table</p>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Language</th>
                <th><a href="https://en.wikipedia.org/wiki/Pangram">Pangram</a></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>English</td>
                <td>The quick brown fox jumps over the lazy dog</td>
            </tr>
            <tr>
                <td>2</td>
                <td>French</td>
                <td>Portez ce vieux whisky au juge blond qui fume</td>
            </tr>
            <tr>
                <td>3</td>
                <td>German</td>
                <td>Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich</td>
            </tr>
            <tr>
                <td>4</td>
                <td>Italian</td>
                <td>Pranzo d&#39;acqua fa volti sghembi</td>
            </tr>
            <tr>
                <td>5</td>
                <td>Spanish</td>
                <td>Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú
                </td>
            </tr>
        </tbody>
    </table>
    <h5 id="heading-5">Heading 5</h5>
    <p>A list of items</p>
    <ul>
        <li>Item 1</li>
        <li>Item 2</li>
        <li>Item 3</li>
    </ul>
    <h6 id="heading-6">Heading 6</h6>
    <p>A numbered list</p>
    <ol>
        <li>Item A</li>
        <li>Item B</li>
        <li>Item C</li>
    </ol>
</body>
</html>
```

the following CSS can be applied to the node to format the Markdown content:

```css
h1, h2, h3, h4, h5, h6 {
  background: #D4D4D4;
  border-top: 1px solid gray;
  border-bottom: 1px solid gray;
  font-weight: normal;
  padding-left: 2px;
  padding-right: 2px;
}
blockquote {
  background: #E6F2E6;
  border-left: 3px solid #408040;
  font-style: italic;
  padding-left: 5px;
  margin-left: 2px;
}
pre {
  background: #E0F0FF;
  border-left: 5px solid #55AAFF;
  padding: 5px;
  margin-left: 2px;
}
code {
  background: #E0F0FF;
  font-family: JetBrains Mono NL, Courier New, Monospaced;
  font-size: 0.9em;
}
table {
  border-spacing: 0px;
  border-right: 1px solid gray;
  border-bottom: 1px solid gray;
}
th, td {
  border-left: 1px solid gray;
  border-top: 1px solid gray;
}
th {
  background: #D4D4D4;
  font-weight: 600;
}
ul {
  margin-left-ltr: 20px;
  margin-right-rtl: 20px;
}
ol {
  margin-left-ltr: 25px;
  margin-right-rtl: 25px;
}
```
