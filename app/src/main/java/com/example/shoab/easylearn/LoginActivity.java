package com.example.shoab.easylearn;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    AppCompatCheckBox statuschecker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        statuschecker = findViewById(R.id.statuscheckL);

        mButtonLogin = findViewById(R.id.button_login);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword = findViewById(R.id.edittext_password);
        mTextViewRegister = findViewById(R.id.textview_register);





        db = new DatabaseHelper(this);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                if(statuschecker.isChecked()){
                    boolean res = db.checkUser(user, pwd,"admin");
                    if (res) {
                        Intent DashBoard= new Intent(LoginActivity.this,DashBoard.class);
                        DashBoard.putExtra("usertype","admin");
                        startActivity(DashBoard);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    boolean res = db.checkUser(user, pwd,"nonadmin");
                    if (res) {
                        Intent DashBoard= new Intent(LoginActivity.this,DashBoard.class);
                        DashBoard.putExtra("usertype","nonadmin");
                        startActivity(DashBoard);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });

    }
}