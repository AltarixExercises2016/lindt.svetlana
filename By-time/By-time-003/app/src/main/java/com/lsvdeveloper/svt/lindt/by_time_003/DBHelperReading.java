package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Линдт Светлана on 02.12.2016.
 */

class DBHelperReading extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 11;
    private static final String DATABASE_NAME="byTime";
    public static final String TABLE_READING="reading";

    public static final String KEY_ID="_id";
    public static final String KEY_LEISURE="leisure";

    private ContentValues contentValues = new ContentValues();
    static SQLiteDatabase db;


    public DBHelperReading(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("work","onCreate");

        sqLiteDatabase.execSQL("create table if not exists " + TABLE_READING+"("+KEY_ID+" integer primary key, "+KEY_LEISURE+" text"+")");

        long start = System.currentTimeMillis();
        sqLiteDatabase.beginTransaction();
        try {
            addValue(sqLiteDatabase,"Рей Брэдбери \"451° по Фаренгейту\"");
            addValue(sqLiteDatabase,"Грегори Дэвид Робертс \"Шантарам\"");
            addValue(sqLiteDatabase,"Джордж Оруэлл \"1984\"");
            addValue(sqLiteDatabase,"Михаил Афанасьевич Булгаков \"Мастер и Маргарита\"");
            addValue(sqLiteDatabase,"Эрих Мария Ремарк \"Три товарища\"");
            addValue(sqLiteDatabase,"Рей Брэдбери \"Вино из одуванчиков\"");
            addValue(sqLiteDatabase,"Харпер Ли \"Убить пересмешника\"");
            addValue(sqLiteDatabase,"Даниел Киз \"Цветы для Элджернона\"");
            addValue(sqLiteDatabase,"Антуан де Сент-Экзюпери \"Маленький принц\"");
            addValue(sqLiteDatabase,"Джером Д. Сэлинджер \"Над пропастью во ржи\"");
            addValue(sqLiteDatabase,"Грегори Дэвид Робертс \"Тень горы\"");
            addValue(sqLiteDatabase,"Габриэль Гарсиа Маркес \"Сто лет одиночества\"");
            addValue(sqLiteDatabase,"Лев Толстой \"Анна Каренина\"");
            addValue(sqLiteDatabase,"Айн Рэнд \"Атлант расправил плечи\"");
            addValue(sqLiteDatabase,"Энди Вейер \"Марсианин\"");
            addValue(sqLiteDatabase,"Федор Михайлович Достоевский \"Преступление и наказание\"");

            sqLiteDatabase.setTransactionSuccessful();
        }finally {
            sqLiteDatabase.endTransaction();
        }
        long end = System.currentTimeMillis();
        String diff = Long.toString(end - start);
        Log.d("work", "time = "+diff+" ms");


    }

    private void addValue(SQLiteDatabase sqLiteDatabase,String value){
        contentValues.put(this.KEY_LEISURE,value);
        sqLiteDatabase.insert(TABLE_READING,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("work","onUpgrade");
        sqLiteDatabase.execSQL("drop table if exists " +TABLE_READING );
        onCreate(sqLiteDatabase);


    }

     String getRandomStr(String nameTable) {
         db = this.getReadableDatabase();
         Cursor count = db.rawQuery("select count(*) from "+TABLE_READING,null);
         count.moveToFirst();
         int countTable = count.getInt(0);
         int i = (int) (Math.random()*countTable);
         Cursor c = db.rawQuery("select "+KEY_LEISURE+" from "+TABLE_READING+ " where "+KEY_ID+" =?",new String[]{Integer.toString(i+1)});
         String str;
         Log.d("work","выбираем строку "+(i+1));
         c.moveToFirst();
         str =c.getString(c.getColumnIndex(KEY_LEISURE));
         c.close();
         count.close();
        return str;

    }

    @Override
    public synchronized void close() {
        if(db != null)
            db.close();
        super.close();
    }



}
