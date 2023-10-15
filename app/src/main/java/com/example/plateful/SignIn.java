package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Cursor query;
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    int signInStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);
        EditText loginInSignInEdt = findViewById(R.id.login_in_sign_in_edt);
        EditText passwordInSignInEdt = findViewById(R.id.password_in_sign_in_edt);
        Button signInInSignInBtn = findViewById(R.id.sign_in_in_sign_in_btn);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        signInInSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = databaseHelper.getReadableDatabase();
                query = db.rawQuery("SELECT * FROM users;", null);
                while (query.moveToNext()) {
                    String loginLocal = query.getString(1);
                    String passwordLocal = query.getString(2);
                    if (loginLocal.equals(loginInSignInEdt.getText().toString()) && passwordLocal.equals(passwordInSignInEdt.getText().toString())) {
                        Toast.makeText(SignIn.this, "Здравствуйте!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(i);
                        finish();
                        signInStatus = 1;
                    }
                }
                if (signInStatus == 0) {
                    Toast.makeText(SignIn.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                    loginInSignInEdt.setText("");
                    passwordInSignInEdt.setText("");
                }
                query.close();
                db.close();
            }
        });
    }
}