package com.example.shoab.easylearn;

import android.Manifest;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {

    CardView mButton1;
    CardView mButton2;
    CardView mButton3;
    CardView mButton4;
    CardView mButton5;
    CardView mButton6;
    CardView mButton7;
    CardView mButton8;
    CardView mBUtton9;
    DrawerLayout drawerLayout;
    CardView cartbutton;
    ImageButton menu;
    private final int STORAGE_PERMISSION_CODE = 1;

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
        mBUtton9=findViewById(R.id.addprescription);
        drawerLayout = findViewById(R.id.drawerlayout);
        cartbutton = findViewById(R.id.cart);
        menu = findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });







        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this,cartActivity.class);
                startActivity(i);
            }
        });

        checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE);

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
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });



        Intent i = getIntent();
        final String status = i.getStringExtra("usertype");
        if(status.equals("nonadmin")){
            mButton7.setEnabled(false);
        }
        mBUtton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this,AddPrescription.class);
                i.putExtra("status",status);
                startActivity(i);
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
                Intent Button_6=new Intent(DashBoard.this, draglist.class);
                //drag list
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
                Button_8.putExtra("status",status);
                startActivity(Button_8);
            }
        });
    }

    public void checkPermission(String permission, int requestCode)
    {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(
                this,
                permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat
                    .requestPermissions(
                            this,
                            new String[] { permission },
                            requestCode);
        }
        else {
            Toast
                    .makeText(this,
                            "Permission already granted",
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

       if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(DashBoard.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(DashBoard.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
}
