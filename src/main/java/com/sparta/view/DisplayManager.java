package com.sparta.view;

import com.sparta.controller.Starter;
import com.sparta.model.CleanData;
import com.sparta.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class DisplayManager {

    public static Logger logger = LogManager.getLogger(DisplayManager.class); // Logger

    // Intro example to be edited later
    public void intro(){

        System.out.println("--------------Employee Database Manager--------------");
        System.out.println("""
                Chose option to run:\s
                1. Run program
                -----------------------------------------------------""");
    }

    // Displays choice for showing bad data
    public void askSecondary(){
        System.out.println("""
                            -----------------------------------------------------
                            Chose option to run
                            1. Run again
                            2. Display duplicates and Corrupted lines
                            3. Search for employee ID
                            """);
    }


    // Gets an input of list of numbered options to be passed to controller class
    public int getChoice(int[] choices){

        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean validInt = false;

        do {
            try {
                validInt = true;
                input = scan.nextInt();
                logger.info("Custom validation.....");
                if (!validateInput(input, choices)){
                    throw new InputMismatchException("Choice outside of accepted values");
                }
            } catch (InputMismatchException e){
                logger.error(e.getMessage(), e);
                scan.next();
                validInt = false;
                printChoices(choices);
            }
        } while (!validInt);
        return input;
    }

    // Validates input is part of expected choices
    boolean validateInput(int input, int[] choices){

        for (int choice : choices){
            if (choice == input){
                logger.info("Input valid");
                return true;
            }
        }
        printChoices(choices);
        logger.info("Invalid");
        return false;
    }

    // Prints allowed options if invalid
    void printChoices(int[] choices){
        System.out.println("Please enter either:");
        for (int choice: choices) {
            System.out.print(choice + ", ");
        }
        System.out.println("\n");
    }

    public void printResultsFromList(List<Employee> employees) {
        for (Employee e : employees){
            System.out.println("-----------------------------------------------------");
            System.out.println(
                    e.getEmployeeID()   + " | " +
                    e.getPrefix()       + " | " +
                    e.getFirstName()    + " | " +
                    e.getLastName());
        }
    }

    public void printBadData(){

        System.out.println("-----------------------------------------------------");
        System.out.println("Duplicates: ");
       // long start = System.nanoTime();
        printResultsFromList(CleanData.getDuplicates());
       // long finish = System.nanoTime();
       // long timeElapsed = finish - start;
     //   System.out.println("total time-"+timeElapsed+" Nanoseconds");
        System.out.println("-----------------------------------------------------");
        System.out.println("Corrupted csv lines: ");
        for (String line: CleanData.getCorrupted()){System.out.println(line);}

    }

    public void printEmployeeID(Employee e){
        System.out.println("-----------------------------------------------------");
        System.out.println(
                e.getEmployeeID()   + " | " +
                e.getPrefix()       + " | " +
                e.getFirstName()    + " | " +
                e.getLastName());
    }

}
