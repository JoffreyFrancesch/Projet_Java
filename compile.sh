#!/usr/bin/env bash

rm -rf Logger/bin
mkdir Logger/bin
javac -d Logger/bin $(find Logger/src -name *.java)

rm -rf Banking/bin
mkdir Banking/bin
javac -classpath Logger/bin -d Banking/bin $(find Banking/src -name *.java)

javac -classpath Banking/bin -d Testframework/bin $(find Testframework/src -name *.java)
