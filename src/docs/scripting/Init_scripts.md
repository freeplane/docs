<!-- toc -->

Starting with 1.5.8 Freeplane supports init scripts, i. e. scripts that are executed on startup. This is especially useful for scripts that change the behavior of Freeplane, e. g. via listeners that listen on events like opening maps, mouse or keyboard events.

So here are the rules (may change until 1.5 is declared stable):

* Init scripts are all scripts in the directory `/scripts/init/`, inside the user directory (`Tools->Open user directory`)
* After startup (Freeplane window is up) all init scripts are run in lexicographical order of script names.
* In an init script you can't rely on the variable <code>node</code> since it is not bound. You also should not assume that any script map is opened.

If you need map specific behavior encode this in your scripts by checking the name of the current map.

## Examples

* [Register a Markdown IContentTransformer](Scripts_collection.md)
* An extended script can be found in this [forum article](http://sourceforge.net/p/freeplane/discussion/758437/thread/748f90ad/?limit=25.md).

<!-- ({Category:Script}) -->

