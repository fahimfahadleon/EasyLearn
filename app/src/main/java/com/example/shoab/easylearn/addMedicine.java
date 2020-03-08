package com.example.shoab.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class addMedicine extends AppCompatActivity {
    EditText dragname,dragtype,dragdescription,dragsolution;
    Button mButton;
    DatabaseHelper db;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine);
        db=new DatabaseHelper(this);
        dragname = (EditText) findViewById(R.id.add_drag_name);
        dragtype = findViewById(R.id.add_type);
        dragdescription = findViewById(R.id.add_drag_descryption);
        dragsolution = findViewById(R.id.add_drag_problem);
        toolbar = findViewById(R.id.toolbar);

        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Add Medicine");

        toolbar.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DashBoard.class));
            }
        });
        toolbar.findViewById(R.id.buttonsignout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

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
                    long ver = db.addDrag(name,type,description,solution);
                    if(ver<0){
                        Toast.makeText(addMedicine.this, "Drag Add Failed Internal Error!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(addMedicine.this, "Drag Add Successful!", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


    }
}
