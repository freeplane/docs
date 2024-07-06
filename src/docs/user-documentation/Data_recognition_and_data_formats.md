<!-- toc -->

If you set the text of a node to a number or date in Freeplane it will likely be recognized specially. If you don't like that advance to [How to switch data recognition off](#how-to-switch-data-recognition-off).

# Numbers
If a number is recognized

* a "123" symbol is displayed in the left corner of the status bar,
* a standard format is applied to the number, so "0.123456" is displayed as "0.1235" by default (due to rounding).

## Number formats
The default ("Standard") number format is "#0.####", i.e. at least one digit before and at most four digits after the decimal separator.

You can change the "Format" in the format panel (View -> Properties panel). There are two types of format patterns for numbers. You will probably use the [Excel style formats](http://www.google.com/search?q=excel+format+number) like these (for a given input number 0.12345):

* .## -> .12
* 0.000000 -> 0.123450 (zero-padded)

An alternative formatter ("printf") style uses the percent sign specially, see [Formatter documentation](http://docs.oracle.com/javase/1.5.0/api/java/util/Formatter.html) (again for a given input number 0.12345):

* %f -> 0.123450 (standard decimal format)
* %.07f -> 0.1234500
* %d -> 0 (integer)

## Language dependency of parsing and formatting
It depends on your language setting which character is used as decimal and grouping sign: In German setting "12.123" will be recognized as 12123 since in Germany "." groups Thousands while "," is used as decimal separator. In an English setting it's vice versa: "12,123" is 12123.

The number formats will automatically acknowledge a change in the language setting too: If a number is displayed as "0,1234" in German setting it will be displayed as "0.1234" after switching to English.

# Dates
If a date is recognized

* a calendar symbol is displayed in the left corner of the status bar,
* a standard format is applied to the date which is dependent on the language setting, e.g. 12/28/12 or 28.12.12.

## Simple input of dates
Input of dates is greatly simplified in Freeplane. Depending on your language setting try 28/12, 12/28 or 28.12 to insert a standard formatted date <currentyear>-12-28. For date-times just add the year and the time like "12/28/13 12:30" to get "2013-12-28 12:30".

## Date formats
The default ("Standard") date format is "SHORT", that is a language setting dependent short date representation, e.g. 12/28/12 or 28.12.12. The default date-time format is "SHORT,SHORT" (short date, no seconds).

You can change the "Format" in the format panel (View -> Properties panel). The [Excel style formats](http://www.google.com/search?q=excel+format+number) for dates use symbols y/M/d/H/m/s for year/month/day/hour/minute/second:

* yyyy-MM-dd HH:mm -> 2012-12-28 12:31
* MM/dd/yy -> 12/28/12

A ["printf" style](http://docs.oracle.com/javase/1.5.0/api/java/util/Formatter.html) is also available for dates but more useful are the language setting depending shortcuts

* SHORT
* MEDIUM
* LONG
which unfortunately are currently only available in the configuration but not in the format panel. (This is considered a bug.)

# Configuration

## Configuration of formats
The personal standard formats are defined in *Tools -> Preferences -> Behavior -> Data formatting and parsing*.
In the same place you can also choose a language setting for formats that differs from the standard language setting. That way you can e.g. enter English style numbers with '.' as the decimal separator while still having Dutch or German menus.

The predefined formats are defined in the file <freeplaneuserdir>/formats.xml. Ask in the forum if you like to change them and need help on it.

## Configuration of the parser
After editing a node text several parsers are tried in a defined sequence. When a parser succeeds to parse the text as a number or date the node set to the parsed value. Note that the whole text is matched. If for instance a number is followed by a word it's not considered a number.

Unlike formatting the parsing has no normal user configuration (beside the possibility to switch parsing on/off). The predefined parsers are defined in the file <freeplaneuserdir>/scanner.xml. Ask in the forum if you like to change them and need help on it.

## How to switch data recognition off
Sometime data recognition can lead to unwanted results. For instance if you have text that you want to make sure that it is entered verbatim without converting "2/3" into "2013-02-03" or "0228" into "228". In this case you have several, more or less drastic possibilities:

* You can turn data recognition off completely under Preferences->Behavior->Data formatting and parsing.
* You can change the node format from "Text" to switch data recognition off for one node.
* If you start typing with a single quote, ', then the text format is changed to "Text" too.
* You can change the map template "standard.mm". Set the format to "Text". Then all new maps have "Text" as the standard format.

