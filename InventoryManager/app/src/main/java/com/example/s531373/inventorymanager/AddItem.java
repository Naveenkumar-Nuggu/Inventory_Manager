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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddItem extends AppCompatActivity {

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
