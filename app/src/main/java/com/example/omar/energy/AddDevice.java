/*package com.example.omar.energy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddDevice extends AppCompatActivity {

    private MySqliteOpenHelper helper;
    private DeviceDataSource ds;
    private Device device;

    public AddDevice() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        helper = new MySqliteOpenHelper(this,"UCAS_DB",null,1);
        ds = new DeviceDataSource(helper);
        refreshListView();

    }

    public void btn_add_device(View view) {

        EditText text_name = (EditText) findViewById(R.id.device_name);
        EditText text_KWH = (EditText) findViewById(R.id.KWH);
        EditText text_usage_time = (EditText) findViewById(R.id.usage_time);

        String name = text_name.getText().toString();
        int KWH = Integer.parseInt(text_KWH.getText().toString());
        int usage_time = Integer.parseInt(text_usage_time.getText().toString());
        device = new Device (usage_time,KWH,name);

        ds.addDevice(device);
        refreshListView();

    }

private void refreshListView(){

    ListView list = (ListView) findViewById(R.id.list_view);
    DeviceAdapter adapter = new DeviceAdapter(this,
            R.layout.device_item_layout,ds.getAllDevices());

    list.setAdapter(adapter);
}

}
*/