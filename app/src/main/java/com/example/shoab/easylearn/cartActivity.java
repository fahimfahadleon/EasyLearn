package com.example.shoab.easylearn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cartActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    ArrayList<MedicineModel> models;
    int totalpriceint;
    TextView totalpricetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.showcartitem);
        totalpricetv = findViewById(R.id.totalprice);

        TextView title =toolbar.findViewById(R.id.toolbartitle);
        title.setText("Shopping Cart");

        toolbar.findViewById(R.id.toolbarbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartActivity.super.onBackPressed();
            }
        });

         if(cartItem.getmodel()!=null){
             models = cartItem.getmodel();

             for(int i = 0;i<models.size();i++){
                 totalpriceint = totalpriceint + Integer.parseInt(models.get(i).getMedicinePrice());
             }

             listView.setAdapter(new ListviewAdapter(this,models));

             totalpricetv.setText(String.valueOf("Total Price: "+totalpriceint));

         }else {
             Toast.makeText(this, "Your cart is empty", Toast.LENGTH_SHORT).show();
             listView.setAdapter(null);
         }

    }


    public static class ListviewAdapter extends ArrayAdapter<MedicineModel> {
        ListviewAdapter(Context context, ArrayList<MedicineModel> users) {
            super(context, 0, users);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            MedicineModel model = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.cartitem, parent, false);
            }
            // Lookup view for data population

            TextView tvname = convertView.findViewById(R.id.textitemname);
            TextView tvprice = convertView.findViewById(R.id.textitemprice);
            TextView tvquantity = convertView.findViewById(R.id.textitemquantity);
            // Populate the data into the template view using the data object

            tvname.setText(model.getMedicinename());
            tvprice.setText(model.getMedicinePrice());
            tvquantity.setText(model.getMedicineQuantity());
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
