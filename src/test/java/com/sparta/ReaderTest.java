package com.sparta;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Test employee amount")
    void readNIORec01Test() {
        int actualResult;
        int expectedResult = 10000;
        actualResult = Reader.readNIO("src/main/resources/EmployeeRecords1.csv").size();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @Tag("EmployeeRecords2")
    @DisplayName("Test employee amount")
    void readNIORec02Test() {
        int actualResult;
        int expectedResult = 10000;
        actualResult = Reader.readNIO("src/main/resources/EmployeeRecords2.csv").size();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Test prefixes")
    void prefixTypeTest() {

        int totalEmp = Reader.readNIO("src/main/resources/EmployeeRecords1.csv").size();
        String[] prefixes = {"Mrs.", "Mr.", "Ms.", "Dr.", "Hon.", "Prof.", "Drs."};

        for (int i = 0; i < totalEmp; i++) {

            //if ((employee = (Reader.readNIO("src/main/resources/EmployeeRecords1.csv").get(i)) == ) {

            }

        }



}