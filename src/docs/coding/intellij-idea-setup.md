<!-- toc -->

Here's a procedure for setting up IntelliJ IDEA.\
See [IDE setup](IDE_setup.md) for an alternative, using Gradle.

### Installation and configuration
1. Go to <https://www.jetbrains.com/idea/download/>
2. Choose **Community** (direct download link for Windows: <https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC>)
3. Install IntelliJ IDEA (`Next`, `Next`, `Next`; the default options are fine)
4. Launch IntelliJ IDEA
5. On the Welcome screen, choose `New Project`
6. `Name:` **freeplane-scripting**
7. `Language:` **Java**
8. `Build system:` **IntelliJ**
9. `JDK:` if none detected, select `Download JDK` and choose version **17**. Any `Vendor:` will do. I choose **Eclipse Temurin ...**
1. Click `Create`
1. Once created, go to `File->Project structure (Ctrl+Alt+Shift+S)`
1. Then to `Modules`, and in the right pane to `Dependencies`
1. Click `+` in the `Dependencies` pane, select `1 JARs or Directories`
1. Navigate to your Freeplane installation directory and select `freeplanelauncher.jar` (e.g. `C:\Program Files\Freeplane\freeplanelauncher.jar`)
1. Again `+` `1 JARs or Directories` `C:\Program Files\Freeplane\core\org.freeplane.core\lib`
1. Once more `+` `1 JARs or Directories` `C:\Program Files\Freeplane\plugins\org.freeplane.plugin.script\lib`
2. Close the Project Structure window with `OK` at the bottom.

The installation is done. You are ready to start creating your first script.

### Script example
In IntelliJ IDEA, right-click on the (blue) folder **src** `New->File` and in the dialog write the name **hello.groovy**.

* In the file (right pane), start writing `def c = ScriptUtils`. A drop-down will appear.
* Choose the (first) entry pointing to `org.freeplane.plugin.script.proxy`. It will add a line at the top `import org.freeplane.plugin.script.proxy.ScriptUtils`.
* Continue writing in line 3. Put a dot after `ScriptUtils` and wait for a drop-down to appear. Select `c()`.
* In the next line (4), write `def node = ScriptUtils.node()`
* In a new line type `c.stat` and select `statusInfo`. You can use `DOWN` `ENTER` or your mouse.
* Then type ` = "Hello. Current node id: ${node.id}`

### Verification in Freeplane
* Copy your script – select the file in the left pane and `Ctrl+C`
* Go to your `<user-dir>/scripts` and paste it `Ctrl+V`
* Alternatively, add your IDEA Project directory to Freeplane `Preferences…->Plugins->Scripting->Script search path (see tooltip)`
* Restart Freeplane and run the script `Tools->Script->Hello` to verify it works OK
