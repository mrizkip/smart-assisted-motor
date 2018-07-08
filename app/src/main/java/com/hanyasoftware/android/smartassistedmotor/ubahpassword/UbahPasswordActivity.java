package com.hanyasoftware.android.smartassistedmotor.ubahpassword;

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

public class UbahPasswordActivity extends AppCompatActivity {

    @BindView(R.id.ubahPassword_password)
    EditText edtPassword;
    @BindView(R.id.ubahPassword_buttonSimpan)
    Button btnSimpan;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private UbahPasswordViewModel ubahPasswordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Ubah Password");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ubahPasswordViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getUbahPasswordViewModelFactory())
                .get(UbahPasswordViewModel.class);

        btnSimpan.setOnClickListener(v -> ubahPassword());
    }

    private void ubahPassword() {
        String password = edtPassword.getText().toString().trim();
        if (password.isEmpty()) {
            edtPassword.setError("Password tidak boleh kosong!");
        } else {
            ubahPasswordViewModel.ubahPassword(password).observe(this, response -> {
                if (response.getInd() == 1) {
                    Toast.makeText(this, "Ubah password berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Ubah password gagal!", Toast.LENGTH_SHORT).show();
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
