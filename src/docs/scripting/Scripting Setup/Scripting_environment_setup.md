This page will present a couple of different setups that can be used for creating scripts. 

A good setup can make the craft more comfortable and efficient. On the other hand, if you are still creating just simple scripts, an advanced setup will be overkill, and a basic setup will offer all you need.

The setups will be divided in 3 levels, for mere didactic reasons: Basic; Intermediate; and Advanced.


# Basic

## "Edit Script"
Inside FreePlane you will find the "Edit Script" tool. It was used in some examples  at [this Tutorial](api-groovy-tutorial.md#script---set-details), where you can learn how it works. An advantage of this setup is that it offers a console, which can be useful to understand how your script interacts with FreePlane.

## Text editor
This setup was mentioned in [this introductory](Scripting.md#select-an-editor) guide.


# Intermediate
## Groovy Console
The [Groovy Console Add-on](https://github.com/EdoFro/Freeplane_groovyConsole) looks similar to the "Edit Script" tool, but it's more powerful. There are some useful tools, like the inspector of variables. 

## IDE (simple version, without debugging)
Creating the script inside an integrated development environment (IDE) is helpful because it has many tools dedicated to writing code, like autocompletion.
[This guide ](intellij-idea-setup.md)shows how to set the IDE for that purpose.

Complementary resources, if you get stuck in the guide:

https://github.com/freeplane/freeplane/discussions/589
https://docs.freeplane.org/scripting/Scripting_environment_setup.html


# Advanced (debugging)
With debugging tools, you can very clearly see how your script interacts with Freeplane, which allows spotting the exact lines of code that are not working correctly.

[This discussion](https://github.com/freeplane/freeplane/discussions/1321) has the most recent and easiest steps to set the IDE. Read all the comments, in order to understand the pitfalls that can happen along the way.

In the comments of that thread, you will be recommended to read [this guide](Debugging_scripts.md), too.

Complementary resources

If you want to read more about using Gradle in Freeplane and in Add-ons, take a look at [this](https://github.com/freeplane/gradle-plugin/discussions/6), [this](https://github.com/freeplane/freeplane/discussions/405) and [this](https://github.com/freeplane/freeplane/discussions/258).
