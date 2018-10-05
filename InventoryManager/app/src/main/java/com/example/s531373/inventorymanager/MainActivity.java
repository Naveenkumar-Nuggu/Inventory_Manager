package com.example.s531373.inventorymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
        Button edititem1=(Button)findViewById(R.id.button3);
        edititem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdititemactivity1();
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
}


