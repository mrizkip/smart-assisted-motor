package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
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

    private BengkelViewModel bengkelViewModel;

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

        bengkelViewModel.getBengkelList().observe(this, bengkelList -> {
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
