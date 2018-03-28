package com.hanyasoftware.android.smartassistedmotor.main;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.riwayat.RiwayatActivity;
import com.hanyasoftware.android.smartassistedmotor.bengkel.BengkelActivity;
import com.hanyasoftware.android.smartassistedmotor.diagnosis.DiagnosisActivity;
import com.hanyasoftware.android.smartassistedmotor.motor.MotorActivity;
import com.hanyasoftware.android.smartassistedmotor.pengaturan.PengaturanActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_jarakTempuh)
    TextView jarakTempuh;
    @BindView(R.id.main_motorContainer)
    RelativeLayout motorContainer;
    @BindView(R.id.main_bengkelContainer)
    RelativeLayout bengkelContainer;
    @BindView(R.id.main_diagnosisContainer)
    RelativeLayout diagnosisContainer;
    @BindView(R.id.main_riwayatContainer)
    RelativeLayout riwayatContainer;
    @BindView(R.id.main_pengaturanContainer)
    RelativeLayout pengaturanContainer;
    @BindView(R.id.main_exitContainer)
    RelativeLayout exitContainer;

    ActionBar actionBar;

    private int jarakTempuhKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Smart Assisted Motor");
        }

        // TODO: HITUNG JARAK TEMPUH
//        jarakTempuhKm = ??

        // motor on click
        motorContainer.setOnClickListener(v -> motorOnClick());

        // diagnosis on click
        diagnosisContainer.setOnClickListener(v -> diagnosisOnClick());

        // bengkel on click
        bengkelContainer.setOnClickListener(v -> bengkelOnClick());

        // riwayat on click
        riwayatContainer.setOnClickListener(v -> riwayatOnClick());

        // pengaturan on click
        pengaturanContainer.setOnClickListener(v -> pengaturanOnClick());

        // exit on click
        exitContainer.setOnClickListener(v -> exitOnClick());

    }

    private void motorOnClick() {
        Intent intent = new Intent(MainActivity.this, MotorActivity.class);
        startActivity(intent);
    }

    private void diagnosisOnClick() {
        Intent intent = new Intent(MainActivity.this, DiagnosisActivity.class);
        startActivity(intent);
    }

    private void bengkelOnClick() {
        Intent intent = new Intent(MainActivity.this, BengkelActivity.class);
        startActivity(intent);
    }

    private void riwayatOnClick() {
        Intent intent = new Intent(MainActivity.this, RiwayatActivity.class);
        startActivity(intent);
    }

    private void pengaturanOnClick() {
        Intent intent = new Intent(MainActivity.this, PengaturanActivity.class);
        startActivity(intent);
    }

    private void exitOnClick() {
        // TODO: exit application
    }
}
