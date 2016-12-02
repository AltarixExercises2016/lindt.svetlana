package com.lsvdeveloper.svt.lindt.by_time_003;

import android.util.Log;

/**
 * Created by Линдт Светлана on 01.12.2016.
 */

public class EmulatorDatabase {
    private static String[] list = {"Идея1","Идея2","Идея3","Идея4","Идея5"};


    static int getLength() {
        Log.d("work","получаем кол-во строк");
        return 5;
    }

    public static String getStr(){
        Log.d("work","получаем строку");
        return list[RandomGenerator.getRandomFromLength()];
    }
}