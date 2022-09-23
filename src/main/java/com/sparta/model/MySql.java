package com.sparta.model;

import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;
import java.util.List;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySql implements Db {

    private static Connection conn = null;

    private static MySql instance = null;

    public static Logger logger= LogManager.getLogger(Starter.class);

    private MySql() { }

    public static MySql getInstance() {
        if (instance == null)
            instance = new MySql();
        if (conn == null)
            conn = getConnection();
        return instance;
    }

    // Use of threads
    public void migrateEmps(List<Employee> employees){
        int len= employees.size();

        List<Employee> q1 = employees.subList(0,len/4);
        List<Employee> q2 = employees.subList(len/4,len/2);
        List<Employee> q3 = employees.subList(len/2,3*len/4);
        List<Employee> q4 = employees.subList(3*len/4,len);

        employees.subList(0, 1000);

        ExecutorService pool = Executors.newFixedThreadPool(4);

        Runnable thread1 = new ThreadConnection(instance, q1);
        Runnable thread2 = new ThreadConnection(instance, q2);
        Runnable thread3 = new ThreadConnection(instance, q3);
        Runnable thread4 = new ThreadConnection(instance, q4);

        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);

        pool.shutdown();
    }

    public static Connection getConnection() {
        Properties props = new Properties();
        Connection conn = null;
        try {
                props.load(new FileReader("src/main/resources/db.properties"));
                conn = DriverManager.getConnection( // Here
                        props.getProperty("mysql.url"),
                        props.getProperty("mysql.username"),
                        props.getProperty("mysql.password"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void createTable() {
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
            queryDrop.executeUpdate();
            queryCreate.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    // Uses connections in threads
    public void insertAll(List<Employee> employees, Connection conn) {

        logger.trace("Starting insertAll method");
        try {
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
            for (Employee e : employees) {
                if (CleanData.employeeNullCheck(e)){
                    // If null
                    System.out.println("Null object");
                    continue;
                }
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

    // Uses member connection
    public Employee getEmployeeById(int id) {
        Employee result;
        try {
            PreparedStatement queryCreate = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            queryCreate.setInt(1, id);
            ResultSet rs = queryCreate.executeQuery();
            rs.next();
            result  = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0),rs.getString(5),
                 rs.getString(6).charAt(0),rs.getString(7),rs.getDate(8),rs.getDate(9),rs.getInt(10));
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
