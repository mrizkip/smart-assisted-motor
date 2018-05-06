package com.hanyasoftware.android.smartassistedmotor.main;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Jarak;
import com.hanyasoftware.android.smartassistedmotor.riwayat.RiwayatActivity;
import com.hanyasoftware.android.smartassistedmotor.bengkel.BengkelActivity;
import com.hanyasoftware.android.smartassistedmotor.diagnosis.DiagnosisActivity;
import com.hanyasoftware.android.smartassistedmotor.motor.MotorActivity;
import com.hanyasoftware.android.smartassistedmotor.pengaturan.PengaturanActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_jarakTempuh)
    TextView jarakTempuh;
    @BindView(R.id.main_motorContainer)
    ConstraintLayout motorContainer;
    @BindView(R.id.main_bengkelContainer)
    ConstraintLayout bengkelContainer;
    @BindView(R.id.main_diagnosisContainer)
    ConstraintLayout diagnosisContainer;
    @BindView(R.id.main_riwayatContainer)
    ConstraintLayout riwayatContainer;
    @BindView(R.id.main_pengaturanContainer)
    ConstraintLayout pengaturanContainer;
    @BindView(R.id.main_exitContainer)
    ConstraintLayout exitContainer;

    ActionBar actionBar;

    private MainViewModel mainViewModel;
    private Jarak jarak;

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

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                checkExternalStoragePermission();
                            } else {
                                permissionGranted();
                            }
                        } else if (report.isAnyPermissionPermanentlyDenied()) {
                            Toast.makeText(MainActivity.this, "Izinkan semua permission untuk menggunakan aplikasi ini!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void checkExternalStoragePermission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        permissionGranted();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(MainActivity.this, "Izinkan semua permission untuk menggunakan aplikasi ini!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();

    }

    private void permissionGranted() {
        jarak = new Jarak();
        mainViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getMainViewModelFactory())
                .get(MainViewModel.class);
        mainViewModel.getJarak().observe(this, jarak1 -> {
            jarak = jarak1;
            if (jarak.getJarak() == null || jarak.getJarak().isEmpty()) {
                jarakTempuh.setText("0");
            } else {
                jarakTempuh.setText(jarak.getJarak());
            }
        });

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
        String jarakIntent;
        if (jarak.getJarak() == null || jarak.getJarak().isEmpty()) {
            jarakIntent = "0";
        } else {
            jarakIntent = jarak.getJarak();
        }
        intent.putExtra("jarak", jarakIntent);
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
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setTitle("Keluar")
                .setMessage("Apakah anda ingin keluar dari aplikasi?")
                .setPositiveButton("YA", (dialog, which) -> {
                    dialog.dismiss();
                    //Stop the activity
                    MainActivity.this.finish();
                })
                .setNegativeButton("TIDAK", (dialogInterface, i) -> dialogInterface.cancel())
                .show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_warning_black_24dp)
                    .setTitle("Keluar")
                    .setMessage("Apakah anda ingin keluar dari aplikasi?")
                    .setPositiveButton("YA", (dialog, which) -> {
                        dialog.dismiss();
                        //Stop the activity
                        MainActivity.this.finish();
                    })
                    .setNegativeButton("TIDAK", (dialogInterface, i) -> dialogInterface.cancel())
                    .show();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }
}
