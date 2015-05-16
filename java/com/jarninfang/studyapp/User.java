package com.jarninfang.studyapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarnin on 5/10/15.
 * Class that holds User information
 * Implements Parcelable so we can transfer the User object between
 * Activities and Fragments
 */
public class User implements Parcelable{

    public List<User> results;

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
    public ArrayList<Course> courses;
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Expose
    public ArrayList<Group> groups;

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void addToGroup( Group group ) {
        groups.add(group);
    }

    public User(String email, String password, String name, int age,
                String school, String description, ArrayList<Course> courses,
                ArrayList<Group> groups) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.school = school;
        this.description = description;
        this.courses = courses;
        this.groups = groups;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = "";
        this.age = -1;
        this.school = "";
        this.description = "";
    }

    //Implementing abstract Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    //Write the User's data to the passed-in parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(school);
        dest.writeString(description);
        dest.writeTypedList(courses);
        dest.writeTypedList(groups);
    }

    //Used to regenerate the object. All Parcelables must have a CREATOR
    //that implements these two methods
    public static final Parcelable.Creator<User> CREATOR =
            new Parcelable.Creator<User>() {

                @Override
                public User createFromParcel(Parcel source) {
                    return new User(source);
                }

                @Override
                public User[] newArray(int size) {
                    return new User[0];
                }
            };

    //Constructor that takes a parcel
    private User(Parcel in) {
        email = in.readString();
        password = in.readString();
        name = in.readString();
        age = in.readInt();
        school = in.readString();
        description = in.readString();
        courses = new ArrayList<Course>();
        in.readTypedList(courses, Course.CREATOR);
        in.readTypedList(groups, Group.CREATOR);
    }
}
