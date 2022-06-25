These are scripts which deal mostly with editing the text of nodes.

Some of them are also available in the editgoodies addon. 

Feel free to add your own scripts here. If you give script a name using wiki text like

`<syntaxhighlight lang="Groovy" name="yourScriptName">
 your script
</syntaxhighlight>`

an extra download button is created for it, and it can be downloaded directly from this page.

For larger scripts there is a special [git](Git_howto.md) repository [https://github.com/freeplane/addons].



## Transpose the two characters around the cursor (for bad typists)

Once this script is downloaded and placed in the script directory, it should be bound to a keystroke so that it can be called without moving from the keyboard. It is now also available as part of the Edit Goodies addon, as is the script below, to change case. That's much the easiest way to install it. This version should be considered a purely instructional example.

```groovy


  // @ExecutionModes({ON_SINGLE_NODE}) 
  // first we import the Java libraries needed 
  // to access and manipulate the text of a node
  import java.awt.KeyboardFocusManager 
  import javax.swing.JEditorPane 
  // Then wrap the action in a "try/catch" block so that it fails gracefully
  // though the record is written to a largely inaccessible log file, and should be displayed better
  try { 
     def focusOwner = KeyboardFocusManager.currentKeyboardFocusManager.focusOwner 
     // these two lines check that the cursor is inside a node being actively edited
     if (focusOwner instanceof JEditorPane) { 
         JEditorPane editor = focusOwner 
         // next, find the cursor position and save it in a variable
         cursor = editor.caretPosition - 1 
         // Get a copy of the node text with all the html markup stripped out
         def oldstr = htmlUtils.htmlToPlain(editor.text)
        // Make a new string with the letters around the cursor changed
         def newstr = oldstr.substring(0, cursor-1) + oldstr[cursor] + oldstr[cursor-1] + oldstr.substring(cursor+1) 
         // And write it back into the node
         editor.text = newstr 
         // finally, put the cursor back where it was
         editor.caretPosition = cursor + 1 
     } 
     else { 
         c.statusInfo = 'cannot transpose: inline editor not active' 
     } 
  } 
  catch (Exception e) { 
    logger.severe('cannot transpose', e) 
  }
```

Author: `seatrout` with polish and editing by `boercher`

## Change case of words, and sort bAD CApitalisation

This script, like the one above, is part of the edit goodies addon, available from the support site. 
If used from here, it should be bound to a key

    <syntaxhighlight lang="Groovy" name="caseChanger">
    // @ExecutionModes({ON_SINGLE_NODE}) 
    //import java.awt.Color
    import java.awt.KeyboardFocusManager 
    import javax.swing.JEditorPane 
    import java.text.BreakIterator
    // annotated a bit extra for instructional purposes
    // starts with wrapping everything in a "try" block so that it crashes gracefully 

    try { 
    // first find the node we are working in
    def focusOwner = KeyboardFocusManager.currentKeyboardFocusManager.focusOwner 
    if (focusOwner instanceof JEditorPane) { 
    JEditorPane editor = focusOwner 
    cursor = editor.caretPosition-1 //Here we find the cursor
    oldWord=editor.getSelectedText()
    plaintext=htmlUtils.htmlToPlain(editor.text) // and here strip out the html for manipulating the text
    isBigSelection=0
    selectionStart=cursor //belt and braces to initialise this, but still
    // first, select the word the cursor is in, or merely hanging around
    // if there is no text presently selected
    if (oldWord==null){
    BreakIterator bi=BreakIterator.getWordInstance()
    bi.setText(plaintext)
    // this next bit should be simple, but is complicated by the need
    // to do the right thing if the cursor is at either end of a word.
    // the next block captures the case if it is at the beginning of a word
    if (bi.isBoundary(cursor) && (bi.isBoundary(cursor-1))){
    if (plaintext.substring(cursor-1,cursor) ==~/[A-z]/) {
    //Problem! It could be a single-letter word, in which case
    oldWord=plaintext.substring(cursor-1,cursor)
    selectionStart=cursor-2
    }
    else {
    oldWord=plaintext.substring(cursor,bi.next(2))
    }
    }
    else {
    oldWord=plaintext.substring(bi.preceding(cursor),bi.next())
    selectionStart=bi.preceding(cursor)
    }    
    }
    // or there may be text selected, perhaps several words. in that case ... 
    else { 
    selectionStart=editor.getSelectionStart()
    selectionEnd=editor.getSelectionEnd()
    oldWord=plaintext.substring(selectionStart-1,selectionEnd)
    isBigSelection=1
    //ui.informationMessage(ui.frame, oldWord, "The selection is")
    }
    // either way, now we have a selection
    // and the next line does all the real work
        
    newWord=cycleCase(oldWord)

    // this next change changed to ensure that only one instance of a word is affected
    //(bug found in v 0.2)

    editor.text=changeSelectedWordOnly(plaintext,selectionStart,oldWord,newWord)
        
    // now clean everything up and put the cursor back where it was 

    if(isBigSelection==0){
    editor.caretPosition = cursor+1
    }
    else {
    editor.setCaretPosition(selectionStart)
    editor.moveCaretPosition(selectionEnd)
    }
        
    } 
    else { 
    c.statusInfo = 'cannot change case: inline editor not active' 
    } 
    } 
    catch (Exception e) { 
    logger.severe('cannot change case', e) 
    }

    // acb routine to ensure only the selection is changed
    // could no doubt be more elegant but life is short

    def changeSelectedWordOnly(text,start,oldWord,newWord){
    firsthalf=text.substring(0,start)
    secondhalf=text.substring(start)
    firsthalf+secondhalf.replaceFirst(oldWord,newWord)
    }

    // And the actual cycle case routine

    def cycleCase(oldWord){
    if (oldWord.toUpperCase()==oldWord){
    oldWord.toLowerCase()
    }
    else if (oldWord.toLowerCase()==oldWord) {
    oldWord[0].toUpperCase()+oldWord.substring(1).toLowerCase()
    }
    else {
    oldWord.toUpperCase()
    }
    }
    </syntaxhighlight>

Author: `seatrout` with polish and editing by `boercher`

## Clean screen editor

A toggle script for when you want to concentrate: will either centre the selected node, hide all others, and darken the background, or switch back to the normal bright, and possibly cluttered, view.

<!-- name=Cleanscreen -->
```groovy
  // @ExecutionModes({ON_SINGLE_NODE})
  import java.awt.Color
  import org.freeplane.core.resources.ResourceController
  import org.freeplane.core.ui.ColorTracker
  import org.freeplane.core.util.ColorUtils
  import org.freeplane.core.util.TextUtils
  import org.freeplane.features.mode.Controller;
  import org.freeplane.features.styles.MapStyle
  import org.freeplane.features.styles.MapStyleModel
  def setBackgroundColor(Color actionColor) {
    Controller controller = Controller.getCurrentController();
    MapStyle mapStyle = (MapStyle) controller.getModeController().getExtension(MapStyle.class);
    MapStyleModel model = (MapStyleModel) mapStyle.getMapHook(node.map.delegate);
    mapStyle.setBackgroundColor(model, actionColor);
  }
 
  def setBackgroundColorCode(String rgbString) {
    setBackgroundColor(ColorUtils.stringToColor(rgbString));
  }
 
  // note Groovy gotcha in the next line -- if "paleblue" 
  // is defined as a colour explicitly, as in
  // "Color paleblue=new Color(218,230,239)"
  // the script breaks, because variables defined in this way are not accessible inside blocks
  // they must instead be defined "naked" as below.
  // see http://groovy.codehaus.org/Scoping+and+the+Semantics+of+%22def%22
  
  paleblue=new Color(218,230,239)
  
  
  if (this.node.style.edge.getColor()==paleblue){
      clutterscreen()
  }
  else {
      clearscreen()
  }
  
  
  def clearscreen(){
    setBackgroundColor(paleblue)
    myname=this.node.getId()
    node.map.filter = { it.getId()==myname }
    this.node.style.edge.setColor(paleblue)
    c.centerOnNode(this.node)
  }
  
  def clutterscreen(){
      this.node.style.edge.setColor(Color.lightGray)
      setBackgroundColor(Color.white)
      node.map.undoFilter()
  }

```

Author: `seatrout` with the hard bits by `boercher`

## Inserts an inline image into node text or details

This script asks for an image file for inclusion as an inline graphics either into node details or node text. Plain texts will be converted to HTML. Thanks to Q [for asking for this feature](http://sourceforge.net/projects/freeplane/forums/forum/758437/topic/4617178).

Note: This script is here just as an example for coding. If you just want to use it use the [Insert Inline Image Add-On](https://www.freeplane.org/wiki/index.php/Add-ons#Insert_Inline_Image) instead.

Requires at least Freeplane 1.2.7

<!-- name=insertInlineImage -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE})
import groovy.swing.SwingBuilder
import java.awt.FlowLayout as FL
import javax.swing.BoxLayout as BXL
import javax.swing.ImageIcon
import javax.swing.JFileChooser
import javax.swing.JTextField
import org.freeplane.core.resources.ResourceController

def ImageIcon getIcon(String path) {
    new ImageIcon(ResourceController.getResourceController().getResource(path))
}

def builder = new SwingBuilder()
def dial = builder.dialog(title:'Insert Image', id:'insertImage', modal:true,
               locationRelativeTo:ui.frame, owner:ui.frame, pack:true, show:true) {
    panel() {
        JTextField urlField
        boxLayout(axis:BXL.Y_AXIS)
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('URL')
            urlField = textField(id:'url', columns:30)
            button(action:action(closure:{
                def chooser = fileChooser(fileSelectionMode:JFileChooser.FILES_ONLY)
                if (chooser.showOpenDialog() == JFileChooser.APPROVE_OPTION)
                    urlField.text = chooser.selectedFile.toURL()
                }), icon:getIcon("/images/fileopen.png"))
        }
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Width:')
            textField(id:'width', columns:3)
            glue()
            label('Height:')
            textField(id:'height', columns:3)
        }
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Target:')
            buttonGroup().with { group ->  
                radioButton(id:'text', text:'Node Text', selected:true, buttonGroup:group)  
                radioButton(id:'details', text:'Node Details', buttonGroup:group)  
            }  
        }
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.RIGHT)
            button(action:action(name:'OK', defaultButton:true, mnemonic:'O',
                                 enabled:bind(source:urlField, sourceProperty:'text',
                                              converter:{ it ? true : false }),
                                 closure:{variables.ok = true; dispose()}))
            button(action:action(name:'Cancel', mnemonic:'C', closure:{dispose()}))
        }
    }
}

