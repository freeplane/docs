<map version="freeplane 1.9.8">
<!--To view this file, download free mind mapping software Freeplane from https://www.freeplane.org -->
<node TEXT="Node CSS Functionality" LOCALIZED_STYLE_REF="AutomaticLayout.level.root" FOLDED="false" ID="ID_1090958577" CREATED="1606664858024" MODIFIED="1638625131873" VGAP_QUANTITY="3 pt" NodeVisibilityConfiguration="SHOW_HIDDEN_NODES"><hook NAME="MapStyle" background="#2e3440">
    <properties show_icon_for_attributes="false" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff" show_note_icons="true" associatedTemplateLocation="template:/macmarrum-dark_nord_template.mm" fit_to_viewport="false"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" ID="ID_680156716" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ID="ID_602083445" ICON_SIZE="12 pt" FORMAT_AS_HYPERLINK="false" VGAP_QUANTITY="2 pt" COLOR="#000000" BACKGROUND_COLOR="#eceff4" STYLE="bubble" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" NUMBERED="false" FORMAT="STANDARD_FORMAT" TEXT_ALIGN="DEFAULT" MAX_WIDTH="10 cm" MIN_WIDTH="0 cm" BORDER_WIDTH_LIKE_EDGE="false" BORDER_WIDTH="1.9 px" BORDER_COLOR_LIKE_EDGE="true" BORDER_COLOR="#f0f0f0" BORDER_DASH_LIKE_EDGE="true" BORDER_DASH="SOLID">
<arrowlink SHAPE="CUBIC_CURVE" COLOR="#a89984" WIDTH="2" TRANSPARENCY="255" DASH="" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_602083445" STARTINCLINATION="102.96 pt;0 pt;" ENDINCLINATION="102.96 pt;2.88 pt;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<font NAME="Trebuchet MS" SIZE="10" BOLD="false" STRIKETHROUGH="false" ITALIC="false"/>
<richcontent CONTENT-TYPE="plain/auto" TYPE="DETAILS"/>
<richcontent TYPE="NOTE" CONTENT-TYPE="plain/auto"/>
<hook NAME="NodeConditionalStyles">
    <conditional_style ACTIVE="true" LOCALIZED_STYLE_REF="default" LAST="false">
        <node_matches_regexp SEARCH_PATTERN=".+" MATCH_CASE="false" ITEM="filter_details"/>
    </conditional_style>
</hook>
<edge STYLE="bezier" COLOR="#93a1a1" WIDTH="3" DASH="SOLID"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details" ID="ID_599277530" COLOR="#ffffff" BACKGROUND_COLOR="#c4cad4">
<hook NAME="NodeCss">body {
                                color: black;
                                }
                            </hook>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes" ID="ID_1169762759" BACKGROUND_COLOR="#cbd3de">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" ID="ID_1824315873"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating" ID="ID_273404251">
