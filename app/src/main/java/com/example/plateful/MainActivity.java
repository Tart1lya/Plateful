package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String REMIND_STATUS = "remind_status";
    private static final String REG_STATUS = "register_status";
    SharedPreferences settingsForRemind, settings;
    int remindStatus, regStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        settingsForRemind = getSharedPreferences(REMIND_STATUS, MODE_PRIVATE);
        settings = getSharedPreferences(REG_STATUS, MODE_PRIVATE);
        remindStatus = settingsForRemind.getInt(REMIND_STATUS, 0);
        regStatus = settings.getInt(REG_STATUS, 0);
        Timer myTimer = new Timer();
        if (remindStatus == 1 && regStatus == 1) {
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        } else {
            if (remindStatus == 0 && regStatus == 1) {
                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent i = new Intent(getApplicationContext(), SignIn.class);
                        startActivity(i);
                        finish();
                    }
                }, 3000);
            }
            if (regStatus == 0) {
                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent i = new Intent(getApplicationContext(), OnboardingScreen.class);
                        startActivity(i);
                        finish();
                    }
                }, 3000);
            }
        }
    }
}