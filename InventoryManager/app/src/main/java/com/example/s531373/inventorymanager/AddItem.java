package com.example.s531373.inventorymanager;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class AddItem extends AppCompatActivity {
    private String ORDER_TYPE="unknown";
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static final int PICK_IMAGE_REQUEST = 0;
    Uri actualUri;
    ImageView imageView;

    private Bitmap yourSelectedImage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        imageView = (ImageView) findViewById(R.id.imageView);
        Intent i = getIntent();

        Button click = (Button) findViewById(R.id.clickimg);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tryToOpenImageSelector();
            }
        });




        Button plus1 = (Button) findViewById(R.id.plus1BTN);
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstin = (EditText) findViewById(R.id.number1ET);
                String str = firstin.getText().toString();
                int i = Integer.parseInt(str);
                i++;
                firstin.setText(""+i);
            }
        });

        Button minus1 = (Button) findViewById(R.id.minus1BTN);
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstin = (EditText) findViewById(R.id.number1ET);
                String str = firstin.getText().toString();
                int i = Integer.parseInt(str);
                i--;
                if(i<0){
                    firstin.setText(""+0);
                }
                else {
                    firstin.setText("" + i);
                }
            }
        });


        Button plus2 = (Button) findViewById(R.id.plus2BTN);
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText seconin = (EditText) findViewById(R.id.number2ET);
                String str = seconin.getText().toString();
                int i = Integer.parseInt(str);
                i++;
                seconin.setText(""+i);
            }
        });

        Button minus2 = (Button) findViewById(R.id.minus2BTN);
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText seconin = (EditText) findViewById(R.id.number2ET);
                String str = seconin.getText().toString();
                int i = Integer.parseInt(str);
                i--;
                if(i<0){
                    seconin.setText(""+0);
                }
                else {
                    seconin.setText("" + i);
                }
            }
        });

        RadioButton rd1 = (RadioButton) findViewById(R.id.autoRD);
        RadioButton rd2 = (RadioButton) findViewById(R.id.manRD);
        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rd1 = (RadioButton) findViewById(R.id.autoRD);
                RadioButton rd2 = (RadioButton) findViewById(R.id.manRD);
                if(rd2.isChecked()) {
                    rd2.setChecked(false);
                    rd1.setChecked(true);
                    ORDER_TYPE="Auto";
                }
                else{
                    rd1.setChecked(true);
                    ORDER_TYPE="Auto";
                }
            }
        });




        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rd1 = (RadioButton) findViewById(R.id.autoRD);
                RadioButton rd2 = (RadioButton) findViewById(R.id.manRD);

               if(rd1.isChecked()){
                   rd1.setChecked(false);
                   rd2.setChecked(true);
                   ORDER_TYPE="Manual";
               }
               else{
                   rd2.setChecked(true);
                   ORDER_TYPE="Manual";
               }
            }
        });

    }

    public void tryToOpenImageSelector() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            return;
        }
        openImageSelector();
    }

    private void openImageSelector() {
        Intent ini;
        if (Build.VERSION.SDK_INT < 19) {
            ini = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            ini = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            ini.addCategory(Intent.CATEGORY_OPENABLE);
        }
        ini.setType("image/*");
        startActivityForResult(Intent.createChooser(ini, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openImageSelector();

                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {


        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {

            if (resultData != null) {
                actualUri = resultData.getData();
                imageView.setImageURI(actualUri);
                imageView.invalidate();
            }
        }
    }








}
