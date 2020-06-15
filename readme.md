# BaseSelenium 

##### This project is designed in java to have a starter environment to test in seleium and appium.

## Support
	#NOTE this proyect only tested in Windows

Web  | Mobile
------------- | -------------
firefox  | Android
edge  | iOS
opera  |  
safari |  
google chrome  |  

## Requirement 
Java [Link](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).

Maven [Link](https://maven.apache.org/download.cgi).

Intellij [Link](https://www.jetbrains.com/idea/download/).

Android Studio [Link](https://developer.android.com/studio).

When installed Java JDK, download Maven in `%ProgramFiles%`.After open the terminal and execute with  `your version`

	@echo off
	SETX /M M2_HOME "%ProgramFiles%\apache-maven-3.6.3"
	SETX /M JAVA_HOME "%ProgramFiles%\Java\jdk1.8.0_251"
	SETX /M PATH "%PATH%;%M2_HOME%\bin"
	SETX /M PATH "%PATH%;%JAVA_HOME%\bin"

When intalled android open the terminal and execute

	@echo off
	SETX /M ANDROID_HOME "%LOCALAPPDATA%\Android\Sdk"
	SETX /M ANDROID_SDK_HOME "%SystemDrive%%HOMEPATH%\.android"
	SETX /M ANDROID_AVD_HOME "%SystemDrive%%HOMEPATH%\.android\avd"
	SETX /M PATH "%PATH%;%ANDROID_HOME%\platforms"
	SETX /M PATH "%PATH%;%ANDROID_HOME%\platform-tools"
	SETX /M PATH "%PATH%;%ANDROID_HOME%\tools"
	SETX /M PATH "%PATH%;%ANDROID_HOME%\tools\bin"

## Install
download the project and import it into Kotline.

### Sequence Run
                    
```seq
Java->RunCucumber.java: Init RunCucumber.java
RunCucumber.java->readProperties.java: Read properties
readProperties.java->RunCucumber.java: Readed properties
RunCucumber.java->Features: init feature
Features->RunCucumber.java: inited feature
RunCucumber.java->StartTypeDriver.java: StartTypeDriver
StartTypeDriver.java->Selenium.java: Init browser type
Selenium.java->webdrivermanager: download browser driver type
Selenium.java->webdrivermanager: Init browser type
webdrivermanager->Selenium.java: Inited browser type
Selenium.java->StartTypeDriver.java: Inited browser type
StartTypeDriver.java->Appium.java: Init mobile type
Appium.java->StartTypeDriver.java: Inited mobile type
StartTypeDriver.java->RunCucumber.java: Start test
RunCucumber.java->StartTypeDriver.java: End test
StartTypeDriver.java->RunCucumber.java: Ended test
RunCucumber.java->Java: Ended test
```

## Settings

setting file  `RunCucumber.properties` from web

	cucumber.typeDriver=selenium
	cucumber.typeBrowser=firefox
	cucumber.tags=--tags "@google"
	cucumber.enableDeleteOldDrivers=false
	#variables cucumber
	cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.typeBrowser}
	cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary
	cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/
	cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/

Setting file  `RunCucumber.properties` from mobile

	cucumber.typeDriver=appium
	urlServerAppium=http://127.0.0.1:4723/wd/hub
	cucumber.tags=--tags "@mobile"
	cucumber.mobilePlatform=Android
	cucumber.mobileLanguage=ES_es
	cucumber.app=test.apk
	cucumber.nameMobile=Pixel_2_API_27
	cucumber.versionMobile=8.1.0
	cucumber.adbName=emulator-5556
	#cucumber set
	cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.app}_${cucumber.nameMobile}
	cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary
	cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/
	cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/
    
    
----
## Run test
Open the terminal in the locate proyect and write

`start mvn post-integration-test -Dmaven.test.failure.ignore=true`

When the tests are complete, reports will have been generated in the  `reports` folder.

## Thank
>cluecumber-report-plugin [Link](https://github.com/trivago/cluecumber-report-plugin).

>webdrivermanager [Link](https://github.com/bonigarcia/webdrivermanager)

>editor.md[Link](https://pandao.github.io/editor.md/en.html)



