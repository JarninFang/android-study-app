package com.jarninfang.studyapp;

import java.util.UUID;

/**
 * Created by jarnin on 5/10/15.
 */
public class Group {
    private String name;
    private String description;
    private int numberOfPeople;
    private UUID mID;  //Random unique identifier for each group
    private String[] members = new String[20]; //Max 20 members a group

    public Group (String groupName, String groupDescription, String firstMember) {
        numberOfPeople = 1;
        mID = UUID.randomUUID();
        name = groupName;
        description = groupDescription;
        members[0] = firstMember;
    }
}
