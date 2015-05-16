package com.jarninfang.studyapp;

import java.util.ArrayList;
import java.util.UUID;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * Created by jarnin on 5/10/15.
 */
public class Group implements Parcelable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int numberOfPeople;

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    private UUID mID;  //Random unique identifier for each group

    public UUID getmID() {
        return mID;
    }

    public void setmID(UUID mID) {
        this.mID = mID;
    }

    private ArrayList<User> members;

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public void addMember(User user) {
        members.add(user);
        numberOfPeople++;
    }

    /*Implement course classification*/

    /*Implement administrator for each group*/

    public Group(String groupName, String groupDescription, User firstMember) {
        numberOfPeople = 1;
        mID = UUID.randomUUID();
        name = groupName;
        description = groupDescription;
        members.add(0,firstMember);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberOfPeople);
        dest.writeString(mID.toString());
        dest.writeString(name);
        dest.writeString(description);
        dest.writeTypedList(members);
    }

    public static final Parcelable.Creator<Group> CREATOR =
            new Creator<Group>() {
                @Override
                public Group createFromParcel(Parcel source) {
                    return new Group(source);
                }

                @Override
                public Group[] newArray(int size) {
                    return new Group[0];
                }
            };

    private Group(Parcel in) {
        numberOfPeople = in.readInt();
        mID = (UUID) in.readSerializable();
        name = in.readString();
        description = in.readString();
        in.readTypedList(members, User.CREATOR);
    }
}

