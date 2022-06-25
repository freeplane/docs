## Embedding Freeplane Maps

To embed into this wiki a Freeplane mind map file that has been uploaded to this wiki, use:
*<code>`<mm>[[Hello.mm]]</mm>`</code>. Do not upload .mm files with spaces as the plugin apparently can't parse for spaces in file names.

----
You can specify if you want to display the map in the flash browser or in the java applet
*<code>`<mm>[[Hello.mm|flash]]</mm>`</code>
*<code>`<mm>[[Hello.mm|applet]]</mm>`</code>
The flash viewer is smaller and starts much faster than the applet viewer.
For this reason do not use both flash and applet on the same wiki page, but choose the one you find the best.
----

You can display the map in a separate page by adding a colon in front of the file name:
*<code>`<mm>[[:Hello.mm]]</mm>`</code>
*<code>`<mm>[[:Hello.mm|description]]</mm>`</code>
*<code>`<mm>[[:Hello.mm|applet]]</mm>`</code>

<div style="border:1px solid #fff; padding-left: 0.5em !important; background-color: #fff; border-width: 0 0 0 1.4em;">

<table>
<tbody>
<tr class="odd">
<td><p><strong>Description</strong></p></td>
<td><p><strong>You type</strong></p></td>
<td><p><strong>You get</strong></p></td>
</tr>
<tr class="even">
<td><p>Embed map in flash<br />
(with height)</p></td>
<td><p><code>&lt;mm&gt;[[/Hello.mm|flash|80pt]]&lt;/mm&gt;</code></p></td>
<td><p><mm><a href="/Hello.mm" title="wikilink">flash|80pt</a></mm></p></td>
</tr>
<tr class="odd">
<td><p>Embed map in flash<br />
without title<br />
(with height and collapsed to level 1)</p></td>
<td><p><code>&lt;mm&gt;[[/Hello.mm|flash|notitle|80pt|parameters startCollapsedToLevel=1]]&lt;/mm&gt;</code></p></td>
<td><p><mm><a href="/Hello.mm" title="wikilink">flash|notitle|80pt|parameters startCollapsedToLevel=1</a></mm></p></td>
</tr>
<tr class="even">
<td><p>Embed map in applet<br />
(with height and title)</p></td>
<td><p><code>&lt;mm&gt;[[/Hello.mm|applet|300px|title example map]]&lt;/mm&gt;</code></p></td>
<td><p><mm><a href="/Hello.mm" title="wikilink">applet|300px|title example map</a></mm></p></td>
</tr>
<tr class="odd">
<td><p>Link to special page with the map in flash<br />
</p></td>
<td><p><code>&lt;mm&gt;[[/:Hello.mm|flash]]&lt;/mm&gt;</code><br />
<code>&lt;mm&gt;[[/:Hello.mm|flash|title the map in flash|map in flash]]&lt;/mm&gt;</code><br />
<code>&lt;mm&gt;[[/:Hello.mm|flash|notitle|map in flash without title]]&lt;/mm&gt;</code></p></td>
<td><p><mm><a href="/:Hello.mm" title="wikilink">flash</a></mm><br />
<mm><a href="/:Hello.mm" title="wikilink">flash|title the map in flash|map in flash</a></mm><br />
<mm><a href="/:Hello.mm" title="wikilink">flash|notitle|map in flash without title</a></mm></p></td>
</tr>
<tr class="even">
<td><p>Link to special page with the map in applet<br />
</p></td>
<td><p><code>&lt;mm&gt;[[/:Hello.mm|applet]]&lt;/mm&gt;</code><br />
<code>&lt;mm&gt;[[/:Hello.mm|applet|title the map in applet|map in applet]]&lt;/mm&gt;</code><br />
<code>&lt;mm&gt;[[/:Hello.mm|applet|notitle|map in applet without title]]&lt;/mm&gt;</code></p></td>
<td><p><mm><a href="/:Hello.mm" title="wikilink">applet</a></mm><br />
<mm><a href="/:Hello.mm" title="wikilink">applet|title the map in applet|map in applet</a></mm><br />
<mm><a href="/:Hello.mm" title="wikilink">applet|notitle|map in applet without title</a></mm></p></td>
</tr>
<tr class="odd">
<td><p>Link to description page</p></td>
<td><p><code>[[/:Image:Hello.mm|:Image:Hello.mm]]</code><br />
<code>[[/:Image:Hello.mm|Example map]]</code></p></td>
<td><p><a href="/:Image:Hello.mm" title="wikilink">:Image:Hello.mm</a><br />
<a href="/:Image:Hello.mm" title="wikilink">Example map</a></p></td>
</tr>
<tr class="even">
<td><p>Link directly to file</p></td>
<td><p><code>[[/Media:Hello.mm|Media:Hello.mm]]</code><br />
<code>[[/Media:Hello.mm|Example map]]</code></p></td>
<td><p><a href="/Media:Hello.mm" title="wikilink">Media:Hello.mm</a><br />
<a href="/Media:Hello.mm" title="wikilink">Example map</a></p></td>
</tr>
</tbody>
</table>

</div>

### Advanced options
The full syntax for embedding an map in the wiki page is:
    <code><nowiki><mm>[[{name}|{options}|parameters {parameters}]]</mm></nowiki></code>

The full syntax for displaying the map in the separate page is:
    <code><nowiki><mm>[[:{name}|{options}|parameters {parameters}|different text]]</mm></nowiki></code>

The options can be zero or more of the following, separated by pipes:
*<code>applet</code>, <code>flash</code>: Controls how the image is displayed,
*<code>{height}px</code>: Sets the given height in pixels,
*<code>{height}pt</code>: Sets the given height in points,
*<code>title {title text}</code>:Displayed map caption also used as a reference to the map file.
*<code>notitle</code>: Display no title and no reference.

The options can be given in any order. 

The parameters can be zero or more of the {key}={value} pairs separated by spaces. 
They are transferred to the browser showing the map. 

TODO Consult flash browser documentation as a mind map for more info.

If a given option does not match any of the other possibilities, it is assumed to be the link text.

## Embedding images in uploaded mind maps
If you want to include pictures in your map, they should be referenced by absolute paths to the images previoulsy uploaded to this site

1. Upload the pictures first
2. Every image in the Freeplane wiki becomes it own path. You can obtain it e.g. using wiki special page  Special:Imagelist. All images listed there are linked to the image position e.g. `http://www.freeplane.org/wiki/images/0/00/Dothiepinscheme.gif`
1. Copy the links and insert them in your local mind map files.
2. Check that the images are shown properly.
3. Upload the mind map.

## External images and map files
You can neither link to nor embed an external map.

You can not embed a map including images located on external server.

<!-- ({Category:This_wiki}) -->

