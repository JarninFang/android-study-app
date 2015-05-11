package com.jarninfang.studyapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by jarnin on 5/9/15.
 * File used to login user
 */
public class Login {
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    User user;
    String userjson;

    private static final String LOGIN_URL =
            "https://dry-dawn-8666.herokuapp.com/login_user";

    public Login (String email, String password) {
        user = new User(email, password);
        new AttemptLogin().execute();
    }
    class AttemptLogin extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {
            InputStream inputStream = null;
            String result = "";

            try {
                //Create HttpClient
                HttpClient httpclient = new DefaultHttpClient();

                //Make post request to the given url
                HttpPost httpPost = new HttpPost(LOGIN_URL);

                //User gson to convert to json
                Gson gson = new GsonBuilder().
                        excludeFieldsWithoutExposeAnnotation().create();
                userjson = gson.toJson(user);

                // Set json to StringEntity
                StringEntity se = new StringEntity(userjson);

                //Set HttpPost Entity
                httpPost.setEntity(se);

                //Execute POST request to the given URL
                HttpResponse httpResponse = httpclient.execute(httpPost);

                //Receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                //Convert inputstream to string
                if(inputStream != null) {
                    result = convertInputStreamToString(inputStream);
                }

                else {
                    result = "Did not work!";
                }
            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return result;
        }

        @Override
        protected void onPostExecute(String file_url) {

        }
    }

    private static String convertInputStreamToString(InputStream inputStream)
            throws IOException {

        BufferedReader bufferedReader = new
                BufferedReader( new InputStreamReader(inputStream) );
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        inputStream.close();
        return result;
    }

    public User getUser() {
        return user;
    }
}
