package com.example.gs.Controller.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gs.Model.ItemModelCalendario;
import com.example.gs.R;

import java.util.List;

/**
 * Created by Carles on 07/05/2017.
 */

public class AdapterCalendario extends BaseAdapter {
    private Activity activity;
    private List<ItemModelCalendario> data;
    private LayoutInflater inflater;
    private int item_layout;

    public AdapterCalendario (Activity activity, List<ItemModelCalendario> data, int item_layout ) {
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

        TextView itemCurs=(TextView) convertView.findViewById(R.id.itemcurs);
        TextView itemActivity=(TextView) convertView.findViewById(R.id.itemactivity);
        TextView itemdate=(TextView) convertView.findViewById(R.id.itemdate);

        //Set values for item at position

        itemCurs.setText(data.get(position).getCurs());
        itemActivity.setText(data.get(position).getActivity());
        itemdate.setText(data.get(position).getDate());
        return convertView;
    }
}
