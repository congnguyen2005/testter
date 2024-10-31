package com.example.and102_asignment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.and102_asignment.database.DBHelper;

public class NguoiDungDAO {
    private DBHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    //login
    public boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendangnhap = ? AND matkhau = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }
    //register
    public boolean Register(String username, String password, String hoten){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap", username);
        contentValues.put("matkhau", password);
        contentValues.put("hoten", hoten);

        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);
        return check != -1;
    }
}