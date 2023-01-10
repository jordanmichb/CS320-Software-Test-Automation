# CS320-Software-Test-Automation
<b> About the Project </b>

This preliminary appointment system contains a class for contacts, appointments, and tasks. The purpose of this project was to create a class for each of these objects, and to create service classes for each object type that can perform actions on the objects. Test classes are then used so that JUnit testing could be performed. The aim of the JUnit testing was to implement test cases that would verify correct code functionality and to ensure 100% code coverage.



<b> Project Functionality </b>

The Contact, Appointment, and Task classes hold the information for each object, validate input for each variable, and contain setter and getter methods to modify or access these variables. If the input is not valid, an exception is thrown. The Service classes are used for storing and operating on these objects. For example, Contact.java will be used to create an instance of Contact, and ContactService.java will create a HashMap to store Contact objects and has methods for adding, deleting, getting, and updating contacts. There are test classes for each object class and for each object service class. They create test cases that verify that all methods work as expected, that input validation works correctly, and that there is 100% code coverage of the object and service classes.

<br>
<br>

<b> Tools Used </b>

JUnit
<br>
&emsp;•	A testing framework to be used with Java that supports test-driven development of programs.

<br>
<br>

<b> Reproducing the Project </b>

•	Open the files in Eclipse
<br>
•	Navigate to the test class of the file that you would like to test
<br>
•	To run just a JUnit test to verify the code functionality: right click, click on "Run As", and select "JUnit Test".
<br>
•	To run a test to verify code functionality and to view code coverage: right click, click on "Coverage As", and select "JUnit Test".
