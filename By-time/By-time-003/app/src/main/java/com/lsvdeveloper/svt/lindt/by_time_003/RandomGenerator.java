package com.lsvdeveloper.svt.lindt.by_time_003;

import android.util.Log;

/**
 * Created by Линдт Светлана on 01.12.2016.
 */

public class RandomGenerator {
    private static String idea;
    private static int randomFromLength;


    static  String go(){
        randomFromLength=generateNumber();
        idea =EmulatorDatabase.getStr();

        return idea;
    }
    static int generateNumber(){
        Log.d("work","создаем случайное число");
        int i = (int) (Math.random()*EmulatorDatabase.getLength());
        return i;
    }

    public static int getRandomFromLength(){
        return randomFromLength;
    }
}
