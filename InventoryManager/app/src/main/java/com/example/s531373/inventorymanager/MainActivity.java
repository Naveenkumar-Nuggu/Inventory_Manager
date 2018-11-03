package com.example.s531373.inventorymanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class    MainActivity extends AppCompatActivity implements ValueEventListener {

    ArrayList<String> namelist;
    String [] name;
    ArrayList<Integer> imgidlist;
    Integer[] imgid;
    ArrayList<String> pricelist;
    String[] price;
    ArrayList<String> quantitylist;
    String[] quantity;
    ListView list;
    CustomList customList;



    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private DatabaseReference mchild = myRef.child("key");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        namelist = new ArrayList<>();
        namelist.add("Dove");
        namelist.add("Tide");
        namelist.add("Notebooks");

        name = namelist.toArray(new String[namelist.size()]);

        pricelist = new ArrayList<>();
        pricelist.add("10$");
        pricelist.add("20$");
        pricelist.add("30$");

        price = pricelist.toArray(new String[pricelist.size()]);

        quantitylist = new ArrayList<>();
        quantitylist.add("3");
        quantitylist.add("2");
        quantitylist.add("4");

        quantity = quantitylist.toArray(new String[quantitylist.size()]);


        imgidlist = new ArrayList<>();

        imgidlist.add(R.drawable.dove);
        imgidlist.add(R.drawable.tide);
        imgidlist.add(R.drawable.notebooks);

        imgid = imgidlist.toArray(new Integer[imgidlist.size()]);
        list = (ListView) findViewById(R.id.listview);

        customList = new CustomList(this,name,imgid,price,quantity);
        list.setAdapter(customList);

        //Sample test for firebase, writing objects
        mchild.setValue("Text");


        Button edititem = (Button) findViewById(R.id.button);
        edititem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity2();
            }
        });

        Button edititem1 = (Button) findViewById(R.id.plus1BTN);
        edititem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity1();
            }
        });

        Button status = (Button) findViewById(R.id.minus1BTN);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity3();
            }
        });


        Button add = (Button) findViewById(R.id.addBTN);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_SHORT).show();
                openAddActivity();
            }
        });

        Button delete = (Button) findViewById(R.id.btdelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage("Are you sure to delete this item");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked Ok", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.create();
                alertDialog.show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    public void openEdititemactivity2() {
        Intent intent = new Intent(this, EditItem.class);
        startActivityForResult(intent, 1);
    }

    public void openEdititemactivity1() {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivityForResult(intent, 1);
    }

    public void openEdititemactivity3() {
        System.out.println("Status Intent initiated");
        Intent intent = new Intent(this, StatusActivity.class);
        startActivityForResult(intent, 1);
    }

    public void openAddActivity() {
        Intent in = new Intent(MainActivity.this, AddItem.class);
        startActivityForResult(in, 1);
    }




    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}


