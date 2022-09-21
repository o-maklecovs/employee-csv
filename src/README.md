# Employee CSV project


This is a project for accessing data from a CSV file about employees.

### Employee type
The Employee class has all the data stored in the CSV file as parameters.
All are required by the constructor, this means corrupted data cannot be stored in an Employee object.
This might change later depending on how corrupted data will be handled.

### Creating Employees
We have a static createEmp method in CreateEmployee class, which accepts a string (read from a CSV file), and outputs and Employee object.
</br> 
It currently uses java.util.Date for dates. This might later change to java.sql.Date
</br> 
If createEmp method cannot cast a line to the required type, it will set it to a null for Object child classes, to -1 for ints, and to '_' for chars.
### Reader
Uses the passed filename to access the CSV file, and creates an array with each line occupying one cell of the array.
We iterate over this array
```java
for (Object line : Files.lines(Path.of(fname)).toArray())
```
We use a boolean to ignore the first (heading) line of the file.




