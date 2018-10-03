package com.hanyasoftware.android.smartassistedmotor.pengaturan;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TambahMotorActivity extends AppCompatActivity {

    @BindView(R.id.tambahMotor_nopol)
    EditText edtNopol;
    @BindView(R.id.tambahMotor_textTipe)
    TextView tvTipe;
    @BindView(R.id.tambahMotor_spnTipe)
    Spinner spnTipe;
    @BindView(R.id.tambahMotor_tahun)
    EditText edtTahun;
    @BindView(R.id.tambahMotor_lcMesin)
    EditText edtLcMesin;
    @BindView(R.id.tambahMotor_ukuranRoda)
    EditText edtUkuranRoda;
    @BindView(R.id.tambahMotor_btnSimpan)
    Button btnSimpan;
    @BindView(R.id.tambahMotor_edtPemilik)
    EditText edtPemilik;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private TambahKendaraanViewModel tambahKendaraanViewModel;
    private SharedPrefsRepository sharedPrefsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_motor);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Tambah Motor");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tambahKendaraanViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getTambahKendaraanViewModelFactory())
                .get(TambahKendaraanViewModel.class);
        sharedPrefsRepository = SAMApplication.getDataComponent().getSharedPrefsRepository();

        btnSimpan.setOnClickListener(v -> simpanMotor());
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

    private void simpanMotor() {
        String nopol = edtNopol.getText().toString().trim();
        String pemilik = edtPemilik.getText().toString().trim();
        String tahun = edtTahun.getText().toString().trim();
        String lcMesin = edtLcMesin.getText().toString().trim();
        String ukuranRoda = edtUkuranRoda.getText().toString().trim();
        String tipe = spnTipe.getSelectedItem().toString();
        if (tipe.equalsIgnoreCase("CB 150R")) {
            tipe = "cb150r";
        } else if (tipe.equalsIgnoreCase("Vario 125")) {
            tipe = "vario125";
        }

        boolean isEmptyField = false;
        if (TextUtils.isEmpty(nopol)) {
            isEmptyField = true;
            edtNopol.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(pemilik)) {
            isEmptyField = true;
            edtPemilik.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(tahun)) {
            isEmptyField = true;
            edtTahun.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(lcMesin)) {
            isEmptyField = true;
            edtLcMesin.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(ukuranRoda)) {
            isEmptyField = true;
            edtUkuranRoda.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(tipe) || tipe.equalsIgnoreCase("UNAVAILABLE_VALUE")) {
            isEmptyField = true;
            tvTipe.setError("Pilih salah satu Tipe Motor!");
        }
        if (!isEmptyField) {
            // Intent to save or finish activity
            Kendaraan kendaraan = new Kendaraan();
            kendaraan.setKnd_usr_id(sharedPrefsRepository.getUserFromPrefs().getUsr_id());
            kendaraan.setKnd_nopol(nopol);
            kendaraan.setKnd_pemilik(pemilik);
            kendaraan.setKnd_tahun(tahun);
            kendaraan.setKnd_lcmesin(lcMesin);
            kendaraan.setKnd_tipe(tipe);
            kendaraan.setKnd_ukuranban(ukuranRoda);
            tambahKendaraanViewModel.tambahKendaraan(kendaraan)
                    .observe(this, integer -> {
                        if (integer == 1) {
                            Toast.makeText(this, "Motor Tersimpan", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "Kendaraan gagal disimpan! Terjadi Kesalahan.", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
