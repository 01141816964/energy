package com.example.omar.energy.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.omar.energy.data.model.Device;
import com.example.omar.energy.data.model.Room;
import com.example.omar.energy.data.model.User;
import com.example.omar.energy.data.repo.DeviceRepo;
import com.example.omar.energy.data.repo.RoomRepo;
import com.example.omar.energy.data.repo.UserRepo;

/**
 * Created by omar on 11/07/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =8;
    // Database Name
    private static final String DATABASE_NAME = "SaveEnergyDB.db";
   // private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper(Context context ) {
        super(context ,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(UserRepo.createTable());
      //db.execSQL(RoomRepo.createTable());
      //db.execSQL(DeviceRepo.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Room.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Device.TABLE);
        onCreate(db);
    }



}




