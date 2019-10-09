package com.example.practice1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.practice1.DB.DBHelper;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    public final static String SUBJECT = "SUBJECT";
    public final static String MESSAGE = "MESSAGE";

    private ArrayList<Message> msgList;

    DBHelper db;


    public void popupDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.msgNotify)
                .setPositiveButton(R.string.view, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Message msg = msgList.get(msgList.size() - 1);
                        Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                        intent.putExtra(SUBJECT, msg.getSubject());
                        intent.putExtra(MESSAGE, msg.getMsg());
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
         builder.create();
         builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db = new DBHelper(this);


        msgList = db.getAllMessage();


        ListView listView = findViewById(R.id.itemList);

        MessageAdapter msgAdapter = new MessageAdapter(msgList, this);

        listView.setAdapter(msgAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message msg = msgList.get(position);
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                intent.putExtra(SUBJECT, msg.getSubject());
                intent.putExtra(MESSAGE, msg.getMsg());
                startActivity(intent);
            }
        });

        popupDialog();

    }


}
