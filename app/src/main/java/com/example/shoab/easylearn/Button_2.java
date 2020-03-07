package com.example.shoab.easylearn;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Button_2 extends AppCompatActivity {

    Button mbutton1;
    Button mbutton2;
    Button mbutton3;
    Button mbutton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_2);
        mbutton1=(Button)findViewById(R.id.button_fever);
        mbutton2=(Button)findViewById(R.id.button_gastric);
        mbutton3=(Button)findViewById(R.id.button_diarrhoea);
        mbutton4=(Button)findViewById(R.id.button_Diabetes);
        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
