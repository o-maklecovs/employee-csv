package com.sparta.view;
import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserID {
    public static Logger logger= LogManager.getLogger(Starter.class);

    public static int getUserID(){
        logger.trace("In the USER ID class");
        Scanner myScan=new Scanner(System.in);
        boolean validData=false;
        int out=0;

        System.out.println("Enter Employee ID");

            do{
                try {
                    validData = true;
                    out = myScan.nextInt();
                    }
                 catch (Exception e){
                    logger.error(e.getMessage());
                    System.out.println("Please enter an integer");
                    myScan.next();
                    validData = false;
                }
            } while (!validData);
        return out;
    }

}
