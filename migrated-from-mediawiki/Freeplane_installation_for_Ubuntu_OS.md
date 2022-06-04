**This page explains how to install Freeplane for the Ubuntu operating system, there are 3 main ways to proceed.**


# First: check Java is installed

Make sure Java is installed:

* Choose Applications > Ubuntu Software center
* Type in the search field: Java
* In the list that opens, choose JDK Java 6 Runtime 
* If you see "Remove", Java is already installed. If you see "Install", click it to install Java.<br> <br>

# Option 1 : install from the official Ubuntu software repository

1. Freeplane is packaged for Debian/Ubuntu, you just need to run:
<code>apt-get install freeplane</code>

If the Freeplane package for your distro is out of date, see option 2 or option 3 below (it requires download from SourceForge official Freeplane project hosting).

# Option 2 : install with .deb file

For every Freeplane release, starting with 1.6.5, there is a .deb available which includes all libraries, so it works on Debian/Ubuntu.

* download the generic .deb: go to http://sourceforge.net/projects/freeplane/, click "Browse all files", navigate to "freeplane stable"
* download freeplane_<version>+upstream-1_all.deb
* install it using
<code>dpkg -i *.deb</code>

* this will create a menu entry for Freeplane, mime type mappings etc
* you're done ;-).


# Option 3 : install with the binary package
1. Download Freeplane binary package

* For  newest version goto  http://www.freeplane.org/preview/ and download Freeplane_bin-XXXX.zip, in which XXXX is a shown version number.
* Or for the official version goto http://sourceforge.net/projects/freeplane/ and press download.
* Then choose Open with Archive manager, and press OK <br><br>

2. Extract the freeplane directory

* In the download window press extract, select the location (e.g. Documents) and press Extract again.
* Then open the the directory where you extracted freeplane (Documents) and open the newly created Freeplane directory. <br><br>

3. Then run freeplane

* In the extracted directory, double-click on Freeplane.sh and select Run (or run in terminal window). Now Freeplane opens and you can use it. <br>

<br>
**If you want you can customize the installation as follows.** 

4. For easy access, add Freeplane to  Applications > Office:

* Right-click Apllications and select Edit Menus
* Select Office (left) and select Add Menu item (right)
* Type a name, e.g. freeplane
* Browse to the directory with freeplane, click freeplane.sh and press ok
* With freeplane selecte, press Properties
* Click on the icon on the left and browse via Documenten > FreeplaneXXX to the file freeplane.svg; and select it. 
Now freeplane is added to Office with the freeplane icon. <br><br>

5. For faster access, add the freeplane icon to the toolbar:

* Goto Applications > Office and right-click Freeplane.
* Select add this launcher to toolbar. <br><br>

6. Now you can start freeplane by pressing its icon in the toolbar <br>

<!-- ({Category:Documentation}) ({Category:Installation}) ({Category:Ubuntu}) -->

