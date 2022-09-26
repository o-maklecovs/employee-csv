package com.sparta.model;

import com.sparta.controller.Reader;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sparta.model.CleanData.*;
import static org.junit.jupiter.api.Assertions.*;

class CleanDataTest {

    @Test
    @DisplayName("Testing to check are there any duplicates in clean record.")
    void duplicatesTest() {
        List<Employee> emp = Reader.readNIO("src/main/resources/EmployeeRecords1.csv");
        Assertions.assertFalse(removeDuplicates(emp).contains(getCorrupted()));
    }

    @Test
    @Tag("EmployeeRecords1")
    @DisplayName("Test for duplicates & unique employees total equals 10000")
    void testTotalRecord01() {

        List<Employee> totalCleaned = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));
        int dups = getDuplicates().size();
        int expectedResult = 10000;
        Assertions.assertTrue((totalCleaned.size()+dups) == expectedResult);

    }

    @Test
    @Tag("EmployeeRecords2")
    @DisplayName("Test for duplicates & unique employees total equals 10000")
    void testTotalRecord02() {

        List<Employee> totalCleaned = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords2.csv"));
        int dups = getDuplicates().size();
        int expectedResult = 10000;
        Assertions.assertTrue((totalCleaned.size()+dups) == expectedResult);

    }


    @Test
    @DisplayName("")
    void testDuplicates() {
        List<Employee> totalCleaned = CleanData.removeDuplicates(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));

    }


}