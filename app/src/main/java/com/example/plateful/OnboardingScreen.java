package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OnboardingScreen extends AppCompatActivity {
    int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding_screen);
        Button onboardingScreenNextBtn = findViewById(R.id.onboarding_screen_next_btn);
        ImageView onboardingScreenPeopleImg = findViewById(R.id.onboarding_screen_people_img);
        TextView onboardingScreenHelloTxt = findViewById(R.id.onboarding_screen_hello_txt);
        ImageView onboardingScreenStatus1 = findViewById(R.id.onboarding_screen_status_light);
        ImageView onboardingScreenStatus2 = findViewById(R.id.onboarding_screen_status_dark_1);
        ImageView onboardingScreenStatus3 = findViewById(R.id.onboarding_screen_status_dark_2);
        onboardingScreenNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page++;
                if (page == 1) {
                    onboardingScreenPeopleImg.setImageResource(R.drawable.img2);
                    onboardingScreenHelloTxt.setText("Заботься о своём здоровье легко и вкусно!");
                    onboardingScreenStatus1.setImageResource(R.drawable.dark);
                    onboardingScreenStatus2.setImageResource(R.drawable.light);
                    onboardingScreenStatus3.setImageResource(R.drawable.dark);
                }
                if (page == 2) {
                    onboardingScreenPeopleImg.setImageResource(R.drawable.img333);
                    onboardingScreenHelloTxt.setText("Готовь вместе с Plateful!");
                    onboardingScreenNextBtn.setBackgroundResource(R.drawable.next2);
                    onboardingScreenStatus1.setImageResource(R.drawable.dark);
                    onboardingScreenStatus2.setImageResource(R.drawable.dark);
                    onboardingScreenStatus3.setImageResource(R.drawable.light);
                }
                if (page == 3) {
                    Intent i = new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}