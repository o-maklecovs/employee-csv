package com.sparta.controller;

import com.sparta.view.DisplayManager;

public class Starter {

    public static void start() {

        // DisplayManager
        DisplayManager display = new DisplayManager();
        RemoveDup.duplicates((Reader.readNIO("src/main/resources/EmployeeRecords1.csv")));
      //  display.printResultsFromList(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));

    }

}
