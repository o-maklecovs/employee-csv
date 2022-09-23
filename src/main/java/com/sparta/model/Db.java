package com.sparta.model;

import java.sql.Connection;
import java.util.List;

public interface Db {

    void insertAll(List<Employee> employees, Connection conn);

    Employee getEmployeeById(int id);
}
