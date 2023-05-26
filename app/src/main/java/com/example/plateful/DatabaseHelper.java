package com.example.plateful;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db";
    private static final int SCHEMA = 1;
    static final String TABLE = "users";
    static final String TABLE_RECENT = "recent";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NAME_OF_DISH = "name_of_dish";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_USER_ID = "user_id";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" + COLUMN_ID
        + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT, " + COLUMN_LOGIN
        + " TEXT, " + COLUMN_PASSWORD + " TEXT);");
        db.execSQL("CREATE TABLE recent (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + COLUMN_USER_ID + " INTEGER," + COLUMN_NAME_OF_DISH + " TEXT, " + COLUMN_DATE + " TEXT, "
                + COLUMN_TIME + " TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECENT);
        onCreate(db);
    }
    void addUser(Context context, String name, String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_LOGIN, login);
        cv.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Ошибка в регистрации", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Добро пожаловать!", Toast.LENGTH_SHORT).show();
        }
    }
    void addDish(Context context, int userId, String nameOfFish, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_ID, userId);
        cv.put(COLUMN_NAME_OF_DISH, nameOfFish);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_TIME, time);
        long result = db.insert(TABLE_RECENT, null, cv);
        if (result == -1) {
            System.out.println("ДОБАВЛЕНО В ИСТОРИЮ ГОТОВОК");
        } else {
            System.out.println("ОШИБКА В ДОБАВЛЕНИИ В ИСТОРИЮ ГОТОВОК");
        }
    }
}
