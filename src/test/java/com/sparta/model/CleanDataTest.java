package com.sparta.model;

import com.sparta.controller.Reader;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sparta.model.CleanData.*;
import static org.junit.jupiter.api.Assertions.*;

class CleanDataTest {

    @Test
    @DisplayName("Testing to check are there any duplicates in clean record.")
    void duplicatesTest() {
        List<Employee> emp = Reader.readNIO("src/main/resources/EmployeeRecords1.csv");
        Assertions.assertFalse(duplicates(emp).contains(getCorrupted()));
    }

    @Test
    @DisplayName("Test for duplicates & unique employees total equals 10000")
    void testDuplicateData() {

        List<Employee> totalCleaned = CleanData.duplicates(Reader.readNIO("src/main/resources/EmployeeRecords2.csv"));
        int dups = getDuplicates().size();
        int expectedResult = 10000;
        Assertions.assertTrue((totalCleaned.size()+dups) == expectedResult);

    }

    @Test
    @DisplayName("")
    void testDuplicates() {
        List<Employee> totalCleaned = CleanData.duplicates(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));

    }


}