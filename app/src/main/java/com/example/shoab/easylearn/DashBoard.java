package com.example.shoab.easylearn;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class DashBoard extends AppCompatActivity {

    CardView mButton1;
    CardView mButton2;
    CardView mButton3;
    CardView mButton4;
    CardView mButton5;
    CardView mButton6;
    CardView mButton7;
    CardView mButton8;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mButton1=findViewById(R.id.button1);
        mButton2=findViewById(R.id.button2);
        mButton3= findViewById(R.id.button3);
        mButton4= findViewById(R.id.button4);
        mButton5= findViewById(R.id.button5);
        mButton6= findViewById(R.id.button6);
        mButton7= findViewById(R.id.button7);
        mButton8= findViewById(R.id.button8);
        drawerLayout = findViewById(R.id.drawerlayout);


        drawerLayout.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        drawerLayout.findViewById(R.id.buttonsignout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });



        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_1=new Intent(DashBoard.this, SearchMedicine.class);
                startActivity(Button_1);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_2=new Intent(DashBoard.this, Indication.class);
                startActivity(Button_2);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_3=new Intent(DashBoard.this, visitingCard.class);
                startActivity(Button_3);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_4=new Intent(DashBoard.this, news.class);
                startActivity(Button_4);
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_5=new Intent(DashBoard.this, shortbyclass.class);
                startActivity(Button_5);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_6=new Intent(DashBoard.this, showbytype.class);
                startActivity(Button_6);
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_7=new Intent(DashBoard.this, addMedicine.class);
                startActivity(Button_7);
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_8=new Intent(DashBoard.this, job.class);
                startActivity(Button_8);
            }
        });
    }
}
