package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class file extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        listView=(ListView) findViewById(R.id.listview);

        ArrayList<String>arrayList=new ArrayList<>();

        arrayList.add("hello");
        arrayList.add("everyone");
        arrayList.add("this is");
        arrayList.add("Menu");
        arrayList.add("app");
        arrayList.add("hello");
        arrayList.add("everyone");
        arrayList.add("this is");
        arrayList.add("Menu");
        arrayList.add("app");
        arrayList.add("Thank you");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(file.this,"clicked item"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}