@echo off
(echo typeDriver=selenium & echo #set selenium & echo browser=firefox & echo #set appium & echo mobilePlatform=Android & echo mobileLanguage=ES_en & echo #set android & echo android_app=test.apk & echo android_mobile=Pixel_2_API_27 & echo android_v_mobile=8.1.0 & echo #set ios & echo iphone_name=iPhone Simulator & echo iphone_v=7.1.0 & echo iphone_app=test.ipa ) > src\test\java\RunCucumber.properties
mvn clean test -P internet


