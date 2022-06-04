<!-- ({Category:Coding}) -->

This page tries to reflect changes of the Freeplane file format.

# Original FreeMind File Format

The original FreeMind format was never described completely formally, but there is some documentation:

* FreeMind's file format is described [in the Wiki](http://freemind.sourceforge.net/wiki/index.php/File_format).
* There is a schema validation in [SVN (integration branch)](http://freemind.cvs.sourceforge.net/viewvc/freemind/freemind/freemind.xsd?view=log&pathrev=fm_060405_integration), with a [latest revision](http://freemind.cvs.sourceforge.net/viewvc/freemind/freemind/freemind.xsd?revision=1.1.2.4.4.2&view=markup&pathrev=fm_060405_integration).

<dl>
    <dt>Note</dt>
    <dd>the above documentation is outdated in regard to elements introduced by Freeplane, like connector labels, attributes, scripts, user icons and (scalable) images embedded in the map.</dd>
</dl>

# Freeplane's version of it

The following schema takes the schema pointed at in the previous chapter and completes it with Freeplane specific extensions (in **bold** for easy identification):

<dl><dt>Attention:&#160;</dt>
<dd>The file format was accurate as per version 1.1.x, new features in 1.2.x have not (yet) been documented.</dd></dl>
<pre>&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;xs:schema xmlns:xs="<a rel="nofollow" class="external free" href="http://www.w3.org/2001/XMLSchema">http://www.w3.org/2001/XMLSchema</a>" elementFormDefault="qualified"&gt;

 &lt;xs:element name='Parameters'&gt;
  &lt;xs:complexType&gt;
	  &lt;!--Is the time management plugin.--&gt;
   &lt;xs:attribute name='REMINDUSERAT' type='xs:integer' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;!--Used for node notes.--&gt;
 &lt;xs:element name='text'&gt;
  &lt;xs:complexType/&gt;
 &lt;/xs:element&gt;

 <b>&lt;!-- BEGIN ATTRIBUTES --&gt;</b>

 <b>&lt;xs:element name='attribute_value'&gt;</b>
  <b>&lt;xs:complexType&gt;</b>
   <b>&lt;xs:attribute name='VALUE' type='xs:string' use='required'/&gt;</b>
   <b>&lt;xs:attribute name='TYPE' type='xs:string' use='optional'/&gt;</b>
  <b>&lt;/xs:complexType&gt;</b>
 <b>&lt;/xs:element&gt;</b>

 <b>&lt;xs:element name='attribute_name'&gt;</b>
  <b>&lt;xs:complexType&gt;</b>
   <b>&lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;</b>
    <b>&lt;xs:element ref='attribute_value'/&gt;</b>
   <b>&lt;/xs:choice&gt;</b>
   <b>&lt;xs:attribute name='NAME' type='xs:string' use='required'/&gt;</b>
   <b>&lt;xs:attribute name='MANUAL' type='xs:boolean' use='optional' /&gt;</b>
   <b>&lt;xs:attribute name='RESTRICTED' type='xs:boolean' use='optional' /&gt;</b>
   <b>&lt;xs:attribute name='VISIBLE' type='xs:boolean' use='optional' /&gt;</b>
  <b>&lt;/xs:complexType&gt;</b>
 <b>&lt;/xs:element&gt;</b>

 <b>&lt;xs:element name='attribute_registry'&gt;</b>
  <b>&lt;xs:complexType&gt;</b>
   <b>&lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;</b>
    <b>&lt;xs:element ref='attribute_name'/&gt;</b>
   <b>&lt;/xs:choice&gt;</b>
   <b>&lt;xs:attribute name='RESTRICTED' type='xs:boolean' use='optional' /&gt;</b>
   <b>&lt;xs:attribute name='SHOW_ATTRIBUTES' use='optional'&gt;</b>
    <b>&lt;xs:simpleType&gt;</b>
     <b>&lt;xs:restriction base='xs:string'&gt;</b>
      <b>&lt;xs:enumeration value='selected'/&gt;</b>
      <b>&lt;xs:enumeration value='hide'/&gt;</b>
     <b>&lt;/xs:restriction&gt;</b>
    <b>&lt;/xs:simpleType&gt;</b>
   <b>&lt;/xs:attribute&gt;</b>
  <b>&lt;/xs:complexType&gt;</b>
 <b>&lt;/xs:element&gt;</b>

 <b>&lt;xs:element name='attribute_layout'&gt;</b>
  <b>&lt;xs:complexType&gt;</b>
   <b>&lt;xs:attribute name='NAME_WIDTH'  type='xs:integer' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='VALUE_WIDTH' type='xs:integer' use='optional'/&gt;</b>
  <b>&lt;/xs:complexType&gt;</b>
 <b>&lt;/xs:element&gt;</b>

 <b>&lt;xs:element name='attribute'&gt;</b>
  <b>&lt;xs:complexType&gt;</b>
   <b>&lt;xs:attribute name='NAME'  type='xs:string' use='required'/&gt;</b>
   <b>&lt;xs:attribute name='VALUE' type='xs:string' use='required'/&gt;</b>
   <b>&lt;xs:attribute name='TYPE' type='xs:string' use='optional'/&gt;</b>
  <b>&lt;/xs:complexType&gt;</b>
 <b>&lt;/xs:element&gt;</b>

 <b>&lt;!-- END ATTRIBUTES --&gt;</b>

 &lt;xs:element name='arrowlink'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='DESTINATION' type='xs:string' use='required'/&gt;
   &lt;xs:attribute name='ENDARROW' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='ENDINCLINATION' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='ID' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STARTARROW' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STARTINCLINATION' type='xs:string' use='optional'/&gt;
   <b>&lt;xs:attribute name='SOURCE_LABEL' type='xs:string' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='MIDDLE_LABEL' type='xs:string' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='TARGET_LABEL' type='xs:string' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='EDGE_LIKE' type='xs:boolean' use='optional'/&gt;</b>
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='cloud'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   <b>&lt;xs:attribute name='WIDTH' type='xs:integer' use='optional'/&gt;</b>
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='edge'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STYLE' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='WIDTH' type='xs:string' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='font'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='BOLD' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      <b>&lt;xs:enumeration value='false'/&gt;</b>
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='ITALIC' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      &lt;xs:enumeration value='false'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='NAME' type='xs:string' use='<b>optional'</b>/&gt;
   &lt;xs:attribute name='SIZE' type='xs:integer' use='<b>optional'</b>/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='hook'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    &lt;xs:element ref='Parameters' minOccurs='0' maxOccurs='1'/&gt;
    &lt;xs:element ref='text' minOccurs='0' maxOccurs='1'/&gt;
   &lt;/xs:sequence&gt;
   &lt;xs:attribute name='NAME' type='xs:string' use='required'/&gt;
   <b>&lt;!-- for embedded images NAME="ExternalObject" --&gt;</b>
   <b>&lt;xs:attribute name='URI'  type='xs:anyURI' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='SIZE' type='xs:decimal' use='optional'/&gt;</b>
   <b>&lt;!-- for map config info NAME="MapStyle" --&gt;</b>
   <b>&lt;xs:attribute name='max_node_width'  type='xs:integer' use='optional'/&gt;</b>
   <b>&lt;xs:attribute name='zoom' type='xs:decimal' use='optional'/&gt;</b>
   <b>&lt;!-- for equations NAME="plugins/latex/LatexNodeHook.properties" --&gt;</b>
   <b>&lt;xs:attribute name='EQUATION' type='xs:string' use='optional'/&gt;</b>
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='icon'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='BUILTIN' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='html'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    &lt;!--Anything that is valid XML, but should be http://www.w3.org/1999/xhtml --&gt;
    &lt;xs:any namespace="##any" minOccurs="0" maxOccurs="unbounded" processContents="skip"/&gt;
   &lt;/xs:sequence&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='richcontent'&gt;
  &lt;xs:complexType&gt;
   &lt;!-- And contains XHTML as unique child:--&gt;
   &lt;xs:sequence&gt;
    &lt;xs:element ref='html' minOccurs='1' maxOccurs='1'/&gt;
   &lt;/xs:sequence&gt;
   &lt;!--Currently, only NODE or NOTE is allowed.--&gt;
   &lt;xs:attribute name='TYPE' use='required'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='NODE'/&gt;
      &lt;xs:enumeration value='NOTE'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='map'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    <b>&lt;xs:element ref='attribute_registry' minOccurs='0' maxOccurs='1'/&gt;</b>
    &lt;xs:element ref='node' <b>minOccurs='1' maxOccurs='1' </b>/&gt;
   &lt;/xs:sequence&gt;
   &lt;xs:attribute name='version' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='node'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;
    &lt;xs:element ref='arrowlink'/&gt;
    &lt;xs:element ref='cloud'/&gt;
    &lt;xs:element ref='edge'/&gt;
    &lt;xs:element ref='font'/&gt;
    &lt;xs:element ref='hook'/&gt;
    &lt;xs:element ref='icon'/&gt;
    &lt;xs:element ref='node'/&gt;
    &lt;!-- For nodes with extended formatting content or for notes to nodes. --&gt;
    &lt;xs:element ref='richcontent'/&gt;
    <b>&lt;xs:element ref='attribute_layout'/&gt;</b>
    <b>&lt;xs:element ref='attribute'/&gt;</b>
   &lt;/xs:choice&gt;
   &lt;xs:attribute name='BACKGROUND_COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='FOLDED' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      &lt;xs:enumeration value='false'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='ID' type='xs:ID' use='optional'/&gt;
   &lt;xs:attribute name='LINK' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='POSITION' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='left'/&gt;
      &lt;xs:enumeration value='right'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='STYLE' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='TEXT' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='LOCALIZED_TEXT' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='TYPE' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='CREATED' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='MODIFIED' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='HGAP' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='VGAP' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='VSHIFT' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='ENCRYPTED_CONTENT' type='xs:string' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
&lt;/xs:schema&gt;
</pre>

# Mapping between old and new format

<dl><dt>Attention:&#160;</dt>
<dd>This effort is on hold until further notice (perhaps after release of version 1.2/1.3).</dd></dl>
<table border="1" cellpadding="20" cellspacing="0">
<caption>Mapping between old and new format
</caption>
<tbody><tr>
<td>
<pre>&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;xs:schema xmlns:xs="<a rel="nofollow" class="external free" href="http://www.w3.org/2001/XMLSchema">http://www.w3.org/2001/XMLSchema</a>"
           elementFormDefault="qualified"&gt;
</pre>
</td>
<td>not relevant
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='Parameters'&gt;
  &lt;xs:complexType&gt;
	  &lt;!--Is the time management plugin.--&gt;
   &lt;xs:attribute name='REMINDUSERAT' type='xs:integer' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by parameter <tt>node:reminder="dateTime"</tt> to <tt>node:node</tt> (this limits the number of reminders to one per node but Freeplane can't anyway handle more than one).
</td></tr>
<tr>
<td>
<pre> &lt;!--Used for node notes.--&gt;
 &lt;xs:element name='text'&gt;
  &lt;xs:complexType/&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Obsolete - all nodes are "rich"
</td></tr>
<tr>
<td>
<pre> &lt;!-- BEGIN ATTRIBUTES --&gt;

 &lt;xs:element name='attribute_value'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='VALUE' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='attribute_name'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;
    &lt;xs:element ref='attribute_value'/&gt;
   &lt;/xs:choice&gt;
   &lt;xs:attribute name='NAME' type='xs:string' use='required'/&gt;
   &lt;xs:attribute name='MANUAL' type='xs:boolean' use='optional' /&gt;
   &lt;xs:attribute name='RESTRICTED' type='xs:boolean' use='optional' /&gt;
   &lt;xs:attribute name='VISIBLE' type='xs:boolean' use='optional' /&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='attribute_registry'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;
    &lt;xs:element ref='attribute_name'/&gt;
   &lt;/xs:choice&gt;
   &lt;xs:attribute name='RESTRICTED' type='xs:boolean' use='optional' /&gt;
   &lt;xs:attribute name='SHOW_ATTRIBUTES' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='selected'/&gt;
      &lt;xs:enumeration value='hide'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='attribute_layout'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='NAME_WIDTH'  type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='VALUE_WIDTH' type='xs:integer' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;xs:element name='attribute'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='NAME'  type='xs:string' use='required'/&gt;
   &lt;xs:attribute name='VALUE' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;

 &lt;!-- END ATTRIBUTES --&gt;
</pre>
</td>
<td>The whole attribute will be replaced as follows. First define the sets of attributes at the map level:
<pre>&lt;map:attributes attribute:restricted="false|true"&gt;
 &lt;attribute:attribute meta:name="..."
                      attribute:restricted="false|true"
                      attribute:selected="false|true"&gt;
  &lt;attribute:value&gt;some value&lt;/attribute:value&gt;
  ...
 &lt;/attribute:attribute&gt;
 ...
&lt;/map:attributes&gt;
</pre>
<p>And then assign the attributes at the node level:
</p>
<pre>&lt;node:attributes attribute:name-width="..."
                 attribute:value-width="..."&gt;
 &lt;attribute:attribute
           meta:name="..."&gt;some value&lt;/attribute:attribute&gt;
 ...
&lt;/node:attributes&gt;
</pre>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='arrowlink'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='DESTINATION' type='xs:string' use='required'/&gt;
   &lt;xs:attribute name='ENDARROW' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='ENDINCLINATION' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='ID' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STARTARROW' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STARTINCLINATION' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='SOURCE_LABEL' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='MIDDLE_LABEL' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='TARGET_LABEL' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='EDGE_LIKE' type='xs:boolean' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;draw:connector ... /&gt;</tt> with attributes
<pre>draw:start-shape="ID"
draw:color="#rrggbb"
draw:end-shape="ID"
map:start-arrow="true|false"
map:end-arrow="true|false"
xml:id="ID"
map:start-inclination="int;int;"
map:end-inclination="int;int;"
draw:style="normal|edge-like"
</pre>
<p>And with possible sub-nodes:
</p>
<pre>&lt;map:start-label&gt;...&lt;/map:start-label&gt;
&lt;svg:title&gt;...&lt;/svg:title&gt; (or svg:desc?!)
&lt;map:end-label&gt;...&lt;/map:end-label&gt;
</pre>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='cloud'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='WIDTH' type='xs:integer' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;node:cloud ... /&gt;</tt> with attributes
<pre>draw:color="#rrggbb"
</pre>
<p>(<tt>WIDTH</tt> parameter isn't used currently and is always 0)
</p>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='edge'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='STYLE' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='WIDTH' type='xs:string' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;node:edge ... /&gt;</tt> with attributes
<pre>draw:color="#rrggbb"
draw:style="linear|sharp-linear|bezier|sharp-bezier|horizontal"
draw:stroke="solid|none"
svg:stroke-width="length" (Freeplane uses only integers)
</pre>
<dl><dt>Note</dt>
<dd>those attributes should be moved to a <tt>&lt;style:style&gt;</tt> element that defines a style with the family value of graphic, and referenced by name through the <tt>draw:style-name</tt> attribute.</dd></dl>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='font'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='BOLD' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      &lt;xs:enumeration value='false'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='ITALIC' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      &lt;xs:enumeration value='false'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
   &lt;xs:attribute name='NAME' type='xs:string' use='optional'/&gt;
   &lt;xs:attribute name='SIZE' type='xs:integer' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;style:text-properties ... /&gt;</tt> with attributes
<pre>fo:color="#rrggbb"
fo:font-weight="normal|bold"
fo:font-style="normal|italic"
fo:font-family="name of the font"
fo:font-size="integer"
</pre>
<dl><dt>Note</dt>
<dd><tt>&lt;style:font-name&gt;</tt> could be used instead of <tt>fo:font-family</tt> but, according to specs, this would mean a separate definition of a font through a <tt>style:font-face</tt> element and that makes the whole thing more complex. See <a href="/wiki/index.php/Freeplane_File_Format#3.14_.3Coffice:font-face-decls.3E" class="mw-redirect" title="Freeplane File Format">Freeplane_File_Format#3.14_.3Coffice:font-face-decls.3E</a>.</dd>
<dt>Note</dt>
<dd>this element should be moved to a <tt>&lt;style:style&gt;</tt> element that defines a style with the family value of text, and referenced by name through the <tt>text:style-name</tt> attribute.</dd></dl>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='hook'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    &lt;xs:element ref='Parameters' minOccurs='0' maxOccurs='1'/&gt;
    &lt;xs:element ref='text' minOccurs='0' maxOccurs='1'/&gt;
   &lt;/xs:sequence&gt;
   &lt;xs:attribute name='NAME' type='xs:string' use='required'/&gt;
   &lt;!-- for embedded images NAME="ExternalObject" --&gt;
   &lt;xs:attribute name='URI'  type='xs:anyURI' use='optional'/&gt;
   &lt;xs:attribute name='SIZE' type='xs:decimal' use='optional'/&gt;
</pre>
</td>
<td>Replaced by the following element:
<pre>&lt;draw:frame draw:transform="scale(sx [sy])"&gt;
 &lt;draw:image xlink:href="URL"/&gt;
&lt;/draw:frame&gt;
</pre>
<dl><dt>Note</dt>
<dd>if wished, the <tt>&lt;draw:image&gt;</tt> element could also have an attribute <tt>draw:filter-name="ExternalObject"</tt> but I wouldn't see the point (rather the name of a plugin for image formats not supported by Freeplane).</dd></dl>
</td></tr>
<tr>
<td>
<pre>   &lt;!-- for map config info NAME="MapStyle" --&gt;
   &lt;xs:attribute name='max_node_width'  type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='zoom' type='xs:decimal' use='optional'/&gt;
</pre>
</td>
<td>It actually depends if those settings shall be different from map to map (within a same file) or the same for the whole file.
<p>In the first case, they would be attributes to the <tt>&lt;map:map&gt;</tt> element:
</p>
<pre>node:max-width="integer"
map:zoom="percentage"
</pre>
<p>And in the 2nd case, they would be <a href="/wiki/index.php/Freeplane_File_Format#3.10_.3Coffice:settings.3E" class="mw-redirect" title="Freeplane File Format">office settings</a>:
</p>
<pre>&lt;config:config-item config:name="NodeMaxWidth"
                    config:type="int"&gt;40&lt;/config:config-item&gt;
&lt;config:config-item config:name="MapZoom"
                    config:type="int"&gt;150&lt;/config:config-item&gt;
</pre>
<p><i><b>TBD</b></i>
</p>
</td></tr>
<tr>
<td>
<pre>   &lt;!-- for equations NAME="plugins/latex/LatexNodeHook.properties" --&gt;
   &lt;xs:attribute name='EQUATION' type='xs:string' use='optional'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Plugin hooks (like Latex) are replaced by an element <tt>&lt;node:content&gt;</tt> with a corresponding namespace definition, like in:
<pre>&lt;node:content 
      xmlns:latex="plugins/latex/LatexNodeHook.properties"&gt;
 &lt;latex:equation&gt;
  &lt;![CDATA[<i>some equation in Latex</i>]]&gt;
 &lt;/latex:equation&gt;
&lt;/node:content&gt;
</pre>
<p>As shown here, in the case of non-XML dialect, the use of a CDATA section is highly recommended.
</p>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='icon'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:attribute name='BUILTIN' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;node:icon ... /&gt;</tt> with attributes
<pre>node:icon-name="..." (a string)
</pre>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='html'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    &lt;!--Anything that is valid XML,
                 but should be http://www.w3.org/1999/xhtml --&gt;
    &lt;xs:any namespace="##any" minOccurs="0" maxOccurs="unbounded"
            processContents="skip"/&gt;
   &lt;/xs:sequence&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Obsolete, as all nodes are rich content...
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='richcontent'&gt;
  &lt;xs:complexType&gt;
   &lt;!-- And contains XHTML as unique child:--&gt;
   &lt;xs:sequence&gt;
    &lt;xs:element ref='html' minOccurs='1' maxOccurs='1'/&gt;
   &lt;/xs:sequence&gt;
   &lt;!--Currently, only NODE or NOTE is allowed.--&gt;
   &lt;xs:attribute name='TYPE' use='required'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='NODE'/&gt;
      &lt;xs:enumeration value='NOTE'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by either
<pre>&lt;node:content xmlns:xhtml="<a rel="nofollow" class="external free" href="http://www.w3.org/1999/xhtml">http://www.w3.org/1999/xhtml</a>"&gt;
 &lt;xhtml:body&gt; ... &lt;/xhtml:body&gt;
</pre>
<p>or
</p>
<pre>&lt;office:annotation xmlns:xhtml="<a rel="nofollow" class="external free" href="http://www.w3.org/1999/xhtml">http://www.w3.org/1999/xhtml</a>"&gt;
 &lt;xhtml:body&gt; ... &lt;/xhtml:body&gt;
</pre>
<dl><dd>Note:the XHTML body is specific to Freeplane, ODF has actually its own markup, but that would be too much to implement. In the future, other type of elements could be implemented in a node or a note (Latex, etc...) instead of XHTML.</dd></dl>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='map'&gt;
  &lt;xs:complexType&gt;
   &lt;xs:sequence&gt;
    &lt;xs:element ref='attribute_registry' minOccurs='0' maxOccurs='1'/&gt;
    &lt;xs:element ref='node' minOccurs='1' maxOccurs='1' /&gt;
   &lt;/xs:sequence&gt;
   &lt;xs:attribute name='version' type='xs:string' use='required'/&gt;
  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;map:map&gt;</tt>
</td></tr>
<tr>
<td>
<pre> &lt;xs:element name='node'&gt;
</pre>
</td>
<td>Replaced by element <tt>&lt;node:node&gt;</tt>
</td></tr>
<tr>
<td>
<pre>  &lt;xs:complexType&gt;
   &lt;xs:choice minOccurs='0' maxOccurs='unbounded'&gt;
    &lt;xs:element ref='arrowlink'/&gt;
    &lt;xs:element ref='cloud'/&gt;
    &lt;xs:element ref='edge'/&gt;
    &lt;xs:element ref='font'/&gt;
    &lt;xs:element ref='hook'/&gt;
    &lt;xs:element ref='icon'/&gt;
    &lt;xs:element ref='node'/&gt;
    &lt;!-- For nodes with extended formatting content or for notes. --&gt;
    &lt;xs:element ref='richcontent'/&gt;
    &lt;xs:element ref='attribute_layout'/&gt;
    &lt;xs:element ref='attribute'/&gt;
   &lt;/xs:choice&gt;
</pre>
</td>
<td>Mapped obviously as described above...
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='BACKGROUND_COLOR'
                 type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>Replaced by attribute <tt>draw:fill-color="#rrggbb"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='COLOR' type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>It's actually the color of the font and has been moved to the corresponding element <tt>&lt;style:text-properties ... /&gt;</tt>.
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='FOLDED' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='true'/&gt;
      &lt;xs:enumeration value='false'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
</pre>
</td>
<td>Replaced by attribute <tt>node:folded="false|true"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='ID' type='xs:ID' use='optional'/&gt;
</pre>
</td>
<td>Replaced by attribute <tt>xml:id="ID"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='LINK' type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>Replaced by attribute <tt>xlink:href="URL"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='POSITION' use='optional'&gt;
    &lt;xs:simpleType&gt;
     &lt;xs:restriction base='xs:string'&gt;
      &lt;xs:enumeration value='left'/&gt;
      &lt;xs:enumeration value='right'/&gt;
     &lt;/xs:restriction&gt;
    &lt;/xs:simpleType&gt;
   &lt;/xs:attribute&gt;
</pre>
</td>
<td>Replaced by attribute <tt>node:side="left|right"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='STYLE' type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>Replaced by attribute <tt>draw:style="fork|bubble"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='TEXT' type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>Obsolete.
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='CREATED' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='MODIFIED' type='xs:integer' use='optional'/&gt;
</pre>
</td>
<td>Replaced respectively by attributes <tt>node:inserted="dateTime"</tt> and <tt>node:modified="dateTime"</tt>
<dl><dt>Note</dt>
<dd>the 'dateTime' format is normally according to <a rel="nofollow" class="external text" href="http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/#isoformats">ISO8601</a> instead of the current UN*X-like number of seconds. <i><b>TBD</b></i> - To Be Discussed.</dd></dl>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='HGAP' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='VGAP' type='xs:integer' use='optional'/&gt;
   &lt;xs:attribute name='VSHIFT' type='xs:integer' use='optional'/&gt;
</pre>
</td>
<td>Replaced respectively by attributes <tt>node:margin-horizontal="integer"</tt>, <tt>node:margin-vertical="integer"</tt> and <tt>node:shift-vertical="integer"</tt>
</td></tr>
<tr>
<td>
<pre>   &lt;xs:attribute name='ENCRYPTED_CONTENT'
                 type='xs:string' use='optional'/&gt;
</pre>
</td>
<td>Replaced by attribute <tt>node:encrypted="false|true"</tt>
</td></tr>
<tr>
<td>
<pre>  &lt;/xs:complexType&gt;
 &lt;/xs:element&gt;
&lt;/xs:schema&gt;
</pre>
</td>
<td>
</td></tr></tbody></table>

