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

Appium Desktop [Link](http://appium.io/downloads.html).

When installed **Java JDK**, download **Maven** run as Administrator
	
 
	set_variables_javaMaven_1.bat
	set_variables_javaMaven_2.bat

When installed **Android Studio** run as Administrator

	@echo off
	set_variables_android_1
	set_variables_android_2

When run **Intellij** install the plugins `Cucumber for Java` and `Gherkin`


## Install
download the project and import it into Intellij.

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

##Structure of the program
Directory  | Functionality
------------- | -------------
baseSelenium\src\test\features  | Contains the .features
baseSelenium\src\test\java\driver  | Contains the typeDriver Appium and Selenium
baseSelenium\src\test\java\page   |  Contains the mapped elements
baseSelenium\src\test\java\steps  |  Contains the features steps


## Settings
The file `RunCucumber.properties` is `baseSelenium\src\test\java`

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
## Write Steps
With **appium** you need declare in your page.class
    
	public MobileElement clear = Appium.utilsMobileElements.findElementById("backspace");
	public MobileElement clear = (MobileElement) Appium.driver.findElement(By.id("backspace"));

With **selenium** you need declare in your page.class
 
 	public WebElement barra = Selenium.utilsWebElements.findElementByName("q");
 	public WebElement barra = Selenium.driver.findElement(By.id("q"));


## Run test
If you like run test in **Java**, run the class RunCucumber_Test.class

	#NOTE in this mode cucumber.tags is read from RunCucumber_Test.class

If you like run test in **maven**, open the terminal in the locate proyect and write

	mvn_web
	mvn_mobile

When the tests are complete, reports will have been generated in the  `baseSelenium\reports`.

## Thank
>cluecumber-report-plugin [Link](https://github.com/trivago/cluecumber-report-plugin).

>webdrivermanager [Link](https://github.com/bonigarcia/webdrivermanager)

>editor.md[Link](https://pandao.github.io/editor.md/en.html)



