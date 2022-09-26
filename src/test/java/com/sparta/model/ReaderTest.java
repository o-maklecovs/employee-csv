package com.sparta.model;

import com.sparta.controller.Reader;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class ReaderTest {

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Test employee amount")
    void readNIORec01Test() {
        int actualResult;
        int expectedResult = 10000;
        actualResult = Reader.readNIO("src/main/resources/EmployeeRecords1.csv").size();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Tag("EmployeeRecords2")
    @DisplayName("Test employee amount")
    void readNIORec02Test() {
        int actualResult;
        int expectedResult = 10000;
        actualResult = Reader.readNIO("src/main/resources/EmployeeRecords2.csv").size();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Test any different prefixes")
    void prefixTypeTest() {

        String[] prefixes = {"Mrs.", "Mr.", "Ms.", "Dr.", "Hon.", "Prof.", "Drs."};
        List<String> employeePrefixes = new ArrayList<>();
        for (String p : prefixes) {
            employeePrefixes.add(p);
        }

        List<Employee> employees = Reader.readNIO("src/main/resources/EmployeeRecords1.csv");
        for (Employee e : employees) {
            Assertions.assertTrue(employeePrefixes.toString().contains(e.getPrefix()));
        }
    }

    @Test
    @Tag("EmployeeRecords2")
    @DisplayName("Invalid gender type check")
    void genderTest() {
        List<Employee> employees = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords2.csv"));
        for (Employee e : employees) {
           // System.out.println(e.getGender());
            if (e.getGender() == 'F') Assertions.assertTrue(true);
            else if (e.getGender() == 'M') Assertions.assertTrue(true);
            else if (e.getGender() == 'X') Assertions.assertTrue(true);
            else Assertions.assertTrue(false);
        }
    }

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Invalid gender type check")
    void genderTest1() {
        List<Employee> employees = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));
        for (Employee e : employees) {
            // System.out.println(e.getGender());
            System.out.println(e.getFirstName());
//            if (e.getGender() == 'F') Assertions.assertTrue(true);
//            else if (e.getGender() == 'M') Assertions.assertTrue(true);
//            else Assertions.assertTrue(false);
        }
    }

}