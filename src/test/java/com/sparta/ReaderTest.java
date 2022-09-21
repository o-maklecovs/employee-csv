package com.sparta;

import com.sparta.controller.Reader;
import com.sparta.model.Employee;
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
        for (String s : prefixes) {
            employeePrefixes.add(s);
        }

        List<Employee> employees = Reader.readNIO("src/main/resources/EmployeeRecords1.csv");
        for (Employee e : employees) {
            Assertions.assertTrue(employeePrefixes.toString().contains(e.getPrefix()));
        }
    }

}