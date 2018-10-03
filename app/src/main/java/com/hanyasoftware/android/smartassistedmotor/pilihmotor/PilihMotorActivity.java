package com.hanyasoftware.android.smartassistedmotor.pilihmotor;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.main.MainActivity;
import com.hanyasoftware.android.smartassistedmotor.pengaturan.TambahMotorActivity;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.KendaraanToMotorAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PilihMotorActivity extends AppCompatActivity {

    @BindView(R.id.pilihMotor_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private SharedPrefsRepository sharedPrefsRepository;
    private PilihMotorViewModel pilihMotorViewModel;
    private KendaraanToMotorAdapter kendaraanToMotorAdapter;
    private FastItemAdapter<MotorAdapter> motorAdapter;
    private List<MotorAdapter> motorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_motor);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Pilih Motor");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        sharedPrefsRepository = SAMApplication.getDataComponent().getSharedPrefsRepository();
        pilihMotorViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getPilihMotorViewModelFactory())
                .get(PilihMotorViewModel.class);
        kendaraanToMotorAdapter = SAMApplication.getMapperComponent().getKendaraanToMotorAdapter();

        initRecyclerView();

        pilihMotorViewModel.getListKendaraan().observe(this, kendaraans -> {
            motorList = kendaraanToMotorAdapter.transform(kendaraans);
            updateRecyclerView(motorList);
        });
    }

    private void initRecyclerView() {
        motorList = new ArrayList<>();
        motorAdapter = new FastItemAdapter<>();
        motorAdapter.set(motorList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(motorAdapter);

        // onClick
        motorAdapter.withSelectable(true);
        motorAdapter.withOnClickListener((v, adapter, item, position) -> {
            Kendaraan kendaraan = new Kendaraan();
            kendaraan.setKnd_id(item.getIdKendaraan());
            kendaraan.setKnd_nopol(item.getNopol());
            kendaraan.setKnd_tipe(item.getTipe());
            kendaraan.setKnd_pemilik(item.getPemilik());
            sharedPrefsRepository.saveKndToPrefs(kendaraan);
            Toast.makeText(this, "Motor terpilih " + kendaraan.getKnd_tipe(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PilihMotorActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        });
    }

    private void updateRecyclerView(List<MotorAdapter> motorAdapters)  {
        motorAdapter.set(motorAdapters);
        motorAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_pilih_motor, menu);

        MenuItem itemTambah = menu.findItem(R.id.menuPilihMotor_tambah);
        Drawable drawable = itemTambah.getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuPilihMotor_tambah:
                Intent intent = new Intent(PilihMotorActivity.this, TambahMotorActivity.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
