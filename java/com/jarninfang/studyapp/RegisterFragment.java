package com.jarninfang.studyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jarnin on 5/9/15.
 */
public class RegisterFragment extends Fragment {

    AutoCompleteTextView emailTextView;
    EditText pwEditText;
    EditText confirmpwEditText;
    Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, parent, false);

        emailTextView = (AutoCompleteTextView) v.findViewById(R.id.email);

        pwEditText = (EditText) v.findViewById(R.id.password);

        confirmpwEditText = (EditText) v.findViewById(R.id.confirm_password);

        registerButton = (Button) v.findViewById(R.id.email_register_button);

        return v;
    }
}
