package com.hanyasoftware.android.smartassistedmotor.guest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailGuestActivity extends AppCompatActivity {

    @BindView(R.id.detailGuest_recyclerView)
    RecyclerView recyclerView;

    private String motor;
    private String kilometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guest);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        motor = intent.getStringExtra("motor");
        kilometer = intent.getStringExtra("kilometer");

        if (motor.equalsIgnoreCase("CB 150R")) {
            if (kilometer.equalsIgnoreCase("1.000 Km")) {

            }
        }
    }
}
