package com.jarninfang.studyapp;

import android.os.Parcelable;
import android.os.Parcel;

import com.google.gson.annotations.Expose;

/**
 * Created by jarnin on 5/14/15.
 * File for course objects
 */
public class Course implements Parcelable {

    @Expose
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Used to regenerate the object. All Parcelables must have a CREATOR
    //that implements these two methods
    public static final Parcelable.Creator<Course> CREATOR =
            new Parcelable.Creator<Course>() {

                @Override
                public Course createFromParcel(Parcel source) {
                    return new Course(source);
                }

                @Override
                public Course[] newArray(int size) {
                    return new Course[0];
                }
            };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    private Course (Parcel in) {
        name = in.readString();
    }
}
