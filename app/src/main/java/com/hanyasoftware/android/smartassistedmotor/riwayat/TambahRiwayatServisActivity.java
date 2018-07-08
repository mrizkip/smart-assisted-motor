package com.hanyasoftware.android.smartassistedmotor.riwayat;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TambahRiwayatServisActivity extends AppCompatActivity {

    @BindView(R.id.tambahRiwayat_tanggal)
    EditText edtTanggal;
    @BindView(R.id.tambahRiwayat_keterangan)
    EditText edtKeterangan;
    @BindView(R.id.tambahRiwayat_simpan)
    Button btnSimpan;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private TambahRiwayatServisViewModel tambahRiwayatServisViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_riwayat_servis);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Tambah Riwayat Servis");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tambahRiwayatServisViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getTambahRiwayatServisViewModelFactory())
                .get(TambahRiwayatServisViewModel.class);

        // TODO edit text tanggal open date picker

        btnSimpan.setOnClickListener(v -> simpanRiwayatServis());
    }

    private void simpanRiwayatServis() {
        boolean valid;
        String tanggal = edtTanggal.getText().toString().trim();
        String keterangan = edtKeterangan.getText().toString().trim();
        if (tanggal.isEmpty()) {
            edtTanggal.setError("Pilih tanggal riwayat servis!");
            valid = false;
        } else if (keterangan.isEmpty()) {
            edtKeterangan.setError("Keterangan tidak boleh kosong!");
            valid = false;
        } else {
            valid = true;
        }

        if (valid) {
            // save riwayat servis
            tambahRiwayatServisViewModel.tambahRiwayatServis(tanggal, keterangan)
                    .observe(this, response -> {
                        if (response.getInd() == 1) {
                            Toast.makeText(this, "Tambah riwayat servis berhasil", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "Tambah riwayat servis gagal!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

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
