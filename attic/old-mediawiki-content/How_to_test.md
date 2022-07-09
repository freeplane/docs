## Freeplane Release Process 

Releasing a stable or unstable version of Freeplane is a two stage process.  Each new test version is uploaded to a [testing area](https://www.freeplane.org/testversion/) prior to release.  When one or more tester confirms that the test version has introduced no major bugs, it will be uploaded as an official release to the Sourceforge files section.  Otherwise, a new test version will be uploaded.  At the moment only team members and selected testers are alerted when new test versions are available, but you are free to periodically check and download any new versions in the [testing area](https://www.freeplane.org/testversion/).


## Testing an official release

If you want to test an official Freeplane release, here's what to do: 

1. Download the [latest release](https://sourceforge.net/projects/freeplane/) 

2. Create a fresh map or use a testing map, and perform as many functions as you can, via both the menus and hot keys.  Particularly try out any new features.  Jot down any problems or bugs you encounter and record what you were doing at the time.  (In the future there will be a systematic test map and/or unit-tests available). 

3. Report any problems via the [bug tracker](https://sourceforge.net/apps/mantisbt/freeplane/) (under Project--&gt;Bugs).  Please include as much information as possible:  

* what you were doing
* the behavior you encountered
* error or warning messages you got
* your Freeplane and Java versions
* your operating system


**ALWAYS SUBMIT:**

* *a description of steps to reproduce the bug*
* *the actual results of following these steps*
* *the expected / desired results*


## Testing a test version

If you wish to test a bleeding edge test version, replace step 1 above with one of the two following options: you can either download the latest binary archive from the [testing area](https://www.freeplane.org/testversion/), or you can check out the latest release from the development repository, and build it.  See the [How to Build Freeplane](../coding/How_to_build_Freeplane.md) wiki page for more information on getting the source and building binaries.

Additionally, if you're testing a test version please complete the [smoke test](https://www.freeplane.org/wiki/index.php/Release_smoke_test), until unit-tests are available to carry out these tests. 


## Testing the development version
If you want to test the next Freeplane version developpers are working on (also called preview version), please refer to [use and download preview version](https://www.freeplane.org/wiki/index.php/Freeplane_1.2.x-1.3.x).


<!-- ({Category:Coding}) -->

