package com.example.omar.energy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omar on 20/03/17.
 */

public class DeviceAdapter extends ArrayAdapter {

  private List <Device> list;
  private Context context;
   private int  resId;

    public DeviceAdapter(Context context,
                         int resource, List list) {
        super(context, resource, list);
        this.list=list;
        this.context=context;
        this.resId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resId,parent,false);

        TextView text_id = (TextView) convertView.findViewById(R.id.text_id);
        TextView text_name = (TextView) convertView.findViewById(R.id.text_name);
        TextView text_KWH = (TextView) convertView.findViewById(R.id.text_KWH);
        TextView text_usage_time = (TextView) convertView.findViewById(R.id.text_usage_time);

        text_id.setText(list.get(position).get_id()+"");
        text_name.setText(list.get(position).getName());
        text_KWH.setText(list.get(position).getKWH()+"");
        text_usage_time.setText(list.get(position).getUsage_time()+"");

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
