/*
package com.example.omar.energy.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import com.androidtutorialshub.loginregister.model.User;

import com.example.omar.energy.module.Device;
import com.example.omar.energy.module.Room;
import com.example.omar.energy.module.User;

import java.util.ArrayList;
import java.util.List;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    // Room table name
    private static final String TABLE_ROOM = "room";
    // Device table name
    private static final String TABLE_DEVICE = "device";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    // Room Table Columns names
    private static final String COLUMN_ROOM_ID = "room_id";
    private static final String COLUMN_ROOM_NAME = "room_name";
    private static final String COLUMN_ROOM_IMAGE = "room_image";
    private static final String COLUMN_ROOM_KWH = "room_kwh";
    private static final String COLUMN_ROOM_DEVICES_NUM = "room_device_num";
    // Deice Table Columns names
    private static final String COLUMN_DEVICE_ID = "device_id";
    private static final String COLUMN_DEVICE_NAME = "device_name";
    private static final String COLUMN_DEVICE_IMAGE = "device_image";
    private static final String COLUMN_DEVICE_KWH = "device_kwh";
    private static final String COLUMN_DEVICE_USAGE_TIME = "device_usage_time";
    private static final String COLUMN_DEVICE_STATUS = "device_status";
    private static final String COLUMN_FOREIGN_EY = "fk_room";

    private static final  String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // create room table sql query
    private String CREATE_ROOM_TABLE = "CREATE TABLE " + TABLE_ROOM + "("
            + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ROOM_NAME + " TEXT,"
            + COLUMN_ROOM_IMAGE + " INTEGER," + COLUMN_ROOM_KWH + " INTEGER, " + COLUMN_ROOM_DEVICES_NUM
            + " INTEGER"+")";


    // create device table sql query
    private String CREATE_DEVICE_TABLE = "CREATE TABLE " + TABLE_DEVICE + "("
            + COLUMN_DEVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DEVICE_NAME + " TEXT,"
            + COLUMN_DEVICE_IMAGE + " INTEGER," + COLUMN_DEVICE_KWH + " INTEGER, " + COLUMN_DEVICE_USAGE_TIME
            + " INTEGER, "+COLUMN_DEVICE_STATUS  + " boolean," +
            COLUMN_FOREIGN_EY + " INTEGER, "+" FOREIGN KEY (" + COLUMN_FOREIGN_EY + ") REFERENCES" +TABLE_ROOM +"("
            + COLUMN_ROOM_ID +")"+")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    // drop room table sql query
    private String DROP_ROOM_TABLE = "DROP TABLE IF EXISTS " + TABLE_ROOM;
    // drop device table sql query
    private String DROP_DEVICE_TABLE = "DROP TABLE IF EXISTS " + TABLE_DEVICE;




*
     * Constructor
     *
     * @param context
     *




    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MySqliteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

 public void onCreateRoom(SQLiteDatabase db) {
        db.execSQL(CREATE_ROOM_TABLE);
    }
    public void onCreateDevice(SQLiteDatabase db) {
        db.execSQL(CREATE_DEVICE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }
    public void onUpgradeRoom(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_ROOM_TABLE);

        // Create tables again
        onCreate(db);

    }
    public void onUpgradevice(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_DEVICE_TABLE);

        // Create tables again
        onCreate(db);

    }





*
     * This method is to create user record
     *
     * @param user



    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }




*
     * This method is to create room record




    public void addRoom(Room room){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, room.getRoomName());
        values.put(COLUMN_ROOM_IMAGE, room.getRoomImageId());

        // Inserting Row
        db.insert(TABLE_ROOM, null, values);
        db.close();

    }




*
     * This method is to create device record



    public void addDevice(Device device){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DEVICE_NAME, device.getDeviceName());
        values.put(COLUMN_DEVICE_IMAGE, device.getDeviceImage());
        values.put(COLUMN_DEVICE_KWH , device.getKWH());

        // Inserting Row
        db.insert(TABLE_ROOM, null, values);
        db.close();

    }










*
     * This method is to fetch all user and return the list of user records
     *
     * @return list








    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table





*
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;






        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }








*
     * This method is to fetch all room and return the list of user records
     *
     * @return list








    public List<Room> getAllRoom() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ROOM_ID,
                COLUMN_ROOM_NAME,
                COLUMN_ROOM_IMAGE,
                COLUMN_ROOM_KWH,
                COLUMN_ROOM_DEVICES_NUM
        };
        // sorting orders
        String sortOrder =
                COLUMN_ROOM_ID ;
        List<Room> roomList = new ArrayList<Room>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table








*
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;








        Cursor cursor = db.query(TABLE_ROOM, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Room room = new Room();
                room.setRoomId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_ID))));
                room.setRoomName(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_NAME)));
                room.setRoomImageId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_IMAGE))));
                room.setKWH(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_KWH))));
                room.setDevicesNumber(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_DEVICES_NUM))));
                // Adding room record to list
                roomList.add(room);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return room list
        return roomList;
    }










*
     * This method is to fetch all device and return the list of user records
     *
     * @return list








    public List<Device> getAllDevice() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_DEVICE_ID,
                COLUMN_DEVICE_NAME,
                COLUMN_DEVICE_IMAGE,
                COLUMN_DEVICE_KWH,
                COLUMN_DEVICE_USAGE_TIME,
                COLUMN_DEVICE_STATUS
        };
        // sorting orders
        String sortOrder =
                COLUMN_DEVICE_ID ;
        List<Device> deviceList = new ArrayList<Device>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table








*
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;








        Cursor cursor = db.query(TABLE_DEVICE, //Table to query
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
                device.setDeviceId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_ID))));
                device.setDeviceName(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_NAME)));
                device.setDeviceImage((Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_IMAGE)))));
                device.setKWH(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_KWH))));
                device.setDeviceUsageTime(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_USAGE_TIME))));
                // Adding device record to list
                deviceList.add(device);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return room list
        return deviceList;
    }











*
     * This method to update user record
     *
     * @param user








    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }









*
     * This method is to delete user record
     *
     * @param user








    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }









*
     * This method to check user exist or not
     *
     * @param email
     * @return true/false








    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition








*
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';







        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }








*
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false







    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions






*
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';








        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}

*/
