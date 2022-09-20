package com.sparta;

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
        List<Employee> employees = new ArrayList<>();
        try {
            boolean flag = true;
            for (Object line : Files.lines(Path.of(fname)).toArray()) {
                if (!flag) {
                    System.out.println(line);
                    employees.add(CreateEmployee.createEmp((String) line));
                }
                else flag = false;
            }
            for (Employee e : employees) System.out.println(e.getFirstName() + " " + e.getLastName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}