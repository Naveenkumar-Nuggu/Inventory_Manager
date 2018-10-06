package com.example.s531373.inventorymanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button edititem=(Button)findViewById(R.id.button);
        edititem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity2();
            }
        });

        Button edititem1=(Button)findViewById(R.id.button5);
        edititem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity1();
            }
        });

        Button status=(Button)findViewById(R.id.button6);
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
                Toast.makeText(getApplicationContext(),"Please Wait...",Toast.LENGTH_SHORT).show();
                openAddActivity();
            }
        });

     Button delete =(Button)findViewById(R.id.btdelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage("Are you sure to delete this item");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Clicked Ok", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Clicked Cancel", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }
    public  void openEdititemactivity2(){
        Intent intent=new Intent(this,EditItem.class);
        startActivityForResult(intent,1);
    }
    public  void openEdititemactivity1(){
        Intent intent=new Intent(this,ViewActivity.class);
        startActivityForResult(intent,1);
    }
    public  void openEdititemactivity3(){
        System.out.println("Status Intent initiated");
        Intent intent=new Intent(this,StatusActivity.class);
        startActivityForResult(intent,1);
    }

    public void openAddActivity(){
        Intent in = new Intent(MainActivity.this,AddItem.class);
        startActivityForResult(in,1);
    }


}


