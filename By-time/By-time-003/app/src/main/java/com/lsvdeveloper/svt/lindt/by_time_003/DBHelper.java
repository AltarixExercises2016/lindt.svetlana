package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Линдт Светлана on 02.12.2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="byTime";
    public static final String TABLE_FOR_COMPANY="forCompany";


    public static final String KEY_ID="_id";
    public static final String KEY_LEISURE="leisure";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_FOR_COMPANY+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_FOR_COMPANY);
        onCreate(sqLiteDatabase);

    }
}
