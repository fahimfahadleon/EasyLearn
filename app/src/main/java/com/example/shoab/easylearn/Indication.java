package com.example.shoab.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class Indication extends AppCompatActivity {

    Button mbutton1;
    Button mbutton2;
    Button mbutton3;
    Button mbutton4;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_indication);
        mbutton1= findViewById(R.id.button_fever);
        mbutton2= findViewById(R.id.button_gastric);
        mbutton3= findViewById(R.id.button_diarrhoea);
        mbutton4= findViewById(R.id.button_Diabetes);

        toolbar = findViewById(R.id.toolbar);

        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Search by diseases");

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
