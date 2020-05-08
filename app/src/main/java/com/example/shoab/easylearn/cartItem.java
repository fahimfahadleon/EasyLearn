package com.example.shoab.easylearn;



import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class cartItem {

     static ArrayList<MedicineModel> allusermodel = new ArrayList<>();

     static void setUsermodel(MedicineModel usermodel) {
        allusermodel.add(allusermodel.size(),usermodel);


         for(int i = 0;i<allusermodel.size();i++){
             Log.e(String.valueOf(i),allusermodel.get(i).getMedicinename());
         }

    }




    static ArrayList<MedicineModel> getmodel(){
        return allusermodel;
    }

}
