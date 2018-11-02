package com.example.s531373.inventorymanager;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class AddItem extends AppCompatActivity {
    private String ORDER_TYPE="unknown";

    private Bitmap yourSelectedImage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        Intent i = getIntent();

        Button click = (Button) findViewById(R.id.clickimg);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);

                startActivityForResult(img,1);


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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();


            Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
            ImageView imgsrc = (ImageView) findViewById(R.id.imageView);
            imgsrc.setImageBitmap(yourSelectedImage);
        }

    }





}
