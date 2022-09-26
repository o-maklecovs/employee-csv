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
The default values of the parameters in createEmp are null for Object child classes, -1 for ints, and '_' for chars,
these values are changed once we are able to parse the input string.
<br/>
Anytime createEmp is unnable to parse, it returns null and adds the string it was unable to parse calls ```duplicatesList(List<Employee> dupes)``` to add the String to the list of corrupted data.
### Reader
Uses the passed filename to access the CSV file, and creates an array with each line occupying one cell of the array.
We use lambdas to add al
```java
Files.lines(Path.of(fname)).skip(1)
        .forEach(e -> employees.add(CreateEmployee.createEmp(e)));

```
We use a boolean to ignore the first (heading) line of the file.


## Cleaning the Data
We have once class for handling duplicates and corrupted data, CleanData.
This contains two lists ``` ArrayList<String> corrupted ``` for storing imparseable or corrupted data, 
and ```List<Employee> duplicates``` for storing duplicates. 
<br/>
Methods ```public static void duplicatesList(List<Employee> dupes)``` 
and ```public static void corruptedLine(String line)``` are used to populate these Lists.
<br/>

``` corrupted ``` is populated from CreateEmployee class, via 
```corruptedLine``` method. 
<br/>
We have a ```public static List<Employee> removeDuplicates(List<Employee> mainList)``` method,
which returns a List with all of the duplicates removed. It also populates the ```List<Employee> duplicates``` via the ```corruptedLine``` method.

## Testing


## Timing
The ```insertAll``` method is being timed in different configurations of the program.
This is done via System.nanoTime().
<br/>
For single threaded program:
2298806133 nanoseconds
<br/>
For multi-threaded program (4 threads):
3484584200 nanoseconds



