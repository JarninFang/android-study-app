package com.jarninfang.studyapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jarnin on 5/10/15.
 * Deals with registering the user by converting the data into json and
 * sending it to the server
 */
public class Register {
    private User user;
    private static String userjson;
    private static final String REGISTER_URL=
            "https://dry-dawn-8666.herokuapp.com/create_user";

    // Constructor takes in a user
    public Register(User user) {
        this.user = user;
        new HttpAsyncTask().execute(REGISTER_URL);

    }

    public static String POST( String url, User user) {
        InputStream inputStream = null;
        String result = "";

        try {
            //Create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            //Make post request to the given url
            HttpPost httpPost = new HttpPost(url);

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

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground( String... urls) {
            return POST(REGISTER_URL, user);
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

}
