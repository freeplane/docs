For UBUNTU, see [here](Freeplane_installation_for_Ubuntu_OS.md)

'''Update: Freeplane is packaged for Debian/Ubuntu => just run:
    apt-get install freeplane

The following steps are recommended if the Freeplane package for your distro is out of date:

1. [Download](http://sourceforge.net/projects/freeplane/) the Freeplane zipfile, and extract its contents to the folder of your choosing (e.g. ~/local/freeplane-xxxx , where xxxx is a version-number).

2. Create a freeplane symlink to ~/local/freeplane-xxxx:  <pre>ln -nsf ~/local/freeplane-xxxx ~/local/freeplane</pre>

3. (optional) If you have a ~/bin folder which is in your shell path, you can create a symlink to the freeplane start-script: <pre>ln -s ~/local/freeplane/freeplane.sh ~/bin/freeplane</pre>  If you do that you should now be able to run freeplane from the commandline by simply typing <code>freeplane</code>.

4. Finally, to add an icon which will show up in your applications menu, save the following text to the file <code>~/.local/share/applications/freeplane.desktop</code> :

<blockquote><pre>
[Entry](Desktop)
Version=1.0
Encoding=UTF-8
Name=Freeplane
Exec=/bin/sh /home/YOUR-USERNAME/local/freeplane/freeplane.sh %f
Terminal=false
Icon=/home/YOUR-USERNAME/local/freeplane/freeplane.svg
Type=Application
MimeType=application/x-freemind
Categories=Application;Office;
GenericName=Freeplane
Comment=A free mind mapping tool
</pre></blockquote>

(for more details on why adding this file works, see [the XDG Desktop Menu Specification](http://standards.freedesktop.org/menu-spec/menu-spec-latest.html), which is followed by all major linux desktop-environments)

Now, any time you wish to update your Freeplane application, just repeat steps 1 and 2.

<!-- ({Category:Documentation}) -->

