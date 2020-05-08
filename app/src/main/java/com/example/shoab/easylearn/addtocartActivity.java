package com.example.shoab.easylearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;

public class addtocartActivity extends AppCompatActivity implements Serializable {

    Toolbar toolbar;
    TextView name,type,price,description,totalprice;
    EditText quantity;
    ImageButton addtocart;

    String tempvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        toolbar = findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocartActivity.super.onBackPressed();
            }
        });
        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Add Medicine to cart");



        name = findViewById(R.id.medicinename);
        type = findViewById(R.id.medicinetype);
        price = findViewById(R.id.medicineprice);
        description = findViewById(R.id.medicinedescription);
        totalprice = findViewById(R.id.totalprice);
        quantity = findViewById(R.id.medicinequantity);
        addtocart = findViewById(R.id.addtocart);



        Intent i = getIntent();
        final Model model = (Model)i.getSerializableExtra("data");

        name.setText(model.getName());
        type.setText(model.getSolution());
        price.setText(model.getType());
        description.setText(model.getDescription());
        totalprice.setText("0");



        quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().length()!=0){
                    tempvalue = String.valueOf(Integer.parseInt(s.toString())*Integer.parseInt(price.getText().toString()));
                    totalprice.setText(tempvalue);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicineModel model1 = new MedicineModel(name.getText().toString(),totalprice.getText().toString(),quantity.getText().toString());

                cartItem.setUsermodel(model1);

                Toast.makeText(addtocartActivity.this, "Medicine successfully added to cart.", Toast.LENGTH_SHORT).show();
                addtocartActivity.super.onBackPressed();
            }
        });

    }
}
