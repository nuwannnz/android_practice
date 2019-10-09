package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private EditText msgEditText;
    private TextView subjectTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        msgEditText = findViewById(R.id.msg);
        subjectTitle = findViewById(R.id.subjectTitle);

        Intent receviedIntent = getIntent();
        msgEditText.setText(receviedIntent.getExtras().getString(StudentActivity.MESSAGE));

        subjectTitle.setText(receviedIntent.getExtras().getString(StudentActivity.SUBJECT));

    }
}
