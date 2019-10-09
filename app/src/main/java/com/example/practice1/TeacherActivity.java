package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practice1.DB.DBHelper;

public class TeacherActivity extends AppCompatActivity {

    private EditText subjectEditText;
    private EditText msgEditText;
    private Button sendButton;

    private String userName;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        subjectEditText = findViewById(R.id.subjectTitle);
        msgEditText = findViewById(R.id.msg);
        sendButton = findViewById(R.id.sendBtn);
        db = new DBHelper(this);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg();
            }
        });
    }

    public void sendMsg(){
        Message msg = new Message(-1, "cat", subjectEditText.getText().toString(), msgEditText.getText().toString());

        long i = db.insertMessage(msg);
        if(i != -1) {
            Intent intent = new Intent(TeacherActivity.this, StudentActivity.class);
            startActivity(intent);
        }
    }


}
