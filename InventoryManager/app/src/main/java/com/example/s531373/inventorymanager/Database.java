package com.example.s531373.inventorymanager;

public class Database {
    private String Itemname;
    private String ItemPrice;
    private String ItemQuantity;
    private String IteamThreshold;
    private String SupplierName;
    private String SupplierPhone;
    private String SupplierEmail;

    public Database(){

    }

    public Database(String itemname, String itemPrice, String itemQuantity, String iteamThreshold, String supplierName, String supplierPhone, String supplierEmail) {
        Itemname = itemname;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
        IteamThreshold = iteamThreshold;
        SupplierName = supplierName;
        SupplierPhone = supplierPhone;
        SupplierEmail = supplierEmail;
    }

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
