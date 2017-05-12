package com.example.gs.Controller.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gs.Model.ItemModel;
import com.example.gs.R;

import java.util.List;

/**
 * Created by Alumne on 06/03/2017.
 */

public class MyListadapter extends BaseAdapter {
    private Activity activity;
    private List<ItemModel> data;
    private LayoutInflater inflater;
    private int item_layout;

    public MyListadapter(Activity activity, List<ItemModel> data, int item_layout ) {
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.data = data;
    }



    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //set custom layout
        if(convertView==null){
            convertView=this.inflater.inflate(item_layout,null);
        }
        //Get Views from custom layout

        TextView itemTitle=(TextView) convertView.findViewById(R.id.itemTitel);
        TextView itemDificultad=(TextView) convertView.findViewById(R.id.itemNota);

        //Set values for item at position

        itemTitle.setText(data.get(position).getTitle());
        itemDificultad.setText(data.get(position).getNota());

        return convertView;
    }
}
