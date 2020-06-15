@echo off
echo add como variable
setx /M ANDROID_HOME "%LOCALAPPDATA%\Android\Sdk"
setx /M ANDROID_SDK_HOME "%SystemDrive%%HOMEPATH%\.android"
setx /M ANDROID_AVD_HOME "%SystemDrive%%HOMEPATH%\.android\avd"
setx /M M2_HOME "%ProgramFiles%\apache-maven-3.6.3"
setx /M JAVA_HOME "%ProgramFiles%\Java\jdk1.8.0_251"
pause
echo add a path
SETX /M PATH "%PATH%;%M2_HOME%\bin"
SETX /M PATH "%PATH%;%JAVA_HOME%\bin"
SETX /M PATH "%PATH%;%ANDROID_HOME%\platforms"
SETX /M PATH "%PATH%;%ANDROID_HOME%\platform-tools"
SETX /M PATH "%PATH%;%ANDROID_HOME%\tools"
SETX /M PATH "%PATH%;%ANDROID_HOME%\tools\bin"
echo revisa los parametros
pause
echo ejecuta los siguientes comandos en un nuevo terminal
start
echo adb
echo emulator
echo avdmanager list avd
pause