package com.example.s531373.inventorymanager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private String[] name;
    private Integer[] imgid;
    private String[] price;
    private String[] quantity;
    private Activity context;

    public CustomList(@NonNull Activity context, String[] name, Integer[] imgid,String[] price, String[] quantity) {
        super(context, R.layout.list_elements,name);
        this.context=context;
        this.imgid=imgid;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.list_elements,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.iv.setImageResource(imgid[position]);
        viewHolder.tv1.setText(name[position]);
        viewHolder.ptv.setText("Price : $"+price[position]);
        viewHolder.qtv.setText("Quantity : " +quantity[position]);
        return r;
    }
    class ViewHolder{
        TextView tv1;
        ImageView iv;
        TextView ptv;
        TextView qtv;
        ViewHolder(View v) {
            tv1 = v.findViewById(R.id.product_name);
            iv = v.findViewById(R.id.prodctimg);
            ptv = v.findViewById(R.id.price);
            qtv = v.findViewById(R.id.quantity);
        }
    }
}

