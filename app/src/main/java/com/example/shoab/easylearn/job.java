package com.example.shoab.easylearn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;




public class job extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton addcv;
    ListView listView;

    ArrayList<Bitmap> userbitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job);
        addcv = findViewById(R.id.uploadcv);
        listView = findViewById(R.id.cvlist);
        userbitmap = new ArrayList<>();

        toolbar = findViewById(R.id.toolbar);

        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Submit CV");


        Intent i = getIntent();
        String status = i.getStringExtra("status");


        if(status.equals("admin")){
            addcv.setEnabled(false);
        }

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                job.super.onBackPressed();
            }
        });



        addcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);



            }
        });





    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            try {
                userbitmap.add(MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData()));
                Log.e("logmessage","picture picked");

                listView.setAdapter(new ListviewAdapter(this,userbitmap));

            } catch (IOException e) {
                e.printStackTrace();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public class ListviewAdapter extends ArrayAdapter<Bitmap> {
        public ListviewAdapter(Context context, ArrayList<Bitmap> users) {
            super(context, 0, users);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            final Bitmap model = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.cvlayout, parent, false);
            }
            // Lookup view for data population

            ImageView tvHome = convertView.findViewById(R.id.cvtext);
            // Populate the data into the template view using the data object



            tvHome.setImageBitmap(model);
            // Return the completed view to render on screen
            return convertView;
        }
    }

}
