Groovy, the scripting language of choice in Freeplane is a full-fledged programming language which can nearly do everything with your computer if it's unconstrained. For this reason Freeplane severely restricts script execution after installation. For script development and for using scripts most of the restrictions should be disabled.

Disabling these restriction doesn't cause a threat by its own although you should be very careful...

*with scripts from persons that you don't know,
*with maps that contain scripts (see [Map local scripts](Map_local_scripts.md) ), and
*when writing your own scripts.

That said normal scripts in Freeplane are less dangerous than macros contained in Office documents since there are no hooks that may start scripts on load of a map or on start of Freeplane. Every script invocation is triggered by you alone so the best advice might be this:

*think twice before installing a script,
*think twice before executing a script,

and everything should be safe - even if you disable most of the restrictions.

Script developers and regular script users will certainly check the following options in the Preferences under *Tools->Preferences->Scripting*:

* *Scripts should be carried out without confirmation?*
* *Permit file/read Operations (NOT recommended)*
* *Trust signed scripts (recommended)*

It's a bit unfortunate that you need file/read for many operations but the Java implementation requires file/read access even for mere creation of a File object, e.g. in this case:
```groovy
node.link.file = c.userDirectory
```
Since Java checks if the file is a directory ahead of it's usage it accesses the file system.

The other options may not be necessary to check:

* *Permit file/write Operations (NOT recommended)*
* *Permit Network Operations (NOT recommended)*
* *Permit to Execute other Applications (NOT recommended)*

A lot of very useful scripts need one or another of those but you can defer enabling them to the moment you need them.

## Formulas
Formulas are somewhat similar to Office macros in that they are evaluated on loading of a map. But formulas are restricted without anyone having the possibility to override this restrictions manually. The worst a formula can do is to read and display local files if you have given scripts the "read file" permission. (That is needed if you have extended the classpath of scripts.) So be careful but not anxious.

## Add-ons
Scripts that are part of [add-ons](Add-ons.md) have their own, independent rights management so you don't have to loosen your scripting permissions just if a certain add-on needs special permissions.

<!-- ({Category:Script}) -->

