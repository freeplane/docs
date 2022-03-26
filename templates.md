<!-- Templates -->

# Templates

## File-Paths for Templates

Depending on your OS, you can find template-folders in different directories. 
However, on every OS, there is a subfolder in the Freeplane installation-folder, where you can store user-definded template-files.

**Attention:**\
You can also change the default directory containing the user configuration. This means, the file-path for templates might differ therefore (see [Customizing Freeplane](customizing-freeplane.md#the-user-directory)).

### Windows

### Linux

**System-wide** templates from installed Freeplane are in:

`/usr/share/freeplane/resources/templates`

**User-defined** templates can also be in:

`~/.config/share/freeplane/VERSION/templates`

### MacOS

## Set a default template file

The default template file will be used for every newly generated mindmap.
You can set a default template file in the preferences:

`Tools > Preferences > Environment`, `Files > 'Standard template file'`

The template files shown here as an option are those located in the [**system-wide** path for template files](#file-paths-for-templates).

## Create a new map from template

You can create a new mindmap from a template file under `File > New map from template…`.
In the dialogue you have different options, depending on which `Files of Type` you choose from the drop-down-menu at the bottom of the dialogue:

![Menu `New map from template…`](/images/fp_1914_new_map_from_template.png)

| **Option** | **Desription** |
| :--- | :--- |
| `All files` | all filetypes _(also non-minmap files which might give you an error)_ |
| `Maps (*.mm)` | existent Freeplane-Mindmaps you or others might have created and whose styling you want to use (see [Styles](styles.md)) |
| `Standard Templates (*.mm)` | the templates Freeplane comes with, located at the [**system-wide** path for template files](#file-paths-for-templates) |
| `User templates (*.mm)` | template-mindmaps you or others created and which are located under the [**user-defined** path for template files](#file-paths-for-templates) |

**Attention**\
Depending on your current choice in the drop-down-menu at the bottom of this dialogue, the path in the _upper_ part changes accordingly:\
If you click on `Standard template (*.mm)` it will show you the **system-wide** path for templates, if you click on `User templates (*.mm)` it will change to the **user-defined** path.
