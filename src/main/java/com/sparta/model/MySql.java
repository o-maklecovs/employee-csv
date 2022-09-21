package com.sparta.model;

import com.sparta.model.Employee;

import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;
import java.util.List;
import java.sql.*;

// must implement Db interface
public class MySql {

    private String url;
    private String username;
    private String password;

//    public MySql(String url, String username, String password) {
//        this.url = url;
//        this.username = username;
//        this.password = password;
//    }

    private void loadCreds() {
        Properties props = new Properties();
        try {
            props.load(new FileReader("src/main/resources/db.properties"));
            this.url = props.getProperty("url");
            this.username = props.getProperty("username");
            this.password = props.getProperty("password");
        } catch (IOException e) {
            // log
            e.printStackTrace();
        }
    }

//    public void insertAll(List<Employee> employees) { }

//    public Employee getEmployee(int id) { }

    public void getAll() {
        this.loadCreds();
        try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM actor");
            ResultSet res = query.executeQuery();
            while (res.next())
                System.out.println(res.getString("first_name") + " " + res.getString("last_name"));
        } catch (SQLException e) {
            // log
            e.printStackTrace();
        }
    }
}
