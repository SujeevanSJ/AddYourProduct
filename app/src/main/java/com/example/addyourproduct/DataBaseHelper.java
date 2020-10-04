package com.example.addyourproduct;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="AddYourProduct.db";
    public static final String TABLE_NAME="AddYourProduct";

    //COL
    public static final String COLS_1="ProductID";
    public static final String COLS_2="ProductName";
    public static final String COLS_3="Quantity";
    public static final String COLS_4="Price";
    public static final String COLS_5="Discription";

    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +TABLE_NAME+"(ProductID INTEGER PRIMARY KEY AUTOINCREMENT,ProductName TEXT ,Quantity TEXT,Price INTEGER,Discription TEXT  )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
}
