package com.example.testfinerio.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testfinerio.R;
import com.example.testfinerio.ui.login.LoginActivity;
import com.example.testfinerio.utils.NetworkChangeReceiver;

public class SplashActivity extends AppCompatActivity {

    OpenLogintask openLogintask;
    NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkNetwork();
    }

    public class OpenLogintask extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            openLogin();
        }
    }

    public void openLogin(){
        Intent intent  = new Intent(this, LoginActivity.class);
        startActivity( intent);
        finish();
    }

    public void checkNetwork(){
        networkChangeReceiver = new NetworkChangeReceiver();
        if(networkChangeReceiver.isOnline(this)){
            openLogintask = new OpenLogintask();
            openLogintask.execute(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else{
            Toast.makeText(this, "No tienes conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }
}