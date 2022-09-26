package com.sparta.controller;

import com.sparta.model.CleanData;
import com.sparta.model.CreateEmployee;
import com.sparta.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Reader {

    public static Logger logger= LogManager.getLogger(Starter.class);

    public static List<Employee> readNIO(String fname) {
        CleanData.makeNull();
        logger.trace("starting a readNIO method");
        List<Employee> employees = new ArrayList<>();
        try {
            Files.lines(Path.of(fname)).skip(1)
                    .forEach(e -> employees.add(CreateEmployee.createEmp(e)));
        } catch (IOException e) {
            logger.error("Error in iterating over CSV file: ");
            logger.error(e.getMessage());
        }
        return employees;
    }

}
