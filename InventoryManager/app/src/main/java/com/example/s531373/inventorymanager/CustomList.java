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

    private String[] textname;
    private String[] cost;
    private String[] quantity1;
    private Integer[] image;
    private Activity context;
    public CustomList( Activity context,String[] textname, String[] cost, String[] quantity1,Integer[] image) {
        super(context, R.layout.list_elements,textname);
        this.textname=textname;
        this.cost=cost;
        this.quantity1=quantity1;
        this.image=image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        viewholder viewholder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.list_elements,null,true);
            viewholder=new viewholder(r);
            r.setTag(viewholder);

        }
        else{
            viewholder=(viewholder)r.getTag();
        }
        viewholder.im.setImageResource(image[position]);
        viewholder.tn.setText(textname[position]);
        viewholder.qt.setText(quantity1[position]);
        viewholder.cs.setText(cost[position]);
        return r;

    }
    class viewholder{
        TextView tn;
        TextView cs;
        TextView qt;
        ImageView im;
        viewholder(View v){
//            tn=v.findViewById(R.id.editTextname);
            cs=v.findViewById(R.id.price);
            qt=v.findViewById(R.id.quantity);
            im=v.findViewById(R.id.image);
        }
    }
}

