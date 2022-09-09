<!-- toc -->

<!-- ({Category:Coding}) -->

## Requirements

* You need java 11 or later and gradle >= 6.0

## Download gradle

* Download gradle: https://gradle.org/releases/
* Unzip to your home directory

## Clone the freeplane repository
    git clone https://github.com/freeplane/freeplane.git
    cd freeplane

## Run gradle

* Gradle wrapper files are intentionally not committed to the sources but git ignored so that you can add them yourself if you need them.
$ ~/Downloads/gradle-6.0.1/bin/gradle build

## Run freeplane
    cd BIN
    ./freeplane.sh # linux
    freeplane.bat
 
## Create package
    ~/git2/freeplane(1.7.x u=)$ ~/Downloads/gradle-6.0.1/bin/gradle clean build dist
    ls DIST

## Configuring an IDE

* See [how to set up IDE](IDE_setup.md)

