package com.sparta.model;

import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CleanData {
    public static Logger logger= LogManager.getLogger(Starter.class);

    // Dupes and corrupted lists and getters
    private static ArrayList<String> corrupted = new ArrayList<>();
    private static List<Employee> duplicates = new ArrayList<>();

    public static ArrayList<String> getCorrupted() {
        return corrupted;
    }
    public static List<Employee> getDuplicates() {
        return duplicates;
    }

    public static List<Employee> duplicates(List<Employee> mainList){
        logger.info("Removing duplicates");

        ArrayList<Employee> duplicates = new ArrayList<>();
        ArrayList<Employee> newEmp = new ArrayList<>();


        for (Employee emp:mainList) {
            try {
                if (Collections.frequency(newEmp, emp) < 1) {
                    newEmp.add(emp);
                } else {
                    duplicates.add(emp);
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }
        CleanData dup = new CleanData();
        duplicatesList(duplicates);
        return newEmp;
    }
    public static void duplicatesList(List<Employee> dupes){duplicates.addAll(dupes);}

    public static void corruptedLine(String line){corrupted.add(line);}

    public static boolean employeeNullCheck(Employee emp){return emp == null;}

}
