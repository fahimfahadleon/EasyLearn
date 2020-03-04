package com.example.shoab.easylearn;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                boolean res = db.checkUser(user, pwd);
                if (res) {
                    Intent DashBoard= new Intent(LoginActivity.this,DashBoard.class);
                    startActivity(DashBoard);

                } else {
                    Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}