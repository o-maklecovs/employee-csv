package com.sparta.model;

import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;
import java.util.List;
import java.sql.*;

// must implement Db interface
public class MySql {

    private static MySql instance = null;

    private static Connection conn = null;

    public static Logger logger= LogManager.getLogger(Starter.class);

    private MySql() { }

    public static MySql getInstance() {
        if (instance == null)
            instance = new MySql();
        if (conn == null) {
            Properties props = new Properties();
            try {
                props.load(new FileReader("src/main/resources/db.properties"));
                conn = DriverManager.getConnection(
                        props.getProperty("url"),
                        props.getProperty("username"),
                        props.getProperty("password")
                );
            } catch (IOException e) {
                logger.fatal(e.getMessage() + " could not get database parameters");
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return instance;
    }

    public void insertAll(List<Employee> employees) {
        logger.trace("Starting insertAll method");
        try {
            PreparedStatement queryDrop = conn.prepareStatement("DROP TABLE IF EXISTS employees");
            PreparedStatement queryCreate = conn.prepareStatement("CREATE TABLE employees (" +
                    "id INT NOT NULL, " +
                    "prefix VARCHAR(10), " +
                    "first_name VARCHAR(100), " +
                    "middle_initial VARCHAR(1), " +
                    "last_name VARCHAR(100), " +
                    "gender VARCHAR(1), " +
                    "mail VARCHAR(200), " +
                    "dob DATE, " +
                    "employment_date DATE, " +
                    "salary INT, " +
                    "PRIMARY KEY (id))");
            PreparedStatement queryInsert = conn.prepareStatement("INSERT INTO employees (" +
                    "id, " +
                    "prefix, " +
                    "first_name, " +
                    "middle_initial, " +
                    "last_name, " +
                    "gender, " +
                    "mail, " +
                    "dob, " +
                    "employment_date, " +
                    "salary) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            conn.setAutoCommit(false);
            queryDrop.executeUpdate();
            queryCreate.executeUpdate();
            for (Employee e : employees) {
                queryInsert.setInt(1, e.getEmployeeID());
                queryInsert.setString(2, e.getPrefix());
                queryInsert.setString(3, e.getFirstName());
                queryInsert.setString(4, Character.toString(e.getMiddleInitial()));
                queryInsert.setString(5, e.getLastName());
                queryInsert.setString(6, Character.toString(e.getGender()));
                queryInsert.setString(7, e.getMail());
                queryInsert.setDate(8, new java.sql.Date(e.getDob().getTime()));
                queryInsert.setDate(9, new java.sql.Date(e.getEmploymentDate().getTime()));
                queryInsert.setInt(10, e.getSalary());
                queryInsert.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

//    public Employee getEmployeeById(int id) { }
}
