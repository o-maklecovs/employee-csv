package com.sparta.model;

import java.util.List;

public class ThreadConnection implements Runnable {

    private MySql instance = null;
    private List<Employee> employeeList = null;

    public ThreadConnection(MySql instance, List<Employee> employeeList) {
        this.instance = instance;
        this.employeeList = employeeList;
    }

    @Override
    public void run() {
        instance.insertAll(employeeList, MySql.getConnection());
    }
}
