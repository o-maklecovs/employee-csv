package com.sparta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public  class CreateEmployee {

    public static Logger logger= LogManager.getLogger(Starter.class);

    public  static Employee createEmp(String line){
        boolean validData=true;

        logger.trace("starting a create Emp method");
        // Split line and create Employee object
        String[] arr= line.split(",");
        logger.info("Line split: " + Arrays.toString(arr));


        //ints:
        int id=-1;
        int salary=-1;
        try{
            id = Integer.parseInt(arr[0]);
            salary = Integer.parseInt(arr[9]);
        }
        catch (Exception e) {logger.error("Could not parse to int in array: "+ Arrays.toString(arr)); validData=false;}

        //Strings
        String prefix = arr[1];
        String fName = arr[2];
        String lName = arr[4];
        String mail = arr[6];

        //chars
        char initial='_';
        char gender='_';
        try {
            initial = arr[3].charAt(0);
            gender = arr[5].charAt(0);
        }
        catch (Exception e){
            logger.error("Could not parse to char in array: " + Arrays.toString(arr));
            validData=false;
        }

        //dates
        java.util.Date dob = null;
        java.util.Date employmentDate = null;
        try {
            dob = new SimpleDateFormat("MM/dd/yyyy").parse(arr[7]);
//            dob = (Date) new SimpleDateFormat("MM/dd/yyyy").parse(arr[7]); // Error line (With cast)
            employmentDate = new SimpleDateFormat("MM/dd/yyyy").parse(arr[8]);
        } catch (Exception e) { // Here
            logger.error("Date formatted correctly, is the date in mm/dd/yyyy?");
            logger.error(e.getMessage());
            validData=false;
        }

        if (validData) {
            return new Employee(id, prefix, fName, initial, lName, gender, mail, dob, employmentDate, salary);
        }
        else return null;
    }
}
