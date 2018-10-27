package com.example.s531373.inventorymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class EditItem extends AppCompatActivity {
    public static final String Textfrom1="test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititem);
        Intent intent=getIntent();
        Button save=(Button) findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }
public void activity(){
    EditText itemName1=(EditText) findViewById(R.id.editText7);
    String itemName=itemName1.getText().toString();
    EditText itemPrice1=(EditText) findViewById(R.id.editText8);
    String itemPrice =itemPrice1.getText().toString();
    EditText itemQuantity1=(EditText) findViewById(R.id.editText9);
    String itemQuantity =itemQuantity1.getText().toString();
    EditText SupplierName1=(EditText) findViewById(R.id.editText10);
    String SupplierName=SupplierName1.getText().toString();
    EditText SupplierPhone1=(EditText) findViewById(R.id.editText11);
    String SupplierPhone=SupplierPhone1.getText().toString();
    EditText SupplierEmail1=(EditText) findViewById(R.id.editText12);
    String SupplierEmail=SupplierEmail1.getText().toString();
    String r= itemName+"#"+itemPrice+"#"+itemQuantity+"#"+SupplierName+"#"+SupplierPhone+"#"+SupplierEmail;

    Intent intent= new Intent(this,ViewActivity.class);
    intent.putExtra(Textfrom1,r);
    startActivityForResult(intent,1);

    }
}
