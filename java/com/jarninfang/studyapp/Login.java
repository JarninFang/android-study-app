package com.jarninfang.studyapp;

import android.os.AsyncTask;

/**
 * Created by jarnin on 5/9/15.
 */
public class Login {
    JSONParser jsonParser = new JSONParser();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    LoginActivity loginActivity = new LoginActivity();

    private static final String LOGIN_URL = "https://dry-dawn-8666.herokuapp.com/";

    class AttemptLogin extends AsyncTask<String, String, String> {
        /*
         * Before starting background thread Show Progress Dialog
         */

        boolean failure = false;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {
            return args[0];
        }

        @Override
        protected void onPostExecute(String file_url) {

        }
    }
}
