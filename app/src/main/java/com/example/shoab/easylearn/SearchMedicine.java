package com.example.shoab.easylearn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;

public class SearchMedicine extends AppCompatActivity  implements Serializable {

    Toolbar toolbar;
    EditText searchedt;
    DatabaseHelper databaseHelper;
    ListView listView;


    ArrayList<Model>data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_medicine);

        listView = findViewById(R.id.searchitemlistview);
        toolbar = findViewById(R.id.toolbar);
        searchedt = findViewById(R.id.searchbar).findViewById(R.id.searchmedicineedt);
        databaseHelper = new DatabaseHelper(this);



        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Search Medicine");

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchMedicine.super.onBackPressed();
            }
        });
        toolbar.findViewById(R.id.toolbarmenubutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        searchedt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String word = s.toString();
                if (!word.isEmpty()){
                  data = databaseHelper.fetchdatabyfilter(word);
                  if(data.size()!=0){
                      ArrayList<Model> list = new ArrayList<>(data);
                      listView.setAdapter(new ListviewAdapter(SearchMedicine.this,list));
                  }else {
                      listView.setAdapter(null);
                  }
                }else {
                    listView.setAdapter(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public class ListviewAdapter extends ArrayAdapter<Model> {
        public ListviewAdapter(Context context, ArrayList<Model> users) {
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
