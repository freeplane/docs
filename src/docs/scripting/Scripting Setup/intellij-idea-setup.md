<!-- toc -->

Here's a procedure for setting up IntelliJ IDEA.\
See [IDE setup](../../coding/IDE_setup.md) for an alternative, using Gradle.

### Installation and configuration
1. Go to <https://www.jetbrains.com/idea/download/>
2. Choose **Community** (direct download link for Windows: <https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC>)
3. Install IntelliJ IDEA (`Next`, `Next`, `Next`; the default options are fine)
4. Launch IntelliJ IDEA
5. On the Welcome screen, choose `New Project`
6. `Name:` **freeplane-scripting**
7. `Language:` **Groovy**
8. `Build system:` **IntelliJ**
9. `JDK:` if none detected, select `Download JDK` and choose version **17**. Any `Vendor:` will do, e.g. **Eclipse Temurin ...**
10. `Groovy JDK`: choose `Specify Groovy SDK home` and navigate to your Freeplane installation directory then to `plugins` and select `org.freeplane.plugin.script`; confirm with `OK` (e.g. `C:\Program Files\Freeplane\plugins\org.freeplane.plugin.script` - _you can copy-paste_)
11. Click `Create`
12. Once created, go to `File->Project structure (Ctrl+Alt+Shift+S)`
13. Then to `Libraries`, and in the middle pane (above `groovy-#.#.#`) click `+` > `Java`
14. Navigate to your Freeplane installation directory and select `freeplanelauncher.jar` (e.g. `C:\Program Files\Freeplane\freeplanelauncher.jar` - _you can copy-paste_)
15. Confirm with `OK` the message "Library 'freeplanelauncher' will be added to the selected modules."
16. In the far-right pane click `+` (above `freeplanelauncher.jar`)
17. Navigate to your Freeplane installation directory > `core` > `org.freeplane.core`, select `lib` and confirm with `OK` (e.g. `C:\Program Files\Freeplane\core\org.freeplane.core\lib` - _you can copy-paste_)
18. And again `+` > Freeplane installation > `plugins` > `org.freeplane.plugin.script`, select `lib` and confirm with `OK` (e.g. `C:\Program Files\Freeplane\plugins\org.freeplane.plugin.script\lib`)
19. Close the Project Structure window with `OK` at the bottom

The installation is done. You are ready to start creating your first script.

### Script example
In IntelliJ IDEA, right-click on the (blue) folder **src** > `New->Groovy Script` and in the dialog write the name **hello**.

* In the file (right-hand pane), start writing `def c = ScriptUtils`. A drop-down will appear
* Choose the (first) entry pointing to `org.freeplane.plugin.script.proxy`. It will add a line at the top `import org.freeplane.plugin.script.proxy.ScriptUtils`
* Continue writing in line 3. Put a dot after `ScriptUtils` and wait for a drop-down to appear. Select `c()` (with `Down`) and confirm with `Enter`
* `Enter` to the next line, then write `def node = ScriptUtils.n` and wait for a drop-dwonto appear with `node()` as the first item - confirm it with `Enter`
* In a new line type `c.stat` and select `statusInfo`. You can use `Down` `Enter` or your mouse
* Then type ` = "Hello. Current node id: ${node.id}`
* Finally, copy the path to your **src** folder, by selecting it (in the left-hand pane) and pressing `Ctrl+Shift+C`

### Verification in Freeplane
* In Freeplane, open `Tools->Preferences… (Ctrl+Comma)` and go to `Preferences…->Plugins->Scripting->Script search path (see tooltip)`
* Paste your path to **src** (something like `C:\Users\<User>\IdeaProjects\freeplane-scritping\src`) and confirm with `OK`
* Restart Freeplane 
* Go to `Tools->Script->Hello` to run it
* Verify in the status bar that you can see `Hello. Current node id: ID_#######`

### Bonus - non-Freeplane Groovy script
In Intellij IDEA, you can also write and **execute** regular Groovy scripts, not only scripts meant for Freeplane.
Here's an example.

* Right-click on your (blue) **src** > `New->Groovy Script` and give it a name, e.g. `currentWeather`
* Copy and paste the code
```groovy
import groovy.json.JsonSlurper

// set your location
float latitude = 50.0
float longitude = 20.0

// get the text from the web
def link = "https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&current_weather=true"
// print it so that you can click on the link to be opened in your web browser
println(link)

// query OpenMeteo for the current weather information
def urlCurrentWeatherInLocation = new URL(link)
def textReturnedFromOpenMeteo = urlCurrentWeatherInLocation.text

// uncomment the next line (and add an import for JsonOutput) to print the returned text
//println(JsonOutput.prettyPrint(textReturnedFromOpenMeteo))

// convert text to a HashMap
def mapFromJson = new JsonSlurper().parseText(textReturnedFromOpenMeteo)

// print the interesting bits
println('-' * 45)
println("  Current temperature (at ${mapFromJson['latitude']} ${mapFromJson['longitude']}): ${mapFromJson['current_weather']['temperature']}")
println('-' * 45)
```
* Run it with `Ctrl+Shift+F10`
