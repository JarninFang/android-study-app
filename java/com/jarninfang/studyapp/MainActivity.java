package com.jarninfang.studyapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by jarnin on 5/9/15.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

 /*       FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.mainFragmentContainer);

        if(fragment == null) {

        }*/


        //USED TO TEST LOGIN
        Intent intent = getIntent();
        User user = (User) intent.getParcelableExtra("User");
        Log.d("email", user.getEmail());
        Log.d("password", user.getPassword());
    }


}
