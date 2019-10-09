package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice1.DB.DBHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox teacherCheckBox;
    private CheckBox studentCheckBox;
    private Button registerBtn;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.userName);
        passwordEditText = findViewById(R.id.pwd);
        teacherCheckBox = findViewById(R.id.teacher);
        studentCheckBox = findViewById(R.id.student);
        registerBtn = findViewById(R.id.registerBtn);

        db = new DBHelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void registerUser(){
        String type = " ";

        if(teacherCheckBox.isChecked()){
            type = "Teacher";

        } else if(studentCheckBox.isChecked()){
            type = "Student";
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Select User Type!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        User user = new User(-1, usernameEditText.getText().toString(), "type", passwordEditText.getText().toString());

        db.insertUser(user);

    }
}
