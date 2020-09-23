package com.example.assignment1laxmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Calling the methods
        configGST();
        configBMI();
    }

    //  Goes to the GST Activity when GST image button activated
    private void configGST() {
//      Declaring the variable 'gstButton' and assigning value to it using the id
        ImageButton gstButton = (ImageButton) findViewById(R.id.gstImage);
//      Event listener for the GST image button
        gstButton.setOnClickListener(new View.OnClickListener() {
            @Override
//            Intent triggered and user redirected to GST Activity
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GSTActivity.class));

            }
        });
    }

    //  Goes to the BMI Activity when BMI image button activated
    private void configBMI() {
        // Declaring the variable 'bmiButton' and assigning value to it using the id
        ImageButton bmiButton = (ImageButton) findViewById(R.id.bmiImage);
//      Event listener for the BMI image button
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent triggered and user redirected to BMI Activity
                startActivity(new Intent(MainActivity.this, BMIActivity.class));
            }
        });
    }
}
