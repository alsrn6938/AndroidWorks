package com.example.gangmingu.myapplication;

import android.provider.BaseColumns;

/**
 * Created by gangmingu on 2017. 4. 20..
 */

public class DBContract {
    public static class ADDR_BOOK implements BaseColumns{
        public static final String TABLE_NAME = "ADDR_TABLE";
        public static final String COL_NO = "ADDR_NO";
        public static final String COL_NAME = "ADDR_NAME";
        public static final String COL_TEL = "ADDR_TEL";

        public static final String CREATE_TABLE = " CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NO + " TEXT, " +
                COL_NAME + " TEXT, " +
                COL_TEL + " TEXT ) ";
    }
}
