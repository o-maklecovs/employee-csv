package com.sparta;

public class Employee {

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

//  don't need this probably
//    public boolean equals(Employee o) {
//        if (o == this) return true;
//        return this.employeeID == o.getEmployeeID();
//    }
}
