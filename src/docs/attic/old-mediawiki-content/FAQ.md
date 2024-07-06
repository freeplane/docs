<!-- toc -->

Answers to questions are to be found on different places, depending on the Freeplane version.


# General
## Are there books about Freeplane?
Yes, but only in French and German:

* [Freeplane 1.3 kompakt (2013, German, book + ebook)](http://www.amazon.de/Freeplane-kompakt-Desktop-Holger-Reibold-ebook/dp/B00H17VW0W/ref=sr_1_sc_1?ie=UTF8&qid=1422696075&sr=8-1-spell&keywords=freeplane+1.3+kompatkt)
* [Mind Mapping - Transformez vos idées en projet avec Freeplane (2012, French)](http://www.amazon.fr/Mind-Mapping-Transformez-projet-Freeplane/dp/2746075709)
* [Eine Einführung in Freeplane als Werkzeug für Wissens- und Zeitmanagement (2013, German, Ebook)](http://www.amazon.de/Einf%C3%BChrung-Freeplane-Werkzeug-Zeitmanagement-ebook/dp/B00CEZUU2C)

Books about Freeplane's anchestor FreeMind might be interesting as well:

* [Booster votre efficacité avec FreeMind, Freeplane et Xmind : Bien démarrer avec le Mind Mapping (2010, French)](http://www.amazon.fr/Booster-votre-efficacité-FreeMind-Freeplane/dp/2212126964)
* [FreeMind kompakt: Besser lernen, verstehen und entscheiden mit dem Open-Source-Mindmapping-Programm (2009, German)](http://www.amazon.de/FreeMind-kompakt-verstehen-entscheiden-Open-Source-Mindmapping-Programm/dp/3939316628)

And of course there are a lot of books on Mindmapping in general.

## What made it worth forking from Freemind?

See the article on the [Freeplane/FreeMind relationship](../user-documentation/Relationship_to_FreeMind.md).

## What's the "Freeplane user directory"?
The Freeplane user directory can be found by invoking the menu item Tools->Open user directory. It's location is the directory <tt>1.2.x</tt> respectively <tt>1.3.x</tt> in <tt>%APPDATA%\Freeplane</tt> (Windows) respectively <tt>~/.freeplane/</tt> (Linux, Mac). It contains all user settings: options in <tt>auto.properties</tt>, scripts, [configuration of data recognition](../../user-documentation/Data_recognition_and_data_formats.md), ...

## Where are the preferences stored?
Almost all preferences are stored in [<userdirectory>](FAQ.md)/auto.properties. It contains all settings, keyboard bindings and more. If you want to install a second copy of Freeplane, e. g. to another computer you can copy auto.properties to copy all settings.

## Where's the log file?
Sometimes you need to know where the log file is located, e.g. if you write [scripts](../scripting/Scripting.md) or [reporting bugs](https://github.com/freeplane/freeplane/issues) . Find it in subdirectory <tt>logs</tt> of the Freeplane "user directory" (see above). It's named <tt>log.0</tt> in most cases. If you have more than one Freeplane instance opened then it might have the name <tt>log.1</tt> or even <tt>log.0.1</tt>. The most recently changed file matching the pattern <tt>log.*</tt> will be the one you are looking for.

## How to replace the splash screen
Find directory resources in the freeplane installation directory,
create directory images in it and put your file named Freeplane_splash.png there.
## Weird problems
See if you find help on the [Troubleshooting](../../user-documentation/Troubleshooting.md) page. Otherwise ask in the [Open discussion forum](http://sourceforge.net/apps/phpbb/freeplane/viewforum.php?f=1).

## How to disable node selection changing when hovering over it
It's in the preferences: *Tools->Preferences->Behaviour->Selection method->By click*

## Conceptual difference between "note" and "detail"?

[Postby quinbus » 31 May 2013 19:51](http://sourceforge.net/apps/phpbb/freeplane/viewtopic.php?f=1&t=629).

I suppose that because I'm one (of presumably many) fans of node DETAIL containers, I should at least stand up and be counted.

As I think about the uses I make of the two different containers, it becomes apparent that the differences for me are really one of style and preference; as the previous poster noted, they are technically very similar. But there are lots of examples in life where two technically similar objects or applications find different uses and proponents. Differences between NOTES and DETAILS are finally a function of the subjective discretion of any given user. So, necessarily, my uses will likely be very different that some one else's; but for what it's worth, here are a few ways I make use of the two containers.

Generally speaking, I use DETAILS to hold supplementary information that could be of immediate use to the reader of any given node. An example would be a node that serves as a parent for a set of meeting notes; the DETAIL for this parent contains the location and title of the meeting. In node details I might put the PURPOSE of the meeting, along with any administrivia that might be useful in the future (e.g., City, Time and Address). Information in the details container is discreetly indicated by the presence of the small toggle which appears below the node; unlike the notes container, there is no icon in the main node container that causes node content to be shifted over to accommodate its presence. The toggle is easily manipulated to hide important information that isn't immediately useful to the visual flow of a map, but, unlike NOTES, this information can be easily visually incorporated in the structure of map when desired.

One really nice application of the DETAILS container is a place to store image files, such as group pictures. To this end, I highly recommend the use of the amazing script out in the library that manages the process of locating images on your computer or network and helping you to size them to an appropriate visual impact and designating which of the three FP containers you want to put the resulting image in. Use of the DETAILS container for this purpose is ideal; image files can be much, much wider than the prevailing nodes in a map, crowding out everything else. Putting images in details allows you to toggle the picture in when desired, but keeping it nicely tucked away when not wanted. Example would be a group photo of a work session or, perhaps screenshots of various whiteboards. The main node container provides the label for the map and a few salient points; with a simple click of the toggle, the detail container can be opened to show the image file. A broader discussion of the way image files are handled in FP (including video examples) can be found at https://www.freeplane.org/forum2012/viewtopic.php?f=3&t=492

I personally tend to reserve NOTES containers for a free form workspace where I can make larger expansions on the brief ideas captured in the main node container. The width of NOTES containers is separate from the prevailing width set in the property panel for any given node, so the workspace is much larger and lends itself to formatting and tools that would likely feel cramped in the other two node containers (e.g., the table feature in SimplyHTML works really well in this space).

An obvious use of NOTES is a quick place to begin formatting meeting notes or letters that may have been suggested in the course of a meeting. Perhaps I took the responsibility in the meeting of formatting a letter to colleagues not present; during the break I can open the NOTES container associated with that particular action item and begin the process of constructing the flow and content. It's easy to share the information with colleagues in the meeting, and it keeps all my work on the subject together in one place. If and when the e-mail or formal letter needs to be sent or formally crafted, it's easy enough to copy and paste, but all the inputs the communique are right there . Generally I think I use the NOTES container similar to what I understand is it's primarily use in the DOCEAR environment: Node containers capture the basic outline of a more complex thought process and the NOTES editor is the place where I would start to flesh those simple ideas into something more cohesive.

Just some thoughts. As I say, your mileage will greatly vary.

But I've grown very attached to DETAILS and make an extensive application of them in my particular use case applications...

Q!

[![Index wiki](FreeplaneWiki.jpg)](http://www.kioo.nl/freeplane/freeplaneWiki)

<!-- ({Category:Documentation}) -->

