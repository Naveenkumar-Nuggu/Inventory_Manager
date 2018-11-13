package com.example.s531373.inventorymanager;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.MimeTypeFilter;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

<<<<<<< HEAD
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.IOException;
=======
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
>>>>>>> 10b2aed67fa4c93d48caf7c3ac6c857b268eda87

public class AddItem extends AppCompatActivity {
    private String ORDER_TYPE="unknown";
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static final int PICK_IMAGE_REQUEST = 0;
    Uri actualUri;
    ImageView imageView;
    EditText name;
    EditText price;
    EditText quantity;
    Button save;
    EditText supplierNA;
    EditText supplierPh;
    EditText supplierEm;
    EditText Threshold;
    DatabaseReference databaseReference;
<<<<<<< HEAD
    StorageReference storagedata;
=======
>>>>>>> 10b2aed67fa4c93d48caf7c3ac6c857b268eda87

    private Bitmap yourSelectedImage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
<<<<<<< HEAD
        storagedata=FirebaseStorage.getInstance().getReference("Database");
=======
>>>>>>> 10b2aed67fa4c93d48caf7c3ac6c857b268eda87
        databaseReference =FirebaseDatabase.getInstance().getReference("Database");
        Threshold= (EditText)findViewById(R.id.number2ET);
supplierNA=(EditText)findViewById(R.id.editText6);
supplierPh=(EditText)findViewById(R.id.editText13);
supplierEm=(EditText)findViewById(R.id.editText14);
        name = (EditText) findViewById(R.id.nameET);
        price = (EditText) findViewById(R.id.priceET);
        quantity = (EditText) findViewById(R.id.quantityET);

        imageView = (ImageView) findViewById(R.id.imageView);
        Intent i = getIntent();

        Button click = (Button) findViewById(R.id.clickimg);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tryToOpenImageSelector();
            }
        });

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = getIntent();
if(actualUri !=null){
    StorageReference storageReference=storagedata.child(System.currentTimeMillis()+"."+getFileextension(actualUri));
storageReference.putFile(actualUri)
        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                String Itemname=name.getText().toString();
                String ItemPrice=price.getText().toString();
                String ItemQuantity=quantity.getText().toString();
                String IteamThreshold=Threshold.getText().toString();
                String SupplierName=supplierNA.getText().toString();
                String SupplierPhone=supplierPh.getText().toString();
                String SupplierEmail=supplierEm.getText().toString();
                if(!TextUtils.isEmpty(Itemname)&& !TextUtils.isEmpty(ItemPrice) && !TextUtils.isEmpty(ItemQuantity) && !TextUtils.isEmpty(IteamThreshold) && !TextUtils.isEmpty(SupplierName) && !TextUtils.isEmpty(SupplierEmail) && !TextUtils.isEmpty(SupplierPhone) ){
                    String id=databaseReference.push().getKey();
                    Database database=new Database(id,Itemname,ItemPrice,ItemQuantity,
                            IteamThreshold,SupplierName,SupplierPhone,SupplierEmail,
                            taskSnapshot.getDownloadUrl().toString());
                    String uploadID=databaseReference.push().getKey();
//                    databaseReference.child(uploadID).setValue()
                    databaseReference.child(id).setValue(database);
                    name.setText("");
                    price.setText("");
                    quantity.setText("");
                    Threshold.setText("");
                    supplierNA.setText("");
                    supplierPh.setText("");
                    supplierEm.setText("");

                }
                else {
                    Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        })
        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
double process=(100.0* taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());

            }
        });

}

                ini.putExtra("name",name.getText().toString());
                ini.putExtra("price",price.getText().toString());
                ini.putExtra("quantity",quantity.getText().toString());
                ini.putExtra("image", BitmapFactory.decodeResource(getResources(),R.id.imageView));


                setResult(Activity.RESULT_OK,ini);
                String Itemname=name.getText().toString();
    String ItemPrice=price.getText().toString();
    String ItemQuantity=quantity.getText().toString();
    String IteamThreshold=Threshold.getText().toString();
    String SupplierName=supplierNA.getText().toString();
    String SupplierPhone=supplierPh.getText().toString();
    String SupplierEmail=supplierEm.getText().toString();
                if(!TextUtils.isEmpty(Itemname)&& !TextUtils.isEmpty(ItemPrice) && !TextUtils.isEmpty(ItemQuantity) && !TextUtils.isEmpty(IteamThreshold) && !TextUtils.isEmpty(SupplierName) && !TextUtils.isEmpty(SupplierEmail) && !TextUtils.isEmpty(SupplierPhone) ){
                    String id=databaseReference.push().getKey();
                    Database database=new Database(id,Itemname,ItemPrice,ItemQuantity,IteamThreshold,SupplierName,SupplierPhone,SupplierEmail);
                    databaseReference.child(id).setValue(database);
                    name.setText("");
                    price.setText("");
                    quantity.setText("");
                    Threshold.setText("");
                    supplierNA.setText("");
                    supplierPh.setText("");
                    supplierEm.setText("");

                }
                else {
                    Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });




        Button plus1 = (Button) findViewById(R.id.plus1BTN);
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstin = (EditText) findViewById(R.id.quantityET);
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
                EditText firstin = (EditText) findViewById(R.id.quantityET);
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
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                savebutuuon();
//            }
//        });

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
        Intent ini=new Intent();
        ini.setType("image/*");
        if (Build.VERSION.SDK_INT < 19) {
            ini = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            ini = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            ini.addCategory(Intent.CATEGORY_OPENABLE);
        }
        //ini.setType("image/*");
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

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
//
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
//
//            if (resultData != null) {
//                actualUri = resultData.getData();
//                imageView.setImageURI(actualUri);
//                imageView.invalidate();
//            }
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null){
            actualUri = data.getData();
            imageView.setImageURI(actualUri);
        }
    }


<<<<<<< HEAD
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
//            if (data != null && data.getData() != null) {
//                actualUri = data.getData();
////                DatabaseReference filepath = databaseReference.child(actualUri.getLastPathSegment());
//try{
//    Bitmap bm=MediaStore.Images.Media.getBitmap(getContentResolver(),actualUri);
//    imageView.setImageBitmap(bm);
//} catch (FileNotFoundException e) {
//    e.printStackTrace();
//} catch (IOException e) {
//    e.printStackTrace();
//}
//            }
//
//        }
//
//    }
    public String getFileextension  (Uri uri){
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

    }
//

=======
>>>>>>> 10b2aed67fa4c93d48caf7c3ac6c857b268eda87
//public void savebutuuon(){
//    String Itemname=name.getText().toString();
////    String ItemPrice=price.getText().toString();
////    String ItemQuantity=quantity.getText().toString();
////    String IteamThreshold=Threshold.getText().toString();
////    String SupplierName=supplierNA.getText().toString();
////    String SupplierPhone=supplierPh.getText().toString();
////    String SupplierEmail=supplierEm.getText().toString();
//    if(!TextUtils.isEmpty(Itemname)){
//        String id=databaseReference.push().getKey();
//        Database database=new Database(id,Itemname);
//        databaseReference.child(id).setValue(database);
//        name.setText("");
//
//    }
//    else {
//        Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
//    }
//}





}
