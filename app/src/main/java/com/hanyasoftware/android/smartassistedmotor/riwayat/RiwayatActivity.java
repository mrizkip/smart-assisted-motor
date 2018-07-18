package com.hanyasoftware.android.smartassistedmotor.riwayat;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.ServisApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RiwayatActivity extends AppCompatActivity {
    private static final String TAG = "RiwayatActivity";

    @BindView(R.id.riwayat_table)
    TableLayout tableLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private RiwayatServisViewModel riwayatServisViewModel;

    private List<ServisApi> servisApiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Riwayat Service");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        riwayatServisViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getRiwayatServisViewModelFactory())
                .get(RiwayatServisViewModel.class);

        servisApiList = new ArrayList<>();

        riwayatServisViewModel.getListServis().observe(this, this::updateRiwayatServis);

    }

    private void updateRiwayatServis(List<ServisApi> servisApis) {
        Log.d(TAG, "updateRiwayatServis: executed");
        for (ServisApi servis : servisApis) {
            Log.d(TAG, "updateRiwayatServis: for loop");
            TableRow row = new TableRow(this);

            TextView tanggal = new TextView(this);
            tanggal.setLayoutParams(new TableRow.LayoutParams(0, 80, 1f));
            tanggal.setBackgroundResource(R.drawable.border);
            tanggal.setPadding(5, 0, 0, 0);
            tanggal.setTextSize(16);
            tanggal.setTextColor(getResources().getColor(R.color.primaryText));
            tanggal.setText(servis.getRws_tanggal());
            tanggal.setGravity(Gravity.CENTER_VERTICAL);
            tanggal.setGravity(Gravity.END);

            TextView servisKeterangan = new TextView(this);
            servisKeterangan.setLayoutParams(new TableRow.LayoutParams(0, 80, 1f));
            servisKeterangan.setBackgroundResource(R.drawable.border);
            servisKeterangan.setPadding(0, 0, 5, 0);
            servisKeterangan.setTextSize(16);
            servisKeterangan.setTextColor(getResources().getColor(R.color.primaryText));
            servisKeterangan.setText(servis.getRws_keterangan());
            servisKeterangan.setGravity(Gravity.CENTER_VERTICAL);
            servisKeterangan.setGravity(Gravity.START);

            row.addView(servisKeterangan);
            row.addView(tanggal);
            tableLayout.addView(row);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_riwayat_servis, menu);

        MenuItem itemHapus = menu.findItem(R.id.menuRiwayatServis_hapus);
        Drawable hapusIcon = itemHapus.getIcon();
        hapusIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        MenuItem itemTambah = menu.findItem(R.id.menuRiwayatServis_tambah);
        Drawable drawable = itemTambah.getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menuRiwayatServis_tambah:
                Intent intent = new Intent(RiwayatActivity.this, TambahRiwayatServisActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
