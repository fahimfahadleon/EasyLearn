package com.example.shoab.easylearn;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mButton7;
    Button mButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mButton1=(Button) findViewById(R.id.button1);
        mButton2=(Button) findViewById(R.id.button2);
        mButton3=(Button) findViewById(R.id.button3);
        mButton4=(Button) findViewById(R.id.button4);
        mButton5=(Button) findViewById(R.id.button5);
        mButton6=(Button) findViewById(R.id.button6);
        mButton7=(Button) findViewById(R.id.button7);
        mButton8=(Button) findViewById(R.id.button8);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_1=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_1.class);
                startActivity(Button_1);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_2=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_2.class);
                startActivity(Button_2);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_3=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_3.class);
                startActivity(Button_3);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_4=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_4.class);
                startActivity(Button_4);
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_5=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_5.class);
                startActivity(Button_5);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_6=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_6.class);
                startActivity(Button_6);
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_7=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_7.class);
                startActivity(Button_7);
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Button_8=new Intent(DashBoard.this,com.example.shoab.easylearn.Button_8.class);
                startActivity(Button_8);
            }
        });
    }
}
