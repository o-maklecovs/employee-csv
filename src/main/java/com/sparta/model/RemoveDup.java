package com.sparta.model;

import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDup {
    public static Logger logger= LogManager.getLogger(Starter.class);

    public static List<Employee> duplicates(List<Employee> mainList){
        logger.info("Removing duplicates");

        ArrayList<Employee> duplicates = new ArrayList<>();
        ArrayList<Employee> newEmp = new ArrayList<>();


        for (Employee emp:mainList) {
            try {
                if (Collections.frequency(newEmp, emp) < 1) {
                    //System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " + emp.getEmployeeID());
                    newEmp.add(emp);
                } else {
                    duplicates.add(emp);
                }
            } catch (Exception e) {
                logger.error(e);
            }

        }

        RemoveDup dup = new RemoveDup();
        dup.duplicatesList(duplicates);
        return newEmp;
    }

    public void duplicatesList(List<Employee> dupes){
        System.out.println("\n"+"\n" + "THESE ARE THE DUPLICATES");
        for (Employee e : dupes) System.out.println(e.getFirstName() + " " + e.getLastName()+ " "+e.getEmployeeID());
    }


}
