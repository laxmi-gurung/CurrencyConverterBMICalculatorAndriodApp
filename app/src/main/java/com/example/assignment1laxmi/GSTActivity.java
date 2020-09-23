package com.example.assignment1laxmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class GSTActivity extends AppCompatActivity {

    //  Declaring the variables
    private EditText amountNoGst;
    private EditText gstPercent;
    private TextView amountWithGST;
    private TextView amountGST;
    private Button calGST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst);

        //      Assigning the variables using the id
        amountNoGst = (EditText)findViewById(R.id.priceNoGst);
        gstPercent = (EditText)findViewById(R.id.gst);
        amountWithGST = (TextView)findViewById(R.id.PriceWithGST);
        amountGST = (TextView)findViewById(R.id.gstAmount);
        calGST = (Button)findViewById(R.id.calculateGSTbutton);

        //      Event listener for Calculate button
        calGST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Getting the price with no GST value
                float total = Float.parseFloat(amountNoGst.getText().toString());
                //      Getting the GST
                float gstPercentage = Float.parseFloat(gstPercent.getText().toString());
                //      Calculating the price with GST
                float finalAmount = total*(gstPercentage/100);
                //      Displaying the Price with GST value
                amountWithGST.setText(Float.toString(finalAmount));

                //      Calculating the GST amount
                float finalGst = total - finalAmount;
                //      Displaying the GST price
                amountGST.setText(Float.toString(finalGst));
            }
        });

    }
}
