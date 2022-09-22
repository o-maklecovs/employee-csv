package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {
    public static Logger logger= LogManager.getLogger(Starter.class);

    public static MySql dbManager = MySql.getInstance();

    public static DisplayManager display = new DisplayManager();

    public static void start() {
        logger.info("starting.");

        display.intro();
        parseChoice(display.getChoice(new int[]{1}));
        display.askSecondary();
        parseChoice(display.getChoice(new int[]{1,2}));

    }

    public static void parseChoice(int choice){
        switch (choice) {
            case 1 -> dbManager.insertAll( // Insert
                    CleanData.duplicates( // Remove dupes
                            Reader.readNIO("src/main/resources/EmployeeRecords1.csv")));
            case 2 -> display.printBadData(); // For later
        }
    }

}
