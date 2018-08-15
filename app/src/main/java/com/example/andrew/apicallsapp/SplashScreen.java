package com.example.andrew.apicallsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    //Declare timer
    public static int SPLASH_TIME_OUT = 1000;
    //Setting a local db shared preference
    SharedPreferences sharedpreferences;
    public static final String USERPREFERENCES = "UserDetails" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //check if user has already logged in
        sharedpreferences = getSharedPreferences(USERPREFERENCES,
                Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i;
                if (sharedpreferences.contains("isLoggedIn")) {
                    i = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


}
