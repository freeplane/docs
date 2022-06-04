<map version="0.9.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Types of free or floating nodes" FOLDED="false" ID="ID_1723255651" CREATED="1283093380553" MODIFIED="1320947013730" VGAP="0">
<hook NAME="MapStyle" max_node_width="600" min_node_width="1">
<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node">
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right">
<stylenode LOCALIZED_TEXT="default" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="12" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.note"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="12" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="12" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="12" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
<stylenode TEXT="Free positionabe child">
<edge STYLE="bezier"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000">
<font SIZE="20"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="12"/>
</stylenode>
</stylenode>
</stylenode>
</map_styles>
</hook>
<richcontent TYPE="DETAILS" HIDDEN="true">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Example
    </p>
    <ul>
      <li>
        Node free 1 is free postionable node with default style and hidden edge
      </li>
      <li>
        Node free 2 is node with default style and hidden edge
      </li>
      <li>
        Node free 3 is node with style Floating node
      </li>
      <li>
        Node free 4 is free &#160;positionable node with style Floating node.
      </li>
      <li>
        Nodes a,b,c,d,e are Free positionable nodes with default style.
      </li>
      <li>
        Nodes a1, a2, a3....c1, c2, c3 are regular nodes with default style.
      </li>
    </ul>
    <p>
      Node free 2 + children is copy of free 1 + chlidren pasted on root.
    </p>
    <ul>
      <li>
        Note that chldren are left-right inverted. free2 loses state &quot;free positionable node&quot;
      </li>
    </ul>
    <p>
      
    </p>
    <p>
      Node free 4 + children and cloud is copy of free 3 + children and cloud.
    </p>
    <ul>
      <li>
        Note that chldren are left-right inverted.
      </li>
      <li>
        Free positioned note has been set by hand.
      </li>
    </ul>
    <p>
      
    </p>
  </body>
</html></richcontent>
<font ITALIC="true"/>
<edge STYLE="hide_edge" COLOR="#808080"/>
<node TEXT="free 1" POSITION="left" ID="ID_1981284080" CREATED="1320906727453" MODIFIED="1320947068175" VGAP="0" HGAP="290" VSHIFT="-106" STYLE="bubble" TEXT_SHORTENED="true">
<hook NAME="FreeNode"/>
<edge STYLE="hide_edge"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Source node
    </p>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Hidden edge
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="c" STYLE_REF="Free positionabe child" ID="ID_1922253302" CREATED="1320906846855" MODIFIED="1320937838604" HGAP="60" VSHIFT="-41">
<hook NAME="FreeNode"/>
<node TEXT="c1" ID="ID_430230186" CREATED="1320937422692" MODIFIED="1320937905544" VSHIFT="30"/>
<node TEXT="c2" ID="ID_1723435908" CREATED="1320937442745" MODIFIED="1320937910161" VSHIFT="10"/>
<node TEXT="c3" ID="ID_852282768" CREATED="1320937466995" MODIFIED="1320937915824" VSHIFT="-30"/>
</node>
<node TEXT="a" STYLE_REF="Free positionabe child" ID="ID_1077589869" CREATED="1320906838189" MODIFIED="1320938128757" HGAP="-40" VSHIFT="-31" TEXT_SHORTENED="true">
<hook NAME="FreeNode"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Edge style smoothly curved
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="a1" ID="ID_1443269402" CREATED="1320937422692" MODIFIED="1320938176727" HGAP="-50" VSHIFT="20" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Default node with default style
    </p>
  </body>
