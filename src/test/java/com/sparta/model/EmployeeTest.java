package com.sparta.model;

import com.sparta.controller.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeTest {

    @Test
    @Tag("EmployeeRecords2")
    @DisplayName("Testing getEmployeeID method")
    void testGetEmployeeID() throws ParseException {
        Employee emp = new Employee(178566,"Mrs.","Juliette",'M',"Rojo",
                'F',"juliette.rojo@yahoo.co.uk",new SimpleDateFormat("MM/dd/yyyy").parse("5/8/1967"),
                new SimpleDateFormat("MM/dd/yyyy").parse("6/4/2011"),193912);

        int expected = emp.getEmployeeID();;
        int actual = 0;

        List<Employee> totalCleaned = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords2.csv"));
        for(Employee e : totalCleaned) {
            if(e.getSalary() == expected){
                actual = expected;
            }
        }
        Assertions.assertEquals(expected,actual);

    }
}
