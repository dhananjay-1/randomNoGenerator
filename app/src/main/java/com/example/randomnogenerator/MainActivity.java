package com.example.randomnogenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText lowerLimit;
    EditText upperLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.generateRandomNo);
        lowerLimit = findViewById(R.id.lowerLimit);
        upperLimit = findViewById(R.id.upperLimit);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Random no. generated", Toast.LENGTH_LONG).show();

                String lowStr = lowerLimit.getText().toString();
                String highStr = upperLimit.getText().toString();

                if(lowStr.isEmpty() || highStr.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "enter the values", Toast.LENGTH_SHORT).show();
                    return;
                }

                int low = Integer.parseInt(lowStr);
                int high = Integer.parseInt(highStr);

                if(high<low)
                {
                    Toast.makeText(getApplicationContext(), "upper limit must be greater", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("low", low);
                intent.putExtra("high", high);


                startActivity(intent);

            }
        });
    }


}
