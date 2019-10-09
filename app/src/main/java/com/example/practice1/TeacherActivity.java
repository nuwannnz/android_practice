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

    private EditText subjectEditText;
    private EditText msgEditText;
    private Button sendButton;
    private TextView teacherActivityTitle;

    private String userName;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        subjectEditText = findViewById(R.id.subjectTitle);
        msgEditText = findViewById(R.id.msg);
        sendButton = findViewById(R.id.sendBtn);
        teacherActivityTitle = findViewById(R.id.teacherActivityTitle);

        db = new DBHelper(this);

        Intent receivedIntent = getIntent();
        userName = receivedIntent.getExtras().getString(LoginActivity.LOGIN_USERNAME);

        teacherActivityTitle.setText("Welcome " + userName);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg();
            }
        });
    }

    public void sendMsg(){
        Message msg = new Message(-1, userName, subjectEditText.getText().toString(), msgEditText.getText().toString());

        long i = db.insertMessage(msg);
        if(i != -1) {
            Intent intent = new Intent(TeacherActivity.this, StudentActivity.class);
            startActivity(intent);
        }
    }


}
