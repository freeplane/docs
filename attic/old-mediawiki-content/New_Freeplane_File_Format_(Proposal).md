; Attention`:` : This effort is on hold until further notice (perhaps after release of version 1.2/1.3).

----

# Introduction

Freeplane version 1.0.x (and 1.1.x) was developed using [FreeMind's](http://freemind.sf.net) [format and file extension (.mm)](Current_Freeplane_File_Format.md) in an effort to allow a smooth transition to users willing to switch to Freeplane. As Freeplane grows mature and wants to make true its [Visions](Visions.md), a new file format is required.

# File types and extensions.

A Freeplane file can come in 4 flavors, as single XML document file or as package:


1.  Single XML document:
    1. a plain XML format with extension <tt>.freeplane</tt>.<br />This format allows further for easy automated generation and XSLT transformation.
    1. the above format in a standard ZIP or JAR file, i.e. if a file named <tt>myfile.freeplane.zip</tt> or <tt>myfile.freeplane.jar</tt> contains a file named <tt>myfile.freeplane</tt>, it will be opened by Freeplane in the same way as the above plain XML format (other files in the same archive will be ignored).<br /> The file format is still easy to generate but takes less space than plain XML, is cleaner to email (some mailers choke on text formats) and can be used to transport other files (even though they will be ignored by Freeplane).
1.  Package Document:
    1. a more complex zipped format with extension <tt>.freeplanez</tt>.<br /> This format allows for embedded styles, images and other 3rd party objects.
    1. the same structure but in an uncompressed directory with extension <tt>.freeplane.d</tt>.

Overall, the XML format is the same in all flavors, and aligned (as much as possible) with the [Open Document Format](http://www.oasis-open.org/committees/office/) from the [OASIS organization](http://www.oasis-open.org/).

# File format requirements


1.  clean XML
1.  multiple maps per file possible
1.  easy generation
1.  embedding of 3rd party objects
1.  support real styles
1.  allow for comparison between different files
1.  allow for tracked changes

# Generic rules


1.  Each XML file must start with an XML declaration <tt>`<?xml version="1.0" encoding="UTF-8" ?>
`</tt>.

    *  this means that the Freeplane format is based on XML 1.0 and has UTF-8 as encoding.
    *  (X)HTML entities are not used anymore for accentuated characters but just plain UTF-8 encoding.
1.  A single XML document may continue with an XSLT reference like <tt>`<?xml-stylesheet type="application/xslt+xml" href="url-to-some-XHTML-transformation-sheet"?>`</tt> as to allow web browsers to render directly Freeplane files.

    *  Freeplane must ignore (but keep) such entries and should add a default one when creating a new map.
    *  The Freeplane team should offer standard XSLT transformation sheets e.g. under <tt>http://freeplane.org/formats/2010/to-xhtml10.xsl</tt>.
1.  All XML markups are in small caps and must have an explicit namespace
1.  The namespace must be declared either as xmlns:attribute of the root element of the XML file, or, if rendered by a plug-in, as xmlns:attribute of the XML element rendered by this plug-in
1. ; Example : if a node has the xmlns attribute <tt>`<map:node xmlns:myplug="myplug-namespace" ...>[...]`</tt>, Freeplane could find an OSGi service <tt>NodeRenderer</tt> with a filter based on the given namespace to render this specific node.

1.  The namespace for Freeplane specific elements is <tt>xmlns:map="http://freeplane.org/formats/2010/map"</tt>.
1.  Until further notice, all formatting elements are based on XHTML 1.0/1.1 and have the namespace <tt>xmlns:xhtml="http://www.w3.org/1999/xhtml"</tt>.
    *  SimplyHTML must be adapted accordingly, and perhaps released as OSGi bundle!?

# Format Specifics

(structure aligned with version 1.2 of the [Open Document Format](http://www.oasis-open.org/committees/office/) )

## Part 1 - XML File Format

### 1 - Introduction

#### 1.1 to 1.4 - no changes

#### 1.5 - Namespaces

We stick to the same namespaces wherever applicable, and add the following one:

<table border="1">
|+ Table 6 - Freeplane namespaces
|- 
|-
| map      || For all Freeplane specific elements || http://freeplane.org/formats/2010/map
|-
| x-office || For Freeplane elements that would belong in the 'office' namespace
| http://freeplane.org/formats/2010/office
|}

### 2 - Scope (not relevant)

### 3 - Document Structure

#### 3.1 Document Representation

##### 3.1.2 <office:document>(Single OpenDocument XML Files)

A typical single opendocument might look as follows:

    <?xml version="1.0" encoding="UTF-8" ?>
    <?xml-stylesheet type="application/xslt+xml" href="http://freeplane.org/formats/2010/to-xhtml10.xsl" ?>
    <office:document office:mimetype="application/x-freeplane" office:version="1.2-fp-1.0" xmlns:[...]>
    <office:automatic-styles> [...] </office:automatic-styles>
    <office:body>             [...] </office:body>
    <office:font-face-decls>  [...] </office:font-face-decls>
    <office:master-styles>    [...] </office:master-styles>
    <office:meta>             [...] </office:meta>
    <office:scripts>          [...] </office:scripts>
    <office:settings>         [...] </office:settings>
    <office:styles>           [...] </office:styles>
    </office:document>

?> **Notes** : Once Freeplane has a registered mime-type, mimetype could become <tt>application/freeplane</tt>. The version is made of the ODF version 1.2, 'fp' for Freeplane and an internal version number, 1.0 to start with.

##### 3.1.3 Package OpenDocument Files

File <tt>**content**.xml</tt>:

    <?xml version="1.0" encoding="UTF-8" ?>
    <office:document-'''content''' office:version="1.2-fp-1.0" xmlns:[...]>
    <office:automatic-styles> [...] </office:automatic-styles>
    <office:body>             [...] </office:body>
    <office:font-face-decls>  [...] </office:font-face-decls>
    <office:scripts>          [...] </office:scripts>
    </office:document>

File <tt>**styles**.xml</tt>:

    <?xml version="1.0" encoding="UTF-8" ?>
    <office:document-'''styles''' office:version="1.2-fp-1.0" xmlns:[...]>
    <office:automatic-styles> [...] </office:automatic-styles>
    <office:font-face-decls>  [...] </office:font-face-decls>
    <office:master-styles>    [...] </office:master-styles>
    <office:styles>           [...] </office:styles>
    </office:document>

File <tt>**meta**.xml</tt>:

    <?xml version="1.0" office:version="1.2-fp-1.0" encoding="UTF-8" ?>
    <office:document-'''meta''' xmlns:[...]>
    <office:meta>             [...] </office:meta>
    </office:document>

File <tt>**settings**.xml</tt>:

    <?xml version="1.0" office:version="1.2-fp-1.0" encoding="UTF-8" ?>
    <office:document-'''settings''' xmlns:[...]>
    <office:settings>         [...] </office:settings>
    </office:document>

#### 3.2 <office:meta>

Section can and should be used as-is. No changes needed.

&rArr; Freeplane should offer a dialog to enter document information.

#### 3.3 <office:body>

Mandatory section, but only child needed is a Freeplane specific <tt>`<x-office:map>`</tt>.

?> **Note** : x-office is used instead of office to avoid polluting the 'office' namespace. x-office can be used as an alternative prefix for the same Freeplane namespace as 'map'.

#### 3.4 to 3.9 not needed, replaced by <x-office:map>

<tt>
?> **TBD** : The exact content of a map will be described in [Freeplane_File_Format/Maps](Freeplane_File_Format/Maps.md)

#### 3.10 <office:settings>

Section can and should be used as-is. No changes needed.

Possibly Freeplane doesn't need the full scope and could cope only with <tt>config-item-set</tt> and <tt>config-item</tt> as in:

    <office:settings>
    <config:config-item-set config:name="''somename''">
    <config:config-item config:name="''itemname''" config:type="''itemtype''">
    ''ConfigValue''
    </config:config-item>
    [...]
    </config:config-item-set>
    <config:config-item-set config:name="''someothername''">
    [...]
    </office:settings>

?> **Note** : as described in chapter 19.32, The values of the config:type attribute are boolean, short, int, long, double, string, datetime or base64Binary.

#### 3.11 Cursor Position Setting

A bit unclear, but I understand something like the following is possible:

    <?opendocument cursor-position="''XXX''" ?>

where *XXX* is a mean to give the cursor position at the time where the document was saved. In Freeplane's case, it could just be a map and/or node ID, but I'm not fully convinced.

#### 3.12 + 3.13 <office:script[s]>

?> **TBD** : The exact handling of scripts will be described in [Freeplane_File_Format/Scripts](Freeplane_File_Format/Scripts.md)

    <office:scripts>
    <office:event-listeners>
    TBD: do we need event listeners in Freeplane? How to implement them?
    </office:event-listeners>
    <office:script script:language="groovy">
    ''Script Specific Text (can also be a link to an external script)''
    </office:script>
    <office:script script:language="lang2">
    [...]
    </office:scripts>

#### 3.14 <office:font-face-decls>

    <office:font-face-decls>
    <style:font-face [...]>
    </style:font-face>
    <style:font-face>
    [...]
    </office:font-face-decls>

I would recommend to skip this function for the next release of Freeplane, chapter 16.21 <style:font-face> seems quite complex to implement. **TBD!**

#### 3.15 Styles

The elements <office:automatic-styles>, <office:master-styles> and <office:styles> could possibly be used but would possibly need to contain map specific styles.

?> **TBD** : The exact handling of styles will be described in Freeplane_File_Format/Styles

#### 3.16 Document and Macro Signatures

The section defines 2 (optional) files described in more details in chapter 2.4 of part 3 of the specification:


* <tt>META-INF/documentsignatures.xml</tt> for signature of all files
* <tt>META-INF/macrosignatures.xml</tt> only for signatures of macros

Does *not* need to be part of next Freeplane release.

### 4 Metadata

The specs define 2 types of metadata:


1.  RDF Metadata, to be defined in the file <tt>manifest.rdf</tt> (more details in part 3)
1.  Non-RDF Metadata, found within the element <tt><office:meta></tt>.

Both can be used as defined in the chapter.

### 5 to 20 (Content, Formatting, attributes, etc...)

?> **TBD** : To Be Used as needed, document here what you use as you implement it!!!

### 21 Document Processing

Nothing really special...

### 22 Conformance

Chapter 22.2.2 "Conforming OpenDocument Extended Documents" is interesting as it defines what the new Freeplane format needs to fulfill.

Freeplane itself would need to comply to 22.3.2 "Conforming OpenDocument Extended Producers"
and 22.4 "Consumer Conformance".

### Appendices A to G

Nothing really relevant in there.

## Part 2 - OpenFormula

not applicable (yet?)

## Part 3 - Packages

### 1 Introduction

Nothing really relevant

### 2 Packages

### 2.0 list of files

The specification doesn't explicitly contain a list of possible files, so here it is, with a reference to the relevant chapters.

The following table shows a summary of all files to be found in an OpenDocument conform package file, as described in the specification:

<table border="1">
|+ Files found in a package according to ODF reference
|-
|-
| <tt>mimetype</tt>
| first file in ZIP file, uncompressed, contains mime type i.e. application/x-freeplane or application/freeplane
| 2.3 MIME Media Type
|-
| <tt>META-INF/manifest.xml</tt>
| manifest file in XML format listing all files in the package with their MIME type and, if needed, encryption options
| 3 Manifest File
|-
| <tt>manifest.rdf</tt>
| meta data file (probably optional for Freeplane)
| 5 Metadata Manifest Files
|-
| <tt>META-INF/documentsignatures.xml</tt> <br /> <tt>META-INF/macrosignatures.xml</tt>
| Signature files respectively for all files and for macros (optional)
| 4 Digital Signatures File (and in Part 1 - 3.16 Document and Macro Signatures)
|-
| <tt>Thumbnails/thumbnail.png</tt>
| Preview image of size 256x256 and 24 bits (optional)
| 2.8 Preview Image
|-
| <tt>content.xml</tt> <br /> <tt>styles.xml</tt> <br /> <tt>meta.xml</tt> <br /> <tt>settings.xml</tt>
| Core content, styles, metadata and settings files
| Part 1
|}

The ODF specification states that a package can contain other files, but it doesn't specify any specific structure (it is also not needed because all such files are referenced in <tt>META-INF/manifest.xml</tt>). Reading between the lines and analyzing OpenOffice files, I come to the conclusion that all additional files should be in sub-directories with names starting with a capital. Here a few examples/suggestions:

<table border="1">
|+ Directories found in a package to contain 3rd party objects
|-
|-
| <tt>Pictures/</tt>
| for all images. Freeplane accepts JPEG, PNG and GIF formats.
|-
| <tt>Icons/</tt>
| for user specific icons. Freeplane accepts JPEG, PNG and GIF formats.
|-
| <tt>Scripts/</tt>
| for Groovy scripts.
|-
| <tt>Objects/</tt>
| for any object that Freeplane would embed without actually being able to do anything with it but just try to display externally.
|}

?> **Note** : further directories can be added as needed.

?> **Note** : to embed objects, OpenOffice creates a binary (format ?) reference file <tt>ObjectReplacements/Object N</tt> (N a growing index) and puts the relevant data in a sub-directory <tt>Object N</tt>, but I don't think we want to do this.

#### 2.4 Encryption

probably not in this version of Freeplane

#### 2.7 Usage of IRIs Within Packages

the chapter is a bit unclear, but I understand basically that links to files within the package are just normal relative links. As all files present in the package need to be referenced in <tt>META-INF/manifest.xml</tt>, Freeplane can safely compare any relative link to the content of this file, and, only if not found, try to resolve the link outside of the package.

?> **Note** : when using a packaged directory, the relative link *outside of the package* means relative to the directory containing the packaged directory. Example: a packaged directory <tt>/home/ewl/Documents/mymap.freeplane.d</tt> where <tt>content.xml</tt> refers to <tt>Scripts/myscript.groovy</tt>; if internal to the package, the absolute path is <tt>/home/ewl/Documents/mymap.freeplane.d/Scripts/myscript.groovy</tt>, but externally resolved, it means <tt>/home/ewl/Documents/Scripts/myscript.groovy</tt>.

### 3 to 5 Manifest, Signatures and Metadata

Relevant without changes, chapters referenced in files table from chapter 2.

### 6 Datatypes

Not really of interest.

### 7 Conformance

Relevant summary, to be fulfilled by Freeplane and its format.
