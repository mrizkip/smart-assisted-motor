package com.hanyasoftware.android.smartassistedmotor.motor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Motor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MotorActivity extends AppCompatActivity {

    @BindView(R.id.motor_nopol)
    TextView nopol;
    @BindView(R.id.motor_tipe)
    TextView tipe;
    @BindView(R.id.motor_tahun)
    TextView tahun;
    @BindView(R.id.motor_lcMesin)
    TextView lcMesin;
    @BindView(R.id.motor_ukuranRoda)
    TextView ukuranRoda;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Motor");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get motor here
        Motor motor1 = new Motor(1, "N 1234 AB", "CB 150 R", "2018", "150 cc", "17");

        // set text view
        nopol.setText(motor1.getNopol());
        tipe.setText(motor1.getTipe());
        tahun.setText(motor1.getTahun());
        lcMesin.setText(motor1.getLcMesin());
        ukuranRoda.setText(motor1.getUkuranRoda());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
