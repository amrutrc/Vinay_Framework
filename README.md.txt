# Signzy Assignment

I have created Hybrid(Method and Data) framework with Page Object Model Design with Page Factory.
***Programming Language used- Java, Selenium 
***Build tool used- Maven
***Testing Framework- TestNG
***Reporting - Extent Report
***Compatible Browsers- Chrome, Firefox

Explaination:
*** All the Locators are stored in POM classes(1 POM Class for each screen). Location- src/main/java/com/signzy/pageobjects
*** Test data is Stored in testProp.property file Location - Signzy/SignzySelenium/testdata/properties
*** All the Tests are present in ScenarioSignzy class. Location- src/test/java/com/flipkart/tests
*** Extent report is generated in Reports folder. 
    -extent report generates beautiful html report with logs and screenshots attached.
*** TestNG report is also generated under test-output folder
*** included all the dependencies in pom xml.
*** Chrome and geckdrivers are present in drivers folder.
*** Setup class under com.signzy.Init package contains script for Webdriver intialization, setting Timeout etc

To Run:
1. We can run using command prompt: Go to Project Directory, run : mvn clean install
2. we Can import the project "SignzySelenium" and run testNG xml from eclipse.
3. Framework has been developed on the windows platform, to run this on MAC, please change the drivers(chrome and gecko) along with the path to the same


