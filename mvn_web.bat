@echo off
start mvn clean
ping -n 10 127.0.0.1 >nul
(echo cucumber.typeDriver=selenium& echo cucumber.typeBrowser=chrome& echo cucumber.tags=--tags "@web"& echo cucumber.enableDeleteOldDrivers=false& echo #variables cucumber& echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.typeBrowser}& echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary& echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/& echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start mvn post-integration-test -Dmaven.test.failure.ignore=true
ping -n 20 127.0.0.1 >nul
(echo cucumber.typeDriver=selenium& echo cucumber.typeBrowser=edge& echo cucumber.tags=--tags "@web"& echo cucumber.enableDeleteOldDrivers=false& echo #variables cucumber& echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.typeBrowser}& echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary& echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/& echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start mvn post-integration-test -Dmaven.test.failure.ignore=true
ping -n 20 127.0.0.1 >nul
(echo cucumber.typeDriver=selenium& echo cucumber.typeBrowser=firefox& echo cucumber.tags=--tags "@web"& echo cucumber.enableDeleteOldDrivers=false& echo #variables cucumber& echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.typeBrowser}& echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary& echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/& echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start mvn post-integration-test -Dmaven.test.failure.ignore=true
ping -n 20 127.0.0.1 >nul
(echo cucumber.typeDriver=selenium& echo cucumber.typeBrowser=opera& echo cucumber.tags=--tags "@web"& echo cucumber.enableDeleteOldDrivers=false& echo #variables cucumber& echo cucumber.TypeTest=${cucumber.typeDriver}_${cucumber.typeBrowser}& echo cucumber.report=--plugin json:reports/json/${cucumber.TypeTest}/report.json --plugin pretty --plugin summary& echo cumcumber.reportHTML=reports/html/${cucumber.TypeTest}/& echo cumcumber.reportJSON=reports/json/${cucumber.TypeTest}/) > src\test\java\RunCucumber.properties
start mvn post-integration-test -Dmaven.test.failure.ignore=true
