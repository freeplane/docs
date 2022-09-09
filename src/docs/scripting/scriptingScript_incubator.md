A collection of scripts that might need a review before adding them to the "official" [Scripts collection](../scripting/Scripts_collection .md).

Feel free to add your own scripts to this page. If you give script a name using wiki text like

`<syntaxhighlight lang="Groovy" name="yourScriptName">
 your script
</syntaxhighlight>`

an extra download button is created for it, and it can be downloaded directly from this page.



## Pair of scripts to increase/decrease the node-width (can be used with shortcuts!)

Since freeplane 1.5.x we can adjust the node-width with ALT+mouse-wheel, but there is currently no way to make it with keyboard shortcuts.

So these scripts aim at increasing/decreasing the node-width (the same way that ALT-mout-wheel would do), but by being scripts they will have a menu entry in "Tools/Scripts/Node Width_Increase" and "Tools/Scripts/Node Width_Decrease", making possible to create a shortcut to these menu entries, and so, to adjust the node-width with keyboard shortcuts.

### How to install the scripts

1. Download the 2 scripts from this page and put them inside the directory "<freeplane-user-dir>/scripts" (you can open "<freeplane-user-dir>" clicking in "Tools/Open user directory")
2. Restart Freeplane   - Verify that the 2 new scripts appear in these 2 new menu-entries "Tools/Scripts/Node Width_Increase" and "Tools/Scripts/Node Width_Decrease"
3. optional Assign a shortcut-key to each of the 2 menu-entries (hold CTRL while clicking a menu-entry)


Hope it helps :)


<!-- name=NodeWidth_Increase -->
```groovy
// @ExecutionModes({ON_SELECTED_NODE})
 
// zipizap, Feb2016
// Trying to solve this thread discussion [1]
// Inspired by this node-width sample code [2]
// Published here: https://www.freeplane.org/wiki/index.php/Script_incubator#Pair_of_scripts_to_increase.2Fdecrease_the_node-width_.28can_be_used_with_shortcuts.21.29
// Dedicated to the great and friendly freeplane community :)
// UPDATE: 2016/08/16 - added improvements made by Ken Hill (see [3])
// UPDATE: 2017/01/13 - smaller code, only uses maxNodeWidth
//
//
// [1] https://sourceforge.net/p/freeplane/discussion/758437/thread/8f1d0faa/
// [2] https://sourceforge.net/p/freeplane/discussion/758437/thread/108a5c74/#2d6a
// [3] https://sourceforge.net/p/freeplane/discussion/758437/thread/8f1d0faa/#bf45
 
def step=10
node.style.maxNodeWidth+=step
```

<!-- name=NodeWidth_Decrease -->
```groovy
// @ExecutionModes({ON_SELECTED_NODE})
 
// zipizap, Feb2016
// Trying to solve this thread discussion [1]
// Inspired by this node-width sample code [2]
// Published here: https://www.freeplane.org/wiki/index.php/Script_incubator#Pair_of_scripts_to_increase.2Fdecrease_the_node-width_.28can_be_used_with_shortcuts.21.29
// Dedicated to the great and friendly freeplane community :)
// UPDATE: 2016/08/16 - added improvements made by Ken Hill (see [3])
// UPDATE: 2017/01/13 - smaller code, only uses maxNodeWidth
//
//
// [1] https://sourceforge.net/p/freeplane/discussion/758437/thread/8f1d0faa/
// [2] https://sourceforge.net/p/freeplane/discussion/758437/thread/108a5c74/#2d6a
// [3] https://sourceforge.net/p/freeplane/discussion/758437/thread/8f1d0faa/#bf45
 
def step=10
(node.style.maxNodeWidth - step) > 0 ? node.style.maxNodeWidth-=step : null
```


Author: `zipizap`



----



## Scripts to save/restore the folding of the current map, with 2 restore-points


