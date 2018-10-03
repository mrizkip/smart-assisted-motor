package com.hanyasoftware.android.smartassistedmotor.register;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_nama)
    EditText edtNama;
    @BindView(R.id.register_username)
    EditText edtUsername;
    @BindView(R.id.register_password)
    EditText edtPassword;
    @BindView(R.id.register_buttonRegister)
    Button btnRegister;
    @BindView(R.id.register_login)
    TextView tvLogin;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Daftar");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        registerViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getRegisterViewModelFactory())
                .get(RegisterViewModel.class);

        btnRegister.setOnClickListener(v -> {
            String nama = edtNama.getText().toString().trim();
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            boolean valid = validateEmptyString(nama, username, password);

            if (valid) {
                // login here
                registerViewModel.registerUser(nama, username, password)
                        .observe(this, registerResponse -> {
                            if (registerResponse == 1) {
                                Toast.makeText(this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else if (registerResponse == 2) {
                                Toast.makeText(this, "Username Sudah Terdaftar!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        tvLogin.setOnClickListener(v -> finish());

    }

    private boolean validateEmptyString(String nama, String username, String password) {
        if (nama == null || nama.isEmpty()) {
            edtNama.setError("Nama tidak boleh kosong!");
            return false;
        } else if (username == null || username.isEmpty()) {
            edtUsername.setError("Username tidak boleh kosong!");
            return false;
        } else if (password == null || password.isEmpty()) {
            edtPassword.setError("Password tidak boleh kosong!");
            return false;
        } else {
            return true;
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
