package com.sparta.model;

import java.sql.*;

// must implement Db interface
public class MySql {

    private String url;
    private String username;
    private String password;

    public MySql(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

//    public void insertAll(List<Employee> employees) { }

//    public Employee getEmployee(int id) { }

    public void getAll() {
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
