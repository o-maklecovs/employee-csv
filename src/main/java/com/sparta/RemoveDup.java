package com.sparta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDup {
    public static List<Employee> duplicates(List<Employee> mainList){

        ArrayList<Employee> duplicates = new ArrayList<>();
        ArrayList<Employee> newEmp = new ArrayList<>();


        for (Employee emp:mainList) {

            if (Collections.frequency(newEmp,emp)<1){
                System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " +emp.getEmployeeID());
                newEmp.add(emp);
            }
//            if (Collections.frequency(mainList, emp) > 1) {
//                System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " +emp.getEmployeeID());
//                duplicates.add(emp);
//                mainList.remove(emp);
//            }
        }
        return newEmp;
    }
}
