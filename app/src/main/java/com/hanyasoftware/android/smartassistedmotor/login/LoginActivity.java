package com.hanyasoftware.android.smartassistedmotor.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.guest.GuestActivity;
import com.hanyasoftware.android.smartassistedmotor.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_email)
    TextView tvEmail;
    @BindView(R.id.login_password)
    TextView tvPassword;
    @BindView(R.id.login_buttonLogin)
    Button btnLogin;
    @BindView(R.id.login_register)
    TextView tvGuest;

    private String username;
    private String password;

    private boolean empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        btnLogin.setOnClickListener(v -> {
            username = tvEmail.getText().toString().trim();
            password = tvPassword.getText().toString().trim();

            empty = validateEmptyString(username, password);

            if (!empty) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
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
