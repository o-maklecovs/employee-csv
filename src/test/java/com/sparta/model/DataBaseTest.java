package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.sparta.model.CreateEmployee.createEmp;
import static com.sparta.model.MySql.getConnection;
import static com.sparta.model.MySql.logger;

public class DataBaseTest {

    @Test
    @DisplayName("Test new inserted data @DB")
    void insertTest() throws SQLException {
        MySql mySql = new MySql();
        List<Employee> employees = new ArrayList<>();

        //new employee details
        int employeeID = 999908;
        String prefix = "Mr.";
        String firstName = "John";
        char middleInitial = 'B';
        String lastName = "Doe";
        char gender = 'M';
        String mail = "johnBdoe@yahoo.com";
        String dob = "11/16/1997";
        String employmentDate = "12/29/2019";
        int salary = 12340;

        String line = employeeID + "," + prefix + "," + firstName + "," + middleInitial + "," + lastName + "," + gender + "," + mail + "," + dob + "," + employmentDate + "," + salary;
        Employee newEmp = createEmp(line);

        employees.add(newEmp);

        mySql.getConnection();

        mySql.createTable();
        mySql.insertAll(employees,getConnection());

        boolean validID=true;
        Employee result=null;
        int id = 999908;
        try {
            Thread.sleep(1000);
            PreparedStatement queryCreate = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?");
            queryCreate.setInt(1, id);
            ResultSet rs = queryCreate.executeQuery();
            rs.next();
            result  = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0),rs.getString(5),
                    rs.getString(6).charAt(0),rs.getString(7),rs.getDate(8),rs.getDate(9),rs.getInt(10));
            getConnection().setAutoCommit(false);
            System.out.println(result.getFirstName());
        } catch (SQLException | InterruptedException e) {
            logger.error(e);
            validID=false;
        }
        if (validID) {
            System.out.println(result);
        }
        Assertions.assertEquals(result.getEmployeeID(),firstName);
    }


}
