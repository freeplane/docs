<!-- toc -->

Freeplane comes with it's own version of the Groovy library. If you want up update it to a more recent one you can do that quite easily. It just takes the following steps:

1. Download Groovy binary distribution package (e.g. <tt>groovy-binary-1.8.0.zip</tt>) from http://groovy.codehaus.org/Download.
2. Extract the <tt>groovy-all</tt> Jar from the package
3. Replace the old <tt>groovy-all</tt> Jar with the new one.

### For Linux (non-deb version)

We assume that Freeplane is installed to <tt>/opt/freeplane</tt>:

    $ unzip groovy-binary-1.8.0.zip groovy-1.8.0/embeddable/groovy-all-1.8.0.jar
    inflating: groovy-1.8.0/embeddable/groovy-all-1.8.0.jar
 
    $ sudo mv /opt/freeplane/plugins/org.freeplane.plugin.script/lib/groovy-all.jar \
    /opt/freeplane/plugins/org.freeplane.plugin.script/lib/groovy-all.jar.orig
 
    $ sudo cp groovy-1.8.0/embeddable/groovy-all-1.8.0.jar \
    /opt/freeplane/plugins/org.freeplane.plugin.script/lib/groovy-all.jar

<!-- ({Category:Script}) -->

