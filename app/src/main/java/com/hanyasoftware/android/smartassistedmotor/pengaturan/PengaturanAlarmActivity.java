package com.hanyasoftware.android.smartassistedmotor.pengaturan;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PengaturanAlarmActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.alarm_switchNotif)
    Switch alarmSwitch;
    @BindView(R.id.alarm_spinnerKm)
    Spinner alarmSpinner;
    @BindView(R.id.alarm_buttonSimpan)
    Button buttonSimpan;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_alarm);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Pengaturan Alarm");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        buttonSimpan.setOnClickListener(v -> {
            Toast.makeText(this, "Pengaturan berhasil disimpan", Toast.LENGTH_SHORT).show();
            finish();
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
