package com.hanyasoftware.android.smartassistedmotor.guest;

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
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailGuestActivity extends AppCompatActivity {

    @BindView(R.id.detailGuest_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private String motor;
    private String kilometer;

    private Map<MapKeyPerawatan, List<DetailGuestAdapter>> mapTabelCb150r;
    private Map<MapKeyPerawatan, List<DetailGuestAdapter>> mapTabelVario125;

    private MapKeyPerawatan keyCb150r;
    private MapKeyPerawatan keyVario125;

    private List<DetailGuestAdapter> detailGuestAdapters;
    private FastItemAdapter<DetailGuestAdapter> fastItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guest);

        ButterKnife.bind(this);

        detailGuestAdapters = new ArrayList<>();
        fastItemAdapter = new FastItemAdapter<>();
        keyCb150r = new MapKeyPerawatan();
        keyVario125 = new MapKeyPerawatan();

        // init table
        initTableCb150r();
        initTableVario125();

        Intent intent = getIntent();
        motor = intent.getStringExtra("motor");
        kilometer = intent.getStringExtra("kilometer");

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle(kilometer);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // fetch detail
        if (motor.equalsIgnoreCase("CB 150R")) {
            keyCb150r.setMotor(motor);
            keyCb150r.setKilometer(kilometer);
            if (mapTabelCb150r.containsKey(keyCb150r)) {
                detailGuestAdapters.clear();
                detailGuestAdapters = mapTabelCb150r.get(keyCb150r);
            }
        } else if (motor.equalsIgnoreCase("Vario 125")) {
            keyVario125.setMotor(motor);
            keyVario125.setKilometer(kilometer);
            if (mapTabelVario125.containsKey(keyVario125)) {
                detailGuestAdapters.clear();
                detailGuestAdapters = mapTabelVario125.get(keyVario125);
            }
        }

        if (detailGuestAdapters != null && !detailGuestAdapters.isEmpty()) {
            fastItemAdapter.set(detailGuestAdapters);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(fastItemAdapter);
        }

    }

    private void initTableCb150r() {
        TabelCb150r tabelCb150r =  new TabelCb150r();
        mapTabelCb150r = tabelCb150r.getMapTableCb150r();
    }

    private void initTableVario125() {
        TabelVario125 tabelVario125 = new TabelVario125();
        mapTabelVario125 = tabelVario125.getMapTableVario125();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    
}
