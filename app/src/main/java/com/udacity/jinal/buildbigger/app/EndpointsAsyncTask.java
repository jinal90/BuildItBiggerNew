package com.udacity.jinal.buildbigger.app;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.jinal.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Jinal Tandel on 6/10/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
    private static MyApi myApiService = null;
    private boolean isSuccess;
    private EndpoinrResponseInterface responseInterface;

    EndpointsAsyncTask(EndpoinrResponseInterface responseInterface) {
        this.responseInterface = responseInterface;

    }

    @Override
    protected String doInBackground(String... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1338.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            isSuccess = true;
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            isSuccess = false;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        responseInterface.onResponse(isSuccess, result);

        /**/


    }

    public interface EndpoinrResponseInterface {

        void onResponse(boolean isSuccess, String result);

    }
}