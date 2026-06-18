Student Record Managment System.

This is a simple college project made in Java. I wrote this program to practise basic programming concepts in a way that is easy to understand. The program helps manage student records using a menu in the console.

The program can add a student, search for a student by id, update student details, delete a student, and display all students. It can also save and load student data using text files, binary files, and serialized files. There is also a report feature, a file properties feature, and a backup featre.

How to run the program.

Open the project in IntelliJ IDEA, or any Java IDE. Run Main.java. The program starts in the console and shows a menu. Enter the number of the option you want to usee.

Main features.

Add student records.
Search student records by id.
Update student records.
Delete student records.
Display all student records.
Save data in text, binary, and serialized format.
Load data from text, binary, and serialzed format.
Generate a simple student report.
Show file properties.
Create a backup file.

Project structure.

The src folder contains the Java source code. The data folder stores the saved student files for the programe.

Main.java handles the menu and user input.
Student.java stores student details.
StudentManager.java manages the list of students.
TextFileManager.java saves and loads text data.
BinaryFileManager.java saves and loads binary data.
SerialFileManager.java saves and loads serialized data, and also creates backups.
ReportGenerator.java prints a student report.
FileUtil.java prepares the data files and shows file details.

What I learned from this project.

I learned how to use classes and objects in Java. I learned how to use a list to manage records. I learned how file handling works in different formats. I also learned how to split one program into smaller classes so the code is easier to raed.

Important note.

When the program starts, it loads data from the text file. If you make changes and want to keep them, use the save option from the menu befor closing it.
