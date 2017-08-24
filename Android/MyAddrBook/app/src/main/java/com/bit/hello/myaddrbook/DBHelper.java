package com.bit.hello.myaddrbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bit104 on 2017-04-12.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    public static final String DB_NAME = "ADDR_BOOK";


    //DB Helper 의 생성자 //context = 실행되고있는 내부 관리되는 메모리 주소
    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    //모든 값을 외부로 부터 받을때
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    public long insertDB(AddrTableVO vo){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBContract.AddrBook.COL_NAME,vo.getSname());
        values.put(DBContract.AddrBook.COL_BIRTH,vo.getSbirth());
        values.put(DBContract.AddrBook.COL_TEL,vo.getStel());

        long insertRow = db.insert(DBContract.AddrBook.TABLE_NAME,null,values);


        return insertRow;
    }

    public List<AddrTableVO> readFromDB(){
        //누구든지 받을수 있게끔 List로 받음.
        List<AddrTableVO> dto = new ArrayList<AddrTableVO>();
        String sql = " SELECT " +
            DBContract.AddrBook.COL_NAME + "," +
            DBContract.AddrBook.COL_BIRTH + "," +
            DBContract.AddrBook.COL_TEL +
        " FROM " + DBContract.AddrBook.TABLE_NAME;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        //값이 참이면 데이터가 최소 1개 있는 것.
        if(cursor.moveToFirst()){
            do {

                AddrTableVO vo = new AddrTableVO();
                vo.setSname(cursor.getString(0));
                vo.setSbirth(cursor.getString(1));
                vo.setStel(cursor.getString(2));
                dto.add(vo);

            } while (cursor.moveToNext());

        }
        return dto;
    }

    @Override
    //처음 핸들링될때 한번
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.AddrBook.CREATE_TABLE);
    }

    @Override
    //버전 바꼇을때
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + DBContract.AddrBook.TABLE_NAME);
        onCreate(db);
    }
}