Trying to help out with this request, to save different folding states [- see the thread for more info

\[1\] https://sourceforge.net/p/freeplane/discussion/758437/thread/10318019/?limit=25#879e


Use the save script to save the current folding of the map, and then later use the restore script to restore the saved-folding.

The folding-states are saved into the maps (.mm) file, and so are persistent across map loading. That is: you can save a folding state today, and next week when you open the same map restore the folding state


There are 2 pairs of files - save/restore_S0 and save/restore_S1 - that enable 2 restore-points. 

If you need more restore points, then create more pairs of files (save/restore_S2, save/restore_S3, ...) where you will only need to change the last 2 lines of code **save_restore_closure(...,"S9")**


### How to install the scripts

1. Download the scripts from https://www.freeplane.org/wiki/index.php/Script_incubator and put them inside the directory "<freeplane-user-dir>/scripts" (you can open "<freeplane-user-dir>" clicking in "Tools/Open user directory")
2. Restart Freeplane   - Verify that the new scripts appear inside menu "Tools/Scripts"
3. optional Assign a shortcut-key to each of the scripts new menu-entries (hold CTRL while clicking a menu-entry)


Hope it helps :)


<!-- name=save_folds_S0 -->
```groovy
// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
Closure save_restore_closure = 
  { String save_or_restore, String folding_state_name ->       
    // The save_or_restore variable should be given on of these two values: "save" or "restore"
    // The folding_state_name variable can be given any name without spaces or special characters. Ex: "S0" or "S1" or "S2"

    if ( save_or_restore == "save" ) {
      // save folding

      // get foldings
      def folded_nodes_ids_ary = c.findAll().findAll { it.isFolded() }.collect { it.id }
        // Array of Strings 
        // [ 'ID_xxx1',
        //   'ID,xxx2',
        //    ...
        //   'ID_xxxN'
        // ]
      //folded_nodes_ids_ary.each { N(it).style.backgroundColorCode = '#0000FF' }

      String stringified_ary_xml_escaped = htmlUtils.toXMLEscapedText( folded_nodes_ids_ary.inspect() )
        // String xml-escaped (ready to be stored in XML file)
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      // save to map stringified_ary_xml_escaped
      node.map.storage[folding_state_name]=stringified_ary_xml_escaped
    } else {
      // restore folding

      // load from map stringified_ary_xml_escaped
      def result_convertible = node.map.storage[folding_state_name]
        // Convertible (see org.freeplane.plugin.script.proxy.Convertible, use result_convertible.string to get String)
        // or null

      if (result_convertible == null) {
        return 
      }

      String stringified_ary_xml_escaped = result_convertible.string
      String stringified_ary = htmlUtils.toXMLUnescapedText( stringified_ary_xml_escaped )
        // String
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      def folded_nodes_ids_ary = Eval.me(stringified_ary)
        // Array of Strings
        //  [ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ] 

      // restore foldings
      c.findAll().each { n ->  n.setFolded( folded_nodes_ids_ary.contains(n.id) ? true : false ) }
    }
  }

// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
save_restore_closure("save", "S0")
//save_restore_closure("restore", "S0")



```

<!-- name=restore_folds_S0 -->
```groovy
// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
Closure save_restore_closure = 
  { String save_or_restore, String folding_state_name ->       
    // The save_or_restore variable should be given on of these two values: "save" or "restore"
    // The folding_state_name variable can be given any name without spaces or special characters. Ex: "S0" or "S1" or "S2"

    if ( save_or_restore == "save" ) {
      // save folding

      // get foldings
      def folded_nodes_ids_ary = c.findAll().findAll { it.isFolded() }.collect { it.id }
        // Array of Strings 
        // [ 'ID_xxx1',
        //   'ID,xxx2',
        //    ...
        //   'ID_xxxN'
        // ]
      //folded_nodes_ids_ary.each { N(it).style.backgroundColorCode = '#0000FF' }

      String stringified_ary_xml_escaped = htmlUtils.toXMLEscapedText( folded_nodes_ids_ary.inspect() )
        // String xml-escaped (ready to be stored in XML file)
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      // save to map stringified_ary_xml_escaped
      node.map.storage[folding_state_name]=stringified_ary_xml_escaped
    } else {
      // restore folding

      // load from map stringified_ary_xml_escaped
      def result_convertible = node.map.storage[folding_state_name]
        // Convertible (see org.freeplane.plugin.script.proxy.Convertible, use result_convertible.string to get String)
        // or null

      if (result_convertible == null) {
        return 
      }

      String stringified_ary_xml_escaped = result_convertible.string
      String stringified_ary = htmlUtils.toXMLUnescapedText( stringified_ary_xml_escaped )
        // String
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      def folded_nodes_ids_ary = Eval.me(stringified_ary)
        // Array of Strings
        //  [ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ] 

      // restore foldings
      c.findAll().each { n ->  n.setFolded( folded_nodes_ids_ary.contains(n.id) ? true : false ) }
    }
  }

// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
//save_restore_closure("save", "S0")
save_restore_closure("restore", "S0")



```

