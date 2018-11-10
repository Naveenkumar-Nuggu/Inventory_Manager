package com.example.s531373.inventorymanager;

import com.google.firebase.database.FirebaseDatabase;

public class Database {
    private String Id;
    private String Itemname;
    private String ItemPrice;
    private String ItemQuantity;
    private String IteamThreshold;
    private String SupplierName;
    private String SupplierPhone;
    private String SupplierEmail;

    public Database(){

    }

    public Database(String id,String itemname, String itemPrice, String itemQuantity, String iteamThreshold, String supplierName, String supplierPhone, String supplierEmail) {
        Itemname = itemname;
        Id = id;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
        IteamThreshold = iteamThreshold;
        SupplierName = supplierName;
        SupplierPhone = supplierPhone;
        SupplierEmail = supplierEmail;
    }
    public String getId() {
        return Id;
    }

//    public Database(String id, String itemname) {
//        this.Itemname = itemname;
//
//        this.Id=itemname;
//    }

//    }


    public String getItemname() {
        return Itemname;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public String getItemQuantity() {
        return ItemQuantity;
    }

    public String getIteamThreshold() {
        return IteamThreshold;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public String getSupplierPhone() {
        return SupplierPhone;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }


}
