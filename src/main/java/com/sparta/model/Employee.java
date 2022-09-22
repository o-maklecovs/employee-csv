package com.sparta.model;

import com.sparta.controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;

public class Employee {
    public static Logger logger= LogManager.getLogger(Starter.class);

    private int employeeID;
    private String prefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String mail;
    private java.util.Date dob;

    private java.util.Date employmentDate;
    private int salary;

    public Employee(int employeeID, String prefix, String firstName, char middleInitial, String lastName, char gender, String mail, java.util.Date dob, java.util.Date employmentDate, int salary) {


        this.employeeID = employeeID;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender=gender;
        this.mail=mail;
        this.dob = dob;
        this.employmentDate = employmentDate;
        this.salary=salary;
    }

    public int getEmployeeID() { return this.employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getPrefix() { return this.prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getMiddleInitial() { return middleInitial; }

    public void setMiddleInitial(char middleInitial) { this.middleInitial = middleInitial; }

    public char getGender() { return gender; }

    public void setGender(char gender) { this.gender = gender; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public Date getDob() { return dob; }

    public void setDob(Date dob) { this.dob = dob; }

    public Date getEmploymentDate() { return employmentDate; }

    public void setEmploymentDate(Date employmentDate) { this.employmentDate = employmentDate; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

//  don't need this probably


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, prefix, firstName, middleInitial, lastName, gender, mail, dob, employmentDate, salary);
    }


}
