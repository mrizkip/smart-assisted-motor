package com.hanyasoftware.android.smartassistedmotor.motor;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
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

    private MotorViewModel motorViewModel;

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

        motorViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getMotorViewModelFactory())
                .get(MotorViewModel.class);

        // Get motor here
        motorViewModel.getKendaraan().observe(this, kendaraan -> {
            if (kendaraan != null) {
                // set text view
                nopol.setText(kendaraan.getKnd_nopol());
                tipe.setText(kendaraan.getKnd_tipe());
                tahun.setText(kendaraan.getKnd_tahun());
                lcMesin.setText(kendaraan.getKnd_lcmesin());
                ukuranRoda.setText(kendaraan.getKnd_ukuranban());
            } else {
                nopol.setText("");
                tipe.setText("");
                tahun.setText("");
                lcMesin.setText("");
                ukuranRoda.setText("");
            }
        });
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
