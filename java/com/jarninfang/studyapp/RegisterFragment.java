package com.jarninfang.studyapp;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarnin on 5/9/15.
 */
public class RegisterFragment extends Fragment {
    AutoCompleteTextView emailTextView;
    EditText pwEditText;
    EditText confirmpwEditText;
    Button registerButton;

    String email, password, cPassword;
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
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailTextView.getText() + "";
                password = pwEditText.getText() + "";
                cPassword = confirmpwEditText.getText() + "";
                if( email.length() == 0 || password.length() == 0 ) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            R.string.fill_in_fields, Toast.LENGTH_SHORT).show();
                }
                else if( password.equals(cPassword)) {
                    Networking n = new Networking();
                    n.execute("https://dry-dawn-8666.herokuapp.com/create_user", Networking.NETWORK_STATE_REGISTER);
                }

                else  {
                    Toast.makeText(getActivity().getApplicationContext(),
                            R.string.passwords_dont_match, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    public class Networking extends AsyncTask {
        public static final int NETWORK_STATE_REGISTER = 1;
        @Override
        protected Object doInBackground(Object[] params) {
            getJson(params[0], (int)params[1]);
            return null;
        }
    }

    private void getJson( String url, int state ) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);

        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();

        boolean valid = false;

        switch (state) {
            case Networking.NETWORK_STATE_REGISTER:
                postParameters.add(new BasicNameValuePair("email", email));
                postParameters.add(new BasicNameValuePair("password", password));
                String s = " { \"email\":" + email + ", \"password\":" + password+"}";
                valid = true;
                break;
            default:
                Log.d("State", "Unknown State");
        }

        if(valid) {
            StringBuffer stringBuffer = new StringBuffer("");
            BufferedReader bufferedReader = null;
            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postParameters);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);

                bufferedReader = new BufferedReader
                        (new InputStreamReader(response.getEntity().getContent()));

                String line = " ";
                String LineSeparator = System.getProperty("line.separator");
                while((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line + LineSeparator);
                }

                bufferedReader.close();



            } catch (Exception e) {
                Log.d("error", e.getMessage());
                e.printStackTrace();
            }

            Log.d("result", "result" + stringBuffer);

        }

        else {
            Log.d("NotValid", "Not valid");
        }

    }

}
