package com.te.webdbdemo.data;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String title;
    private Object info;

    public Employee(int id, String lastName, String firstName, String title) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
