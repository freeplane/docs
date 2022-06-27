[Back to Scripting overview](/#/scripting/Scripting ':ignore')


There are a few utility classes in Freeplane that are of special use for scripting. Look up their API in the Freeplane scripting API docs, for example coming from the menu - *Help -> Scripting API*. Here are the direct links:

## UITools
Available via the shortcut *ui*, e.h. *ui.frame* instead of *UITools.getFrame()*. See it's [API](http://www.freeplane.org/doc/api/org/freeplane/core/ui/components/UITools.html).

## TextUtils
Mainly gives acces to available translations. Use the shortcut *textUtils*, e.h. *textUtils.getText('invalid_url', 'The URL is invalid')*. See it's [API](http://www.freeplane.org/doc/api/org/freeplane/core/util/TextUtils.html).

## HtmlTools

Available via the shortcut *htmlUtils*, e.h. *htmlUtils.toHtml("bla\nbla")*. See it's [API](http://www.freeplane.org/doc/api/org/freeplane/core/util/HtmlUtils.html).

## LogUtils

Gives access to Freeplane's standard logging facility, see it's [API](http://www.freeplane.org/doc/api/org/freeplane/core/util/LogUtils.html).

## FreeplaneVersion

*FreeplaneVersion.version* is the full current version (like "1.2.20") but FreeplaneVersion has also accessors for major, minor versions etc. See it's [API](http://www.freeplane.org/doc/api/org/freeplane/core/util/FreeplaneVersion.html).

<!-- ({Category:Script}) -->

