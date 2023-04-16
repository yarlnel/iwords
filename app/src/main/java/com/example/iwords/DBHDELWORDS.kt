package com.example.iwords

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHDELWORDS(context: Context) : SQLiteOpenHelper(context, "dbone", null, 1) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL("create table cont (name text,$index)")/*id text,count text*/
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("drop table if exists cont")
        onCreate(sqLiteDatabase)
    }

    companion object {

        val name = "name"
        val index = "indexe"
    }
}
