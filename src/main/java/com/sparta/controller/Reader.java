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
import java.util.stream.Stream;

public class Reader {

    public static Logger logger= LogManager.getLogger(Starter.class);

    public static List<Employee> readNIO(String fname) {
        CleanData.makeNull();
        logger.trace("starting a readNIO method");
        List<Employee> employees = new ArrayList<>();
        try {
            Files.lines(Path.of(fname)).skip(1)
                    .forEach(e -> employees.add(CreateEmployee.createEmp(e)));
//            boolean flag = true;
//            for (Object line : Files.lines(Path.of(fname)).toArray()) {
//                if (!flag) {
//                    employees.add(CreateEmployee.createEmp((String) line));
//                }
//                else {flag = false; logger.trace("skipping the heading line of the csv file");}
//            }
            //for (Employee e : employees) System.out.println(e.getFirstName() + " " + e.getLastName());
        } catch (IOException e) {
            logger.error("Error in iterating over CSV file: ");
            logger.error(e.getMessage());
        }
        return employees;
    }

}
