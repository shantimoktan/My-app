package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RelativeLayout listBtn,calculatorBtn,gameBtn;

        listBtn = findViewById(R.id.listBtn);
        calculatorBtn = findViewById(R.id.calculatorBtn);
        gameBtn = findViewById(R.id.gameBtn);

        // open List screen activity
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, file.class));
            }
        });

        // open Calculator screen activity
        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, CalculatorActivity.class));
            }
        });

        // open Game screen activity
        gameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, GameActivity.class));
            }
        });
    }
}