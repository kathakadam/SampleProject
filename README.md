# Instructions and Notes

Package Layout
1. com.SampleProject.test package has the base test case
2. commonFunctions package has methods which will be reused by all test cases. It includes reporting methods, driver handling methods
and listener class methods.
3. pageFunctions package has class files for each page functionality.

Reporting
1. Report folder(at project level) has report.html file which provides the status of the test run.

TestNG xml
1. Cross browser testing and parallel testing have been inplemented. Thread-count can be changed to 2.
2. File location: test-output>testng.xml
3. parameter tag has browser and url value browser values allowed "chrome" and "firefox"


Listner Class
1. onStart method invokes methods before running TestNG Suite
2. onFinish method invokes methods after running TestNG Suite

# Changes to be made in the code before starting execution: below mentioned point to be followed
After you download the project, edit the System.Setproperty(as per local machine setting) for chromedriver.exe and geckodriver.exe in below mentioned file
src/test/java > commonFunctions > HandleDriver

# How to start execution
Right click testng.xml file and Select RunAs>TestNG Suite.
