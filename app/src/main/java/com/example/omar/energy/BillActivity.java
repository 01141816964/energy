package com.example.omar.energy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId) {

                if ( checkedId == R.id.rb_khartoum){
                    Toast.makeText(BillActivity.this, "khartoum", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.rb_cairo){
                    Toast.makeText(BillActivity.this, "cairo", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.rb_makkah){
                    Toast.makeText(BillActivity.this, "makkah", Toast.LENGTH_SHORT).show();
                }

            }

        });

        CheckBox arabic =(CheckBox) findViewById(R.id.cb_arabic);
        CheckBox english =(CheckBox) findViewById(R.id.cb_english);
        arabic.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked)
                            Toast.makeText(BillActivity.this, "arabic", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        english.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked)
                            Toast.makeText(BillActivity.this, "english", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(BillActivity.this,
                        parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SeekBar sb =(SeekBar) findViewById(R.id.seekBar);
      final  TextView tv =(TextView) findViewById(R.id.pb_text);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //Toast.makeText(BillActivity.this, "progress = "+progress, Toast.LENGTH_SHORT).show();
            tv.setText("progress="+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
