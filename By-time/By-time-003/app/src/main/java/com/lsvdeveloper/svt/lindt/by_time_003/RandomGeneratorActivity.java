package com.lsvdeveloper.svt.lindt.by_time_003;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomGeneratorActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textRandomGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generetor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textRandomGenerator = (TextView) findViewById(R.id.textRandomGenerator);

        Button buttonStart = (Button) findViewById(R.id.start);
        buttonStart.setOnClickListener(this);
    }
        @Override
        public void onClick (View view){

           textRandomGenerator.setText(RandomGenerator.go());
        }
    }

