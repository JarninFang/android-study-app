package com.jarninfang.studyapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jarnin on 5/10/15.
 */
public class GroupListFragment extends ListFragment {

    private ArrayList<Group> groups;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Groups");

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup parent,
                              Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_group_list, parent, false);

        return v;
    }
}
