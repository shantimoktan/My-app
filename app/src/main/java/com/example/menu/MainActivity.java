package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //edit username and password
        EditText username, password;
        Button loginbtn;

        //admin and admin (fixed user and password)
        String correct_username = "admin";
        String correct_password = "admin";

            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            loginbtn = findViewById(R.id.loginbtn);

            //define materialButton to loginbtn
         //   MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);


            loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //incase of empty
                    if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Empty data", Toast.LENGTH_LONG).show();
                    } else if (username.getText().toString().equals(correct_username)) {
                        //check password
                        if (password.getText().toString().equals(correct_password)) {
                            Toast.makeText(MainActivity.this, "Success login", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this, file.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid username/password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid username/password", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }



