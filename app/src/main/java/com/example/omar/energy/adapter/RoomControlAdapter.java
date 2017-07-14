package com.example.omar.energy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.omar.energy.R;
import com.example.omar.energy.data.model.Device;
import com.example.omar.energy.data.model.Room;

import java.util.List;

/**
 * Created by omar on 14/07/17.
 */

public class RoomControlAdapter extends RecyclerView.Adapter<RoomControlAdapter.RoomViewHolder> {
    private Context mcontext;
    private List<Room> roomList;

      // Adapter Constructor  -- initialize objects
    public RoomControlAdapter(Context mContext, List<Room> roomList) {
        this.roomList=roomList;
        this.mcontext=mContext;
    }
    // inflating recycler item view
    @Override
    public RoomControlAdapter.RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room_control, parent, false);
        return new RoomViewHolder(itemView);
    }
    // add and get data from view
    @Override
    public void onBindViewHolder(final RoomViewHolder holder, int position) {
        final Room room = roomList.get(position);

        holder.roomName.setText(room.getRoomName());
        holder.device1.setText(room.getDeviceList().get(0).getDeviceName());
        holder.device2.setText(room.getDeviceList().get(1).getDeviceName());
        holder.toggleRoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton button, boolean isChecked) {

             if( holder.toggleRoom.isChecked()){
                 Toast.makeText(mcontext, holder.roomName.getText()+" is ON",
                         Toast.LENGTH_SHORT).show();
                 holder.toggleDevice1.setChecked(true);
                 room.getDeviceList().get(0).setStatus(true);

                 holder.toggleDevice2.setChecked(true);
                 room.getDeviceList().get(1).setStatus(true);


             }
             else
                 Toast.makeText(mcontext, holder.roomName.getText()+" is OFF",
                         Toast.LENGTH_SHORT).show();
             holder.toggleDevice1.setChecked(false);
             room.getDeviceList().get(0).setStatus(false);

             holder.toggleDevice2.setChecked(false);
             room.getDeviceList().get(1).setStatus(false);

         }
     }
);
        holder.toggleDevice1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {

                if( holder.toggleDevice1.isChecked()){
                    Toast.makeText(mcontext, holder.device1.getText()+" is ON",
                            Toast.LENGTH_SHORT).show();
                    room.getDeviceList().get(0).setStatus(true);

                }
                else
                    Toast.makeText(mcontext, holder.device1.getText()+" is OFF",
                            Toast.LENGTH_SHORT).show();
                   room.getDeviceList().get(0).setStatus(false);

            }
        }
        );
        holder.toggleDevice2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton button, boolean isChecked) {

                    if( holder.toggleDevice2.isChecked()){
                        Toast.makeText(mcontext, holder.device2.getText()+" is ON",
                                Toast.LENGTH_SHORT).show();
                        room.getDeviceList().get(1).setStatus(true);

                    }
                    else
                        Toast.makeText(mcontext, holder.device2.getText()+" is OFF",
                                Toast.LENGTH_SHORT).show();
                    room.getDeviceList().get(1).setStatus(true);

                }
            }
);


    }

    @Override
    public int getItemCount() {
        return 0;
    }


    // initialize holder and like view elements
    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public TextView roomName,device1,device2;
        public ToggleButton toggleRoom,toggleDevice1,toggleDevice2;

        public RoomViewHolder(View itemView) {
            super(itemView);
            roomName = (TextView) itemView.findViewById(R.id.roomName);
            device1 = (TextView) itemView.findViewById(R.id.device1);
            device2 = (TextView) itemView.findViewById(R.id.device2);
            toggleRoom = (ToggleButton) itemView.findViewById(R.id.toggleRoom);
            toggleDevice1 = (ToggleButton) itemView.findViewById(R.id.toggleDevice1);
            toggleDevice2= (ToggleButton) itemView.findViewById(R.id.toggleDevice2);



        }
    }
}
