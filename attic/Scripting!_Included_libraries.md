[Back to Scripting overview](Scripting.md)


OSGI allows to control exactly which packages should be exported by a library. By this means only a few of the libraries included in the Freeplane distribution are accessible by scripts:

## Accessible libraries

* Allmost all packages of the <tt>freeplane</tt> project as listed in [freeplane/META-INF/MANIFEST.MF](http://freeplane.bzr.sf.net/bzr/freeplane/freeplane_program/release_branches/1_0_x/annotate/head%3A/freeplane/META-INF/MANIFEST.MF) in section <tt>Export-Package</tt>.
* [groovy-all.jar](http://groovy.codehaus.org/Download) The groovy implementation comes with a large number of included libraries, e.g.
    * [antlr](http://www.antlr.org/)
    * [asm](http://asm.ow2.org/)
    * [commonscli](http://commons.apache.org/cli/)
* [commons-lang](http://commons.apache.org/lang/) Utility classes (without <tt>builder</tt>, <tt>math</tt>, <tt>exception</tt> and <tt>time</tt>).
* Java standard runtime library, <tt>jre/lib/rt.jar</tt>
* [Jortho](http://jortho.sourceforge.net/) (since 1.2.22)

## Inaccessible libraries that are part of the distribution

Accessing the following libraries requires *repackaging* of Freeplane (the libraries are grouped by their project). If there there should be a common need to add certain packages/libraries, please file a feature request [here](https://sourceforge.net/p/freeplane/featurerequests/).

### freeplane

* SimplyHTML
* forms
* gnu-regexp

### freeplane_plugin_help

* jhall

### freeplane_plugin_latex

* jlatexmath

### freeplane_plugin_svg

* batik-anim
* batik-awt-util
* batik-bridge
* batik-codec
* batik-css
* batik-dom
* batik-ext
* batik-extension
* batik-gui-util
* batik-gvt
* batik-parser
* batik-script
* batik-svg-dom
* batik-svggen
* batik-swing
* batik-transcoder
* batik-util
* batik-xml
* js
* pdf-transcoder
* xerces_2_5_0
* xml-apis-ext
* xml-apis

<!-- ({Category:Script}) -->

