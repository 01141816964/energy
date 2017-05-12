package com.example.omar.energy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 19/03/17.
 */

public class DeviceDataSource {
    private MySqliteOpenHelper helper;
    private SQLiteDatabase db;
    private final String TABLE_NAME ="device";

    public DeviceDataSource(MySqliteOpenHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public long addDevice(Device device){
        ContentValues values = new ContentValues();
        values.put("name",device.getName());
        values.put("KWH",device.getKWH());
        values.put("usage_time",device.getUsage_time());

        long id= db.insert(TABLE_NAME,null,values);
        return id;
    }
    public void removeDeviceById(int id){
        db.delete(TABLE_NAME, "_id =?", new String[]{Integer.toString(id)});


    }
    public void removeDevice(Device device){

        removeDeviceById( device.get_id());

    }
    public  void updateDevice(int id,Device device ){
        ContentValues values = new ContentValues();
        values.put("name",device.getName());
        values.put("KWH",device.getKWH());
        values.put("usage_time",device.getUsage_time());
        db.update(TABLE_NAME,values,"_id=?",new String[]{id+""});


    }
    public List getAllDevices(){
        ArrayList<Device> list = new ArrayList<Device>();

        Cursor cursor= db.query(TABLE_NAME, new String[]{"_id","name","KWH","usage_time"}
                ,null,null,null,null,"name",null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int KWH = cursor.getInt(2);
            int usage_time = cursor.getInt(3);

            Device device= new Device(usage_time,KWH,name);
            device.set_id(id);
            list.add(device);

            cursor.moveToNext();
        }
        return list;
    }
    public Device getDeviceById(int id){
        Device device = null;
        Cursor cursor=  db.query(TABLE_NAME,null,
                "_id=?",new String[]{id+""},null,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            int KWH = cursor.getInt(2);
            int usage_time=cursor.getInt(3);

            device=new Device(usage_time,KWH,name);
            device.set_id(_id);
            cursor.moveToNext();

        }
        return device ;
    }

}
