package com.sparta.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.model.CreateEmployee.createEmp;
import static com.sparta.model.JavaFaker.getJavaFaker;

class CreateEmployeeTest {


    @Test
    @DisplayName("Test")
    void createEmpTest() {
        int employeeID = -12345;
        String prefix = "Mr";
        String firstName = "J0hn";
        char middleInitial = 'Ω';
        String lastName = "";
        char gender = 'Z';
        String mail = getJavaFaker().internet().emailAddress();
        java.util.Date dob = getJavaFaker().date().birthday();

        java.util.Date employmentDate = getJavaFaker().date().birthday();
        int salary = -123456;

        //createEmp(employeeID,prefix,firstName,middleInitial,lastName,gender,mail,dob,employmentDate,salary);


    }
}