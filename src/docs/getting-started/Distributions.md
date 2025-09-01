
Freeplane is available for different Operating Systems. All Freeplane setup files are available for [download here](https://sourceforge.net/projects/freeplane/files/freeplane%20stable).

Please find below recommendations to choose which **file to download before installing Freeplane on your computer**.

<!-- toc -->

# Java runtime requirement

Freeplane requires a Java runtime:
- some of the distributions below embed Java, so nothing else is needed,
- but the other distributions require **Java to be installed independently**.

When using an independently installed Java runtime, it needs to be of a compatible version number (see details for each distribution). The version to be used by Freeplane can be configured using the [FREEPLANE_JAVA_HOME](Command-line_options_and_configuration.md#select-java-installation-used-to-run-freeplane) environment variable.

# Distributions for Microsoft Windows

* **Freeplane-Setup-with-Java-xxx.exe**: Windows installer with embedded Java.
* **Freeplane-Setup-xxx.exe**: Windows installer which requires Java 8 to 22 to be installed.
* **FreeplanePortable-xxx.paf.exe**: runs on Windows using [Portable Apps](https://portableapps.com/) launcher.
Requires [Open JDK JRE64 portable java version 15](https://sourceforge.net/projects/portableapps/files/OpenJDK%20JRE%20Portable/OpenJDKJRE64_15.0.2_Build_7.paf.exe/download) to be installed on your portable app device. It saves user configuration files on the same device.
* **freeplane_bin-xxx.zip**: archive without installer. It requires Java 11 to 21 to be installed.

# Distributions for Apple macOS

* **Freeplane-xxx-intel.dmg**: distribution with embedded Java for macOS with an Intel or Apple M1/M2/... processor
* **Freeplane-xxx-apple.dmg**: distribution with embedded Java for macOS with an Apple M1/M2/... processor.

Those distributions do not include the adaptive Look and Feel VAqua.

# Distributions for Linux

* **freeplane_xxx~upstream-1_all.deb**: Debian installer compliant with differents Linux derivatives.
* **freeplane_bin-xxx.zip**: archive without installer. 

They both require Java 11 to 21 to be installed.
