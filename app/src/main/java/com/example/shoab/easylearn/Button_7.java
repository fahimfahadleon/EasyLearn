package com.example.shoab.easylearn;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        mEditText = (EditText) findViewById(R.id.edittext_button7);

        mButton =findViewById(R.id.button_button7);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.addDrag(mEditText.getText().toString());
               final ArrayList<String> mylist = new ArrayList<>();
                if(c!=null){
                    while (c.moveToNext()){
                        String dragname= c.getString(1);


                        mylist.add(dragname);
                    }
                }



            }
        });


    }
}
