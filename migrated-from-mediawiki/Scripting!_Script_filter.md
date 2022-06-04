For special search and filtering tasks scripting can be employed. The rich [scripting API](http://www.freeplane.org/wiki/index.php/Scripting_API) gives access to all relevant properties of nodes and the [Groovy language](http://groovy.codehaus.org/) provides all measures to express every filtering condition you may think of.

Script filters are selected either via *Filter->Compose filter* or via the filtering toolbar in the following way:

* Select "Script filter" in the field that shows "Core, details or note" by default.
* Click on "Edit script"
* In the dialog enter some Groovy expression that returns a boolean value like <tt>true</tt>, <tt>1 > 0</tt>, node.text.contains('bla')
* Click on OK to close the editor.
* In the filter composer you have to "Add" the new filter and so on (not very intuitive but you'll find your way).

Here after some samples will show you what you can do.

## Node modification date

Some of us are using Freeplane to follow project's tasks. To easily follow evolution of them, we can filter nodes having a ModifyDate < last week. Meaning all nodes for which I've not made any updates since 1 week. The script filter for that is

    node.lastModifiedAt <= new Date() - 7

Now, to filter for all nodes that have changed within the last 2 hours (see [Groovy dates and times](http://groovycookbook.org/basic_types/dates_times/#dates_times-UsingGroovy%27sTimeCategory) )

    use (groovy.time.TimeCategory) {
    node.lastModifiedAt <= 2.hours.ago
    }


<!-- ({Category:Script}) -->

