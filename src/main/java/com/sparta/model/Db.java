package com.sparta.model;

import java.util.List;

public interface Db {

    public void insertAll(List<Employee> employees);

    public Employee getEmployee(int id);
}
