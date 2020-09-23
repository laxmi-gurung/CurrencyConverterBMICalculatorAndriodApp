package com.example.assignment1laxmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

//  Declaring the variables
    private SeekBar weightBar;
    private SeekBar heightBar;
    private TextView weightText;
    private TextView heightText;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

//      Assigning the variables using the id
        weightBar = (SeekBar)findViewById(R.id.weightSlider);
        weightText = (TextView)findViewById(R.id.bmiText1);
        heightBar = (SeekBar)findViewById(R.id.heightSlider);
        heightText = (TextView)findViewById(R.id.bmiText2);
        result = (TextView)findViewById(R.id.BMI);

//      Calling the methods
        weight();
        height();
    }

//  Weight SeekBar
    public void weight() {

//        Displaying the value from the weight seek bar
        weightText.setText("Weight : " + weightBar.getProgress());

//        Event listener for the weight seek bar
        weightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            Declaring the variable to carry the progress value of the seek bar
            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressValue = i;
//                Displays the value of the seek bar
                weightText.setText("Weight : " + progressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

//  Height SeekBar
    public void height() {
//      Displaying the value from the height seek bar
        heightText.setText("Height : " + weightBar.getProgress());

//      Event listener for the height seek bar
        weightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//          Declaring the variable to carry the progress value of the height seek bar
            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressValue = i;
//              Displays the value of the height seek bar
                heightText.setText("Height : " + progressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculateBMI(View v) {
        String weightStr = weightText.getText().toString();
        String heightStr = heightText.getText().toString();

        if (weightStr != null && !"".equals(weightStr)
                && (heightStr != null) && !"".equals(heightStr)) {
            float weightValue = Float.parseFloat(weightStr);
            float heightValue = Float.parseFloat(heightStr) / 100;

            float bmi = weightValue / (heightValue * heightValue);

            resultBMI(bmi);
        }
    }

    private void resultBMI(float bmi) {

        if (Float.compare(bmi, 15f) <= 0) {
            result.setText(bmi + " : Very Serverly Underweight");
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            result.setText(bmi + " : Serverly Underweight");
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            result.setText(bmi + " : Underweight");
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            result.setText(bmi + " : Normal");
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            result.setText(bmi + " : Overweight");
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            result.setText(bmi + " : Obese");
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            result.setText(bmi + " : Severly Obese");
        } else {
            result.setText(bmi + " : Very Serverly Overweight");
        }
    }

}

