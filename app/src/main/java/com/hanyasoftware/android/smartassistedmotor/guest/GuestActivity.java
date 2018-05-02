package com.hanyasoftware.android.smartassistedmotor.guest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestActivity extends AppCompatActivity {

    @BindView(R.id.guest_spinnerMotor)
    Spinner spinnerMotor;
    @BindView(R.id.guest_recyclerView)
    RecyclerView recyclerView;

    private List<GuestAdapter> cb150rAdapters;
    private List<GuestAdapter> motor2Adapters;
    private FastItemAdapter<GuestAdapter> fastItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        ButterKnife.bind(this);

        cb150rAdapters = new ArrayList<>();
        motor2Adapters = new ArrayList<>();
        fastItemAdapter = new FastItemAdapter<>();

        initAdapter();
        fastItemAdapter.set(cb150rAdapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastItemAdapter);

        spinnerMotor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String motor = adapterView.getItemAtPosition(pos).toString();

                if (motor.equalsIgnoreCase("CB 150R")) {
                    fastItemAdapter.set(cb150rAdapters);
                    fastItemAdapter.notifyAdapterDataSetChanged();
                } else {
                    fastItemAdapter.set(motor2Adapters);
                    fastItemAdapter.notifyAdapterDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initAdapter() {
        GuestAdapter km1 = new GuestAdapter("1.000 Km");
        GuestAdapter km4 = new GuestAdapter("4.000 Km");
        GuestAdapter km6 = new GuestAdapter("6.000 Km");
        GuestAdapter km8 = new GuestAdapter("8.000 Km");
        GuestAdapter km12 = new GuestAdapter("12.000 Km");
        GuestAdapter km16 = new GuestAdapter("16.000 Km");
        GuestAdapter km18 = new GuestAdapter("18.000 Km");
        GuestAdapter km20 = new GuestAdapter("20.000 Km");
        GuestAdapter km24 = new GuestAdapter("24.000 Km");
        GuestAdapter km28 = new GuestAdapter("28.000 Km");
        GuestAdapter km30 = new GuestAdapter("30.000 Km");
        GuestAdapter km32 = new GuestAdapter("32.000 Km");
        GuestAdapter km36 = new GuestAdapter("36.000 Km");
        GuestAdapter km40 = new GuestAdapter("40.000 Km");
        GuestAdapter km42 = new GuestAdapter("42.000 Km");
        GuestAdapter km44 = new GuestAdapter("44.000 Km");
        GuestAdapter km48 = new GuestAdapter("48.000 Km");
        GuestAdapter km52 = new GuestAdapter("52.000 Km");
        GuestAdapter km54 = new GuestAdapter("54.000 Km");

        cb150rAdapters.add(km1);
        cb150rAdapters.add(km6);
        cb150rAdapters.add(km12);
        cb150rAdapters.add(km18);
        cb150rAdapters.add(km24);
        cb150rAdapters.add(km30);
        cb150rAdapters.add(km36);
        cb150rAdapters.add(km42);
        cb150rAdapters.add(km48);
        cb150rAdapters.add(km54);

        motor2Adapters.add(km1);
        motor2Adapters.add(km4);
        motor2Adapters.add(km8);
        motor2Adapters.add(km12);
        motor2Adapters.add(km16);
        motor2Adapters.add(km20);
        motor2Adapters.add(km24);
        motor2Adapters.add(km28);
        motor2Adapters.add(km32);
        motor2Adapters.add(km36);
        motor2Adapters.add(km40);
        motor2Adapters.add(km44);
        motor2Adapters.add(km48);
        motor2Adapters.add(km52);
    }
}
