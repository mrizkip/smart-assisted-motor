package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBengkelActivity extends AppCompatActivity {

    @BindView(R.id.detailBengkel_namaBengkel)
    TextView nama;
    @BindView(R.id.detailBengkel_alamat)
    TextView alamat;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detailBengkel_buttonLihatMap)
    Button btnMap;
    @BindView(R.id.detailBengkel_buttonLihatAntrian)
    Button btnAntrian;

    ActionBar actionBar;

    private BengkelAdapter bengkel = new BengkelAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bengkel);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        bengkel.setIdBengkel(intent.getIntExtra("id", 0));
        bengkel.setNama(intent.getStringExtra("nama"));
        bengkel.setAlamat(intent.getStringExtra("alamat"));
        bengkel.setMerk(intent.getStringExtra("merk"));
        bengkel.setJarak(intent.getDoubleExtra("jarak", 0));
        bengkel.setLatitude(intent.getStringExtra("latitude"));
        bengkel.setLongitude(intent.getStringExtra("longitude"));

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Detail Bengkel");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        nama.setText(bengkel.getNama());
        alamat.setText(bengkel.getAlamat());

        btnMap.setOnClickListener(v -> {
            String latitude = bengkel.getLatitude();
            String longitude = bengkel.getLongitude();
            String label = bengkel.getNama();
            String uriBegin = "geo:" + latitude + "," + longitude;
            String query = latitude + "," + longitude + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            // Creates an Intent that will load a map
            Uri gmmIntentUri = Uri.parse(uriString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
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
