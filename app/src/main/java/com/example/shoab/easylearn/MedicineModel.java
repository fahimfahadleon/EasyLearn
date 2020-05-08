package com.example.shoab.easylearn;

import java.io.Serializable;

public class MedicineModel implements Serializable {
    public  String Medicinename;
    public  String MedicinePrice;
    public  String MedicineQuantity;

    public MedicineModel(String medicinename, String medicinePrice, String medicineQuantity) {
        Medicinename = medicinename;
        MedicinePrice = medicinePrice;
        MedicineQuantity = medicineQuantity;
    }

    public String getMedicinename() {
        return Medicinename;
    }

    public String getMedicinePrice() {
        return MedicinePrice;
    }

    public String getMedicineQuantity() {
        return MedicineQuantity;
    }
}
