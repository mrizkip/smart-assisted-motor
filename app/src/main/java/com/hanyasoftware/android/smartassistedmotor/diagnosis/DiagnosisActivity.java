package com.hanyasoftware.android.smartassistedmotor.diagnosis;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.DiagnosaResponse;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiagnosisActivity extends AppCompatActivity {

    @BindView(R.id.diagnosis_jarakTempuh)
    TextView jarakTempuh;
    @BindView(R.id.diagnosis_textDiagnosis)
    TextView textDiagnosis;
    @BindView(R.id.diagnosis_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.diagnosis_totalBiaya)
    TextView tvTotalBiaya;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private List<DiagnosaAdapter> diagnosaAdapters;
    private FastItemAdapter<DiagnosaAdapter> fastItemAdapter;
    private int jumlahBiaya = 0;

    private DiagnosaViewModel diagnosaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Diagnosis");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        diagnosaViewModel = ViewModelProviders.of(this, SAMApplication.getDataComponent().getDiagnosaViewModelFactory())
                .get(DiagnosaViewModel.class);

        Intent intent = getIntent();
        String jarak = intent.getStringExtra("jarak");

        // set km
        jarakTempuh.setText(jarak);

        // set diagnosis
        textDiagnosis.setText("Diagnosis pada jarak " + jarak + " km.");

        // init
        diagnosaAdapters = new ArrayList<>();
        fastItemAdapter = new FastItemAdapter<>();
        fastItemAdapter.set(diagnosaAdapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastItemAdapter);

        diagnosaViewModel.getDiagnosa().observe(this, diagnosaResponse -> {
            if (diagnosaResponse != null) {
                updateDiagnosa(diagnosaResponse);
            }
        });

    }

    private void updateDiagnosa(DiagnosaResponse diagnosaResponse) {
        if (diagnosaResponse != null && diagnosaResponse.getInd() == 1) {
            diagnosaAdapters.removeAll(diagnosaAdapters);
            String[] arrayDiagnosa = diagnosaResponse.getDiagnosa().split(";");
            for (String baris : arrayDiagnosa) {
                String[] column = baris.split(":");
                int biaya;
                try {
                    biaya = Integer.parseInt(column[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    biaya = 0;
                }

                jumlahBiaya += biaya;

                DiagnosaAdapter itemAdapter = new DiagnosaAdapter();
                itemAdapter.setNomor(column[0]);
                itemAdapter.setPerawatan(column[1]);
                itemAdapter.setKeterangan(column[2] + "\n" + "Biaya: " + biaya);

                diagnosaAdapters.add(itemAdapter);
            }

            fastItemAdapter.set(diagnosaAdapters);
            fastItemAdapter.notifyDataSetChanged();

            tvTotalBiaya.setText("Total Prediksi Biaya: Rp " + jumlahBiaya);
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
