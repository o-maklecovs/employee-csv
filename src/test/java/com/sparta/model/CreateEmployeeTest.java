package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.sparta.model.CreateEmployee.createEmp;
import static com.sparta.model.JavaFaker.getJavaFaker;

class CreateEmployeeTest {


    @Test
    @DisplayName("Testing employee creating method with valid inputs")
    void createEmpTest() throws ParseException {
        int employeeID = getJavaFaker().number().numberBetween(100_000, 1_000_000);
        String prefix = "Mr.";
        String firstName = getJavaFaker().name().firstName();
        char middleInitial = getJavaFaker().name().nameWithMiddle().charAt(0);
        String lastName = getJavaFaker().name().lastName();
        char gender = 'F';
        String mail = getJavaFaker().internet().emailAddress(firstName + "." + middleInitial + "." + lastName);
        String dob = "11/16/1997";
        String employmentDate = "12/29/2019";
        int salary = 12340;


        String line = employeeID + "," + prefix + "," + firstName + "," + middleInitial + "," + lastName + "," + gender + "," + mail + "," + dob + "," + employmentDate + "," + salary;
        Employee newEmp = createEmp(line);

            Assertions.assertEquals(employeeID, newEmp.getEmployeeID());
            Assertions.assertEquals(firstName, newEmp.getFirstName());
            Assertions.assertEquals(prefix, newEmp.getPrefix());
            Assertions.assertEquals(new SimpleDateFormat("MM/dd/yyyy").parse(dob), newEmp.getDob());
            Assertions.assertEquals(middleInitial, newEmp.getMiddleInitial());

    }
}