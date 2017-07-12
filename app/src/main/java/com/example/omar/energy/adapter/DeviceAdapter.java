package com.example.omar.energy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.omar.energy.module.Device;
import com.example.omar.energy.R;

import java.util.List;

/**
 * Created by omar on 20/03/17.
 */



public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    private Context mContext;
    private List<Device> deviceList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, kwh;
        public ImageView thumbnail, overflow;
        public ToggleButton toggleButton;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.title);
            kwh = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.deviceImage);
            overflow = (ImageView) view.findViewById(R.id.overflow);
            toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton2);
        }
    }


    public DeviceAdapter(Context mContext, List<Device> deviceList) {
        this.mContext = mContext;
        this.deviceList = deviceList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Device device = deviceList.get(position);
        holder.name.setText(device.getDeviceName());

        holder.kwh.setText(device.getKWH() + " KWH");

        // loading device cover using Glide library
        Glide.with(mContext).load(device.getDeviceImage()).into(holder.thumbnail);



        holder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                           @Override
                                                           public void onCheckedChanged(CompoundButton button, boolean isChecked) {

       if( holder.toggleButton.isChecked()){
           Toast.makeText(mContext, holder.name.getText()+" is ON",
                   Toast.LENGTH_SHORT).show();}
       else
           Toast.makeText(mContext, holder.name.getText()+" is OFF",
                   Toast.LENGTH_SHORT).show();
   }
}
        );

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_device, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Edit", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "View history", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }
}
