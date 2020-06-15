@echo off
adb kill-server
adb kill-server
mvn clean
cls
(echo cucumber.typeDriver=appium&echo urlServerAppium=http://127.0.0.1:4723/wd/hub&echo cucumber.tags=--tags "@mobile"&echo cucumber.mobilePlatform=Android&echo cucumber.mobileLanguage=ES_en&echo cucumber.app=test.apk&echo cucumber.nameMobile=Pixel_2_API_27&echo cucumber.versionMobile=8.1.0&echo cucumber.adbName=emulator-5556&echo #cucumber set&echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.app}_${cucumber.nameMobile}&echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary&echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/&echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start %ANDROID_HOME%\tools\emulator.exe -avd Pixel_2_API_27 -no-snapshot -no-snapshot-load -no-snapshot-save -memory 512 -timezone Europe/Paris -no-boot-anim -no-audio -nocache
start %ANDROID_HOME%\tools\emulator.exe -avd Pixel_2_API_27_2 -no-snapshot -no-snapshot-load -no-snapshot-save -memory 512 -timezone Europe/Paris -no-boot-anim -no-audio -nocache
ping -n 30 127.0.0.1 >nul
adb devices
adb devices
cls
start mvn post-integration-test -Dmaven.test.failure.ignore=true
ping -n 20 127.0.0.1 >nul
(echo cucumber.typeDriver=appium&echo urlServerAppium=http://127.0.0.1:4723/wd/hub&echo cucumber.tags=--tags "@mobile"&echo cucumber.mobilePlatform=Android&echo cucumber.mobileLanguage=ES_en&echo cucumber.app=test.apk&echo cucumber.nameMobile=Pixel_2_API_27_2&echo cucumber.versionMobile=8.1.0&echo cucumber.adbName=emulator-5554&echo #cucumber set&echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.app}_${cucumber.nameMobile}&echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary&echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/&echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start mvn post-integration-test -Dmaven.test.failure.ignore=true