<!-- name=save_folds_S1 -->
```groovy
// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
Closure save_restore_closure = 
  { String save_or_restore, String folding_state_name ->       
    // The save_or_restore variable should be given on of these two values: "save" or "restore"
    // The folding_state_name variable can be given any name without spaces or special characters. Ex: "S0" or "S1" or "S2"

    if ( save_or_restore == "save" ) {
      // save folding

      // get foldings
      def folded_nodes_ids_ary = c.findAll().findAll { it.isFolded() }.collect { it.id }
        // Array of Strings 
        // [ 'ID_xxx1',
        //   'ID,xxx2',
        //    ...
        //   'ID_xxxN'
        // ]
      //folded_nodes_ids_ary.each { N(it).style.backgroundColorCode = '#0000FF' }

      String stringified_ary_xml_escaped = htmlUtils.toXMLEscapedText( folded_nodes_ids_ary.inspect() )
        // String xml-escaped (ready to be stored in XML file)
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      // save to map stringified_ary_xml_escaped
      node.map.storage[folding_state_name]=stringified_ary_xml_escaped
    } else {
      // restore folding

      // load from map stringified_ary_xml_escaped
      def result_convertible = node.map.storage[folding_state_name]
        // Convertible (see org.freeplane.plugin.script.proxy.Convertible, use result_convertible.string to get String)
        // or null

      if (result_convertible == null) {
        return 
      }

      String stringified_ary_xml_escaped = result_convertible.string
      String stringified_ary = htmlUtils.toXMLUnescapedText( stringified_ary_xml_escaped )
        // String
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      def folded_nodes_ids_ary = Eval.me(stringified_ary)
        // Array of Strings
        //  [ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ] 

      // restore foldings
      c.findAll().each { n ->  n.setFolded( folded_nodes_ids_ary.contains(n.id) ? true : false ) }
    }
  }

// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
save_restore_closure("save", "S1")
//save_restore_closure("restore", "S1")



```

<!-- name=restore_folds_S1 -->
```groovy
// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
Closure save_restore_closure = 
  { String save_or_restore, String folding_state_name ->       
    // The save_or_restore variable should be given on of these two values: "save" or "restore"
    // The folding_state_name variable can be given any name without spaces or special characters. Ex: "S0" or "S1" or "S2"

    if ( save_or_restore == "save" ) {
      // save folding

      // get foldings
      def folded_nodes_ids_ary = c.findAll().findAll { it.isFolded() }.collect { it.id }
        // Array of Strings 
        // [ 'ID_xxx1',
        //   'ID,xxx2',
        //    ...
        //   'ID_xxxN'
        // ]
      //folded_nodes_ids_ary.each { N(it).style.backgroundColorCode = '#0000FF' }

      String stringified_ary_xml_escaped = htmlUtils.toXMLEscapedText( folded_nodes_ids_ary.inspect() )
        // String xml-escaped (ready to be stored in XML file)
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      // save to map stringified_ary_xml_escaped
      node.map.storage[folding_state_name]=stringified_ary_xml_escaped
    } else {
      // restore folding

      // load from map stringified_ary_xml_escaped
      def result_convertible = node.map.storage[folding_state_name]
        // Convertible (see org.freeplane.plugin.script.proxy.Convertible, use result_convertible.string to get String)
        // or null

      if (result_convertible == null) {
        return 
      }

      String stringified_ary_xml_escaped = result_convertible.string
      String stringified_ary = htmlUtils.toXMLUnescapedText( stringified_ary_xml_escaped )
        // String
        // "[ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ]"
        
      def folded_nodes_ids_ary = Eval.me(stringified_ary)
        // Array of Strings
        //  [ 'ID_xxx1',
        //    'ID,xxx2',
        //     ...
        //    'ID_xxxN'
        //  ] 

      // restore foldings
      c.findAll().each { n ->  n.setFolded( folded_nodes_ids_ary.contains(n.id) ? true : false ) }
    }
  }

// USAGE: save_restore_closure("save"|"restore", "S0"|"S1"|"S2")
//save_restore_closure("save", "S1")
save_restore_closure("restore", "S1")



```

