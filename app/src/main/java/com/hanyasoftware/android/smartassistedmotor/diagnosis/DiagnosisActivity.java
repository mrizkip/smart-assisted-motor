package com.hanyasoftware.android.smartassistedmotor.diagnosis;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiagnosisActivity extends AppCompatActivity {

    @BindView(R.id.diagnosis_jarakTempuh)
    TextView jarakTempuh;
    @BindView(R.id.diagnosis_textDiagnosis)
    TextView textDiagnosis;
    @BindView(R.id.diagnosis_buttonPrediksi)
    Button buttonPrediksi;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

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

        // set km
        jarakTempuh.setText("10.000");

        // set diagnosis
        textDiagnosis.setText("Diagnosis pada jarak " + "10.000" + " km.");


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
