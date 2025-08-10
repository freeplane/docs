Here's how to set up Freeplane in IntelliJ IDEA:

# Importing into IDEA

1. File->New->Project from Existing Sources and point to your cloned repo. Pay attention to point to the correct folder. For example, if the repo folder is a folder called freeplane-1.11.x that you placed in a folder called FPsource, then make sure to point to the folder freeplane-1.11.x, and not the parent folder FPsource.
2. In "Import Project" window that appears, choose "Import project from external model" -> "Gradle"
3. Click "Trust Project"

This should import and run Gradle for the project, downloading all dependencies.

# Building

First, make sure that you are using a Gradle version that is able to build Freeplane.  When this guide was written, the user had to choose a Gradle JVM lower than 20. It can be set at the IDEA Settings: `File | Settings | Build, Execution, Deployment | Build Tools | Gradle`.

To build the freeplane binaries, open Terminal (at the bottom, in IDEA) and run (make sure that you are at the root folder):
```
.\gradlew.bat build
```

If it complains about JAVA_HOME not being set, you need to set the variable, preferably for the system, or for this session only:
```
$Env:JAVA_HOME="C:\Users\<user-name>\.jdks\temurin-<version>"
.\gradlew.bat build
```
Change `C:\Users\<user-name>\.jdks\temurin-<version>` for the path of your Java JDK. It may also be, for example, at your Program files folder, like this: `C:\Program Files\Java\jdk-18.0.2`.


# How to launch Freeplane

* copy `freeplane_debughelper/idea/runConfigurations` (the whole `runConfigurations` directory!) containing run configuration files into `.idea` created by IntelliJ in project root
* Restart IntelliJ afterwards.

Now, in the top right corner you will see the "Run/Debug configuration" options, including two called "freeplane" and "freeplane dist". You will be able to run Freeplane by choosing any of them. But, trying to run Freeplane, you need to set, again, the correct Java:

* at the top right, click the 3 dots and open `Edit...` (or search for `Edit Configurations...`);
* inside the `Build and run`section, the first combobox allows choosing the java. Choose a compatible version.

# Configuring the launcher for your needs

The "run configuration" is also the place to pass parameter to the launcher, like pointing to a different user folder to be used by Freeplane. Writing like this creates a new APPDATA folder inside the BIN folder, and will be used as the user directory: `-U "%APPDATA%\FreeplaneTests"`

# Where to create the scripts

The easiest way to make the scripts be detected by the debugger is placing them inside this same project. But, there is no need to place them inside this same folder that is located Freeplane. You can create a different Module, to be dedicated for developing the scripts.

To learn how to make the debugging, see [this page](Debugging_scripts.md).
