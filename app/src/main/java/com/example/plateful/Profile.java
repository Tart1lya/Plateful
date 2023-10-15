package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Cursor query;
    SQLiteDatabase db;
    private static final String ID_INFO = "id_info";
    SharedPreferences settingsForId;
    DatabaseHelper databaseHelper;
    String name, email;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        ImageButton backBtn = findViewById(R.id.back_btn);
        TextView nameTxt = findViewById(R.id.name_txt);
        TextView emailTxt = findViewById(R.id.email_txt);
        ImageButton recentBtn = findViewById(R.id.recent_btn);
        ImageButton favouritesBtn = findViewById(R.id.favourites_btn);
        settingsForId = getSharedPreferences(ID_INFO, MODE_PRIVATE);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        id = settingsForId.getInt(ID_INFO, 0);
        query = db.rawQuery("SELECT * FROM users;", null);
        while (query.moveToNext()) {
            if (query.getInt(0) == id) {
                name = query.getString(1);
                email = query.getString(2);
                break;
            }
        }
        nameTxt.setText(name);
        emailTxt.setText(email);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);
                finish();
            }
        });
    }
}