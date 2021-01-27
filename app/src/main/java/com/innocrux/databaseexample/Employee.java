package com.innocrux.databaseexample;

public class Employee {
    int id;
    String name;

    public Employee(int id, String name, String joiningdate, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.joiningdate = joiningdate;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJoiningdate() {
        return joiningdate;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    String joiningdate;
    String dept;

    double salary;



}

