package com.example.s531373.inventorymanager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AddAdapter extends ArrayAdapter<Database> {
    private Activity context;
    private List<Database> AddItemList;
    public  AddAdapter(Activity context,List<Database> AddItemList){
        super(context,R.layout.activity_additem);
        this.context=context;
        this.AddItemList=AddItemList;
    }

//    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.activity_additem,null,true);
        TextView productname=(TextView)view.findViewById(R.id.nameET);
        TextView price=(TextView)view.findViewById(R.id.priceET);
        TextView quantity=(TextView)view.findViewById(R.id.quantityET);
        Database addItem=AddItemList.get(position);
        productname.setText(addItem.getItemPrice());
        price.setText(addItem.getItemPrice());
        quantity.setText(addItem.getItemQuantity());
        return view;


    }
}
