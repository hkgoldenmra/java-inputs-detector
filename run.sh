#!/bin/bash
java
if [ "${$?}" = '127' ]; then
	echo 'Command "java" does not exist'
	echo 'Run "sudo apt-get install openjdk-8-jre"' 
	echo 'Download and install the Java Runtime Environment (JRE) in the system'
	sudo apt-get install openjdk-8-jre
	read
else
	java -jar "java-inputs-detector.jar" 2>/dev/null
fi
