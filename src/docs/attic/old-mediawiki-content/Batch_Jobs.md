<!-- toc -->

Freeplane is a program with a graphical user interface. - That's smart since it would be hard to create mindmaps otherwise...

But there are some cases where you might want to let Freeplane do something for you unattended especially if you have appropriate scripts. So here's what Freeplane supports in this respect:

* Open the GUI, execute one or more functions and exit afterwards,
* Execute one or more function and keep the Freeplane window opened.

All is build on two building blocks:

* All functions in the menu (e.g. scripts) are available for batch execution.
* The functions are submitted to Freeplane [on the command line](../getting-started/Command-line_options_and_configuration.md).

## Howto
### Preparation
Install [Freeplane stable](https://sourceforge.net/projects/freeplane/) and a recent [Developer Tools add-on](http://www.freeplane.org/wiki/index.php/Add-ons#Add-on_Developer_Tools). Then restart Freeplane.

### Run a function on startup
Let's assume that you want to launch the "Open saved map..." function whenever you start Freeplane. This is how it works:

* Start Freeplane and invoke *Tools > Developer Tools > Menu item info*
* In the dialog select *File > Open saved map...* and click *OK*.
* The necessary command line argument that is printed after "Command line option:" has been copied to the clipboard.
* Open a command line window. If the Freeplane executables are not in the *path* variable you have to *cd* to the directory where freeplane.bat (on Windows) or freeplane.sh (on Linux) reside.
* On Windows type

    freeplane.bat -XOpenAction

* on Linux type (note that the dollar signs have to be quoted)

    ./freeplane.sh -XOpenAction

* before Freeplane 1.5 menu action keys contained dollar signs and on Linux you had to protect these via single quotation marks:

    ./freeplane.sh -X'$OpenAction$0'

### Run a script and terminate
Scripts have their menu items too so most of the steps also hold for scripts.

* Find the command line option as written above. Let's assume the command line parameter is -XMyScript_on_single_node

* On Windows type

    freeplane.bat -S -N -XMyScript_on_single_node

* on Linux type

    ./freeplane.sh -S -N -XMyScript_on_single_node

* Option *-S* makes Freeplane stop/shutdown after executing the script.
* Option *-N* let's Freeplane set the system variable *nonInteractive* variable to *true*. It's upto the script to evaluate this variable like this:

    boolean isInteractive() {
    return !Boolean.parseBoolean(System.getProperty("nonInteractive"))
    }

## Notes

* Options without an argument can be combined with others like -SNX'MyScript_on_single_node'

* If you want to execute more than one menu item use the -X option multiple times. Each item will be executed in the order given on the command line.

* The "single instance" preferences (Environment->Single program instance) are ignored for batch jobs since the other instance may not be able to handle all commands properly. If you for instance have given the command to exit after executing the options you might not be aware that you would terminate the single instance.

## Example: Exporting to file

Exporting to files requires writing a script. The type of export has to be copied verbatim from the export dialog. These strings are unfortunately internationalized so the scripts depend on the configured interface language. You can use this script to write the available descriptions to the logfile:

    println c.exportTypeDescriptions.join('\n')

And this script exports the map to a file:

    boolean overwriteExistingFile = true
    def filename = '/tmp/' + node.map.file.name.replaceFirst('.mm$', '.pdf')
    // English localization
    c.export(node.map, new File(filename), 'Portable Document Format (PDF) (.pdf)', overwriteExistingFile)
    // German localization
    //c.export(node.map, new File(filename), 'Portables Dokumentenformat (PDF) (.pdf)', overwriteExistingFile)

<!-- ({Category:Advanced})({Category:Script}) -->

