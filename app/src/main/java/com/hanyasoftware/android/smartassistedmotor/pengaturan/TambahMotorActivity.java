package com.hanyasoftware.android.smartassistedmotor.pengaturan;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TambahMotorActivity extends AppCompatActivity {

    @BindView(R.id.tambahMotor_nopol)
    EditText edtNopol;
    @BindView(R.id.tambahMotor_tipe)
    EditText edtTipe;
    @BindView(R.id.tambahMotor_tahun)
    EditText edtTahun;
    @BindView(R.id.tambahMotor_lcMesin)
    EditText edtLcMesin;
    @BindView(R.id.tambahMotor_ukuranRoda)
    EditText edtUkuranRoda;
    @BindView(R.id.tambahMotor_btnSimpan)
    Button btnSimpan;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

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
        String tipe = edtTipe.getText().toString().trim();
        String tahun = edtTahun.getText().toString().trim();
        String lcMesin = edtLcMesin.getText().toString().trim();
        String ukuranRoda = edtUkuranRoda.getText().toString().trim();

        boolean isEmptyField = false;
        if (TextUtils.isEmpty(nopol)) {
            isEmptyField = true;
            edtNopol.setError("Field ini tidak boleh kosong!");
        }
        if (TextUtils.isEmpty(tipe)) {
            isEmptyField = true;
            edtTipe.setError("Field ini tidak boleh kosong!");
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
        if (!isEmptyField) {
            Toast.makeText(this, "Motor Tersimpan", Toast.LENGTH_SHORT).show();
            // Intent to save or finish activity
            finish();
        }

    }
}
