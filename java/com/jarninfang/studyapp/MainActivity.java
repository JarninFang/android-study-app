package com.jarninfang.studyapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by jarnin on 5/9/15.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.mainFragmentContainer);

        if(fragment == null) {
            fragment = new GroupListFragment();
        }

        fm.beginTransaction()
                .add(R.id.fragmentGroupList, fragment)
                .commit();


        //USED TO TEST LOGIN
        Intent intent = getIntent();
        User user = (User) intent.getParcelableExtra("User");

    }


}
