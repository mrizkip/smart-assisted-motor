package com.hanyasoftware.android.smartassistedmotor.riwayat;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    private RiwayatServisViewModel riwayatServisViewModel;

    private Calendar calendar;

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

        riwayatServisViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getRiwayatServisViewModelFactory())
                .get(RiwayatServisViewModel.class);

        // TODO edit text tanggal open date picker
        calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener datePicker = (datePicker1, year, month, day) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };

        edtTanggal.setOnClickListener(view -> {
            new DatePickerDialog(TambahRiwayatServisActivity.this, datePicker,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        btnSimpan.setOnClickListener(v -> simpanRiwayatServis());
    }

    private void updateLabel() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        edtTanggal.setText(sdf.format(calendar.getTime()));
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
            riwayatServisViewModel.tambahRiwayatServis(tanggal, keterangan)
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
