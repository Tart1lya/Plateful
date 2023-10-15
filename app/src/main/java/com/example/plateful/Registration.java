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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    Cursor query;
    SQLiteDatabase db;
    private static final String REG_STATUS = "register_status";
    private static final String REMIND_STATUS = "remind_status";
    private static final String ID_INFO = "id_info";
    String email;
    SharedPreferences settings, settingsForRemind, settingsForId;
    SharedPreferences.Editor prefEditor;
    DatabaseHelper databaseHelper;
    int regStatus = 0, remindStatus = 0, badStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);
        EditText nameEdt = findViewById(R.id.name_edt);
        EditText loginEdt = findViewById(R.id.login_edt);
        EditText passwordEdt = findViewById(R.id.password_edt);
        Button signUpBtn = findViewById(R.id.sign_up_btn);
        CheckBox remindMeCheckBox = findViewById(R.id.remind_me_check_box);
        settings = getSharedPreferences(REG_STATUS, MODE_PRIVATE);
        settingsForRemind = getSharedPreferences(REMIND_STATUS, MODE_PRIVATE);
        settingsForId = getSharedPreferences(ID_INFO, MODE_PRIVATE);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = loginEdt.getText().toString();
                query = db.rawQuery("SELECT * FROM users;", null);
                while (query.moveToNext()) {
                    if (query.getString(2).equals(email)) {
                        Toast.makeText(getApplicationContext(), "Аккаунт с такой почтой уже есть!", Toast.LENGTH_SHORT).show();
                        loginEdt.setText("");
                        passwordEdt.setText("");
                        badStatus = 1;
                        break;
                    }
                }
                if (badStatus == 0) {
                    if (remindMeCheckBox.isChecked()) {
                        remindStatus = 1;
                        prefEditor = settingsForRemind.edit();
                        prefEditor.putInt(REMIND_STATUS, remindStatus);
                        prefEditor.apply();
                    }
                    databaseHelper.addUser(getApplicationContext(), nameEdt.getText().toString().trim(),
                            loginEdt.getText().toString().trim(),
                            passwordEdt.getText().toString().trim());
                    query = db.rawQuery("SELECT * FROM users;", null);
                    while (query.moveToNext()) {
                        if (query.getString(2).equals(email)) {
                            int id = query.getInt(0);
                            prefEditor = settingsForId.edit();
                            prefEditor.putInt(ID_INFO, id);
                            prefEditor.apply();
                            break;
                        }
                    }
                    regStatus = 1;
                    prefEditor = settings.edit();
                    prefEditor.putInt(REG_STATUS, regStatus);
                    prefEditor.apply();
                    Intent i = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(i);
                    finish();
                    db.close();
                }
            }
        });
    }
}