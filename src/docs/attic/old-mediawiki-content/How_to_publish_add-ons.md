<!-- toc -->

These are the steps to publish an add-on:

## Put the source code under public version control

To facilitate collaboration and continuous improvement put the source-code under version control in a public Github, Bitbucket or SourceForge repository. If you want you could contribute to the [central Freeplane add-on repository](http://github.com/freeplane/addons) (either as a Freeplane developer or via [pull requests](http://github.com/freeplane/addons/pulls) ). In most cases you will have your own repository.

Hint: Check the license of your add-on. If you have chosen the [GPL](http://en.wikipedia.org/wiki/GNU_General_Public_License) (as recommended) you have to provide the source code with the add-on. If you have no compiled .jar or .class files the packaged add-on contains all sources in principle - but you should rather make the whole directory structure accessible that makes up your add-on.

## Provide your add-on for download

There are many places where you can publish your packaged add-ons:

1. In opposite to Github Bitbucket and SourceForge provide download pages.
2. Freeplane developers have access to the [Freeplane webserver](http://www.freeplane.org/addons/).
3. Maybe you have your own web space somewhere
4. As a last resort you can upload an packaged add-on as an attachment of a forum post.

## Add-on updater support

Freeplane periodically checks for add-ons updates but you can also do that directly via *Help -> Check for updates*.

To enable update check for your add-on you have to

5. create a downloadable file with versioning information in one of the two formats described below,
6. Freeplane will find a "version.properties" or "version.txt" file if it located directly on the add-on's homepage like the one of the [devtools add-on](../scripting/Add-ons_(Develop).md#install-developer-tools): [devtools/version.properties](http://www.freeplane.org/addons/devtools/version.properties).
7. If the file has a different name or location you have to specify the URL as the *updateUrl* of the add-on map's root node, like http://my.addon.com/path/to/version.properties.

### .properties file format

Informations are stored as key=value:
    version=x.y.z
    downloadUrl=http://direct.link.to/download
    changelogUrl=http://link.to/your/changelog

The *version* property is mandatory, *changelogUrl* is optional.

If the version number in this file is higher than the version installed by the user, he will be prompted to go to the *downloadUrl* (or the add-on homepage by default) if he wants to download the latest release.

### .txt file format

This is the native Freeplane versioning format that is also used for Freeplane updates:
    =========
    x.y.z
    =========
    your changelog here

Where x, y and z are your version numbers (the '======' lines are mandatory).

If the version number in this file is higher than the version installed by the user, he will be prompted to go to your homepage if he wants to download the latest release.

## Register your add-on on the Add-ons Wiki page

Add your add-on to the [add-on wiki page](http://www.freeplane.org/wiki/index.php/Add-ons). You can generate an appropriate text via *Tools > Developer Tools > Generate add-on documentation*. Check if all links are correct (download link, add-on' and author's homepage, image).

## Announce the new add-on
Do not forget to post about your new add-on in the [Freeplane Open Discussion forum](http://sourceforge.net/apps/phpbb/freeplane/viewforum.php?f=1). (As a temporary solution you could upload the add-on as an attachment to your post if you have no better download location yet.)

## If you can't continue to maintain an add-on

* please try to find somebody who likes to adopt your package in the forum.
* If you haven't done so make the source code available now.

