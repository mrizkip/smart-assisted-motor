package com.hanyasoftware.android.smartassistedmotor.main;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
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

import java.util.ArrayList;
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

    private SharedPrefsRepository sharedPrefsRepository;
    private List<Integer> listKilometer;

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
        jarak = new Jarak();
        initListKm();

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
        mainViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getMainViewModelFactory())
                .get(MainViewModel.class);
        sharedPrefsRepository = SAMApplication.getDataComponent().getSharedPrefsRepository();
        mainViewModel.getJarak().observe(this, jarak1 -> {
            jarak = jarak1;
            if (jarak1 == null) {
                jarakTempuh.setText("0");
            } else {
                jarakTempuh.setText(jarak.getJarak());

                //  build notification from every request jarak
                boolean switchState = sharedPrefsRepository.getSwitchState();
                if (switchState) {
                    int jarakInt = Integer.parseInt(jarak.getJarak());
                    int jarakTarget = sharedPrefsRepository.getJarakFromPrefs();
                    for (int km : listKilometer) {
                        if (jarakInt >= (km - jarakTarget) && jarakInt <= km) {
                            buildNotification(jarakInt);
                        }
                    }
                }

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

    private void buildNotification(int jarakInt) {

        Uri notifSoundUri = Uri.parse(sharedPrefsRepository.getRingtoneUriFromPrefs());

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, "SAM_CANNEL_ID");
        notifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifBuilder.setContentTitle("Jarak Sudah Dekat");
        notifBuilder.setContentText("Jarak mencapai " + jarakInt + ", lihat diagnosisnya.");
        notifBuilder.setSound(notifSoundUri);
        notifBuilder.setDefaults(Notification.DEFAULT_VIBRATE);

        Intent notificationIntent = new Intent(this, DiagnosisActivity.class);
        notificationIntent.putExtra("jarak", String.valueOf(jarakInt));

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notifBuilder.build());
    }

    private void initListKm() {
        listKilometer = new ArrayList<>();
        listKilometer.add(1000);
        listKilometer.add(4000);
        listKilometer.add(8000);
        listKilometer.add(12000);
        listKilometer.add(16000);
        listKilometer.add(20000);
        listKilometer.add(24000);
        listKilometer.add(28000);
        listKilometer.add(32000);
        listKilometer.add(36000);
        listKilometer.add(40000);
        listKilometer.add(44000);
        listKilometer.add(48000);
        listKilometer.add(52000);
        listKilometer.add(56000);
    }

    private void motorOnClick() {
        Intent intent = new Intent(MainActivity.this, MotorActivity.class);
        startActivity(intent);
    }

    private void diagnosisOnClick() {
        Intent intent = new Intent(MainActivity.this, DiagnosisActivity.class);
        String jarakIntent;
        if (jarakTempuh.getText().toString().equalsIgnoreCase("0")) {
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
