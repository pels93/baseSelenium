@echo off
SETX /M ANDROID_HOME "%LOCALAPPDATA%\Android\Sdk"
SETX /M ANDROID_SDK_HOME "%SystemDrive%%HOMEPATH%\.android"
SETX /M ANDROID_AVD_HOME "%SystemDrive%%HOMEPATH%\.android\avd"