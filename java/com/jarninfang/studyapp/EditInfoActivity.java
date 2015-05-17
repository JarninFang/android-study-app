package com.jarninfang.studyapp;

import java.util.ArrayList;

/**
 * Created by Gokul on 5/16/2015.
 */
public class EditInfoActivity extends activity {
    private String name;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    private int age;

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    private String school;

    public String getSchool() {return school;}

    public void setSchool(String school) {this.school = school;}

    private String description;

    public String getDescription() {return description;}

    public void setDescription() {this.description = description;}

    private ArrayList<String> courses;

    public ArrayList<String> getCourses() {return courses;}

    public void setCourses(ArrayList<String> courses) {this.courses = courses;}
}
