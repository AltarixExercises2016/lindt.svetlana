package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Линдт Светлана on 26.12.2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME="byTimeLeisure";
    private static final String TABLE_LEISURE="leisure";
    private static final String TABLE_FOR_COMPANY="forCompany";
    private static final String TABLE_FOR_ONE="forOne";
    private static final String TABLE_WITH_CHILDREN_1= "forChildren_1_3";
    private static final String TABLE_WITH_CHILDREN_3="forChildren_3_6";
    public static final String TABLE_WITH_CHILDREN_6="forChildren_6_";

    public static final String KEY_ID_LEISURE="_id_leisure";
    public static final String KEY_ID="_id";
    public static final String KEY_LEISURE="leisure";

    static SQLiteDatabase db;
    private ContentValues contentValues = new ContentValues();


    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d("work","onCreate");

        sqLiteDatabase.execSQL("create table if not exists " + TABLE_LEISURE+
                "("+KEY_ID_LEISURE+" integer primary key, "+KEY_LEISURE+" text"+")");
        sqLiteDatabase.execSQL("create table if not exists " + TABLE_FOR_COMPANY+
                "("+KEY_ID+" integer primary key, "+KEY_ID_LEISURE+" text," +
                " foreign key ("+KEY_ID_LEISURE+") references "+TABLE_LEISURE+" ("+KEY_ID_LEISURE+"));");
        sqLiteDatabase.execSQL("create table if not exists " + TABLE_FOR_ONE+
                "("+KEY_ID+" integer primary key, "+KEY_ID_LEISURE+" text"+")");
        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_1+
                "("+KEY_ID+" integer primary key, "+KEY_ID_LEISURE+" text"+")");
        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_3+
                "("+KEY_ID+" integer primary key, "+KEY_ID_LEISURE+" text"+")");
        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_6+
                "("+KEY_ID+" integer primary key, "+KEY_ID_LEISURE+" text"+")");

        long start = System.currentTimeMillis();
        sqLiteDatabase.beginTransaction();
        try {
            addValue(sqLiteDatabase,"Прогулка по парку",KEY_LEISURE, TABLE_LEISURE);
            addValue(sqLiteDatabase,"Прогулка по парку1",KEY_LEISURE, TABLE_LEISURE);
            addValue(sqLiteDatabase,"Прогулка по парку2",KEY_LEISURE, TABLE_LEISURE);
            addValue(sqLiteDatabase,"Прогулка по парку3",KEY_LEISURE, TABLE_LEISURE);
            addValue(sqLiteDatabase,"Прогулка по парку4",KEY_LEISURE, TABLE_LEISURE);


            addValue(sqLiteDatabase,"1",KEY_ID_LEISURE, TABLE_FOR_COMPANY);
            addValue(sqLiteDatabase,"2",KEY_ID_LEISURE, TABLE_FOR_ONE);



            sqLiteDatabase.setTransactionSuccessful();
        }finally {
            sqLiteDatabase.endTransaction();
        }
        long end = System.currentTimeMillis();
        String diff = Long.toString(end - start);
        Log.d("work", "time = "+diff+" ms");


    }

    private void addValue(SQLiteDatabase sqLiteDatabase,String value, String column, String table){
        contentValues.put(column,value);
        sqLiteDatabase.insert(table,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("work","onUpgrade");
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_FOR_ONE );
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_FOR_COMPANY );
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_1 );
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_3);
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_6 );
        onCreate(sqLiteDatabase);
        Log.d("work","onUpgrade");

    }

    String getRandomStr(String nameTable) {
        db = this.getReadableDatabase();
//        Cursor c = db.query(nameTable,new String[] {KEY_LEISURE},null,null,null,null,null);
//        int i = (int) (Math.random()*c.getCount());
        String str=null;
//        Log.d("work","выбираем строку "+i);
//        c.moveToFirst();
//        for (int n=0; n<i;n++){c.moveToNext();}
//        str =c.getString(c.getColumnIndex(KEY_LEISURE));
//        c.close();
        return str;
    }

    @Override
    public synchronized void close() {
        if(db != null)
            db.close();
        super.close();
    }



}
