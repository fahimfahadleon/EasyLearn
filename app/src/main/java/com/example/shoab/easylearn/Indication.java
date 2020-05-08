package com.example.shoab.easylearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


public class Indication extends AppCompatActivity  implements Serializable {

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

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Indication.super.onBackPressed();
            }
        });

        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Indication.this,ShowMedicine.class);
                i.putExtra("type","fever");
                startActivity(i);
            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Indication.this,ShowMedicine.class);
                i.putExtra("type","gastric");
                startActivity(i);
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Indication.this,ShowMedicine.class);
                i.putExtra("type","diarrhoea");
                startActivity(i);
            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Indication.this,ShowMedicine.class);
                i.putExtra("type","diabetes");
                startActivity(i);
            }
        });

    }
}
