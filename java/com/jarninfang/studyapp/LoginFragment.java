package com.jarninfang.studyapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jarnin Fang on 4/28/2015.
 */
public class LoginFragment extends Fragment {

    AutoCompleteTextView emailTextView;
    TextView passwordTextView;
    Button signInButton;
    Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, parent, false);

        emailTextView = (AutoCompleteTextView) v.findViewById(R.id.email);

        passwordTextView = (TextView) v.findViewById(R.id.password);

        signInButton = (Button) v.findViewById(R.id.email_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailTextView.getText() + "";
                String password = passwordTextView.getText() + "";
            }
        });

        registerButton = (Button) v.findViewById(R.id.email_register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start RegisterFragment
                RegisterFragment regFrag = new RegisterFragment();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, regFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return v;
    }
}
