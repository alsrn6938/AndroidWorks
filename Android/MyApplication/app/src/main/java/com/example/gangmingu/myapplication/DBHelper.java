package com.example.gangmingu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gangmingu on 2017. 4. 20..
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ADDR_BOOK";
    public static final int DB_VERSION = 1;


    public DBHelper (Context context) { super (context, DB_NAME, null, DB_VERSION);}

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version);
    }

    public void insertDB(AddrTableVO vo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBContract.ADDR_BOOK.COL_NO,vo.getAno());
        values.put(DBContract.ADDR_BOOK.COL_NAME,vo.getAname());
        values.put(DBContract.ADDR_BOOK.COL_TEL,vo.getAtel());

        long
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
