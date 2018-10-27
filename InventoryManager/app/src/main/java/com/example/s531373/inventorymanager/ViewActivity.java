package com.example.s531373.inventorymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent=getIntent();
        String text3=intent.getStringExtra(EditItem.Textfrom1);
        String[] a1=text3.split("#");
        String ItemName =a1[0];
        String ItemPrice=a1[1];
        String ItemQuantity=a1[2];
        String SupplierName=a1[3];
        String SupplierPhone=a1[4];
        String SupllierEmail=a1[5];

        TextView price1=(TextView) findViewById(R.id.textView16);
        price1.setText(ItemPrice);
//        TextView ItemName1=(TextView) findViewById(R.id.textView16);
        TextView ItemQuantity1=(TextView) findViewById(R.id.textView17);
        ItemQuantity1.setText(ItemQuantity);
        TextView SupplierName1=(TextView) findViewById(R.id.textView14);
//        TextView SupplierPhone1=(TextView) findViewById(R.id.textView16);

        TextView SupplierEmail1=(TextView) findViewById(R.id.textView15);
        SupplierEmail1.setText(SupllierEmail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }
}
