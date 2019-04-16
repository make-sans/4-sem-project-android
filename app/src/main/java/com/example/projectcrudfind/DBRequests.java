package com.example.projectcrudfind;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public class DBRequests {

    ProgressBar progressBar;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "ridiculous-affair.000webhostapp.com";

    public DBRequests(Context context){

        progressBar = new ProgressBar(context);
      /*  progressBar.setCancelable(false);
        progressBar.setTitle("Processing");
        progressBar.setMessage("Please wait...");*/


    }

    public void storeUserDataInBackground(User user, GetUserCallback userCallback){
    progressBar.isShown();

    new StoreUserDataAsyncTask(user, userCallback).execute();
    }

    public void fetchUserDataInBackground(User user, GetUserCallback callBack){
    progressBar.isShown();

    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{

        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback userCallback){
            this.user = user;
            this.userCallback = userCallback;

        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

          /*  progressBar.dismiss();*/
            super.onPostExecute(aVoid);
        }
    }
}
