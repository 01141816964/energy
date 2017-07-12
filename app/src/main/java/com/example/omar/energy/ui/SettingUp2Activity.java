package com.example.omar.energy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.omar.energy.R;
import com.example.omar.energy.module.Device;
//import com.example.omar.energy.sqlite.MySqliteOpenHelper;
//import com.example.omar.energy.module.User;
import com.example.omar.energy.ui.AddDeviceDialog;

import java.util.List;


public class SettingUp2Activity extends FragmentActivity implements AddDeviceDialog.ShareDialogListener
       {


 //  private MySqliteOpenHelper databaseHelper;
  //  private User user;
    private Device device;
    private List<Device> deviceList;
    private AppCompatTextView tv;


    private String[] roomName = {
            "Bed Room", "Living Room", "Office",
            "Kitchen", "Path Room"};
    private int[] roomImageId = {
            R.drawable.bed_512, R.drawable.armchair_512, R.drawable.office_512,
            R.drawable.refrigerator_512, R.drawable.pathroom_512};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_up2);

        tv = (AppCompatTextView) findViewById(R.id.tvTitle);

     //   databaseHelper = new MySqliteOpenHelper(getApplicationContext());
        //user = new User();
        device = new Device();

        Button devivrbutton =(Button) findViewById(R.id.button2);
        devivrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.DialogFragment dialog = new AddDeviceDialog();
                dialog.show(getFragmentManager(), "ShareDialog");
            }
        });


   //     databaseHelper = new MySqliteOpenHelper(this, "FoodDB.sqlite", null, 1);

    //    MySqliteOpenHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY     AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)");
        }

/*
    public void addRoom(View view) {

        final MaterialSimpleListAdapter adapter = new MaterialSimpleListAdapter(new MaterialSimpleListAdapter.Callback() {
            @Override
            public void onMaterialListItemSelected(MaterialDialog dialog, int index, MaterialSimpleListItem item) {
                Toast.makeText(getApplicationContext(), "You selected: " + item.getContent(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        adapter.add(new MaterialSimpleListItem.Builder(this)
                .content(roomName[0])
                .icon(roomImageId[0])
                .backgroundColor(Color.WHITE)
                .build());
        adapter.add(new MaterialSimpleListItem.Builder(this)
                .content(roomName[1])
                .icon(roomImageId[1])
                .backgroundColor(Color.WHITE)
                .build());
        adapter.add(new MaterialSimpleListItem.Builder(this)
                .content(roomName[2])
                .icon(roomImageId[2])
                .backgroundColor(Color.WHITE)
                .build());
        adapter.add(new MaterialSimpleListItem.Builder(this)
                .content(roomName[3])
                .icon(roomImageId[3])
                .backgroundColor(Color.WHITE)
                .build());
        adapter.add(new MaterialSimpleListItem.Builder(this)
                .content(roomName[4])
                .icon(roomImageId[4])
                .backgroundColor(Color.WHITE)
                .build());


        new MaterialDialog.Builder(this)
                .title("Select Room")
                .adapter(adapter, null)
                .show();




}*/

    public void showuser(View view){
        Intent homeintent = new Intent(this,UsersListActivity.class);
        startActivity(homeintent);

    }
           public void showRoom(View view){
               Intent room = new Intent(this,RoomDetailsActivity.class);
               startActivity(room);

           }
           int[] covers = new int[]{
                   R.drawable.airconditioner,
                   R.drawable.fan,
                   R.drawable.lamp,
                   R.drawable.washing,
           };


           @Override
           public void onDialogPositiveClick(android.app.DialogFragment dialog, String name, int kwh ,int  usageTime) {
               Toast.makeText(this, "Position Shared" + name + kwh , Toast.LENGTH_SHORT).show();
               device.setDeviceName(name.trim());
              device.setKWH(covers[kwh]);
               device.setDeviceUsageTime(usageTime);

           //    databaseHelper.addDevice(device);


            //   deviceList.addAll(databaseHelper.getAllDevice());
             //  Device device = deviceList.get(0);
            //   String namee =device.getDeviceName();
               tv.setText(device.getDeviceName());

           }

           @Override
           public void onDialogNegativeClick(android.app.DialogFragment dialog) {

           //    deviceList.addAll(databaseHelper.getAllDevice());
               Device device = deviceList.get(0);
               String name=device.getDeviceName();

               Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

           }
       }

/*
        LayoutInflater inflater = this.getLayoutInflater();
       View dialogView = inflater.inflate(R.layout.activity_register, null);
        final EditText etUsername = (EditText) dialogView.findViewById(R.id.textInputEditTextName);
        final EditText etEmail = (EditText) dialogView.findViewById(R.id.textInputEditTextEmail);
        final EditText etPassword = (EditText) dialogView.findViewById(R.id.textInputEditTextPassword);


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Login");
        // this is set the view from XML inside AlertDialog
        alert.setView(dialogView);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Login", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user = etUsername.getText().toString();
                String pass = etEmail.getText().toString();
                Toast.makeText(getBaseContext(), "Username: " + user + " email: " + pass, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    /*
        boolean wrapInScrollView = true;
        View dialogView = dialog.getCustomView();

        MaterialDialog.Builder deviceDialog = new MaterialDialog.Builder(this)
                .title("Add Device")
                .customView(R.layout.activity_register, wrapInScrollView)
                .positiveText("agree")
                .negativeText("disagree")
                .positiveColorRes(R.color.black)
                .negativeColorRes(R.color.black)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        // TODO
                        String name =etUsername.getText().toString();
                        String email =etEmail.getText().toString();
                        String Password =etPassword.getText().toString();
                        Toast.makeText(getBaseContext(), "Username: " + name + " email: " + email, Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        // TODO
                        Toast.makeText(getApplicationContext(),"cancel", Toast.LENGTH_SHORT).show();
                    }
                });
        MaterialDialog dialog = deviceDialog.build();


        dialog.show();*/


/*
        new MaterialDialog.Builder(this)
                .title("title")
                .content("content")
                .positiveColorRes(R.color.black)
                .negativeColorRes(R.color.black)
                .theme(Theme.LIGHT)
                .positiveText("agree")
                .negativeText("disagree")
                .neutralText("more_info")
                .show();*/
