package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Линдт Светлана on 02.12.2016.
 */

public class DBHelper extends SQLiteOpenHelper  {

    private static String DB_PATH = "/data/data/com.lsvdeveloper.svt.lindt.by_time_003/databases/";

    private static final int DATABASE_VERSION = 9;
    private static final String DATABASE_NAME="byTime";
    private static final String TABLE_FOR_COMPANY="forCompany";
    private static final String TABLE_FOR_ONE="forOne";
    private static final String TABLE_READING="reading";
    private static final String TABLE_WITH_CHILDREN_1= "forChildren_1_3";
    private static final String TABLE_WITH_CHILDREN_3="forChildren_3_6";
    private static DBHelper dbHelper;
    private final Context mContext;


    public static final String TABLE_WITH_CHILDREN_6="forChildren_6_";
    public static final String TABLE_SEQ="sequence";

    public static final String KEY_ID="_id";
    public static final String KEY_LEISURE="leisure";
    public static final String KEY_NAME="name";
    public static final String KEY_SEQ="seq";
    static SQLiteDatabase db;


    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_FOR_COMPANY+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_FOR_ONE+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_READING+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_1+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_3+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_WITH_CHILDREN_6+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");
//        sqLiteDatabase.execSQL("create table if not exists " + TABLE_SEQ+"("+KEY_NAME+" text, "+KEY_SEQ+" text"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //db.execSQL("drop table if exists " +TABLE_FOR_ONE );
        //db.execSQL("drop table if exists " +TABLE_FOR_COMPANY );
        //db.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_1 );

        //db.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_3);
        //db.execSQL("drop table if exists " +TABLE_WITH_CHILDREN_6 );
        //db.execSQL("drop table if exists " +TABLE_READING );
        //db.execSQL("drop table if exists " +TABLE_SEQ );

        Log.d("work","onUpgrade");

    }


    public void createDataBase() {
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH + DATABASE_NAME);
            if (!file.exists()) {
                this.getReadableDatabase();
                //получаем локальную бд как поток
                myInput = mContext.getAssets().open(DATABASE_NAME);
                // Путь к новой бд
                String outFileName = DB_PATH + DATABASE_NAME;

                // Открываем пустую бд
                myOutput = new FileOutputStream(outFileName);

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (IOException ex) {
        }
    }


    int getLength(String nameTable) {
        String[] str = {nameTable};
        String[] colums = {KEY_SEQ};
        dbHelper.openDataBase();
        //Cursor c = db.query(TABLE_SEQ,colums,KEY_NAME+" = ?",str,null,null,null);
        Cursor c = db.query(TABLE_FOR_ONE,new String[] {KEY_LEISURE},null,null,null,null,null);

        //c.moveToFirst(); // переходим на первую строку
        // извлекаем данные из курсора
        //int i = c.getInt(c.getColumnIndex(KEY_SEQ));
        //c.close();



        int i = c.getCount();
        //String i = c.getString(1);
        c.close();
        dbHelper.close();

        Log.d("work","получаем кол-во строк "+i);
        return i;
    }
    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(db != null)
            db.close();
        super.close();
    }



}
