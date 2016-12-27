package com.lsvdeveloper.svt.lindt.by_time_003;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class RandomGeneratorActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textRandomGenerator;

    String nameTable;
    private DBHelperReading dbHelperReading;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textRandomGenerator = (TextView) findViewById(R.id.textRandomGenerator);

        Button buttonStart = (Button) findViewById(R.id.start);
        buttonStart.setOnClickListener(this);



    }
    @Override
    public void onClick (View view){
        Intent intent = getIntent();
        nameTable = intent.getStringExtra("nameTable");
        if (nameTable.equals(DBHelperReading.TABLE_READING))
        textRandomGenerator.setText(getStrReading());
        else{textRandomGenerator.setText(getStr());}
    }

    String  getStrReading(){
        dbHelperReading = new DBHelperReading(this);
        String str = dbHelperReading.getRandomStr(nameTable);
        Log.d("work","получаем строку");
        return str;
    }
    String  getStr(){
        dbHelper = new DBHelper(this);
        String str = dbHelper.getRandomStr(nameTable);
        Log.d("work","получаем строку");
        return str;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbHelperReading!=null)
        dbHelperReading.close();
        if(dbHelper!=null)
        dbHelper.close();
    }
}

