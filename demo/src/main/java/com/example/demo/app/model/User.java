package com.example.demo.app.model;

public class User {

    private int id;
    private String name;
    private String project;


    public User(int id, String name, String project) {
        this.id = id;
        this.name = name;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
