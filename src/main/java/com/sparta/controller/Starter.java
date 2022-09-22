package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static Logger logger= LogManager.getLogger(Starter.class);


    public static void start() {
        logger.info("starting.");

        DisplayManager display = new DisplayManager();
        List<Employee> empList= RemoveDup.duplicates(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));

        MySql db=MySql.getInstance();
        db.insertAll(empList);
    }

}
