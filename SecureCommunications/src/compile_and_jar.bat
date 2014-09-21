@echo off
echo [+] Compiling
javac securecommunications\*.java
echo.
echo.
echo [+] JARing
jar cvmf manifest.mf ..\dist\SecureCommunications.jar securecommunications\*.class