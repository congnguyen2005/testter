package com.example.and102_asignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AND102.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng NGUOIDUNG
        String createUserTable = "CREATE TABLE NGUOIDUNG (" +
                "tendangnhap TEXT PRIMARY KEY, " +
                "matkhau TEXT, " +
                "hoten TEXT)";
        db.execSQL(createUserTable);

        // Tạo bảng SANPHAM
        String createProductTable = "CREATE TABLE SANPHAM (" +
                "masp TEXT PRIMARY KEY, " +
                "tensp TEXT, " +
                "giaban INTEGER, " +
                "soluong INTEGER)";
        db.execSQL(createProductTable);

        // Chèn dữ liệu ban đầu vào bảng NGUOIDUNG
        String insertUserData = "INSERT INTO NGUOIDUNG (tendangnhap, matkhau, hoten) VALUES " +
                "('nguyendc', '123', 'Cong Nguyen'), " +
                "('nguyen', '123', 'nguyen')";
        db.execSQL(insertUserData);

        // Chèn dữ liệu ban đầu vào bảng SANPHAM
        String insertProductData = "INSERT INTO SANPHAM (masp, tensp, giaban, soluong) VALUES " +
                "('1', 'bánh', 5000, 30), " +
                "('2', 'kẹo', 10000, 42), " +
                "('3', 'kẹo', 111, 42), " +
                "('4', 'kẹo', 1000220, 42), " +
                "('5', 'kẹo', 332, 42), " +
                "('6', 'kẹo', 32, 42), " +
                "('7', 'bút', 4224, 10)";
        db.execSQL(insertProductData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            // Xóa các bảng nếu đã tồn tại
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");

            // Tạo lại các bảng
            onCreate(db);
        }
    }
}