Author: `zipizap`



## Helper methods to manipulate html-formatted text


In [this forum thread](https://sourceforge.net/p/freeplane/discussion/758437/thread/a2117c8c/), Alexandre shares groovy methods that help to manipulate an html-formatted text. 

Copy/paste them into your groovy scripts, and enjoy. 

Show your love and appreciation in the forum thread :)



:::: So use **ReplaceWithFormat** to replace text in the html and you can use **FindWithFormat** to search the html. **FindWithFormat** allows to use for example the caret (^) for the beginning of string which is not possible when there is the html header tags...I use it to check if some string exists at the beginning of a node. **ReplaceWithFormat** allows also to use the caret char to replace at the beginning of a string, which I use to insert text at the beginning of a node. I am not sure if it works for appending at the end ($) I didn't test for that as I don't need it for now.
:::: 
:::: Thanks,
:::: 
:::: Alexandre




<!-- name=html_text_methods -->
```groovy
def AddHtmlTags(text) { return '<html><head><body><p>' + text + '</p></body></head></html>' }

def RemoveHtmlTags(text) {
    def strippedText = text.replaceAll('<(html|head|body|p)>', '')
    strippedText = strippedText.replaceAll('</(html|head|body|p)>', '')
    strippedText = strippedText.replaceAll('\n', '')
    strippedText = strippedText.replaceAll('^\\s*', '')
    return strippedText
}

def ReplaceWithFormat(pNode, pattern, replacement) { 
    def strippedText = RemoveHtmlTags(pNode.text)
    def replacedText = strippedText.replaceAll(pattern, replacement)
    return AddHtmlTags(replacedText)
    }

def FindWithFormat(pNode, pattern) {
    def strippedText = RemoveHtmlTags(pNode.text)
    if (strippedText =~ /${pattern}/)
        return true
    else
        return false
}
```


## How to call freeplane menu-items from groovy script


In [this forum thread](https://sourceforge.net/p/freeplane/discussion/758437/thread/e7343b63/#9ab4), Alexandre shares one possible way to call freeplane menu-items from groovy script, and a small function to make it easy to call them. 

Latter Volker reminds there is already a more complete method: [menuUtils.executeMenuItems()](https://www.freeplane.org/doc/api/org/freeplane/core/util/MenuUtils.html#executeMenuItems-java.util.List)  in the Freeplane Scritping API for calling menu items. To find out what is the *menuItemKey* of a *menu item*, there is a tool that ships with the [Developer Tools Addon](https://www.freeplane.org/wiki/index.php/Add-ons#Developer_Tools) just for that.


Copy/paste them into your groovy scripts, and enjoy. 

Show your love and appreciation in the forum thread :)


<!-- name=script -->
```groovy
// In this example, 'SelectAllAction' is the <<menuItemKey>> corresponding to the Freeplane <<menu item>> clicable in "Navigate/Select all visible nodes". 
// This will select all nodes in the map.

menuUtils.executeMenuItems(['SelectAllAction'])

```

