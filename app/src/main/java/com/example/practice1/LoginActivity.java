package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice1.DB.DBHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public final static String LOGIN_USERNAME = "LOGIN_USERNAME";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private User selectedUser;
    private Button loginBtn;
    private Button registerBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.userName);
        passwordEditText = findViewById(R.id.pwd);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        db = new DBHelper(this);

       loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               handleLoginClick();
           }
       });

       registerBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
               startActivity(intent);
           }
       });

    }

    private void handleLoginClick(){

        String uservalue = usernameEditText.getText().toString();
        String pwd = passwordEditText.getText().toString();

         selectedUser = db.login(uservalue, pwd);
         Intent intent = null;

         if(selectedUser == null){
             Context context = getApplicationContext();
             CharSequence text = "Username and password are wrong!";
             int duration = Toast.LENGTH_SHORT;

             Toast toast = Toast.makeText(context, text, duration);
             toast.show();
             return;
         } else if(selectedUser.getUserType().equalsIgnoreCase( "Teacher")){
              intent = new Intent(LoginActivity.this, TeacherActivity.class);
         } else if(selectedUser.getUserType().equalsIgnoreCase("Student")){
             intent = new Intent(LoginActivity.this, StudentActivity.class);
         }

         intent.putExtra(LOGIN_USERNAME, selectedUser.getUserName());
         startActivity(intent);
    }
}
