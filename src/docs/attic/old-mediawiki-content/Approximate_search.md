<!-- toc -->

# Approximate Search in Freeplane

Starting with 1.2.13, Freeplane includes an 'Approximate Search' feature which allows to find
content (nodes, notes, or whatever) that do not exactly match the search term, but allow some changes
("distance") between the search term and the content. See the section *Search results* below for
some examples of approximate searching.

## How to run (approximate) Search
Press *Ctrl-F* or select *View->Toolbars->Filter toolbar* to show the "filter/search" toolbar and enable
Approximate searching by enabling the "Approximate" checkbox in the filter toolbar (Alt+A). Then you can
enter a search term in the search box (to the left of *Match Case*) and press Enter or click the
*Find next* Button (icon with a blue right arrow in the filter toolbar) to start the search.
If you want to check for equality (search term equals content as opposed to is contained in content),
then you should change the default "Contains" in the search type combobox to "Is equal to".
You can define more complex search rules by using the *Filter->Compose filter* dialog.

## How to find (approximate) occurrences of the search term
This section only applies to freeplane >= 1.2.15.x.
In order to search within the content (node text, note, ...), you need to start the Rich Text Editor
(e.g. Alt+Enter for node content), click the *Find&Replace* icon or hit Ctrl+F which opens the
*Find & Replace Dialog*. In the options panel at the bottom you will find *Match case*
and *Match approximately* that correspond to the options in freeplane's filter toolbar.
Enter the search term, select approximate matching and click *Find next...* to highlight the
search occurrences incrementally.

## Search results
Once you activate Approximate matching, all matching using the filter tool is done approximately, i.e.

* you can search for "file" and it will find "flie" (typo)
* you can search for "hobbies" and it will find "hobbys"
* "setup" = "set up"
* if you use Freeplane for program source code: you can search for "NumberFormat" and it will find "aNumber_Format"
* "Bismark" = "Bismarck"
* "188x" = "1886"
* ...

Of course there are also limitations for this search feature!
A search is considered a match depending on the edit distance between the search term and the content
(see *Threshold* section below). That means that you get False Positives (i.e. "print"="pointer" for a 'Contains' match etc.) and False Negatives
(i.e. "fitness center"!="fitness studio" or for an equality match: "RandomFileAccess"!="RandomAccessFolder", etc.).

## The threshold
Matching is done based on *edit distance* ([Damerau-Levenshtein algorithm](http://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance), the popular library *Lucene* uses the same algorithm), i.e. a match beween search term *x* and content *y* is considered a hit (true positive) if
(|x| - dist(x,y))/|x| > minProb.
The Threshold for approximate matching *minProb* can be customized in the *Tools->Preferences* dialog, tab *Behavior*,
section *Search*. The lower the value, the more variations of the search term will be found. minProb=0.15 will find almost anything,
while minProb=1.0 will do exact string matching. The results above are observed using the default minProb=0.65.

## Comparison to Regular Expressions
If you know exactly what variations of a search term you are looking for,
and you know regular expressions, then the Regex search feature will probably be a better choice.

## Implementation details
There are two *EditDistanceStringMatchingStrategy* implementations: Damerau-Levenshtein, and a Pseudo-Damerau-Levenshtein that
is a simple modification of the Levenshtein algorithm (see [Wikipedia page](http://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance) ).
Both algorithms were enhanced by the *semi-global* option that allows the search-term to be shifted free-of-cost and is used 
by substring ("Contains") matching. Pseudo-Damerau-Levenshtein is the default because I understand the implementation and it can easily
be adapted (for example punishing matches with spaces in content separately).

The occurrences are computed by calculating all *pairwise Alignments* from the DP matrix that have a score >= minProb, and then
using a heuristic to filter overlapping alignments. For example, searching for *"Bismark"* in a text *"... Bismarck lived...Bismarck reigned..."*
yields the following two alignments:

<table>
<tbody>
<tr class="odd">
<td><p><code>----Bismar-k----------------------------</code><br />
<code>... Bismarck lived...Bismarck reigned...</code></p></td>
</tr>
</tbody>
</table>

<table>
<tbody>
<tr class="odd">
<td><p><code>---------------------Bismar-k-----------</code><br />
<code>... Bismarck lived...Bismarck reigned...</code></p></td>
</tr>
</tbody>
</table>

## Feedback
Please edit this section (if you have the privileges) or post in the [Open Discussion Forum](http://sourceforge.net/apps/phpbb/freeplane/viewforum.php?f=1),
your feedback is very much appreciated!

* Should we replace the "Match case" and "Approximate" checkboxes with icons?
* Should we increase the default threshold (find less) or decrease it (find more)?

