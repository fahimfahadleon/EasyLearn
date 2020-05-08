package com.example.shoab.easylearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class visitingCard extends AppCompatActivity {


    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitingcard);


        toolbar = findViewById(R.id.toolbar);


        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Visiting Card");

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitingCard.super.onBackPressed();
            }
        });

    }
}
