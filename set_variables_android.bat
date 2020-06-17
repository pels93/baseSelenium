@echo off
CLS
SET nombre_JDK
SET nombre_MAVEN
SET tipo_jdk=jdk
SET tipo_maven=maven
set ruta_temp=%HOMEPATH%\desktop
set ruta_busqueda_java=%ProgramFiles%\java
set ruta_busqueda_maven=%ProgramFiles%
cd %ruta_busqueda_java%
CLS
	dir %tipo_jdk%* | findstr %tipo_jdk% >> %ruta_temp%\filelist.txt
    cd %ruta_temp%
    for /F "delims=" %%a in ('findstr %tipo_jdk% filelist.txt') do set "nombre_JDK=%%a"
    set nombre_JDK=%nombre_JDK:~36%
	DEL filelist.txt

CLS
cd %ruta_busqueda_maven%
CLS
	dir *%tipo_maven%* | findstr %tipo_maven% >> %ruta_temp%\filelist.txt
    cd %ruta_temp%
    for /F "delims=" %%a in ('findstr %tipo_maven% filelist.txt') do set "nombre_MAVEN=%%a"
    set nombre_MAVEN=%nombre_MAVEN:~36%
    DEL filelist.txt

	echo ---------------------------------------------
    echo %nombre_JDK%
    echo %nombre_MAVEN%
    echo ---------------------------------------------
    pause
CLS
SETX /M M2_HOME "%ProgramFiles%\%nombre_MAVEN%"
SETX /M JAVA_HOME "%ProgramFiles%\Java\%nombre_JDK%"
SETX /M PATH "%PATH%;%M2_HOME%\bin"
SETX /M PATH "%PATH%;%JAVA_HOME%\bin"
SETX /M ANDROID_HOME "%LOCALAPPDATA%\Android\Sdk"
SETX /M ANDROID_SDK_HOME "%SystemDrive%%HOMEPATH%\.android"
SETX /M ANDROID_AVD_HOME "%SystemDrive%%HOMEPATH%\.android\avd"
SETX /M PATH "%PATH%;%LOCALAPPDATA%\Android\Sdk\platforms"
SETX /M PATH "%PATH%;%LOCALAPPDATA%\Android\Sdk\platform-tools"
SETX /M PATH "%PATH%;%LOCALAPPDATA%\Android\Sdk\tools"
SETX /M PATH "%PATH%;%LOCALAPPDATA%\Android\Sdk\tools\bin"
CLS
echo ---------------------------------------------
echo ejecuta los siguientes comandos en un nuevo terminal
echo ---------------------------------------------
echo adb
echo emulator
echo avdmanager list avd
echo.
echo.
pause