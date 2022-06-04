This page will give you all the information you need to translate Freeplane into your own language.


# Freeplane GUI translation and improvement
This How-To section describes the tools and (alternative) processes for Freeplane GUI translation. This concerns the translation of all the English source strings displayed in the Freeplane interface, especially in menus and dialogs.

English is the source language for all translations, so you need to know English to be a translator.

UI designers need to be able to improve the UI by improving the existing English source strings and by adding new tool tips. Since they use the same tools and almost the same processes, these processes are also described here.

This How-To uses the following conventions and terms:

* **Language code:** 'xx' in any file name or URL means the two letter language code of the language you are translating to. So you have to replace it by that language code to make it work.
* **Your language page:** `https://hosted.weblate.org/projects/freeplane/translation/xx/`, Weblate page that gives an overview of the translation of Freeplane to your language. For details see [[#Weblate|Weblate]]

* **Your translation item:** An untranslated English source string that you would like to translate or an existing translation that you would like to improve.
* **Translate page:** Weblate page where you can edit your translation item, see [[#How to translate|How to translate]]
* **Translation key:** This is a unique text string that links a certain English source string to all its translations and defines the location where the source string or its translation is displayed in the user interface.
* **File separator:** '/' (forward slash) is used as file separator in the display of paths in order to be compatible with all relevant operating systems. '\' (backward slash) is the default in Windows, but '/' will work as well.
* **Freeplane user directory:** <fpuserdir> preceding any file name is the path to the Freeplane user directory. This path ends in /Freeplane/1.5.x/ where the last subdirectory varies between major releases. You can open this directory in your file manager via the Freeplane menu Tools > Open user directory.

If you have any questions or suggestions with regard to this part of the How-To, post them at the thread [Questions about translating Freeplane via the Weblate tool](https://sourceforge.net/p/freeplane/discussion/758437/thread/3b20093b/)

## Tools: Weblate and Freeplane translation editor

### Weblate

Since version 1.3.x Freeplane uses a collaborative [web based translation](http://weblate.org) tool developed by [Michal Čihař](http://cihar.com). For all described processes the translations are entered or imported in Weblate (except for new tool tips which are merged directly into git). From Weblate all new and changed are committed to the Freeplane git release branch. Weblate stays in sync with the Freeplane git release branche, so any committed new tool tip or other new translation key and its English source string are immediately available for translation in Weblate. With every new Freeplane release the current state of the Freeplane translation in Weblate is also released.

In order to get started as a Freeplane translator or UI designer in Weblate you need to know and do a few things:

* You can find the Freeplane Weblate project page here: http://hosted.weblate.org/projects/freeplane.
* If you have not registered for Weblate yet, you need to do so by clicking 'Register' in the top-right corner and following the instructions.
* It is important that you know how to find your language page, i.e. the Freeplane Weblate page that gives an overview of the translation to your language, has some handy filters for strings to check and has the menu items Search and Files that we are going to use in this How-To:
    * On the Freeplane Weblate project page, click component Translation and then on your language
    * If in your Weblate profile you specify your translated language and subscribe to the Freeplane project, a link to this page appears in your Weblate Dashboard
    * The web address of this page is `https://hosted.weblate.org/projects/freeplane/translation/xx/` where 'xx' is the 2-letter code for your language.

* You need to get yourself familiar with Weblate functionality, so take a look at the [Weblate translator guide](http://docs.weblate.org/en/latest/user/index.html) and keep it as a reference next to this How-To.

If you find bugs on the Weblate tool, you can report them [here](https://github.com/nijel/weblate/issues).

### Freeplane translation editor

The Freeplane translation editor is a tool for translators and UI designers that is available in the Freeplane GUI. It is included in Freeplane v1.5.16 or higher and is enabled by installing the [User Translation Support add-on](https://sourceforge.net/projects/freeplane/files/addons/user-translation-support/User-Translation-Support-v1.0.addon.mm/download).

The translation editor appears when you press Crtr+Shift+F10 while your mouse is hovering above the text of your translation item. It shows a translation window for the text string and, if applicable, for the tool tip associated with the text string. You can choose to do one of 2 things:

* You can choose to translate in the translation window itself (i.e. offline translation). When you close Freeplane, all translated items are stored in a local file: <fpuserdir>UserResources_xx.properties, that can be uploaded to Weblate.
* Or you can choose to press the Weblate button. This takes you straight to the correct translate page, the Weblate page where you can edit your translation item.

The translation editor does not work for all GUI text strings. In that case the message "No translatable string found" appears in the bottom-left corner of the Freeplane Window.

For some tool tip items you might notice that offline editing is disabled and that the translate page cannot be found. In that case it is a [[#New tool tips|new tool tip]].

If you would like to change the standard hot key for the translation editor, you can do so by selecting **Tools > Set text change hot key from** the menu.

### Online or offline translation?

In the following 2 paragraphs it is explained in detail how these 2 tools work together in online or offline translation. Both ways have advantages over the other.

| Online translation                                                                                                | Offline translation                                                          |
| ----------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| Easy to collaborate                                                                                               | Fast                                                                         |
| Automatically work on the most current translation                                                                | You immediately can check the result of your translation in the Freeplane UI |
| More information and tools to support translation: glossary, machine translation, review flags, comments, history | You do not need Internet during translation                                  |

When to use online or offline translation depends on what you have to do, your circumstances, your translation skills and the preferences of you and your co-translators. Here are a few examples 

| Online translation                                                       | Offline translation                                                       |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------- |
| When you have to improve existing translations                           | When you have to translate untranslated items                             |
| When you translate a few items from time to time                         | When you want to and are able to translate a lot of items in a short time |
| When you need to collaborate with other translators for your language    | When you are the only translator for a language                           |
| When machine translation and a secondary language can help you translate | When you are able to translate without any aids                           |
| When the quality of translation is more important                        | When the speed of translation is more important                           |
| When you always have access to Internet                                  | When you need to be able to do part of the work offline                   |

## Online translation

Online translation has basically 3 steps:

1. You need to find, filter and/or review translation items
2. Translate an item
3. Test your Weblate translation

### How to find, filter and/or review translation items

The following 4 scenarios can help you to get from no translation to a complete and improved translation. You could use a combination of scenario 1 and 2 to go through all menu's and screens systematically followed by scenario 3. Scenario 1 is the only scenario that can be replaced with offline translation. Scenario 4 can take place at any time. In case of a largely completed translation that needs maintenance, the scenarios can be used in any order. New tool tips and other new English source strings and translation keys that are added during development are probably easiest found through scenario 3, though it might be difficult to find the location of these strings in the user interface.

**Scenario 1: In the Freeplane user interface you see a string you would like to translate or improve and you can use the Freeplane translation editor.** You can recognise untranslated strings as the English source string with the token [me](Translate) attached to it. Otherwise you could see a string that needs better formulation or  correction of a language error. Hold your mouse above the intended string and press Ctrl+Shift+F10 to invoke the Freeplane translation editor. It will show the string and, if applicable, its tool tip. Press the Weblate button of the string you would like to translate or improve. That will directly open your web browser with the Weblate page for your translation item. In a few cases this scenario does not work or stops here:

* When you press Ctrl+Shift+F10 the translation editor does not appear and the message "No translatable string found" appears in the bottom-left corner of the Freeplane Window. The translation editor cannot handle this type of string and you should use scenario 2 to find and translate this string.
* After you press the Weblate button, the translation item cannot be found in Weblate. This concerns a new tool tip, see [[#New tool tips|New tool tips]]
* You may find that the string is already translated or improved. This is because Weblate can be ahead of the translation that came with the Freeplane release you are using.

**Scenario 2: As scenario 1 but without the Freeplane translation editor.** Once you have identified your translation item you go to your language page (`https://hosted.weblate.org/projects/freeplane/translation/xx/`) and press Search. In case of translation you enter the English source string in Query and enable option "Search in source strings" In case of an improvement you enter the current translation in Query and enable option "Search in target strings". After pressing the Search button you might directly find the page for your translation item. If you find more than one item, you can browse through them to find your translation item. If you find nothing or the wrong item the English source text or the translated text has been changed in Weblate since the moment of the Freeplane release you are using. You can try to find them by reducing the number of keywords in the search.

**Scenario 3: Finding remaining or new untranslated items in Weblate.** In Weblate you can easily find all untranslated items by clicking 'Not translated strings' on your language page. Disadvantage over scenario 1 and 2 is that you might have difficulties to find the location of these translation items in the Freeplane interface, so you miss the context that helps you to translate or improve it. After having gone systematically through all menu's and screens with scenario 1 and 2, this is the only way to find the remaining untranslated items.

**Scenario 4: Reviewing translations.** In scenario 1 and 2 you review the translations directly in the Freeplane interface. In Weblate there are many additional ways to select translations for review:

* **Review all translation items marked for review:** Click the link 'Strings marked for review' from your language page. You can now browse through all translations that are marked for review by other translators or automatically by Weblate if the English source string has changed. If necessary you can improve the translation. If your are satisfied with the translation, remove the tick "Needs review" and save.
* **Review all translations done by other translators since a certain date:** From your language page click Search, in the Review pane specify the date and click "Start review".
* **Review consistent translation of a certain keyword:** From your language page click search, enter the keyword, only enable "Search in source strings" and hit the Search button.
* **Review translations with failed checks:** From your language page click the link "Strings with failed checks". On the search page you can use "Search filter" to filter on specific failed checks.

### How to translate

The basis of the translate page is the English source string and the translation field. For an untranslated item you can enter the translation. An existing translation you can review and change. You can also enable or disable 'Needs review' if necessary. Then you can save your changes.

If the English source string has changed, the change is shown as well. If you have another secondary language that you know better than English, you can specify that in your Weblate profile and the translation to this secondary language is also shown on the translate page. 

If you do not know the location of your translation item in the Freeplane user interface (scenario 3 and 4), the context string (which is in fact the translation key) and the Nearby messages might give a clue.

You can check what Machine translation suggests and how translators have changed the translation in History. Comments and Glossary are discussed in [[#How to collaborate to translate Freeplane to your language|How to collaborate to translate Freeplane to your language]]

### How to test your Weblate translations:

* Open your language page: `https://hosted.weblate.org/projects/freeplane/translation/xx/`
* Choose Files
* Click "Download", save freeplane-translation-xx.properties
* Copy freeplane-translation-xx.properties to <fpuserdir>resources/translations/Resources_xx.properties
* Restart Freeplane
* Test your translations
* Close Freeplane
* Remove <fpuserdir>resources/translations/Resources_xx.properties, otherwise it will overrule newer translations that will come with new Freeplane releases.

## Offline translation

The basic steps of offline translation are simple: you translate your translation items with the translation editor and then you upload your translation to Weblate. The use of the translation editor [[#Freeplane translation editor|has already been explained]]. The [[#How to upload your translation|first paragraph]] explains how to upload your translation.

When you plan to translate offline you need to realise that there are 3 risks that could upset you and your peer translators compared to the situation where you and the other translators use online translation exclusively:

1. Your local Freeplane translation files are not automatically up to date with the most current translation to your language. There is a risk that you translate items that already have been translated.
2. You and other translators for your language are not automatically aware of reach others work. There is a risk that you and your co-translators work on the same translation items. 
3. You do not automatically compare your translation with an existing translation that is added after the local outdated translation (risk 1) or while you were working on your offline translation (risk 2). There is a risk that you accidentally overwrite a preferable translation.
In the best case scenario there is no translation to your language yet and you are able to ensure that you are the only translator. In other scenarios these unwanted results could occur and might upset you and/or your co-translators. So it is better to prevent these risks from happening by the measures explained in the [[#How to prevent offline translation risks|third paragraph]]. Part of these measures concern updating the local language files and it helps to understand their hierarchy as explained in the [[#Understanding translation file hierarchy|second paragraph]].

### How to upload your translation

When you have finished your offline translation and would like to upload your translation to Weblate, you can take steps 5 to 10 in the procedure described  in [[#How to prevent offline translation risks|How to prevent offline translation risks]]. In step 9 you can choose from the following settings:

The standard recommended settings are:
: **Merge method:** Add as a translation
: **Processing of strings needing review:** Do not import
: **Merge file header:** Disabled
: **Merge translation comments:** Disabled
: **Overwrite existing translations:** Enabled
You apply these settings if you are sure there are no existing translations, if you have an alternative for reviewing translations that are going to be overwritten or if you are intentionally overwriting existing translations with improved translations.

If there is a chance that you are going to overwrite other translations unintentionally, the following alternative settings allows you or you co-translator to review whether you have accidentally overwritten a preferable translation.
: **Merge method:** Add as a translation needing review
: **Processing of strings needing review:** Import as string needing review
See also the procedure in [[#How to prevent offline translation risks|How to prevent offline translation risks]] for a smarter way to review for preferable translations that are accidentally overwritten.

If you want to prevent that your import overwrites existing translations, you can change the last setting as follows
: **Overwrite existing translations:** Disabled

Other variations are not relevant, since the type of translation file we use does not have a file header and does not support marking individual strings needing review or adding translations comments.

### How to keep your local translation files up to date

If you understand Freeplane's translation file hierarchy, you can figure out how to keep the local Freeplane translation up to date. Freeplane looks for a translation of a certain translation key in the following order:

4. in <fpuserdir>UserResources_xx.properties (where translation editor stores translations)
5. in <fpuserdir>resources/translations/Resources_xx.properties (that you can use to save the most recent translation from Weblate)
6. in the file Resources_xx.properties that came with the release (in the installation directory)
7. in the file with the English resource strings, displaying it as "<English text> [translate me]"

With this file hierarchy in mind you can easily grasp the following situations:

* Suppose you download the translation file in your language from Weblate and save it as <fpuserdir>resources/translations/Resources_xx.properties. Then the updated translations from Weblate will overrule the outdated translations that came with your current Freeplane version.
* The previous bullet is not true if you kept an <fpuserdir>UserResources_xx.properties with some outdated translation strings that overrule the strings with the same translation keys in <fpuserdir>resources/translations/Resources_xx.properties. So it is good practise to remove <fpuserdir>UserResources_xx.properties after you have uploaded your translationThat will also prevent you from uploading the same translation strings twice. 
* Suppose you have finished your translation work, you keep <fpuserdir>resources/translations/Resources_xx.properties without updating it and you update Freeplane to a new version. At that moment outdated translations in <fpuserdir>resources/translations/Resources_xx.properties overrule updated translations that come with the Freeplane releases. So if you want to benefit from automatic translation updates that come worth Freeplane releases you should remove <fpuserdir>resources/translations/Resources_xx.properties.

### How to prevent offline translation risks

When you start offline translation you need to assess to what extent the risks of outdated translation files and hidden translation work do apply. Here are some suggested measures and a procedure, just check what applies to your situation. If you work with a group of translators, you can agree on your measures and procedures.

**Measures**

* Announce on the Freeplane forum that you are going to do an offline translation. You can do this in an existing or new thread as explained in [[#Discussion in a topic on the Freeplane forum|Discussion in a topic on the Freeplane forum]]
* Keep the moment between starting the offline translation and uploading it to Weblate as short as possible. For example, if you can work on the translation fulltime for 2 days, upload it immediately after you have finished. If you can work on it one hour now and then, upload it after each hour.

**Procedure**

This is an example procedure that updates your local translation before you start offline translation and allows you to review whether your upload overwrites any new or changed translations that other translators have added to Weblate while you were working offline. Some steps might not apply to all situations, e.g. if Weblate does not contain any translations in your language yet, there is no need to download a translation file to update the translation in Freeplane (step 2).

8. Remove the file <fpuserdir>UserResources_xx.properties if you have uploaded offline translations previously and forgot to remove it.
9. In Weblate go to your language page and click Files > Download original translation file (Java Properties (ISO-8859-1)). Save the file as <fpuserdir>resources/translations/Resources_xx.properties. Restart Freeplane. The Freeplane translation for your language is now up to date with Weblate.
10. If you have not done so, change the language of the Freeplane user interface to your language in Tools > Preferences > Environment > Language and restart Freeplane.
11. Carry out your offline translation.
12. Close Freeplane to make sure that all your translations are stored in <fpuserdir>UserResources_xx.properties
13. Open your language page (`https://hosted.weblate.org/projects/freeplane/translation/xx/`)

1. Click Files > Upload translation
2. Choose the file <fpuserdir>UserResources_xx.properties
3. Choose the options as recommended in [[#How to upload your translation|these instructions]]. You can use the standard settings or, if you do not want to spent time on reviewing in the next step, you can choose not to overwrite existing translations.
4. Click the upload button
5. From your language page, click history and check that your translations have been imported. Click on every item with action'Translation changed' and check in the history tab of the displayed translate page whether you unintentionally have overwritten something. If you find the previous translation better than yours, you can restore the previous one.
6. Remove <fpuserdir>UserResources_xx.properties to prevent that you upload the same translations again and to enable you to see updates through the other language files, see the previous paragraph.

## New tool tips

The translator editor has also functionality for UI Designers to add new tool tips in order to improve the user interface. Translators can recognise these new tool tips by the fact that the entry field in translator editor is disabled or by the fact the Weblate button does not find the translation item. A translator can enable the translation of a tool tip by taking over the role of the UI designer. It requires the translator to submit an English source string before the actual translation can start. It also requires an developer to add the new translation key and source string to Weblate, so enabling is not an instant action. The next paragraphs describe in detail the different processes with regard to new tool tips.

### UI designer process

This process is for new tool tips only. If you want to improve the source string of existing tool tips follow the [[#Change English source strings|regular process]] to change source strings.

7. Check if there is any open "New tool tips" bug report. If so, wait till they are all closed and Weblate is up to date. If not, you might repeat your own work or overwrite your co-designers work.
8. If the Freeplane language is other than English, change it to English in Preferences
9. Close Freeplane
10. Remove <fpuserdir>UserResources_en.properties to prevent submitting the same new tool tips
11. Download the English source through menu "Files > Download original translation file (Java Properties(ISO-8859-1))" from https://hosted.weblate.org/projects/freeplane/translation/en/. Save it as <fpuserdir>viewer-resources/translations/Resources_en.properties. In this way your local source strings are up to date.
12. Start Freeplane
13. Hover over the item that you would like to add a tool tip to. If there is already a tool tip, skip the item. If not, press Ctrl+Shift+F10
14. Enter the text for the tool tip (the bottom field) and press OK.
15. Repeat the last 2 steps till you have finished what you had planned
16. Close Freeplane
17. Create a [new bug report](https://sourceforge.net/p/freeplane/bugs/new/) titled "New tool tips" and attach <fpuserdir>UserResources_en.properties
18. If necessary, change Freeplane back to the original language.

### Translator process

If you want to enable translation for a certain tool tip, you should follow the following steps.

19. Hover over the item with the disabled tool tip and press Ctrl+Shift+F10.
20. Press the Weblate button. If the translation key is present in Weblate, you can continue with normal online translation. For the offline translation process continue with that section below. If no translation key is present, continue with the next step
21. Follow the steps of the UI designer process
22. When the "New tool tips" bug report is closed, continue with online translation. For offline translation process continue with that section below. 

### Offline translation process for new tool tips

This is the same as the normal offline translation process, except that you need to update the English source strings to enable the new tool tip fields:

* Download the English source through menu "Files > Download original translation file (Java Properties(ISO-8859-1))" from https://hosted.weblate.org/projects/freeplane/translation/en/. Save it as <fpuserdir>viewer-resources/translations/Resources_en.properties. In this way your local source strings are up to date.

## Change English source strings

It is possible to change the English source strings with the same tools as used for translation. You should do this with the utmost care. If you see a spelling error in the source text you can correct it just like that. Other improvements you should discuss in the [Improvement of Freeplane usability](https://sourceforge.net/p/freeplane/discussion/758437/thread/e234f3f6/) thread. In addition can go to the English translate page of the item you would like to improve, check 'Needs review' and leave your suggestions as a [[#Communication by comments and review flags in Weblate|comment at the translation level]].

I recommend you to change English source strings only online because you will make a few changes at a time and you will prevent a mix up with [[#New tool tips|new tool tips]]. 

You can follow the instructions for online and offline translation with a few adjustments:

* In order to use the Freeplane translation editor for English source text, you need to change the interface language to English in Freeplane's preferences.
* Where it says 'your language page' you can start off from the Freeplane English source page: https://hosted.weblate.org/projects/freeplane/translation/en/
* Obviously on the translate page for English there is no source string, in the translation field you can change the source string
* While you are on a translate page for a language other than English, there is a icon of a pencil next to the label 'Source'. This icon links to the translate page for the English source string.
* If you want to test or update the English source strings in your local Freeplane, you can download them from Weblate in the same way as for translations, but you should save it as: <fpuserdir>viewer-resources/translations/Resources_en.properties.

## How to collaborate to translate Freeplane to your language

Weblate makes it very easy to collaborate on translating Freeplane to your language. If you or another translator add a new translation, the other translators immediately see this new translation in Weblate. If something unexpected has happened to a translation item you can check in the history tab of the translate page who has done what. The following paragraphs highlight some other Weblate collaboration features and the fact that you also can communicate through the Freeplane forum. 

### Communication by comments and review flags in Weblate

If you are not sure about your or somebody else's translation you can check 'Needs review' and add a translation comment with your question or concern. Be sure to choose 'Translation comment' as a scope so that it is only visible to other translators in your language. This means you can write the comment in your language.

If you have a remark that can help translators of all languages, e.g. "*Clone* and *copy* should be translated to different words, because they are functionally different.", you can choose 'Source string comment' as a scope. Of course you should write this comment in English.

If you have a suggestion to improve an English source string, ignore the Weblate advice and see [[#Change English source strings|Change English source strings]] about how to communicate this.

### Consistent translation by using a glossary

A Weblate glossary is a great way to agree on a consistent translation of certain keywords. If we repeat the example of the terms *clone* and *copy*, that are functionally different in Freeplane: in the glossary you can actually suggest how both words should be translated in your language. Once a keyword in the glossary appears in the source string on the translate page, suggested translations appear in the Glossary window in the right top corner of the translate page. You can also add a new keyword with translation to the glossary through this window.

If you want to review and edit your glossary, you can click the 'Manage glossary' icon in the top right corner of the glossary window. Alternatively, you can go to the page https://hosted.weblate.org/dictionaries/freeplane/ and select the glossary for your language from the overview.

### Discussion in a topic on the Freeplane forum

If you feel the need to have a discussion with your fellow translators you can check if there is an existing thread for your language on the [Freeplane forum](https://sourceforge.net/p/freeplane/discussion/758437/). If not, you can start a new topic for translation to your language. Since such topic is for people having the same primary language, you are allowed to write in your mother tongue. If you subscribe to this thread, e-mail messages will notify you of new posts.

Here is an incomplete list of forum threads and pages related to the translation to different languages. If any existing translation thread is missing from this list or if you started a new translation topic for your language, report it in the thread: [Questions about translating Freeplane via the Weblate tool](https://sourceforge.net/p/freeplane/discussion/758437/thread/3b20093b/)

#### French / Français

You can have a look at:

* [Old forum thread 1](https://www.freeplane.org/forum2012/viewtopic.php?f=1&t=69&sid=6fe29d34506a47b7f1b2942e19cc0a22)

* [Old forum thread 2](https://sourceforge.net/projects/freeplane/forums/forum/758437/topic/3496807).

#### Flemish/Dutch / Nederlands/Vlaams

* You can consult [Translation nl](Translation_nl.md) for general guidelines

* Your can post your questions, remarks and requests in [this thread](https://sourceforge.net/p/freeplane/discussion/758437/thread/fe83a1fb/)

* This is an [old thread](https://sourceforge.net/p/freeplane/discussion/758437/thread/36e42c1c/) on Dutch documentation

## Frequently Asked Questions / Tips for translators

<dl>
  <dt>While running Freeplane, why are some strings ending with "[translate me]"?&nbsp;</dt>
    <dd>As long as a key is missing in a translation, Freeplane automatically uses "&lt;English text&gt; [translate me]" as translation. Translators should translate these strings in priority and then remove "[translate me]".</dd>
  <dt>Why are strings ending with "[auto]"?&nbsp;</dt>
    <dd>Translation files can be submitted to an automatic translation tool, then strings of type "&lt;English text&gt; [translate me]" becomes strings of type "&lt;local language text&gt; [auto]". Translators should search and review these strings and then remove "[auto]".</dd>
  <dt>Why is there sometimes space before values?&nbsp;</dt>
    <dd>spaces before values are ignored, don't care.</dd>
  <dt>Why is there &amp; character before some values (sometimes "in" the words)?&nbsp;</dt>
    <dd>The ampersand (&amp;) is used to mark keys in the menu (i.e. open the menu, press the key/letter to activate the menu entry) - It is not necessary to add the &amp; character to your translation, because Freeplane will automatically mark keys in the menu. I you do want to have full control over which keys are marked, you can add the &amp; character to your translation strings and you need to make sure that each letter is only used once per menu. The easiest way to do this is to finalize your translation and than quickly add the &amp; characters in <a href="#Offline_translation">offline translation</a> because then you can immediately check the result in the Freeplane interface.</dd>
  <dt>Some values begins by &lt;html&gt; with no &lt;/html&gt; at the end?&nbsp;</dt>
    <dd>Java accepts unclosed tags - don't care.</dd>
  <dt>Some keys are not used / displayed in the software&nbsp;</dt>
    <dd>you should stay aligned with the English version to be on the safe side, but if keys are not used, it's a bug you can report it <a rel="nofollow" class="external text" href="https://sourceforge.net/p/freeplane/bugs/">here</a>.</dd>
  <dt>When testing Freeplane with my translation file, some menus are missing or some buttons have no label, why?&nbsp;</dt>
    <dd>If you leave any empty keys in the file, Freeplane assumes they are valid translations and displays nothing. There are differences between "empty key in the translation file" which displays nothing and "missing key in the translation file" which displays "&lt;English text&gt; [translate me]" (see above).</dd>
  <dt>Your translation is truncated&nbsp;</dt>
    <dd>If your translation is truncated when displayed, it may contains a ' (apostrophe) character (e.g. Freeplane displays "Copier l" instead of "Copier l'identifiant"), you may simply enter the ' character twice (ie "Copier l"identifiant") as translation, where " is twice the character '. Most of the time, ' apostrophe characters should be handled as in the English version (for some strings which are used in format statements put them twice, for other strings put them once).</dd>
</dl>

# Translation of Freeplane add-ons
[Add-ons](Add-ons.md) manage their translations on their own, i.e. the translations are integrated into the add-on sources. Nevertheless, it's simple to translate an add-on by editing the add-on installation package in Freeplane and modifying the translations therein. If the translations contain non-ASCII characters you have to encode the text using a script, either from the [Developer Tools](https://www.freeplane.org/wiki/index.php/Add-ons#Add-on_Developer_Tools) (since version 0.9.16) or from [here](https://sourceforge.net/apps/mantisbt/freeplane/view.php?id=2091).

# Translation of third party tool used in Freeplane
## JOrtho spell checker
For spell check Freeplane relies on JOrtho project. JOrtho translation file contains very few strings and only 5 are used in Freeplane but if you want to translate this file too, you can get it at its [current location](https://github.com/freeplane/freeplane/tree/master/JOrtho_0.4_freeplane/src/com/inet/jortho/i18n).

# Translation of Tutorial or Documentation maps

These are the mind maps you get when you press Help &rarr; Tutorial (freeplaneTutorial.mm) and Help &rarr; Documentation (freeplane.mm).


## Basic steps

23. Create a working directory *myTranslations*.
24. Copy the most recent English documentation from https://www.freeplane.org/mapsOnline. For this choose *Help > Documentation Maps Online* and select the map of your choice; or copy your last translation.
25. make a subdirecory structure for images: *myTranslations/doc*; (if you use these, also *myTranslations/mouse* and *myTranslations/key*).
26. Copy images you reuse or put new images you use in myTranslations.doc (possibly also  myTranslations/mouse and myTranslations/key).
27. Edit your translation. Drag your images from the defined subdirectories into your translation (assuming URI's are relative). 
28. Test the translation, in particular the images.
29. Zip directory myTranslations.
30. Select *Help > report a bug*, select new report of type translation and upload the zip file. 

**Note**
Check Help > Documentation Maps Online > indexMap > Images/doc for the images used in the present doc mind maps.



Old

1. Download the latest version of <tt>freeplane.mm</tt> and <tt>FP_MenuReference.mm</tt> (or an already existing versions in your language) from the repository.
   * The current link is https://github.com/freeplane/freeplane/tree/master/freeplane/resources/translations/ (but check if it's not an outdated link)
2. Visit pages https://www.freeplane.org/doc/freeplane_all_languages.html and https://www.freeplane.org/doc/FP_MenuReference_all_languages.html to see how the documentation is automaticly translated by Google Translate.
3. Using the latest development version of Freeplane, just create a map in your language (or complete the one already existing).
   * As it's almost impossible to track differences between maps and ensure an exact one to one relationship between the languages, we don't expect this from translators.
   * To track changes of <tt>freeplane.mm</tt> filters can be useful: Open the file in normal mindmap mode (not via F1) and apply a "Date filter" with the modification time set to the last time you have edited the translated map.
   * Just make sure that the map is consistent with the current version of Freeplane, as complete as possible and helpful to users.
4. Go to the [tracker](http://sourceforge.net/apps/mantisbt/freeplane/search.php?project_id=12&hide_status_id=90) (requires Sourceforge log-in) and upload your map (the Project should be set to Translations).

# Keys Mapping translation

TBD


# Java Help translation

TBD (the current version doesn't allow for localization). Hint for later: http://jhelpdev.sourceforge.net/


<!-- ({Category:Advanced}) ({Category:Translation}) -->