</html></richcontent>
</node>
<node TEXT="a2" ID="ID_84580629" CREATED="1320937442745" MODIFIED="1320937456240" HGAP="-50" VSHIFT="-20"/>
<node TEXT="a3" ID="ID_1757772734" CREATED="1320937466995" MODIFIED="1320937500411" HGAP="-50" VSHIFT="-20"/>
</node>
<node TEXT="b" STYLE_REF="Free positionabe child" ID="ID_1604640076" CREATED="1320906850201" MODIFIED="1320937720886" HGAP="-40" VSHIFT="29">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d" STYLE_REF="Free positionabe child" ID="ID_112545749" CREATED="1320937664897" MODIFIED="1320937831038" HGAP="30" VSHIFT="30"/>
<node TEXT="e" STYLE_REF="Free positionabe child" ID="ID_461854204" CREATED="1320906853547" MODIFIED="1320938947150" HGAP="10" VSHIFT="49">
<hook NAME="FreeNode"/>
</node>
</node>
<node TEXT="free 4" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="left" ID="ID_985625677" CREATED="1320906727453" MODIFIED="1320947049860" VGAP="0" HGAP="290" VSHIFT="199" STYLE="bubble" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Source node
    </p>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Hidden edge
      </li>
    </ul>
  </body>
</html></richcontent>
<hook NAME="FreeNode"/>
<node TEXT="c" STYLE_REF="Free positionabe child" ID="ID_839108428" CREATED="1320906846855" MODIFIED="1320937838604" HGAP="60" VSHIFT="-41">
<hook NAME="FreeNode"/>
<node TEXT="c1" ID="ID_763806447" CREATED="1320937422692" MODIFIED="1320937905544" VSHIFT="30"/>
<node TEXT="c2" ID="ID_1629783896" CREATED="1320937442745" MODIFIED="1320937910161" VSHIFT="10"/>
<node TEXT="c3" ID="ID_750621414" CREATED="1320937466995" MODIFIED="1320937915824" VSHIFT="-30"/>
</node>
<node TEXT="a" STYLE_REF="Free positionabe child" ID="ID_1263732257" CREATED="1320906838189" MODIFIED="1320938128757" HGAP="-40" VSHIFT="-31" TEXT_SHORTENED="true">
<hook NAME="FreeNode"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Edge style smoothly curved
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="a1" ID="ID_839936528" CREATED="1320937422692" MODIFIED="1320938176727" HGAP="-50" VSHIFT="20" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Default node with default style
    </p>
  </body>
</html></richcontent>
</node>
<node TEXT="a2" ID="ID_231947311" CREATED="1320937442745" MODIFIED="1320937456240" HGAP="-50" VSHIFT="-20"/>
<node TEXT="a3" ID="ID_1184280081" CREATED="1320937466995" MODIFIED="1320937500411" HGAP="-50" VSHIFT="-20"/>
</node>
<node TEXT="b" STYLE_REF="Free positionabe child" ID="ID_1212966082" CREATED="1320906850201" MODIFIED="1320937720886" HGAP="-40" VSHIFT="29">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d" STYLE_REF="Free positionabe child" ID="ID_535498001" CREATED="1320937664897" MODIFIED="1320937831038" HGAP="30" VSHIFT="30"/>
<node TEXT="e" STYLE_REF="Free positionabe child" ID="ID_573303485" CREATED="1320906853547" MODIFIED="1320938947150" HGAP="10" VSHIFT="49">
<hook NAME="FreeNode"/>
</node>
</node>
<node TEXT="free 2" POSITION="right" ID="ID_1552746378" CREATED="1320906727453" MODIFIED="1320947073884" VGAP="0" HGAP="90" VSHIFT="-106" STYLE="bubble" TEXT_SHORTENED="true">
<edge STYLE="hide_edge"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Copy of free 1, pasted on root:
    </p>
    <ul>
      <li>
        NOT free positionable
      </li>
      <li>
        Hidden edge
      </li>
      <li>
        left and right are interchanged
      </li>
      <li>
        children remain free positioned nodes
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="c" STYLE_REF="Free positionabe child" ID="ID_689852567" CREATED="1320906846855" MODIFIED="1320937838604" HGAP="60" VSHIFT="-41">
<hook NAME="FreeNode"/>
<node TEXT="c1" ID="ID_1573989371" CREATED="1320937422692" MODIFIED="1320937905544" VSHIFT="30"/>
<node TEXT="c2" ID="ID_1014069284" CREATED="1320937442745" MODIFIED="1320937910161" VSHIFT="10"/>
<node TEXT="c3" ID="ID_769006008" CREATED="1320937466995" MODIFIED="1320937915824" VSHIFT="-30"/>
</node>
<node TEXT="a" STYLE_REF="Free positionabe child" ID="ID_942051679" CREATED="1320906838189" MODIFIED="1320938128757" HGAP="-40" VSHIFT="-31" TEXT_SHORTENED="true">
<hook NAME="FreeNode"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Edge style smoothly curved
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="a1" ID="ID_700487982" CREATED="1320937422692" MODIFIED="1320938176727" HGAP="-50" VSHIFT="20" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Default node with default style
    </p>
  </body>
