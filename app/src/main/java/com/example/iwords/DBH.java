package com.example.iwords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBH extends SQLiteOpenHelper {
    public DBH( Context context) {
        super(context, "dbone",null, 1);
    }

    public final static String name = "name";
    public final static String id = "id";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table cont (name text)");/*id text,count text*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("drop table if exists cont");
       onCreate(sqLiteDatabase);
    }
}
