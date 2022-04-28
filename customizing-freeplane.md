<!-- customization -->

# Customizing Freeplane

## The user directory

### Contents of the user directory

<!-- FIXME: describe an add infos about the contents here -->

### Location of the user directory

Depending on your OS and personal preferences, you can find the user directory in different places.

#### Windows

<!-- FIXME: where is the user directory on Windows? -->
*TODO*

#### Linux

System-wide configuration directory for Freeplane (installed via the package manager of your distribution):

`/usr/share/freeplane/`

User directory (in the `.config` folder inside the home directory of the current user):

`~/.config/freeplane/`

#### MacOS

<!-- FIXME: where is the user directory on MacOS? -->
*TODO*

### Opening the user directory from the menu

You can open the current user directory of Freeplane in your default filebrowser via the menu: `Tools > Open user directory`.

### Change the location of the user directory

You can change where the user directory should be.

#### Command line

In the command line you can change the path to the user directory when invoking Freeplane with the following command:

`freeplane -U<userdir>`
