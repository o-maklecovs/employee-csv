package com.sparta;

import com.sparta.view.DisplayManager;

public class Starter {

    public static void start() {

        // DisplayManager
        DisplayManager display = new DisplayManager();
        display.printResultsFromList(Reader.readNIO("src/main/resources/EmployeeRecords1.csv"));

    }

}
