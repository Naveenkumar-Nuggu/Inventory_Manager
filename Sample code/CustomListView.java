package com.example.s531373.inventorymanager;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {

    private String[] itemname;
    private String[] price;
    private String price1;
    private String quant;
    private String[] quantity;
    private Integer[] imgid;
    private Activity context;

    public CustomListView(Activity context, String[] itemname ,String[] price,String price1,String quant,String[] quantity,Integer[] imgid) {
        super(context, R.layout.listview_layout,itemname);
        this.context=context;
        this.itemname=itemname;
        this.price=price;
        this.price1=price1;
        this.quant=quant;
        this.quantity=quantity;
        this.imgid=imgid;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,   @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder= null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder =(ViewHolder) r.getTag();
        }
        viewHolder.imv.setImageResource(imgid[position]);
        viewHolder.tv1.setText(itemname[position]);
        viewHolder.tv2.setText(price1);
        viewHolder.tv3.setText(price[position]);
        viewHolder.tv1.setText(quant);
        viewHolder.tv1.setText(quantity[position]);
        return r;

    }

    class ViewHolder{
        TextView tv1,tv2,tv3,tv4,tv5;
        ImageView imv;
        ViewHolder(View v){
            tv1= v.findViewById(R.id.itemtv);
            tv2= v.findViewById(R.id.pricetv);
            tv3= v.findViewById(R.id.pricetv1);
            tv4= v.findViewById(R.id.quanttv);
            tv5= v.findViewById(R.id.quanttv1);
            imv= v.findViewById(R.id.imv);
        }

    }






}
