@echo off
start mvn cluecumber-report:reporting -Dcumcumber.reportHTML=reports/html/selenium_firefox/ -Dcumcumber.reportJSON=reports/json/selenium_firefox/ 
start mvn cluecumber-report:reporting -Dcumcumber.reportHTML=reports/html/selenium_edge/ -Dcumcumber.reportJSON=reports/json/selenium_edge/
start mvn cluecumber-report:reporting -Dcumcumber.reportHTML=reports/html/selenium_chrome/ -Dcumcumber.reportJSON=reports/json/selenium_chrome/
start mvn cluecumber-report:reporting -Dcumcumber.reportHTML=reports/html/selenium_opera/ -Dcumcumber.reportJSON=reports/json/selenium_opera/
start mvn cluecumber-report:reporting -Dcumcumber.reportHTML=reports/html/appium_android/ -Dcumcumber.reportJSON=reports/json/appium_android/
exit