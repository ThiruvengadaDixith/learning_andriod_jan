package com.innocrux.retrofit_demo;

public class DataModel {

    // this model class will be a template for the data that we are going to parse

    private int userId;

    private int id;

    private String title;

    private  boolean  completed;

    // Getters

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
