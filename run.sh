#!/bin/bash
MAIN=TestStringHash
CP="junit-4.11.jar:hamcrest-core-1.3.jar:."
javac -cp $CP *.java
java -cp $CP org.junit.runner.JUnitCore $MAIN