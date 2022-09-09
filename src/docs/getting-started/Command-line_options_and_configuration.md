<!-- toc -->

## Command-line options
Call freeplane like this:

    freeplane [options] [file1 [file2 ...]]

* -h|--help: list available options
* -X<menukey>: execute menu item with key <menukey>. Use devtools add-on to find the menu keys
* -S: stop after executing menu items
* -N: set the 'nonInteractive' system property to 'true'
* -U<userdir>: set the freeplane user config directory (**only since version 1.3.3!!!**)

Batch execution of menu items (e.g. scripts) is described in a [special wiki article](Batch_Jobs.md).

## Debug start script under Linux

Start Freeplane in debug mode (if you have problems starting):

    DEBUG=true freeplane.sh

# Environment variables
## Select Java installation used to run Freeplane
The following variables are tried in order:

* FREEPLANE_JAVA_HOME
* JAVA_HOME (not on Windows OS)

For windows, set one of these variables and run freeplane.exe or freeplaneConsole.exe:

    FREEPLANE_JAVA_HOME=C:\Program Files\Java\jre1.8.0_131

or, under Linux/UNIX:

    FREEPLANE_JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/ ./freeplane.sh

### Java version

Freeeplane 1.10.x requires Java between Java 8 and Java 17.

Freeplane 1.9.x requires Java between Java 8 and Java 15, because Java 16 is not compatible with current Groovy Engine.\
Use of Java 16 can be permitted only on Linux by setting variable <code>FREEPLANE_USE_UNSUPPORTED_JAVA_VERSION</code> to 1.

## JAVA_OPTS
Set Java Properties, e.g. set the freeplane user config directory in Freeplane < 1.3.3:

    JAVA_OPTS=-Dorg.freeplane.userfpdir=$HOME/blabla freeplane.sh

<!-- ({Category:Documentation}) -->

