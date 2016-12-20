package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.Context;
import android.util.Log;

/**
 * Created by Линдт Светлана on 02.12.2016.
 */

public class ConnectionDatabase  {



    public  void go(){
        ConnectionDatabase connectionDatabase= new ConnectionDatabase();


    }
    static int getLength(String nameTable) {
        //sqLiteDatabase.execSQL("select seq from sqlite_sequence were name = " +nameTable);

        Log.d("work","получаем кол-во строк");
        return 5;
    }

    public static String getStr(){
        Log.d("work","получаем строку");
        return null;
    }
}
