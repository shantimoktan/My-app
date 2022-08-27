package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileActivity extends AppCompatActivity {
    private static String fileName ="admin.txt";

    EditText createList;
    // buttons
    Button createBtn,viewFile,updateFile,deleteFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        createList = findViewById(R.id.createList);

        createBtn = findViewById(R.id.createBtn);
        updateFile = findViewById(R.id.UpdateFile);
        viewFile = findViewById(R.id.ViewFile);
        deleteFile = findViewById(R.id.DeleteFile);

        // save text to file
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if text is empty
                if(createList.getText().toString().length() > 0){
                    saveAndupdateFile("Saved to");
                }else{
                    Toast.makeText(FileActivity.this, "Please fill the input.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // update text to file
        updateFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check if file exist
                File file = new File(getFilesDir()+"/"+fileName);
                if(file.exists()) {
                    saveAndupdateFile("Updated File");
                }else{
                    Toast.makeText(FileActivity.this, "Filed Not Found. Please make one.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // view saved text from file
        viewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if file exist
                File file = new File(getFilesDir()+"/"+fileName);
                if(file.exists()){
                    FileInputStream fis =null;
                    try {

                        // if file exist read and send to textView
                        fis =openFileInput(fileName);
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);
                        StringBuilder sb = new StringBuilder();

                        String text;
                        while ((text = br.readLine()) != null){
                            sb.append(text).append("\n");
                        }
                        createList.setText(sb.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(fis != null){
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }else{
                    Toast.makeText(FileActivity.this, "Filed Not Found. Please make one.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        // delete file
        deleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if file exist
                File fileDelete = new File(getFilesDir()+"/"+fileName);
                if(fileDelete.exists()){

                    // delete that file
                    fileDelete.delete();
                    createList.getText().clear();
                    Toast.makeText(FileActivity.this, "Filed Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FileActivity.this, "Filed Not Found. Please make one.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // save and update file
    public void saveAndupdateFile(String message){
        String text = createList.getText().toString();
        FileOutputStream fos = null;
        try {

            // save content to file and clear textField
            fos =openFileOutput(fileName, MODE_PRIVATE);
            fos.write(text.getBytes());
            createList.getText().clear();
            Toast.makeText(FileActivity.this,message+getFilesDir()+"/"+fileName, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

