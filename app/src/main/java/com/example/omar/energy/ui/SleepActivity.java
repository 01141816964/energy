package com.example.omar.energy.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//import com.androidtutorialshub.loginregister.R;
//import com.androidtutorialshub.loginregister.adapters.UsersRecyclerAdapter;
//import com.androidtutorialshub.loginregister.model.User;
//import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

//import com.example.omar.energy.sqlite.MySqliteOpenHelper;
import com.example.omar.energy.R;
//import com.example.omar.energy.module.User;
import com.example.omar.energy.adapter.RoomControlAdapter;
import com.example.omar.energy.data.model.Device;
import com.example.omar.energy.data.model.Room;
import com.example.omar.energy.data.model.User;
import com.example.omar.energy.data.repo.UserRepo;
import com.example.omar.energy.adapter.UsersRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SleepActivity extends AppCompatActivity {

    private AppCompatActivity activity = SleepActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private List<Room> roomList;
    private List<Device> deviceList;
    private RoomControlAdapter roomConrtolAdapter;
    private UserRepo userRepo;
    //   private MySqliteOpenHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerRoomControl);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        roomList = new ArrayList<>();
        deviceList = new ArrayList<>();

        roomConrtolAdapter = new RoomControlAdapter( activity, roomList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(roomConrtolAdapter);
        //databaseHelper = new MySqliteOpenHelper(activity);
        // userRepo = new UserRepo(activity);

       /* String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);
*/
        prepareAlbums();
      //  getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
   /* private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(userRepo.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }*/

    private void prepareAlbums() {


        Device a = new Device(0,"AC", 50, 5,true);
        deviceList.add(a);

        a = new Device(1,"FAN", 60,6,true);
        deviceList.add(a);

        a = new Device(2 ,"Lamp", 70 , 7 , true);
        deviceList.add(a);

        Room room=new Room (0, "Living Room", deviceList);
        roomList.add(room);

         room=new Room (1, "Bed Room 1", deviceList);
        roomList.add(room);
         room=new Room (2, "Bed Room 2", deviceList);
        roomList.add(room);
         room=new Room (3, "Office", deviceList);
        roomList.add(room);



        roomConrtolAdapter.notifyDataSetChanged();
    }
}