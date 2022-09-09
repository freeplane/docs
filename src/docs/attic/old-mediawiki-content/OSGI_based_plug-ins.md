<!-- toc -->

FreeMind has a proprietary extension mechanism further called *plug-ins*. FreeMind plug-ins are automatically loaded by FreeMind using their XML descriptors. This mechanism should be replaced because of the following reasons: 

#Current plug-in design defines many additional classes and interfaces which are actually not necessary and can be replaced by interface used in the freemind kernel. 
#Current XML descriptors have many not documented attributes. There is no need in big XML descriptors any more because FreePlane API allowing plug-ins to seemlesly integrate themselves to the main program e.g. add and serialize new node properties and add their own actions to Freeplane menus/toolbars. 
#Using of OSGI framework is a standard way to organize plug-ins in external projects with excellent IDE support.

Currently I am converting all FreeMind hooks into usual packages which reside inside of freemind.jar. Later they should be converted to OSGI packages. This task should prepare this connection. Now I prefer [knopflerfish](http://www.knopflerfish.org) as a framework. 

<!-- ({Category:Coding})({Category:Needs_Updating}) -->

