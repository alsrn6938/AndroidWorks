package com.bit.hello.myaddrbook;

import android.provider.BaseColumns;

/**
 * Created by bit104 on 2017-04-12.
 */

public  class DBContract {

    public static class AddrBook implements BaseColumns {

        public static final String TABLE_NAME = "ADDR_TABLE";
        public static final String COL_NAME = "ANAME";
        public static final String COL_BIRTH = "ABIRTH";
        public static final String COL_TEL = "ATEL";

        public static final String CREATE_TABLE = " CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_BIRTH + " INTEGER, " +
                COL_TEL + " TEXT )";
    }
}
