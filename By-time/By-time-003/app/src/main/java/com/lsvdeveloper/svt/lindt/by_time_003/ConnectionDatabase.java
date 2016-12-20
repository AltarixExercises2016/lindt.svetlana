package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.Context;
import android.util.Log;

/**
 * Created by Линдт Светлана on 02.12.2016.
 */

public class ConnectionDatabase  {
    private static DBHelper dbHelper;


    public  void go(){
        ConnectionDatabase connectionDatabase= new ConnectionDatabase();


    }
    static int getLength() {
        //SELECT COUNT(*) FROM table;
        //SHOW TABLE STATUS FROM database WHERE Name = 'table';
        Log.d("work","получаем кол-во строк");
        return 5;
    }

    public static String getStr(){
        Log.d("work","получаем строку");
        return null;
    }
}
