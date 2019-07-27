package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {
        if (myApiService == null) { // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setApplicationName("Build it bigger")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        context = contexts[0];

        try{
            return myApiService.getRandomJoke().execute().getData();
        }catch (IOException error){
            return error.getMessage();
        }
    }

    public interface TaskCompleteListener {
        void onTaskComplete(String result);
    }

    private TaskCompleteListener mTaskCompleteListener;

    public EndpointAsyncTask(TaskCompleteListener listener){
        mTaskCompleteListener = listener;
    }

    @Override
    protected void onPostExecute(String result) {
        if(result != null){
            mTaskCompleteListener.onTaskComplete(result);
        }
    }
}