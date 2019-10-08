package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practice1.DB.DBHelper;

public class TeacherActivity extends AppCompatActivity {

    private EditText subjectTextView;
    private EditText msgTextView;
    private Button sendButton;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        subjectTextView = findViewById(R.id.subjectTitle);
        msgTextView = findViewById(R.id.msg);
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
        Message msg = new Message(-1, "cat", subjectTextView.getText().toString(), msgTextView.getText().toString());

        long i = db.insertMessage(msg);
        if(i != -1) {
            Intent intent = new Intent(TeacherActivity.this, StudentActivity.class);
            startActivity(intent);
        }
    }


}
