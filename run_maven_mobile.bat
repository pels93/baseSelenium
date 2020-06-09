@echo off
(echo typeDriver=appium & echo #set selenium & echo browser=edge & echo #set appium & echo mobilePlatform=Android & echo mobileLanguage=ES_fr & echo #set android & echo android_app=test.apk & echo android_mobile=Pixel_2_API_27 & echo android_v_mobile=8.1.0 & echo #set ios & echo iphone_name=iPhone Simulator & echo iphone_v=7.1.0 & echo iphone_app=test.ipa ) > src\test\java\RunCucumber.properties
start %ANDROID_HOME%\tools\emulator.exe -avd Pixel_2_API_27 -no-snapshot -no-snapshot-load -no-snapshot-save -memory 512 -timezone Europe/Paris -no-boot-anim -no-audio -nocache
ping -n 20 127.0.0.1 >nul
mvn clean test -P mobile
pause


