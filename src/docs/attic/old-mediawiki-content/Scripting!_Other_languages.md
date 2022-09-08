Starting with Freeplane 1.3.5_05 Groovy isn't your only choice for doing scripting in Freeplane. You can use all languages that (a) build on the Java Virtual Machine (JVM) and (b) provide a [JSR 223](http://en.wikipedia.org/wiki/Scripting_for_the_Java_Platform) adapter. These include most of the large [list of JVM-languages ](http://en.wikipedia.org/wiki/List_of_JVM_languages), e.g. JavaScript, Jython, Scala, Clojure, ...


## Built-in: JavaScript

JavaScript can be used without any further installation. To use it just create a <tt>.js</tt> file in <freeplane-user-dir>/scripts, e.g. <tt>Test.js</tt>, and start to code. (Freeplane looks up the right script engine based on the file extension.) Here is an example:
```groovy
var children = node.children;
print("children: " + children);
for (var i = 0; i < children.size(); i++) {
  print('child ' + i + ' is ' + children.get(i).plainText);
}
node.detailsText = children.size() + " children";
node.style.textColor = Java.type("java.awt.Color").RED;
c.statusInfo = "JavaScript script done!";
```

You see that the convenient [property access](../scripting/Scripting.md) known from Groovy is also supported for JavaScript.

## Installation of other languages

To install a new language you only have to install all required JAR (.jar) files in <freeplane-user-dir>/lib. Alternatively include JARs from other local folders by extending Freeplane's script classpath. Which JARs you need should be mentioned in the documentation of the language or in documentation of the JSR 223 adapter if is not part of the standard language distribution. Depending on the implementation/quality of the existing JSR 223 adpters problems might occur. If you get another language working please add a section here with a description what you had to do.

### Jython

Here a step-by-step instruction to install [Jython](http://jython.org), the Python implementation that runs on the JVM:

1. Download the all-in-one Jython-JAR, e.g. [from maven central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22jython-standalone%22). It contains not only the language and all necessary libraries but also the JSR 223 adapter.
2. Copy <code>jython-standalone-<version>.jar</code> to <code><freeplane-user-dir>/lib/</code>.
3. Create the following test script as <code><freeplane-user-dir>/scripts/testJython.py</code> (suffix ".py" is mandatory)
4. Restart Freeplane, so the script appears in the menu.
5. run it via *Tools -> Scripts -> Test Jython -> Execute...one selected node*. Note that the same code is also valid in Groovy and JavaScript:
    c.statusInfo = "Jython's here: Node's text is " + node.text

Hints for scripting Freeplane in Python/Jython can be found on page [Scripting! Jython](../scripting/Scripting!_Jython.md).

## Drawbacks

Groovy is the distinguished scripting language for Freeplane and will be most probably always be better supported than other languages. Here are the differences:

* Since most Freeplane scripting happens in Groovy, you will more likely find one to help you with problems in the Freeplane forum.
* Groovy is (so far) the only language to write formulas and filters with.
* The Groovy scripting API is extended by some methods and tweaks (see [a separate page](Scripting!_text_editing.md) ):
    - Shortcut methods 
    - Simple references to other nodes like ''ID_1723255651.text''

* The script editor only supports Groovy scripts.

A part of this drawbacks could be worked around in the future. It could be made possible for instance to change the language for formulas per map. (If you would like to implement that show up in the [Developers forum](http://sourceforge.net/apps/phpbb/freeplane/viewforum.php?f=2).)

<!-- ({Category:Script}) -->

