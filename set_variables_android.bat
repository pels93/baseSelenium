@echo off
echo add como variable
echo setx /M ANDROID_HOME "%LOCALAPPDATA%\Android\Sdk"
echo setx /M ANDROID_SDK_HOME "%HOMEPATH%\.android"
echo setx /M ANDROID_AVD_HOME "%HOMEPATH%\.android\avd"
echo setx /M M2_HOME "%ProgramFiles%\apache-maven-3.6.3"
pause
echo add a path
echo %JAVA_HOME%\bin
echo %M2_HOME%\bin
echo %ANDROID_HOME%\platforms
echo %ANDROID_HOME%\platform-tools
echo %ANDROID_HOME%\tools
echo %ANDROID_HOME%\tools\bin
pause

adb
emulator
avdmanager list avd
