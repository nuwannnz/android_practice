package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.practice1.DB.DBHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.userName);
        passwordEditText = findViewById(R.id.pwd);

        db = new DBHelper(this);

        String uservalue = usernameEditText.getText().toString();
        String pwd = passwordEditText.getText().toString();



        db.login(uservalue, pwd);



    }
}
