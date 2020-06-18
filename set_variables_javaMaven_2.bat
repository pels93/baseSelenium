@echo off
SETX /M PATH "%PATH%;%M2_HOME%\bin;%JAVA_HOME%\bin"
echo ---------------------------------------------
echo run the next steps in new terminal
echo ---------------------------------------------
echo java -version
echo mvn --version
echo.
echo.
pause