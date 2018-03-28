package com.hanyasoftware.android.smartassistedmotor.pengaturan;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PengaturanActivity extends AppCompatActivity {

    @BindView(R.id.pengaturan_alarm)
    TextView alarm;
    @BindView(R.id.pengaturan_motor)
    TextView motor;
    @BindView(R.id.pengaturan_suara)
    TextView suara;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Pengaturan");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // alarm on click
        alarm.setOnClickListener(v -> alarmOnClick());

        // suara on click
        suara.setOnClickListener(v -> suaraOnClick());

        // motor on click
        motor.setOnClickListener(v -> motorOnClick());
    }

    private void alarmOnClick() {

    }

    private void suaraOnClick() {

    }

    private void motorOnClick() {

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
