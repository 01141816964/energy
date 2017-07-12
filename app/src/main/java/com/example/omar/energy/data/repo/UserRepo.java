package com.example.omar.energy.data.repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


import com.example.omar.energy.data.DBHelper;
//import com.example.omar.energy.data.DatabaseManager;
import com.example.omar.energy.data.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 11/07/17.
 */

public class UserRepo {

    private DBHelper dbHelper;
    private User user;

    public UserRepo(Context context){
        dbHelper = new DBHelper(context);
    }
       // user = new User();




    public static String createTable(){
        return "CREATE TABLE " + User.TABLE  + "("
                + User.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + User.COLUMN_USER_NAME + " TEXT,"
                + User.COLUMN_USER_EMAIL + " TEXT," + User.COLUMN_USER_PASSWORD + " TEXT" + ")";
    }


  /*  public int insert(User user) {
        int userId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_USER_NAME, user.getName());
        values.put(User.COLUMN_USER_EMAIL, user.getEmail());
        values.put(User.COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        userId=(int)db.insert(User.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return userId;
    }*/

    public void addUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(User.COLUMN_USER_NAME, user.getName());
        values.put(User.COLUMN_USER_EMAIL, user.getEmail());
        values.put(User.COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(User.TABLE, null, values);
        db.close();

   }


    public void delete( ) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    //    SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(User.TABLE,null,null);
        db.close();
      //  DatabaseManager.getInstance().closeDatabase();
    }


    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                User.COLUMN_USER_ID,
                User.COLUMN_USER_EMAIL,
                User.COLUMN_USER_NAME,
                User.COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                User.COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(User.TABLE, //Table to query
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
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(User.COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(User.COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(User.COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(User.COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
//        DatabaseManager.getInstance().closeDatabase();
        db.close();

        // return user list
        return userList;
    }


    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                User.COLUMN_USER_ID
        };
        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        // selection criteria
        String selection = User.COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(User.TABLE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
//        DatabaseManager.getInstance().closeDatabase();


        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                User.COLUMN_USER_ID
        };
     SQLiteDatabase db =dbHelper.getReadableDatabase();
     // SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();



        // selection criteria
        String selection = User.COLUMN_USER_EMAIL + " = ?" + " AND " + User.COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(User.TABLE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
//        DatabaseManager.getInstance().closeDatabase();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}


