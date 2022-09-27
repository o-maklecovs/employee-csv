# Employee CSV project

This is a project for accessing data from a CSV file about employees.

## Employee type

The Employee class has all the data stored in the CSV file as parameters.
All are required by the constructor, this means corrupted data cannot be stored in an Employee object.

## Creating Employee

We have a static ```createEmp``` method in ```CreateEmployee``` class, which accepts a string (read from a CSV file), and outputs an ```Employee``` object.
 
The default values of the parameters in ```createEmp``` are ```null``` for ```Object``` child classes, -1 for ```ints```, and _ for chars,
these values are changed once we are able to parse the input string.

Anytime ```createEmp``` is unable to parse, it returns ```null``` and adds the string it was unable to parse calls to ```duplicatesList``` list.

## File reader

Uses the passed filename to access the CSV file, and creates an array with each line occupying one cell of the array.
Functional appraoch was used for this.

```java
Files.lines(Path.of(fname)).skip(1)
        .forEach(e -> employees.add(CreateEmployee.createEmp(e)));

```

```skip``` function was used to skip over the first line of the CSV file.

## Cleaning the data

We have a class for handling duplicates and corrupted data, ```CleanData```. It contains ```corrupted``` list for storing unparsable or corrupted data, and ```duplicates``` list for storing duplicates.

Methods ```duplicatesList``` and ```corruptedLine``` are used to populate these Lists.

```corrupted``` is populated from ```CreateEmployee``` class, via ```corruptedLine``` method. 

We have a ```removeDuplicates``` method, which returns a list with all the duplicates removed. It also populates the ```duplicates``` via the ```duplicatesList``` method.

## Database

```Db``` interface was created to be implemented by all database classes. In case of this project there is only one class (```MySql```) that implements ```Db```.

```MySql``` class contains two methods for inserting into (```insertAll```) and retrieving (```getEmployeeById```) from the database. There are also some additional methods: ```getInstance``` for getting an instance of a class (```MySql``` class uses a singleton pattern), ```getConnection``` for creating and returning a connection handle, ```createTable``` for creating a new table and ```migrateEmps```, which works in tandem with ```ThreadConnection``` class, for executing database queries in multithreaded mode.

```ThreadConnection``` class contains ```run``` method, which executes database insertion method. This class is used for executing database queries in multithreaded mode.

## View

```DisplayManager``` has three purposes:

* Printing information to the console
* Accepting and returning user input
* Validating user input

It has a number of methods that print out choices, results, input prompts and error messages.

## Starter/controller

```Starter``` class is the controller of this application, it calls ```DisplayManager```'s and model's (```MySql```, ```CleanData```, etc.) methods and contains a ```start``` method, which is a starting point of the application and is called in the ```main``` method.

## Testing

```Unit testing``` approach has been used in this project. ```Junit Jupiter``` dependency is added to do our test. For result comparison, ```Assertions``` class has been used to check expected & actual result.
> * ``` i.e. Assertions.assertEquals(employeeID, newEmp.getEmployeeID());```
```java
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
</dependency>
```
Also, ```Java Faker``` library dependency added into Maven to create data for testing purposes.
Basically, some methods from different classes are tested on different cvs files to check methods are working properly as intended.
```java

<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```


## Timing

The ```insertAll``` method is being timed in different configurations of the program. This is done via System.nanoTime().

For single threaded program: 2298806133 nanoseconds

For multithreaded program (4 threads): 3484584200 nanoseconds
