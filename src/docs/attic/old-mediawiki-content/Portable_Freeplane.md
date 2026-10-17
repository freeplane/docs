<!-- toc -->

# Portable Freeplane

Freeplane can run as a [portable application](http://portableapps.com/) from your USB stick.

## Windows

#[Download a portable apps platform](http://portableapps.com/download) and install it on your USB stick,
#run the platform software from the stick,
#[Download a portable java](http://portableapps.com/apps/utilities/java_portable),
#[Download FreeplanePortable_XX.paf.exe](http://sourceforge.net/projects/freeplane/files/freeplane%20stable/),
#Install portable java and freeplane as explained [here](http://portableapps.com/support/portable_app#installing)

If Freeplane does not detect Java automatically, edit:

PortableApps\PortableApps\FreeplanePortable\App\AppInfo\Launcher\FreeplanePortable.ini

and make sure the following path points to the correct Java installation:

FREEPLANE_JAVA_HOME=%PAL:PortableAppsDir%\CommonFiles\Java

Now you can start Freeplane from the portable app platform program menu and it should use the Java runtime from the USB stick.

<!-- ({Category:Documentation}) -->
