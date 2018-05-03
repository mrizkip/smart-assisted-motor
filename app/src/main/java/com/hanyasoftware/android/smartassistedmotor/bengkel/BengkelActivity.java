package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BengkelActivity extends AppCompatActivity {

    private static final String TAG = "BengkelActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bengkel_recycleViewListBengkel)
    RecyclerView recyclerView;

    ActionBar actionBar;

    private FastItemAdapter<BengkelAdapter> fastBengkelAdapter;
    private List<BengkelAdapter> bengkelAdapter;

    private BengkelViewModel bengkelViewModel;

    private boolean flagGps = false;

    private String latitude;
    private String longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengkel);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Bengkel Terdekat");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fastBengkelAdapter = new FastItemAdapter<>();
        bengkelAdapter = new ArrayList<>();

        bengkelViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getBengkelViewModelFactory())
                .get(BengkelViewModel.class);

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            flagGps = showGpsStatus();
                            if (flagGps) {
                                // get location and fetch bengkel
                                getLocation(BengkelActivity.this);
                            } else {
                                Toast.makeText(BengkelActivity.this, "GPS Harus Aktif!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();

    }

    private void getLocation(Context context) {
        SingleShotLocationProvider.requestSingleUpdate(context,
                location -> {
                    latitude = String.valueOf(location.latitude);
                    longitude = String.valueOf(location.longitude);
                    fetchBengkel();
                });
    }

    private boolean showGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        return Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
    }

    private void fetchBengkel() {
        Log.d(TAG, "fetchBengkel: latitude " + latitude);
        Log.d(TAG, "fetchBengkel: longitude " + longitude);
        bengkelViewModel.getBengkelList(latitude, longitude).observe(this, bengkelList -> {
            bengkelAdapter = bengkelList;
            fastBengkelAdapter.set(bengkelAdapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(fastBengkelAdapter);

            fastBengkelAdapter.withSelectable(true);
            fastBengkelAdapter.withOnClickListener((v, adapter, item, position) -> {
                Intent intent = new Intent(v.getContext(), DetailBengkelActivity.class);
                intent.putExtra("id", item.getBngId());
                intent.putExtra("nama", item.getBngNama());
                intent.putExtra("alamat", item.getBngAlamat());
                intent.putExtra("merk", item.getKtgNama());
                intent.putExtra("latitude", item.getBngLatitude());
                intent.putExtra("longitude", item.getBngLongitude());
                intent.putExtra("jarak", item.getDistance());
                startActivity(intent);
                return true;
            });
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