<edge STYLE="hide_edge"/>
<cloud COLOR="#7f7f7f" SHAPE="ROUND_RECT"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.selection" ID="ID_313273079" COLOR="#ffffff" BACKGROUND_COLOR="#009999">
<edge COLOR="#ff6600"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode TEXT="CSS.Styles" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="3 pt" SHAPE_VERTICAL_MARGIN="0 pt" UNIFORM_SHAPE="true" TEXT_ALIGN="CENTER">
<font SIZE="24"/>
</stylenode>
<stylenode TEXT="CSS.Pre.Details" BACKGROUND_COLOR="#c4cad4"/>
<stylenode TEXT="CSS.Pre.Attributes" BACKGROUND_COLOR="#cbd3de">
<font SIZE="9"/>
</stylenode>
<stylenode TEXT="CSS.Pre.Selected" COLOR="#ffffff" BACKGROUND_COLOR="#009999">
<edge COLOR="#ff6600"/>
</stylenode>
<stylenode TEXT="CSS.menu" COLOR="#ffffff" BACKGROUND_COLOR="#373e4d" STYLE="fork" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" BORDER_WIDTH_LIKE_EDGE="false" BORDER_WIDTH="0 px">
<edge STYLE="horizontal" COLOR="#59657c" WIDTH="1"/>
</stylenode>
<stylenode TEXT="CSS.info" ID="ID_482568585" COLOR="#cccccc" BACKGROUND_COLOR="#373e4d" STYLE="rectangle" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" FORMAT="markdownPatternFormat" BORDER_WIDTH_LIKE_EDGE="true" MAX_WIDTH="15 cm" MIN_WIDTH="15 cm">
<arrowlink SHAPE="LINE" COLOR="#59657c" WIDTH="1" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_482568585" STARTARROW="NONE" ENDARROW="NONE"/>
<edge STYLE="linear" COLOR="#59657c" WIDTH="1" DASH="DASHES"/>
<hook NAME="NodeCss">code {
  font-size: 1rem;
  background: #D08770;
  color: white;
}</hook>
</stylenode>
<stylenode TEXT="CSS.info.listing" COLOR="#cccccc" BACKGROUND_COLOR="#373e4d" STYLE="fork" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" BORDER_WIDTH_LIKE_EDGE="true">
<edge STYLE="horizontal" COLOR="#59657c" WIDTH="1" DASH="DASHES"/>
</stylenode>
<stylenode TEXT="CSS.info.alt" COLOR="#cccccc" BACKGROUND_COLOR="#373e4d" STYLE="fork" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" BORDER_WIDTH_LIKE_EDGE="true">
<edge COLOR="#59657c" WIDTH="1"/>
</stylenode>
<stylenode TEXT="CSS.Dialog" BACKGROUND_COLOR="#ffffff" STYLE="rectangle" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt" BORDER_WIDTH="3 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#000000" MAX_WIDTH="20 cm">
<font NAME="Courier New"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important" ID="ID_749235638" BORDER_WIDTH="3 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#cc241d">
<icon BUILTIN="yes"/>
<arrowlink COLOR="#cc241d" TRANSPARENCY="255" DESTINATION="ID_749235638"/>
<font SIZE="12" ITALIC="false"/>
</stylenode>
<stylenode TEXT="Custom_Style_1" COLOR="#e0e000" BACKGROUND_COLOR="#993300">
<edge COLOR="#cc3300"/>
</stylenode>
<stylenode TEXT="CSS.Markdown" FORMAT="markdownPatternFormat" MAX_WIDTH="20 cm">
<hook NAME="NodeCss">h1, h2, h3, h4, h5, h6 {
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
}</hook>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" ID="ID_1659178249" COLOR="#ffffff" BACKGROUND_COLOR="#484747" STYLE="bubble" SHAPE_HORIZONTAL_MARGIN="10 pt" SHAPE_VERTICAL_MARGIN="10 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" ID="ID_771207535" COLOR="#eceff4" BACKGROUND_COLOR="#d08770" STYLE="bubble" SHAPE_HORIZONTAL_MARGIN="8 pt" SHAPE_VERTICAL_MARGIN="5 pt">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" ID="ID_814211067" COLOR="#3b4252" BACKGROUND_COLOR="#ebcb8b">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" ID="ID_352058479" COLOR="#2e3440" BACKGROUND_COLOR="#a3be8c">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" ID="ID_294563152" COLOR="#2e3440" BACKGROUND_COLOR="#b48ead">
<font SIZE="11"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5" ID="ID_119767224" BACKGROUND_COLOR="#81a1c1">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6" ID="ID_1794312820" BACKGROUND_COLOR="#88c0d0">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7" ID="ID_759282133" BACKGROUND_COLOR="#8fbcbb">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8" ID="ID_94638384" BACKGROUND_COLOR="#d8dee9">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9" ID="ID_885575204" BACKGROUND_COLOR="#e5e9f0">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10" ID="ID_703695337" BACKGROUND_COLOR="#eceff4">
<font SIZE="9"/>
</stylenode>
</stylenode>
</stylenode>
</map_styles>
</hook>
<node TEXT="Tool panel -&gt; Format" POSITION="right" ID="ID_1674447032" CREATED="1637045511378" MODIFIED="1638623184304" MIN_WIDTH="0 cm" VGAP_QUANTITY="3 pt">
<node TEXT="Node Font" STYLE_REF="CSS.menu" ID="ID_1109578443" CREATED="1637045528466" MODIFIED="1638623300450" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="13.28 pt" VSHIFT_QUANTITY="-5.76 pt">
<node TEXT="CSS" STYLE_REF="CSS.menu" ID="ID_7055575" CREATED="1637049867871" MODIFIED="1638623300449" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="12.56 pt" VSHIFT_QUANTITY="15.12 pt">
<node TEXT="Edit CSS..." STYLE_REF="CSS.menu" ID="ID_611041429" CREATED="1637047233910" MODIFIED="1638623288710" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="8.24 pt" VSHIFT_QUANTITY="18.72 pt">
<node TEXT="When used, CSS is added (individually) to the selected node" STYLE_REF="CSS.info" ID="ID_1936441565" CREATED="1637061694545" MODIFIED="1637062087930" HGAP_QUANTITY="184.64001 pt" VSHIFT_QUANTITY="-12.96 pt"/>
</node>
</node>
</node>
</node>
<node TEXT="Styles dialog" POSITION="right" ID="ID_707338571" CREATED="1637045857960" MODIFIED="1637058528429" HGAP_QUANTITY="35.6 pt" VSHIFT_QUANTITY="10.08 pt">
<cloud COLOR="#373e4d" SHAPE="ROUND_RECT"/>
<node TEXT="Right-Hand Side Panel" ID="ID_1844688991" CREATED="1637046662067" MODIFIED="1638623232977" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="106.16 pt" VSHIFT_QUANTITY="-12.24 pt" MIN_WIDTH="0 cm">
<node TEXT="Node Font" STYLE_REF="CSS.menu" ID="ID_1666579151" CREATED="1637047278799" MODIFIED="1638623306198" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="18.32 pt" VSHIFT_QUANTITY="-5.76 pt">
<node TEXT="CSS" STYLE_REF="CSS.menu" ID="ID_576601529" CREATED="1637047233910" MODIFIED="1638623310642" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="9.68 pt" VSHIFT_QUANTITY="15.12 pt">
<node TEXT="Edit CSS..." STYLE_REF="CSS.menu" ID="ID_1423348045" CREATED="1637047233910" MODIFIED="1638623310642" VGAP_QUANTITY="3 pt" HGAP_QUANTITY="7.52 pt" VSHIFT_QUANTITY="16.56 pt"/>
</node>
</node>
</node>
<node TEXT="Styles" STYLE_REF="CSS.Styles" ID="ID_109289917" CREATED="1637045895402" MODIFIED="1637058301688">
<node TEXT="" ID="ID_1689478660" CREATED="1637056263446" MODIFIED="1637056263451">
<hook NAME="FirstGroupNode"/>
</node>
<node TEXT="Predefined styles" ID="ID_1368623263" CREATED="1637045992314" MODIFIED="1637046007479">
<node TEXT="Default" ID="ID_1494356986" CREATED="1637046008532" MODIFIED="1638624169871">
<arrowlink DESTINATION="ID_1494356986" MIDDLE_LABEL="Connector" STARTINCLINATION="84.24 pt;-6.48 pt;" ENDINCLINATION="84.24 pt;12.24 pt;"/>
<node TEXT="CSS added here will affect &lt;u&gt;node-core&lt;/u&gt; HTML/Markdown of all nodes where **Default** is applied&#xa;(except for nodes with individually-added CSS)" STYLE_REF="CSS.info" ID="ID_556439444" CREATED="1637046662067" MODIFIED="1638624706703" HGAP_QUANTITY="103.28 pt" VSHIFT_QUANTITY="-5.76 pt">
<node TEXT="additionally, &lt;u&gt;node-core&lt;/u&gt; HTML/Markdown is controlled by **Default**&apos;s formatting properties, which are converted to CSS for `body`" STYLE_REF="CSS.info" ID="ID_391451512" CREATED="1637050039659" MODIFIED="1638725208242"/>
</node>
</node>
<node TEXT="Details" STYLE_REF="CSS.Pre.Details" ID="ID_417592" CREATED="1637046168303" MODIFIED="1637059103718" VGAP_QUANTITY="3 pt">
<node TEXT="CSS added here will affect &lt;u&gt;node-details&lt;/u&gt; HTML/Markdown of all nodes in the map" STYLE_REF="CSS.info" ID="ID_1395028814" CREATED="1637046662067" MODIFIED="1638624716353" HGAP_QUANTITY="106.16 pt" VSHIFT_QUANTITY="-1.44 pt">
<node TEXT="if CSS is missing, the &lt;u&gt;node-details&lt;/u&gt; HTML/Markdown is styled by CSS added to **Default**, alongside the **Details**&apos; formatting properties, which can be derived from **Default**&apos;s formatting properties" STYLE_REF="CSS.info" ID="ID_448279837" CREATED="1637050039659" MODIFIED="1638726541059"/>
</node>
</node>
<node TEXT="Attributes" STYLE_REF="CSS.Pre.Attributes" ID="ID_1460102422" CREATED="1637046182327" MODIFIED="1637057906875"/>
<node TEXT="Note" ID="ID_352537091" CREATED="1637046185703" MODIFIED="1637059324548" VGAP_QUANTITY="3 pt">
<node TEXT="CSS added here will affect &lt;u&gt;note&lt;/u&gt; HTML/Markdown of all nodes in the map" STYLE_REF="CSS.info" ID="ID_131966491" CREATED="1637046662067" MODIFIED="1638624747153" HGAP_QUANTITY="116.24001 pt" VSHIFT_QUANTITY="-0.72 pt">
<node TEXT="if CSS is missing, the &lt;u&gt;note&lt;/u&gt; HTML/Markdown is styled by CSS added to **Default**, alongside the **Note**&apos;s formatting properties, which can be derived from **Default**&apos;s formatting properties" STYLE_REF="CSS.info" ID="ID_410907191" CREATED="1637050039659" MODIFIED="1638726590002"/>
</node>
</node>
<node TEXT="Floating node" LOCALIZED_STYLE_REF="defaultstyle.floating" ID="ID_1862721206" CREATED="1637046196759" MODIFIED="1638624960085">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673"/>
</node>
<node TEXT="Selected node" STYLE_REF="CSS.Pre.Selected" ID="ID_655190852" CREATED="1637046200791" MODIFIED="1638624953853">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673"/>
</node>
</node>
<node TEXT="User defined styles" ID="ID_1523529456" CREATED="1637049477103" MODIFIED="1637049502518">
<node TEXT="Custom_Style_1" STYLE_REF="Custom_Style_1" ID="ID_1004656557" CREATED="1637049503688" MODIFIED="1637059127101" VGAP_QUANTITY="2.88 pt">
<node TEXT="CSS added here will affect &lt;u&gt;node-core&lt;/u&gt; HTML/Markdown of all nodes where the **Style** is applied&#xa;(except for nodes with individually-added CSS)" STYLE_REF="CSS.info" ID="ID_73040673" CREATED="1637046662067" MODIFIED="1638624767580" HGAP_QUANTITY="59.36 pt" VSHIFT_QUANTITY="-1.44 pt">
<node TEXT="if CSS is missing, the &lt;u&gt;node-core&lt;/u&gt; HTML/Markdown is styled by CSS added to **Default**, alongside the **Style**&apos;s formatting properties, which can be derived from **Default**&apos;s formatting properties" STYLE_REF="CSS.info" ID="ID_187170987" CREATED="1637050039659" MODIFIED="1638625327555"/>
</node>
</node>
</node>
<node TEXT="" ID="ID_998570899" CREATED="1637056263438" MODIFIED="1637058897599" VGAP_QUANTITY="3 pt">
<hook NAME="SummaryNode"/>
<hook NAME="AlwaysUnfoldedNode"/>
<node TEXT="" STYLE_REF="CSS.info.alt" ID="ID_885221116" CREATED="1637050838081" MODIFIED="1637058897597" HGAP_QUANTITY="13.28 pt" VSHIFT_QUANTITY="-7.2 pt">
<node TEXT="text color" STYLE_REF="CSS.info.listing" ID="ID_1878523709" CREATED="1637050142893" MODIFIED="1637061896385"/>
<node TEXT="background color" STYLE_REF="CSS.info.listing" ID="ID_1141324419" CREATED="1637050152542" MODIFIED="1637061896389"/>
<node TEXT="font family" STYLE_REF="CSS.info.listing" ID="ID_1417356992" CREATED="1637050157838" MODIFIED="1637061896390"/>
<node TEXT="font size" STYLE_REF="CSS.info.listing" ID="ID_1034953419" CREATED="1637050177734" MODIFIED="1637061896391"/>
<node TEXT="bold" STYLE_REF="CSS.info.listing" ID="ID_1802332401" CREATED="1637050180359" MODIFIED="1637061896392"/>
<node TEXT="strike through" STYLE_REF="CSS.info.listing" ID="ID_698947030" CREATED="1637050203999" MODIFIED="1637061896393"/>
<node TEXT="italic" STYLE_REF="CSS.info.listing" ID="ID_1120793705" CREATED="1637050181679" MODIFIED="1637061896394"/>
<node TEXT="text alignment" STYLE_REF="CSS.info.listing" ID="ID_1825065660" CREATED="1637050217575" MODIFIED="1637061896395"/>
</node>
</node>
<node TEXT="Apply level styles" ID="ID_222610227" CREATED="1637058323372" MODIFIED="1637058327413">
<node TEXT="Root" LOCALIZED_STYLE_REF="AutomaticLayout.level.root" ID="ID_1149388413" CREATED="1637058367021" MODIFIED="1638624946393">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673"/>
</node>
<node TEXT="Level 1" LOCALIZED_STYLE_REF="AutomaticLayout.level,1" ID="ID_1952470923" CREATED="1637058328397" MODIFIED="1638624939600">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673"/>
</node>
<node TEXT="Level 2" LOCALIZED_STYLE_REF="AutomaticLayout.level,2" ID="ID_861367070" CREATED="1637058337172" MODIFIED="1638624933032">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673"/>
</node>
<node TEXT="Level 3" LOCALIZED_STYLE_REF="AutomaticLayout.level,3" ID="ID_1922325649" CREATED="1637058353773" MODIFIED="1638624911794">
<arrowlink STYLE_REF="CSS.info" SHAPE="LINE" COLOR="#59657c" TRANSPARENCY="255" DASH="7 7" DESTINATION="ID_73040673" STARTINCLINATION="79.2 pt;0 pt;" ENDINCLINATION="116.64 pt;28.8 pt;"/>
</node>
</node>
</node>
</node>
<node TEXT="Example of Markdown with CSS" FOLDED="true" POSITION="right" ID="ID_719644940" CREATED="1638625419251" MODIFIED="1638725323339" VGAP_QUANTITY="3 pt">
<node TEXT="# Heading 1&#xa;Regular text. **Bold text.** *Italic text.* ***Both: bold and italic.***&#xa;&#xa;A line (horizontal ruler) using underscores:&#xa;___&#xa;&#xa;&lt;s&gt;Strike through&lt;/s&gt; NB. using `~~deleted text~~` doesn&apos;t work in Freeplane (Java html/css renderer)&#xa;&#xa;E.g. ~~deleted text~~&#xa;&#xa;&lt;u&gt;Underlined text&lt;/u&gt;&#xa;&#xa;## Heading 2&#xa;&gt; A quote, line 1.&#xa;&gt; Line 2 of the quote (will be joined with line 1).&#xa;&gt;&gt; A quote within a quote&#xa;&#xa;### Heading 3&#xa;Sample text with `an in-line piece of code`.&#xa;&#xa;```groovy&#xa;// a Groovy code example - as a block of code&#xa;def name = &apos;Freeplane User&apos;&#xa;&quot;Hello, ${name}!&quot;&#xa;```&#xa;&#xa;    Another example of a block of code&#xa;    introduced as indented Markdown (with a tab or 4 spaces)&#xa;&#xa;&gt;     An example of a quote&#xa;&gt;     containing a block of code&#xa;&gt;     At least 5 spaces need to be used&#xa;&gt; And it continues as a regular quote&#xa;&#xa;#### Heading 4&#xa;A table&#xa;&#xa;| # | Language | [Pangram](https://en.wikipedia.org/wiki/Pangram) |&#xa;|--|--|--|&#xa;| 1 | English | The quick brown fox jumps over the lazy dog |&#xa;| 2 | French | Portez ce vieux whisky au juge blond qui fume |&#xa;| 3 | German | Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich |&#xa;| 4 | Italian | Pranzo d&apos;acqua fa volti sghembi |&#xa;| 5 | Spanish | Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú |&#xa;&#xa;##### Heading 5&#xa;A list of items&#xa;&#xa;* Item 1&#xa;* Item 2&#xa;* Item 3&#xa;&#xa;###### Heading 6&#xa;A numbered list&#xa;&#xa;1. Item A&#xa;2. Item B&#xa;3. Item C" STYLE_REF="CSS.Markdown" ID="ID_537463989" CREATED="1638625448884" MODIFIED="1638725148013"/>
</node>
<node TEXT="The same Markdown without CSS" FOLDED="true" POSITION="right" ID="ID_1186507779" CREATED="1638725628564" MODIFIED="1638725636702" VGAP_QUANTITY="3 pt">
<node TEXT="# Heading 1&#xa;Regular text. **Bold text.** *Italic text.* ***Both: bold and italic.***&#xa;&#xa;A line (horizontal ruler) using underscores:&#xa;___&#xa;&#xa;&lt;s&gt;Strike through&lt;/s&gt; NB. using `~~deleted text~~` doesn&apos;t work in Freeplane (Java html/css renderer)&#xa;&#xa;E.g. ~~deleted text~~&#xa;&#xa;&lt;u&gt;Underlined text&lt;/u&gt;&#xa;&#xa;## Heading 2&#xa;&gt; A quote, line 1.&#xa;&gt; Line 2 of the quote (will be joined with line 1).&#xa;&gt;&gt; A quote within a quote&#xa;&#xa;### Heading 3&#xa;Sample text with `an in-line piece of code`.&#xa;&#xa;```groovy&#xa;// a Groovy code example - as a block of code&#xa;def name = &apos;Freeplane User&apos;&#xa;&quot;Hello, ${name}!&quot;&#xa;```&#xa;&#xa;    Another example of a block of code&#xa;    introduced as indented Markdown (with a tab or 4 spaces)&#xa;&#xa;&gt;     An example of a quote&#xa;&gt;     containing a block of code&#xa;&gt;     At least 5 spaces need to be used&#xa;&gt; And it continues as a regular quote&#xa;&#xa;#### Heading 4&#xa;A table&#xa;&#xa;| # | Language | [Pangram](https://en.wikipedia.org/wiki/Pangram) |&#xa;|--|--|--|&#xa;| 1 | English | The quick brown fox jumps over the lazy dog |&#xa;| 2 | French | Portez ce vieux whisky au juge blond qui fume |&#xa;| 3 | German | Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich |&#xa;| 4 | Italian | Pranzo d&apos;acqua fa volti sghembi |&#xa;| 5 | Spanish | Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú |&#xa;&#xa;##### Heading 5&#xa;A list of items&#xa;&#xa;* Item 1&#xa;* Item 2&#xa;* Item 3&#xa;&#xa;###### Heading 6&#xa;A numbered list&#xa;&#xa;1. Item A&#xa;2. Item B&#xa;3. Item C" STYLE_REF="CSS.Markdown" ID="ID_1838921575" CREATED="1638725643074" MODIFIED="1638726289494">
<hook NAME="NodeCss">none {}</hook>
</node>
</node>
</node>
</map>
