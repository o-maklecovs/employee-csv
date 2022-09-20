package com.sparta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public  class CreateEmployee {

    public static Logger logger= LogManager.getLogger(Starter.class);

    public  static Employee createEmp(String line){
        // Split line and create Employee object
        String[] arr= line.split(",");
        logger.info("Line split: " + Arrays.toString(arr));

        int id=Integer.parseInt(arr[0]);
        String prefix = arr[1];
        String fName = arr[2];
        char initial = arr[3].charAt(0);
        String lName = arr[4];
        char gender = arr[5].charAt(0);
        String mail = arr[6];
        java.util.Date dob = null;
        java.util.Date employmentDate = null;

        try {
            dob = new SimpleDateFormat("MM/dd/yyyy").parse(arr[7]);
//            dob = (Date) new SimpleDateFormat("MM/dd/yyyy").parse(arr[7]); // Error line (With cast)
            employmentDate = new SimpleDateFormat("MM/dd/yyyy").parse(arr[8]);
        } catch (Exception e) { // Here
            logger.error("Date not formatted mm/dd/yyyy");
            logger.error(e.getMessage());
        }

        int salary=Integer.parseInt(arr[9]);

        return new Employee(id, prefix, fName, initial, lName, gender, mail, dob, employmentDate, salary);
    }
}
