<!-- toc -->


# Templates

For a [style](styles.md) to be available in other mind maps, it needs to be saved in a template.
Once this is done, the style will be available in each new mind map created from that template.

There are 2 ways to do it
1. Open the template mind map and add your new style there
2. Add a new style to your regular mind map
   * In `Tool panel` → `Make current formatting default`, after setting the properties of your new style, choose `for all maps based on template:` and click `Apply`
   * Use `Choose template` to change the association beforehand, if needed

## File Paths for Templates

Depending on your OS, you can find template folders in different directories. 
However, on every OS, there is a subfolder in the Freeplane installation-folder, where you can store user-defined template files.

> Note: You can also change the default directory containing the user configuration.
This means, the file path for templates might be different in your Freeplane (see [The user directory](#the-user-directory)).

### Windows

<!-- FIXME: where are the locations on Windows? -->
*TODO*

### Linux

**System-wide** templates (when Freeplane is installed via the package manager of your distribution) are located in:

`/usr/share/freeplane/resources/templates`

**User-defined** templates can be found in:

`~/.config/freeplane/VERSION/templates`

### MacOS

`~/.freeplane/VERSION/templates`

## Set a default template file

The default template file will be used for every newly generated mind map.
You can set the default template file in the preferences:

`Tools > Preferences > Environment`, `Files > 'Standard template file'`

The template files shown here as an option are those located in the [**system-wide** path for template files](#file-paths-for-templates).

## Create a new map from a template

You can create a new mind map from a template file at `File > New map from template…`.
In the dialogue you have different options, depending on which `Files of Type` you choose from the drop-down menu at the bottom of the dialogue:

![Menu `New map from template…`](../images/fp_1914_new_map_from_template.png ':size=x200')

| **Option** | **Description**                                                                                           |
| :--- |:----------------------------------------------------------------------------------------------------------|
| `All files` | all filetypes _(also non-mind-map files, which might give you an error)_                                  |
| `Maps (*.mm)` | your mind maps, whose styling you want to use (see [Styles](styles.md))                                    |
| `Standard Templates (*.mm)` | the templates Freeplane comes with → [**system-wide** path for template files](#file-paths-for-templates) |
| `User templates (*.mm)` | your template mind maps → [**user-defined** path for template files](#file-paths-for-templates)            |

> Note: Depending on your current choice in the drop-down menu at the bottom of this dialogue, the path in the _upper_ part changes accordingly:\
If you click on `Standard template (*.mm)` it will show you the **system-wide** path for templates, if you click on `User templates (*.mm)` it will change to the **user-defined** path.
