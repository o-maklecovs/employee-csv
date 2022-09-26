package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

import java.util.Scanner;

public class Starter {
    public static Logger logger= LogManager.getLogger(Starter.class);
    public static MySql dbManager = MySql.getInstance();
    public static DisplayManager display = new DisplayManager();
    private static String fileName = null;

    private static boolean start = true;
    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(int choice) {
        switch(choice){
            case 1 -> fileName = "src/main/resources/EmployeeRecords1.csv";
            case 2 -> fileName = "src/main/resources/EmployeeRecords2.csv";
            case 3 -> fileName = "src/main/resources/EmployeeRecordsLarge.csv";
        }
    }

    public static void start() {
        logger.info("starting.");

        dbManager.createTable();
        while(start){
            runStageOne();
            runStageTwo();
        }
    }

    public static void parseChoiceStage(int choice, int stage){

        switch (stage) {
            case 1: // Stage one
                switch (choice) {
                    case 1 -> {
                        display.displayFiles();
                        setFileName(display.getChoice(new int[]{1, 2, 3}));
                        dbManager.migrateEmps(CleanData.duplicates(Reader.readNIO(fileName)));
                    }
                    case 2 -> runIdSearch();
                }
                break;
            case 2: // Stage 2
                switch(choice){
                    case 1 -> runStageOne();
                    case 2 -> display.printBadData();
                    case 3 -> runIdSearch();
                    case 4 -> {
                        System.out.println("Exiting program...");
                        start = false;
                    }
                }
        }
    }

    public static void runStageOne(){
        display.stageOne();
        parseChoiceStage(display.getChoice(new int[]{1, 2}), 1);
    }

    public static void runStageTwo(){
        display.stageTwo();
        parseChoiceStage(display.getChoice(new int[]{1, 2, 3, 4}), 2);
    }

    public static void runIdSearch(){
        display.displaySearchById();
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        display.printEmployeeID(dbManager.getEmployeeById(id));
    }
}
