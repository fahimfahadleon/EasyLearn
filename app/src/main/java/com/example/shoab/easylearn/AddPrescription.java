package com.example.shoab.easylearn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
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
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class AddPrescription extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton addprescription;
    ListView listView;

    ArrayList<Bitmap> userbitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescription);
        addprescription = findViewById(R.id.uploadcv);
        listView = findViewById(R.id.cvlist);
        userbitmap = new ArrayList<>();


        toolbar = findViewById(R.id.toolbar);

        TextView title = toolbar.findViewById(R.id.toolbartitle);
        title.setText("Submit CV");


        Intent i = getIntent();
        String status = i.getStringExtra("status");


        if (status.equals("nonadmin")) {
            addprescription.setEnabled(false);

            String checkdata = Environment.getExternalStorageDirectory().getAbsolutePath() + "/prescription/";
            File directory = new File(checkdata);

            if (directory.exists()) {
                ArrayList<String> files = getFile(directory);

                listView.setAdapter(new ListviewPreadapter(this, files));
            }
        }

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPrescription.super.onBackPressed();
            }
        });


        addprescription.setOnClickListener(new View.OnClickListener() {
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


                listView.setAdapter(new ListviewAdapter(this, userbitmap));


                String filename = System.currentTimeMillis() + ".png";

                String storage = Environment.getExternalStorageDirectory().getAbsolutePath() + "/prescription/";


                File sd = new File(storage);
                if (!sd.exists()) {
                    if (sd.mkdirs()) {
                        Toast.makeText(this, "directory created", Toast.LENGTH_SHORT).show();
                    }
                }

                File dest = new File(sd, filename);

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                try {
                    FileOutputStream out = new FileOutputStream(dest);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("error 1", e.getMessage());
                }

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("error 2", e.getMessage());
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static class ListviewAdapter extends ArrayAdapter<Bitmap> {
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


    public static class ListviewPreadapter extends ArrayAdapter<String> {
        public ListviewPreadapter(Context context, ArrayList<String> users) {
            super(context, 0, users);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            final String filelocation = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.cvlayout, parent, false);
            }
            // Lookup view for data population

            ImageView tvHome = convertView.findViewById(R.id.cvtext);
            // Populate the data into the template view using the data object

            File file = new File(filelocation);


            Log.e("file location", file.getAbsolutePath());

            if (file.exists()) {

                Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                tvHome.setImageBitmap(myBitmap);
            }
            // Return the completed view to render on screen
            return convertView;
        }
    }


    public ArrayList<String> getFile(File dir) {

        ArrayList<String> fileslocation = new ArrayList<>();
        File[] listFile = dir.listFiles();


        if (listFile != null) {

            Log.e("directory", "listfile not null");
            for (int i = 0; i < listFile.length; i++) {
                Log.e("files", listFile[i].getName());

                Log.e("filespath", listFile[i].getAbsolutePath());
            }

            for (File file : listFile) {


                if (file.getName().endsWith(".png")) {

                    String temp = file.getAbsolutePath();
                    if (!fileslocation.contains(temp))
                        fileslocation.add(temp);
                }

            }
        }


        return fileslocation;
    }
}