</html></richcontent>
</node>
<node TEXT="a2" ID="ID_686414690" CREATED="1320937442745" MODIFIED="1320937456240" HGAP="-50" VSHIFT="-20"/>
<node TEXT="a3" ID="ID_92949469" CREATED="1320937466995" MODIFIED="1320937500411" HGAP="-50" VSHIFT="-20"/>
</node>
<node TEXT="b" STYLE_REF="Free positionabe child" ID="ID_514004533" CREATED="1320906850201" MODIFIED="1320937720886" HGAP="-40" VSHIFT="29">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d" STYLE_REF="Free positionabe child" ID="ID_22243944" CREATED="1320937664897" MODIFIED="1320937831038" HGAP="30" VSHIFT="30"/>
<node TEXT="e" STYLE_REF="Free positionabe child" ID="ID_1585639732" CREATED="1320906853547" MODIFIED="1320938954388" HGAP="10" VSHIFT="49">
<hook NAME="FreeNode"/>
</node>
</node>
<node TEXT="free 3" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_2932471" CREATED="1320906727453" MODIFIED="1320947043995" VGAP="0" HGAP="90" VSHIFT="144" STYLE="bubble" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Source node
    </p>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Hidden edge
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="c" STYLE_REF="Free positionabe child" ID="ID_195667310" CREATED="1320906846855" MODIFIED="1320937838604" HGAP="60" VSHIFT="-41">
<hook NAME="FreeNode"/>
<node TEXT="c1" ID="ID_1317737304" CREATED="1320937422692" MODIFIED="1320937905544" VSHIFT="30"/>
<node TEXT="c2" ID="ID_1459215567" CREATED="1320937442745" MODIFIED="1320937910161" VSHIFT="10"/>
<node TEXT="c3" ID="ID_1607541909" CREATED="1320937466995" MODIFIED="1320937915824" VSHIFT="-30"/>
</node>
<node TEXT="a" STYLE_REF="Free positionabe child" ID="ID_1897947363" CREATED="1320906838189" MODIFIED="1320938128757" HGAP="-40" VSHIFT="-31" TEXT_SHORTENED="true">
<hook NAME="FreeNode"/>
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Free positionable node
      </li>
      <li>
        Edge style smoothly curved
      </li>
    </ul>
  </body>
</html></richcontent>
<node TEXT="a1" ID="ID_701861076" CREATED="1320937422692" MODIFIED="1320938176727" HGAP="-50" VSHIFT="20" TEXT_SHORTENED="true">
<richcontent TYPE="DETAILS">
<html>
  <head>
    
  </head>
  <body>
    <p>
      Default node with default style
    </p>
  </body>
</html></richcontent>
</node>
<node TEXT="a2" ID="ID_694005913" CREATED="1320937442745" MODIFIED="1320937456240" HGAP="-50" VSHIFT="-20"/>
<node TEXT="a3" ID="ID_1642775981" CREATED="1320937466995" MODIFIED="1320937500411" HGAP="-50" VSHIFT="-20"/>
</node>
<node TEXT="b" STYLE_REF="Free positionabe child" ID="ID_1509198893" CREATED="1320906850201" MODIFIED="1320937720886" HGAP="-40" VSHIFT="29">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d" STYLE_REF="Free positionabe child" ID="ID_943657546" CREATED="1320937664897" MODIFIED="1320937831038" HGAP="30" VSHIFT="30"/>
<node TEXT="e" STYLE_REF="Free positionabe child" ID="ID_89995684" CREATED="1320906853547" MODIFIED="1320938947150" HGAP="10" VSHIFT="49">
<hook NAME="FreeNode"/>
</node>
</node>
</node>
</map>
