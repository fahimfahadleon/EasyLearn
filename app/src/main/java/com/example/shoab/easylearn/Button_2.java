package com.example.shoab.easylearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

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
                Intent DrugByIndication=new Intent(Button_2.this, com.example.shoab.easylearn.DrugByIndication.class);
                startActivity(DrugByIndication);
            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Gastric=new Intent(Button_2.this ,Gastric.class);
                startActivity(Gastric);
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Diarrhoea=new Intent(Button_2.this, com.example.shoab.easylearn.Diarrhoea.class);
                startActivity(Diarrhoea);
            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Diabetes=new Intent(Button_2.this , com.example.shoab.easylearn.Diabetes.class);
                startActivity(Diabetes);
            }
        });

    }
}
