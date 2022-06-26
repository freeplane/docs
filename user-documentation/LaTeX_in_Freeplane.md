Freeplane 1.2.x supports LaTeX formulae in boxes underneath nodes while Freeplane 1.3.x deprecates those boxes and adds LaTeX directly to node contents. Please see the relevant subsections below.

Thanks to the excellent [JLaTeXMath](http://forge.scilab.org/index.php/p/jlatexmath/)!

# LaTeX Text+Formulae in Freeplane >1.3.x =

![](../images/Freeplane_LaTeX.jpg ':size=200')
<!--
See the [example mindmap](http://www.freeplane.org/wiki/images/0/01/Freeplane_LaTeX.jpg).
-->

* LaTeX text is displayed inline in node content (as opposed to underneath nodes in 1.2.x)
* You can tell Freeplane to treat a node as LaTeX text by either:
    * using a "\latex " ("\latex" + <space or newline>) prefix
    * *View->Controls->Tool panel* (previously *View->Properties panel*), then *Core text->Format->LaTeX*
* By default the LaTeX interpreter is in text mode, so you need to use $...$ for (inline) formulae
* Automatic linebreaks are supported
* The editor supports LaTeX syntax highlighting

Example:

    \latex my formula: $x_2=\frac{1}{2}$

## Common/global LaTeX Macros
Freeplane has a textbox in preferences->Plugins->LaTeX that allows you to enter
code (usually macros) that will be inserted into every LaTeX node before the actual node content.
Be aware though, that using this means that your map will only be readable by someone else if he/she
also includes the macros in his/her config!

## "Unparsed LaTex" (LaTeX for Export)
JLaTeXMath, the component used by Freeplane for rendering LaTeX, is focused on math and thus does not support i.e. itemize or enumerate and more.
However, some people want to export complete LaTeX documents, including code not supported by JLaTeXMath, and if you try to use
unsupported LaTeX in LaTeX nodes (Format=LaTeX or node prefix "\latex"), then this will be correctly exported but you will get ugly error boxes in Freeplane.

In order to solve this, we have added Format="Unparsed LaTeX" (translation may be different) and the node prefix "\unparsedlatex" (for symmetry, will not be translated).
Nodes designated like this will use LaTeX syntax highlighting and will be exported correctly, but will not be rendered with JLaTeXMath.

## Including LaTeX content from file system
If your node matches the pattern

    \latexinput{<file>}

then Freeplane will include the given file at the given position in the LaTeX export.
Note that the export will fail if the document cannot be read.

Caveat: The file must be a well-formed XML document, so you must have a root tag and escape <, > and & (&lt;, &gt;, &amp;),
like this:

    <doc>
    \begin{tabular}{cc}
    1 &amp;amp; 2 \\
    3 &amp;amp; 4 \\
    \end{tabular}
    </doc>

## Combination of LaTeX and Groovy formulas
Here's how to format formula results as LaTeX:

1. Set node format to LaTeX.
2. Let your formula generate LaTeX code.

Example (copy 'n paste it into a map)

    ="\\LaTeX: \$\\sum_{children} = ${children.sum(0)}\$"
    2
    3
    4

Note that LaTeX symbol `\` has to be doubled in a double quoted string and that a `$` have to be escaped with a single `\` to prevent Groovy from interpreting it as the prefix of a variable.

## Known Problems

* Array environments are maximized on the maximum node width
* align=right and align=center does not work well
* The syntax highlighting editor has problems with some unicode/chinese characters. If you experience this, turn off the editor in prefs->Plugins->LaTeX (Freeplane will then use the normal editor for LaTeX).

## Customizing LaTeX Export

* Copy <installation_dir>/resources/xslt/mm2latex*.xsl to <fpuserdir>/xslt (you can find <fpuserdir> with Tools->Open user directory)
* You need all three because mm2latexartcl.xsl and mm2latexbook.xsl include mm2latexinput.xsl
* Adapt your export script (usually document: mm2latexartcl.xsl, book: mm2latexbook.xsl, or input: mm2latexinput.xsl)
* Restart freeplane --> the new export scripts will be used

## Other Export solutions
There are many XSLT scripts out there; here is one from Igor Gartzia Olaizola that
[integrates well with Freeplane](http://sourceforge.net/apps/phpbb/freeplane/viewtopic.php?f=1&t=942) and also allows to export to LaTeX Beamer presentations:
[https://sites.google.com/site/freemind2beamer/](https://sites.google.com/site/freemind2beamer/). The source code is [on github](https://github.com/igor-go/mm_xslt_exports).

# LaTeX Formulae in Freeplane 1.2.x
This type of LaTeX formulae in Freeplane is deprecated in Freeplane 1.3.x
(the formula boxes  will still be displayed and can be edited but you can't add new
boxes)! Please see the 1.3.x section above if you're using Freeplane 1.3.x.

* you can add a LaTeX formula to a node by running *Edit->Node Extensions->Add LaTeX formula...*
* you can edit a LaTeX formula related to a node by running *Edit->Node Extensions->Edit LaTeX formula...*
* you can remove a LaTeX formula by selecting *Edit->Node Extensions->Remove LaTeX formula* OR by using *Edit->Node Extensions->Edit LaTeX formula...* and specifying an empty text.
* by default the LaTeX interpreter is in math mode
* does not support automatic linebreaks

Example:

    x_2=\frac{1}{2}

