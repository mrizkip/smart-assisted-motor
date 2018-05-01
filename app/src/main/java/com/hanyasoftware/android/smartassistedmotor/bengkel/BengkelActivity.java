package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BengkelActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bengkel_recycleViewListBengkel)
    RecyclerView recyclerView;

    ActionBar actionBar;

    private FastItemAdapter<BengkelAdapter> fastBengkelAdapter;
    private List<BengkelAdapter> bengkelAdapter;

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

        initBengkel();

        fastBengkelAdapter.set(bengkelAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastBengkelAdapter);

        fastBengkelAdapter.withSelectable(true);
        fastBengkelAdapter.withOnClickListener((v, adapter, item, position) -> {
           Intent intent = new Intent(v.getContext(), DetailBengkelActivity.class);
           intent.putExtra("id", item.getIdBengkel());
           intent.putExtra("nama", item.getNama());
           intent.putExtra("alamat", item.getAlamat());
           intent.putExtra("merk", item.getMerk());
           intent.putExtra("latitude", item.getLatitude());
           intent.putExtra("longitude", item.getLongitude());
           intent.putExtra("jarak", item.getJarak());
           startActivity(intent);
            return true;
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

    private void initBengkel() {
        BengkelAdapter bengkel1 = new BengkelAdapter();
        bengkel1.setIdBengkel(1);
        bengkel1.setNama("Official Workshop Honda AHASS Putra Jaya");
        bengkel1.setAlamat("Jl. Candi Panggung No.3C-D, Mojolangu, Kec. Lowokwaru, Kota Malang, Jawa Timur 65142");
        bengkel1.setLatitude("-7.93877");
        bengkel1.setLongitude("112.623251");
        bengkel1.setMerk("Honda");
        bengkel1.setJarak(1.0);

        BengkelAdapter bengkel2 = new BengkelAdapter();
        bengkel2.setIdBengkel(2);
        bengkel2.setNama("AHASS SUKMA MALANG Sigura-Gura");
        bengkel2.setAlamat("Jl. Bendungan Sigura-gura Barat No. 41D, RT. 01/RW. 08, Karangbesuki, Sukun, Kota Malang, Jawa Timur 65149");
        bengkel2.setLatitude("-7.957490");
        bengkel2.setLongitude("112.605907");
        bengkel2.setMerk("Honda");
        bengkel2.setJarak(1.0);

        BengkelAdapter bengkel3 = new BengkelAdapter();
        bengkel3.setIdBengkel(3);
        bengkel3.setNama("Workshop Yamaha BSM Galunggung");
        bengkel3.setAlamat("Jl. Galunggung No.36, Gading Kasri, Klojen, Kota Malang, Jawa Timur 65115");
        bengkel3.setLatitude("-7.970313");
        bengkel3.setLongitude("112.613513");
        bengkel3.setMerk("Yamaha");
        bengkel3.setJarak(1.0);
        
        BengkelAdapter bengkel4 = new BengkelAdapter();
        bengkel4.setIdBengkel(4);
        bengkel4.setNama("Yamaha Surya Inti Putra Blimbing");
        bengkel4.setAlamat("Jalan Jend A. Yani No.20 A-B, Blimbing, Kota Malang, Jawa Timur");
        bengkel4.setLatitude("-7.942547");
        bengkel4.setLongitude("112.642075");
        bengkel4.setMerk("Yamaha");
        bengkel4.setJarak(1.0);
        
        BengkelAdapter bengkel5 = new BengkelAdapter();
        bengkel5.setIdBengkel(5);
        bengkel5.setNama("Bengkel Suzuki Tlogomas");
        bengkel5.setAlamat("Jl. Raya Tlogomas No.20, Tlogomas, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144");
        bengkel5.setLatitude("-7.927153");
        bengkel5.setLongitude("112.602291");
        bengkel5.setMerk("Suzuki");
        bengkel5.setJarak(1.0);
        
        BengkelAdapter bengkel6 = new BengkelAdapter();
        bengkel6.setIdBengkel(6);
        bengkel6.setNama("PT. Surapita UNITRANS Kawasaki Main Dealer Malang");
        bengkel6.setAlamat("Jl. Jaksa Agung Suprapto No.71, Samaan, Klojen, Kota Malang, Jawa Timur 65112");
        bengkel6.setLatitude("-7.966525");
        bengkel6.setLongitude("112.633593");
        bengkel6.setMerk("Kawasaki");
        bengkel6.setJarak(1.0);
        
        bengkelAdapter.add(bengkel1);
        bengkelAdapter.add(bengkel2);
        bengkelAdapter.add(bengkel3);
        bengkelAdapter.add(bengkel4);
        bengkelAdapter.add(bengkel5);
        bengkelAdapter.add(bengkel6);

    }
}
