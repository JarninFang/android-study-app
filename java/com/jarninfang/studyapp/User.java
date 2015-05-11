package com.jarninfang.studyapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jarnin on 5/10/15.
 */
public class User {

    @Expose
    private String email;

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    @Expose
    private String password;

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Expose
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Expose
    private int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Expose
    private String school;
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Expose
    public String[] courses = new String[8]; // Max 8 classes
    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }


    public User(String email, String password, String name, int age,
                String school, String description, String[] courses) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.school = school;
        this.description = description;
        this.courses = courses;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = "";
        this.age = -1;
        this.school = "";
        this.description = "";
    }



}
