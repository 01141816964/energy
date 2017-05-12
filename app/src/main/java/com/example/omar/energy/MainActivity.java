package com.example.omar.energy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    EditText mEnterUserName;
    Button mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterUserName =(EditText) findViewById(R.id.user_name_edit_text);
        mSignUp =(Button)  findViewById(R.id.singup_button);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = mEnterUserName.getText().toString();

                Intent startAddDeviceActivity = new Intent(MainActivity.this ,HomeActivity.class);
                startAddDeviceActivity.putExtra(Intent.EXTRA_TEXT,UserName);
                startActivity(startAddDeviceActivity);
            }
        });
    }
}
