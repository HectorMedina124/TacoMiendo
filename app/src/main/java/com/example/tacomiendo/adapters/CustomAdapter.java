package com.example.tacomiendo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacomiendo.R;

public class CustomAdapter  extends BaseAdapter {
    String[] alimentos;
    int[] alimentosid;
    LayoutInflater layoutInflater;
    String[] precios;
    public CustomAdapter(String [] alimentos,int[]alimentosid,LayoutInflater layoutInflater,String[] precios){
        this.alimentos=alimentos;
        this.alimentosid=alimentosid;
        this.layoutInflater=layoutInflater;
        this.precios=precios;
    }
    @Override
    public int getCount() {
        return alimentos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view1=layoutInflater.inflate(R.layout.row_data,null);
        TextView name=view1.findViewById(R.id.comida);
        ImageView image=view1.findViewById(R.id.images);
        name.setText(alimentos[position]);
        image.setImageResource(alimentosid[position]);
        TextView precio=view1.findViewById(R.id.precio);
        precio.setText(precios[position]);
        return view1;
    }

}

