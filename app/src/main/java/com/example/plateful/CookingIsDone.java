package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class CookingIsDone extends AppCompatActivity {
    Cursor query;
    SQLiteDatabase db;
    String nameOfDish, descriptionOfDish;
    DatabaseHelper databaseHelper;
    private static final String ID_INFO = "id_info";
    SharedPreferences settingsForId;
    SharedPreferences.Editor prefEditor;
    int id, index = 0;
    int [] arrAllDishes = {
            R.drawable.img_breakfast_1, R.drawable.img_breakfast_2, R.drawable.img_breakfast_3,
            R.drawable.img_lunch_1, R.drawable.img_lunch_2, R.drawable.img_lunch_3,
            R.drawable.img_dinner_1, R.drawable.img_dinner_2, R.drawable.img_dinner_3
    };
    String [] arrNameOfDishes = {"Яблочная каша", "Яичница с тыквой", "Фриттата с овощами и фетой",
            "Салат греческий с курицей", "Перцы, фаршированные кускусом", "Куриный стейк",
            "Тушеная свинина с кукурузой", "Говядина с овощами стир-фрай", "Сливочная паста фетучини"
    };
    Uri uri;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cooking_is_done);
        ImageButton addToFavBtn = findViewById(R.id.add_to_fav_btn);
        ImageButton exitBtn = findViewById(R.id.exit_btn);
        settingsForId = getSharedPreferences(ID_INFO, MODE_PRIVATE);
        nameOfDish = getIntent().getExtras().getString("name_of_dish");
        descriptionOfDish = getIntent().getExtras().getString("description_of_dish");
        id = settingsForId.getInt(ID_INFO, 0);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();

        addToFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrNameOfDishes.length; i++) {
                    if (nameOfDish.equals(arrNameOfDishes[i])) {
                        index = i;
                        break;
                    }
                }
                uri = Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" +
                        arrAllDishes[index]);
                path = uri.toString();
                databaseHelper.addFavDish(getApplicationContext(), id, nameOfDish, descriptionOfDish,
                        path);
                addToFavBtn.setImageResource(R.drawable.favourites);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);
                finish();
            }
        });
    }
}