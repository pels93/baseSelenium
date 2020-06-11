@echo off
adb kill-server
adb kill-server
start %ANDROID_HOME%\tools\emulator.exe -avd Pixel_2_API_27 -no-snapshot -no-snapshot-load -no-snapshot-save -memory 512 -timezone Europe/Paris -no-boot-anim -no-audio -nocache
start %ANDROID_HOME%\tools\emulator.exe -avd Pixel_2_API_27_2 -no-snapshot -no-snapshot-load -no-snapshot-save -memory 512 -timezone Europe/Paris -no-boot-anim -no-audio -nocache
ping -n 20 127.0.0.1 >nul
adb devices



