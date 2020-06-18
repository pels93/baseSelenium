@echo off
SETX /M PATH "%PATH%;%M2_HOME%\bin;%JAVA_HOME%\bin"
echo ---------------------------------------------
echo ejecuta los siguientes comandos en un nuevo terminal
echo ---------------------------------------------
echo java -version
echo mvn --version
echo.
echo.
pause