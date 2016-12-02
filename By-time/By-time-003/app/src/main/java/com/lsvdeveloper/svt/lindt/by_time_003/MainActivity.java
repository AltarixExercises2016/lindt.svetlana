package com.lsvdeveloper.svt.lindt.by_time_003;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_main:
            return true;

            case R.id.action_settings:
            Intent intent1 = new Intent(this, SettingsActivity.class);
            startActivity(intent1);
            return true;

            case R.id.action_info:
            Intent intent2 = new Intent(this, InfoActivity.class);
            startActivity(intent2);
            return true;

            case R.id.action_exit:
            System.exit(0);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intentButton;
        Intent intentTable;

    switch(view.getId()){
        case R.id.button1:
            //intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table1");
            //startActivity(intentButton);
            startActivity(intentTable);
//          String table = "table1";
             break;

        case R.id.button2:
            intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table2");
            startActivity(intentButton);

//          String table = "table2";
            break;

        case R.id.button3:
            intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table3");
            startActivity(intentButton);
//                String table = "table3";
            break;
        case R.id.button4:
            intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table4");
            startActivity(intentButton);
//          String table = "table4";
            break;

        case R.id.button5:
            intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table5");
            startActivity(intentButton);
//          String table = "table5";
            break;

        case R.id.button6:
            intentButton = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable = new Intent(MainActivity.this, RandomGeneratorActivity.class);
            intentTable.putExtra("name","table6");
            startActivity(intentButton);
//          String table = "table6";//использовать не String
            break;
        }
    }
}
