package com.jarninfang.studyapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jarnin on 5/10/15.
 */
public class GroupListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup parent,
                              Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_group_list, parent, false);
        
        return v;
    }
}
