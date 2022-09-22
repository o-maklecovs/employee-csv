package com.sparta.view;
import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class GetUserID {
    public static Logger logger= LogManager.getLogger(Starter.class);

    public static int getUserID(){
        Scanner myScan=new Scanner(System.in);
        boolean validData=false;
        int out=0;

        System.out.println("Enter User ID");

        while(!validData){
            try {out= myScan.nextInt(); validData=true;}
            catch(Exception e){System.out.println("Please enter an integer");
                logger.info("User entered data that could not be parsed as an integer");}
        }
        return out;
    }

}
