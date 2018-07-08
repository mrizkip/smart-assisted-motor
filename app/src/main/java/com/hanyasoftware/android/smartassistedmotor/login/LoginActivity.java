package com.hanyasoftware.android.smartassistedmotor.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.guest.GuestActivity;
import com.hanyasoftware.android.smartassistedmotor.main.MainActivity;
import com.hanyasoftware.android.smartassistedmotor.pilihmotor.PilihMotorActivity;
import com.hanyasoftware.android.smartassistedmotor.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_email)
    EditText tvEmail;
    @BindView(R.id.login_password)
    EditText tvPassword;
    @BindView(R.id.login_buttonLogin)
    Button btnLogin;
    @BindView(R.id.login_register)
    TextView tvRegister;
    @BindView(R.id.login_guest)
    TextView tvGuest;

    private String username;
    private String password;

    private boolean valid;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getLoginViewModelFactory())
                .get(LoginViewModel.class);

        btnLogin.setOnClickListener(v -> {
            username = tvEmail.getText().toString().trim();
            password = tvPassword.getText().toString().trim();

            valid = validateEmptyString(username, password);

            if (valid) {
                loginViewModel.login(username, password).observe(this, loginStatus -> {
                    if (loginStatus != null) {
                        if (loginStatus) {
                            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, PilihMotorActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "Login Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Login Gagal!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        tvGuest.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, GuestActivity.class);
            startActivity(intent);
        });


    }

    private boolean validateEmptyString(String username, String password) {
        if (username == null || username.isEmpty()) {
            tvEmail.setError("Email harus diisi!");
            return false;
        } else if (password == null || password.isEmpty()) {
            tvPassword.setError("Password harus diisi!");
            return false;
        }  else {
            return true;
        }
    }
}
