package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button addBtn,minusBtn,multiplyBtn,divideBtn;
        EditText value1, value2;
        TextView answer;

        // calculation buttons
        addBtn = findViewById(R.id.addBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        divideBtn = findViewById(R.id.divideBtn);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        answer= findViewById(R.id.answer);

        // calculate addition
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("Total: "+String.valueOf(Float.parseFloat(value1.getText().toString())+Float.parseFloat(value2.getText().toString())));
            }
        });


        // calculate subtraction
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("Total: "+String.valueOf(Float.parseFloat(value1.getText().toString())-Float.parseFloat(value2.getText().toString())));
            }
        });

        // calculate multiplication
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("Total: "+String.valueOf(Float.parseFloat(value1.getText().toString())*Float.parseFloat(value2.getText().toString())));
            }
        });

        // calculate division
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("Total: "+String.valueOf(Float.parseFloat(value1.getText().toString())/Float.parseFloat(value2.getText().toString())));
            }
        });
    }
}