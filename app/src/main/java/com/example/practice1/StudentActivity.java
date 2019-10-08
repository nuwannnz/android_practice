package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.practice1.DB.DBHelper;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db = new DBHelper(this);


        ArrayList<Message> msgList = db.getAllMessage();


        ListView listView = findViewById(R.id.itemList);

        MessageAdapter msgAdapter = new MessageAdapter(msgList, this);

        listView.setAdapter(msgAdapter);


    }


}