def String insertTag(String text, String htmlTag) {
    if (text == null)
        text = ""
    if ( ! text.startsWith("<html>"))
        text = "<html><head/><body>${text}</body></html>"
    return text.replace("</body>", htmlTag + "</body>")
}

def String imageTag(url, width, height) {
    def attribs = [ "src='${url}'" ]
    if (width)
        attribs << "width='${width}'"
    if (height)
        attribs << "height='${height}'"
    "<img ${attribs.join(' ')} />"
}

def vars = builder.variables
if (vars.ok) {
    def imageTag = imageTag(vars.url.text, vars.width.text, vars.height.text)
    if (vars.details.selected)
        node.details = insertTag(node.detailsText, imageTag)
    else
        node.text = insertTag(node.text, imageTag)
}
```

Author: `boercher`

## Simple plain text word count using scripts

This script will take the selected node(s), iterate down through subnodes, and count plain text. Notes, attributes, icons are not counted.

<!-- name=countWords -->
```groovy
  // @ExecutionModes({ON_SINGLE_NODE})
  // Initial version: wordCount.groovy by User:cybaker
  // Adapted for Freeplane by User:Boercher
  // This script goes through all selected nodes and their subnodes and
  // counts the number of plain text words, not including notes. Words
  // are delimited by a any white space character.
  // Message box for reporting added by User:seatrout
  //
  // Usage: Select node(s). Run script once.

  import java.text.NumberFormat;

  def nodes = new HashSet()
  c.selecteds.each{ nodes.addAll(it.find{true}) }

  def result = nodes.sum(0){ it.plainTextContent.split("\\s+").length }
  ui.informationMessage(ui.frame, NumberFormat.getInstance().format(result)+ " Words in selected node and children", "Word Count")

```

Author: `cybaker`

## Delete line breaks

    Replace line breaks in the node text by space characters.

    <syntaxhighlight lang="Groovy" name="deleteLineBreaks">
  
    // @ExecutionModes({ON_SELECTED_NODE})
    node.text = node.text.replaceAll('\\s*\n\\s*', ' ')
  

Author: `boercher`

## Note statistics

This script prints note statistics to the status bar no matter if the note editor panel is opened or not. Although not strictly an editing script this one shows how to access the note editor panel.

<!-- name=noteStatistics -->
```groovy
// @ExecutionModes({ON_SINGLE_NODE}) 

import org.freeplane.features.note.NoteController

def noteTextFromViewer = NoteController.controller.noteViewerComponent?.documentText
def noteText = noteTextFromViewer ? htmlUtils.htmlToPlain(noteTextFromViewer) : node.note?.to?.plain
if (noteText) {
	def wordCount = noteText.split('\\W+').length
	c.statusInfo = "note: ${wordCount} words, ${noteText.length()} characters"
}
else {
	c.statusInfo = "no note"
}
```

Author: `boercher`

