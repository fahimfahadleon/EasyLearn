package com.example.shoab.easylearn;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class Button_7 extends AppCompatActivity {
    EditText dragname,dragtype,dragdescription,dragsolution;
    Button mButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_7);
        db=new DatabaseHelper(this);
        dragname = (EditText) findViewById(R.id.add_drag_name);
        dragtype = findViewById(R.id.add_type);
        dragdescription = findViewById(R.id.add_drag_descryption);
        dragsolution = findViewById(R.id.add_drag_problem);

        mButton =findViewById(R.id.button_button7);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = dragname.getText().toString();
                String type = dragtype.getText().toString();
                String description = dragdescription.getText().toString();
                String solution = dragsolution.getText().toString();

                if(TextUtils.isEmpty(name)){
                    dragname.setError("Field Can Not Be Empty!");
                    dragname.requestFocus();
                    dragname.setCursorVisible(true);
                }else if(TextUtils.isEmpty(type)){
                    dragtype.setError("Field Can Not Be Empty!");
                    dragtype.requestFocus();
                    dragtype.setCursorVisible(true);
                }else if(TextUtils.isEmpty(description)){
                    dragdescription.setError("Field Can Not Be Empty!");
                    dragdescription.requestFocus();
                    dragdescription.setCursorVisible(true);
                }else if(TextUtils.isEmpty(solution)){
                    dragsolution.setError("Field Can Not Be Empty!");
                    dragsolution.requestFocus();
                    dragsolution.setCursorVisible(true);
                }else {

                }


            }
        });


    }
}
