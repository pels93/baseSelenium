@echo off
CLS
SETX /M PATH "%PATH%;%ANDROID_HOME%\platforms;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin"
CLS
echo ---------------------------------------------
echo run the next steps in new terminal
echo ---------------------------------------------
echo adb
echo emulator
echo avdmanager list avd
echo.
echo.
pause