package com.example.omar.energy.data.repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


import com.example.omar.energy.data.DBHelper;
//import com.example.omar.energy.data.DatabaseManager;
import com.example.omar.energy.data.model.Device;
import com.example.omar.energy.data.model.Room;
import com.example.omar.energy.data.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by omar on 11/07/17.
 */

public class DeviceRepo {

    private DBHelper dbHelper;


    public DeviceRepo(Context context){
        dbHelper = new DBHelper(context);
    }

    public static String createTable(){
        return "CREATE TABLE " + Device.TABLE  + "("
                + Device.COLUMN_DEVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Device.COLUMN_DEVICE_NAME + " TEXT,"
                + Device.COLUMN_DEVICE_KWH + " INTEGER )";
    }

    public void addDevice(Device device){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Device.COLUMN_DEVICE_NAME, device.getDeviceName());
        values.put(Device.COLUMN_DEVICE_ID, device.getDeviceId());
        values.put(Device.COLUMN_DEVICE_KWH , device.getKWH());

        // Inserting Row
        db.insert(Device.TABLE, null, values);
        db.close();

    }

    public List<Device> getAllDevice() {
        // array of columns to fetch
        String[] columns = {
                //       COLUMN_DEVICE_ID,
                Device.COLUMN_DEVICE_NAME,
                Device.COLUMN_DEVICE_ID,
                Device.COLUMN_DEVICE_KWH,
                //    COLUMN_DEVICE_USAGE_TIME,
                //    COLUMN_DEVICE_STATUS
        };
        // sorting orders
        String sortOrder =
                Device.COLUMN_DEVICE_NAME ;
        List<Device> deviceList = new ArrayList<Device>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(Device.TABLE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Device device = new Device();
                device.setDeviceId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Device.COLUMN_DEVICE_ID))));
                device.setDeviceName(cursor.getString(cursor.getColumnIndex(Device.COLUMN_DEVICE_NAME)));
              //  device.setDeviceImage((Integer.parseInt(cursor.getString(cursor.getColumnIndex(Device.COLUMN_DEVICE_IMAGE)))));
                device.setKWH(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Device.COLUMN_DEVICE_KWH))));
                //    device.setDeviceUsageTime(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_USAGE_TIME))));
                // Adding device record to list
                deviceList.add(device);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return room list
        return deviceList;
    }



}
