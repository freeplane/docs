<!-- toc -->

## Running export

This xslt exports are available together with all other exports through menu File -&gt; Export... 

The *Export Using XSLT* function applies an XSL Transformation to the Freeplane mindmap, to create a new file. 

In the *Freeplane Export using XSLT* dialog box, the *Files of type* combo is populated with the list of supplied or user defined XSL files. 

The files contained in the freeplane installation are located under freeplane installation directory in subdirectory resources/xslt.

## Creating own XSLT transformations

You can define your own export as xslt table where you can implement all transformations. For instance you can generate your own xhtml and also attribute html elements with class attributes for css styling. XSL files must be stored in the *xslt* subfolder, either in the Freeplane system directory (e.g. C:\Program Files\Freeplane\resources\xslt\) or in the Freeplane user directory (e.g. ~/.freeplane/xslt/). 

XSL files must have the .xsl extension. 

XSL files must contain within the 5 first lines a string matching the following pattern: 

> MINDMAPEXPORTFILTER *extensions* *description*

where the fields in italic are relative to the file format to which the mindmap will be exported to using this specific XSLT sheet: 

* *extensions* is a semi-colon separated list of acceptable file extensions without asterisk or dot (e.g. "htm;html") 
* *description* is a description of the file format (e.g. "Meeting Minutes in HTML")

Only the first unique combination of extensions and description will be kept, in such a way that users can "overwrite" an already existing XSLT sheet with their own version.

## Viewing XML input for XSLT export transformation
The input xml for xslt transformations is different from the content of mm file. There is a special export sheet "Export raw xml with node formatting". XML produced by this sheet is the exact copy of the XML fed into xslt transformations.

<!-- ({Category:Documentation}) ({Category:Documentation}) -->

