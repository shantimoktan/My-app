package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    // generate random number between 1 - 100
    final int min = 1;
    final int max = 100;
    int random = new Random().nextInt((max - min) + 1) + min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button guessBtn,playAgain;
        EditText numberInput;
        TextView message;

        guessBtn = findViewById(R.id.guessBtn);
        numberInput = findViewById(R.id.yourNumber);
        message = findViewById(R.id.message);
        playAgain = findViewById(R.id.playAgain);
        playAgain.setVisibility(View.GONE);

        // on guess button clicked
        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // toggle button
                guessBtn.setVisibility(View.GONE);
                playAgain.setVisibility(View.VISIBLE);

                if(numberInput.getText().toString().equals(String.valueOf(random))){
                    // if number is same then show green text
                    ((TextView)message).setTextColor(getResources().getColor(R.color.green));
                    message.setText("well done you guessed the correct number");
                }else{
                    // if number is not same then show red text
                    ((TextView)message).setTextColor(getResources().getColor(R.color.red));
                    message.setText("Opps, wrong guess, try again.");
                }
            }
        });

        // on play again button clicked
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate new random number
                random = new Random().nextInt((max - min) + 1) + min;

                // clear previous number and message
                message.setText("");
                numberInput.setText("");

                // toggles button
                guessBtn.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.GONE);
            }
        });
    }
}