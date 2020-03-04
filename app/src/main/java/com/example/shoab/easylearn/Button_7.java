package com.example.shoab.easylearn;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class Button_7 extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_7);
        db=new DatabaseHelper(this);
        mEditText = (EditText) findViewById(R.id.add_drag_name);

        mButton =findViewById(R.id.button_button7);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


    }
}
