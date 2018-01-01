@echo off
java
if %errorlevel%==9009 (
	echo Command "java" does not exist
	echo Visit "https://www.java.com/zh_TW/download"
	echo Download and install the Java Runtime Environment ^(JRE^) in the system
	start "" "https://www.java.com/zh_TW/download"
	pause
) else (
	java -jar "java-inputs-detector.jar" 2>nul
)
