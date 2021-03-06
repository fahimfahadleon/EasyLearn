package com.example.shoab.easylearn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


public class shortbyclass extends AppCompatActivity implements Serializable {


    Toolbar toolbar;
    DatabaseHelper databaseHelper;
    ListView classlistveiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortbyclass);

        toolbar = findViewById(R.id.toolbar);
        databaseHelper = new DatabaseHelper(this);
        classlistveiw = findViewById(R.id.classlistview);

        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Medicine by class");

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortbyclass.super.onBackPressed();
            }
        });





        Cursor row = databaseHelper.GetAllData("DRUGLIST");
        ArrayList<Model> mylist = new ArrayList<>();

        if (row != null) {
            row.moveToFirst();
            while(!row.isAfterLast()){

                int id=row.getInt(row.getColumnIndex("ID"));
                String name=row.getString(row.getColumnIndex("name"));
                String type = row.getString(row.getColumnIndex("type"));
                String description = row.getString(row.getColumnIndex("description"));
                String solution = row.getString(row.getColumnIndex("solution"));

                mylist.add(new Model(id,name,type,description,solution));
                // do what ever you want here
                row.moveToNext();
            }

            row.close();
        }


        String [] myarray = new String[mylist.size()];
        for(int i = 0;i<mylist.size();i++){

            Model model = mylist.get(i);
            myarray[i] = model.getName();
        }


        Arrays.sort(myarray);

        ArrayList<Model> finalisemodel = new ArrayList<>();

        for (String s : myarray) {
            for (int j = 0; j < mylist.size(); j++) {
                if (mylist.get(j).getName().equals(s)) {
                    finalisemodel.add(mylist.get(j));
                }
            }
        }


        classlistveiw.setAdapter(new ListviewAdapter(this, finalisemodel));



    }


    public  class ListviewAdapter extends ArrayAdapter<Model> {
        ListviewAdapter(Context context, ArrayList<Model> users) {
            super(context, 0, users);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            final Model model = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemlayout, parent, false);
            }
            // Lookup view for data population

            TextView tvHome = convertView.findViewById(R.id.itemid);
            // Populate the data into the template view using the data object
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startcartactivity(model);
                }
            });

            tvHome.setText(model.getName());
            // Return the completed view to render on screen
            return convertView;
        }
    }
    void startcartactivity(Model model){
        Intent i = new Intent(this,addtocartActivity.class);
        i.putExtra("data",model);
        startActivity(i);

    }
}
