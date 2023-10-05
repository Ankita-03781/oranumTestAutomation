#1. Project Overview
###Its a test automation project that tests the functionalities of website - http://www.oranum.com/ 

##It covers test cases for below functionalities

###- Searching for partial text should display only matching psychics.

###- Validate that the buttons will trigger a 'Sign up' overlay to be displayed

###- On the home page, selecting different topics should display only matching psychics.

#2. Installation Instructions

####Prerequisites - Java 8, IDE like Eclipse or IntelliJ, Cucumber plugin in eclipse

####Clone the project from the git repository

####Open the project in eclipse/IntelliJ

####Run the test runner file in package - /src/test/java/com/oranum/TestRunner.java

####Right click -> Run as -> Junit

####After successful run, report will be generated inside target/cucumber-reports folder

#3. Usage Guide
####The cucumber feature files gives a clear view of the requirement under test. These files are located at path - /workflow/src/test/resources/features/

####All the step definition files are located here - /workflow/src/test/java/stepsDef

####The Webdriver is being managed through class - /workflow/src/test/java/driverUtil/DriverManager.java

####This class is extended in all the stepDefs in order to use the driver in all the test cases

###It follows a Page Object Modal, the page related methods and their xpaths are maintained in this class - /workflow/src/test/java/pages/OranumHomePage.java
