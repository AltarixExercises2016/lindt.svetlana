package com.lsvdeveloper.svt.lindt.by_time_003;


import android.content.Intent;
import android.database.SQLException;
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
    private DBHelper dbHelper;


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

            textRandomGenerator.setText("");
            //System.out.println(generateNumber());

        }
    int  generateNumber(){
        dbHelper = new DBHelper(this);
        dbHelper.createDataBase();

        try {
            dbHelper.openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        }

        Log.d("work","создаем случайное число");
        int i = (int) (Math.random()*dbHelper.getLength("nameTable"));
        return i;
    }


    //Override
    //protected void onDestroy() {
    //    super.onDestroy();
    //    db.close();
    //    dbHelper.close();
    //}
    }

