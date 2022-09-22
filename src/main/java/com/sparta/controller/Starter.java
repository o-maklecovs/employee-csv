package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {
    public static Logger logger= LogManager.getLogger(Starter.class);

    public static void start() {
        logger.info("starting.");

        MySql dbManager = MySql.getInstance();
        DisplayManager display = new DisplayManager();

        dbManager.insertAll( // Insert
                CleanData.duplicates( // Remove dupes
                Reader.readNIO("src/main/resources/EmployeeRecords1.csv")));
        display.printBadData();
    }

}
