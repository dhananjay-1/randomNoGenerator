package com.example.randomnogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    TextView result;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int low = intent.getIntExtra("low", 0);
        int high = intent.getIntExtra("high", 0);

        layout = (LinearLayout) findViewById(R.id.layout);
        int randNo = generateRandomNo(low, high);

        result = (TextView) findViewById(R.id.result);;
        result.setText(String.valueOf(randNo));


    }

    public int generateRandomNo(int low, int high)
    {
        int total = high-low+1;

        Random rand = new Random();

        int randNo = low + rand.nextInt(total);

        // changing the background color randomly
        layout.setBackgroundColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) ));

        return randNo;
    }
}
