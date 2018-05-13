package com.hanyasoftware.android.smartassistedmotor.diagnosis;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.guest.DetailGuestAdapter;
import com.hanyasoftware.android.smartassistedmotor.guest.MapKeyPerawatan;
import com.hanyasoftware.android.smartassistedmotor.guest.TabelCb150r;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiagnosisActivity extends AppCompatActivity {

    @BindView(R.id.diagnosis_jarakTempuh)
    TextView jarakTempuh;
    @BindView(R.id.diagnosis_textDiagnosis)
    TextView textDiagnosis;
    @BindView(R.id.diagnosis_buttonPrediksi)
    Button buttonPrediksi;
    @BindView(R.id.diagnosis_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private String motor;
    private String kilometer;

    private Map<MapKeyPerawatan, List<DetailGuestAdapter>> mapTabelCb150r;

    private MapKeyPerawatan keyCb150r;

    private List<DetailGuestAdapter> detailGuestAdapters;
    private FastItemAdapter<DetailGuestAdapter> fastItemAdapter;

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

        Intent intent = getIntent();
        String jarak = intent.getStringExtra("jarak");

        // set km
        jarakTempuh.setText(jarak);

        // set diagnosis
        textDiagnosis.setText("Diagnosis pada jarak " + jarak + " km.");

        // init
        detailGuestAdapters = new ArrayList<>();
        fastItemAdapter = new FastItemAdapter<>();
        keyCb150r = new MapKeyPerawatan();
        initTableCb150r();

        // set motor
        motor = "CB 150R";
        int jarakInt = Integer.parseInt(jarak);
        if (jarakInt >= 0 && jarakInt < 4000) {
            kilometer = "1.000 Km";
        } else if (jarakInt >= 4000 && jarakInt < 12000) {
            kilometer = "6.000 Km";
        } else if (jarakInt >= 12000 && jarakInt < 18000) {
            kilometer = "12.000 Km";
        } else if (jarakInt >= 18000 && jarakInt < 24000) {
            kilometer = "18.000 Km";
        } else if (jarakInt >= 24000 && jarakInt < 30000) {
            kilometer = "24.000 Km";
        } else if (jarakInt >= 30000 && jarakInt < 36000) {
            kilometer = "30.000 Km";
        } else if (jarakInt >= 36000 && jarakInt < 42000) {
            kilometer = "36.000 Km";
        } else if (jarakInt >= 42000 && jarakInt < 48000) {
            kilometer = "42.000 Km";
        } else if (jarakInt >= 48000 && jarakInt < 54000) {
            kilometer = "48.000 Km";
        } else if (jarakInt >= 54000) {
            kilometer = "54.000 Km";
        }

        // get diagnosis
        keyCb150r.setMotor(motor);
        keyCb150r.setKilometer(kilometer);
        if (mapTabelCb150r.containsKey(keyCb150r)) {
            detailGuestAdapters.clear();
            detailGuestAdapters = mapTabelCb150r.get(keyCb150r);
        }

        if (detailGuestAdapters != null && !detailGuestAdapters.isEmpty()) {
            fastItemAdapter.set(detailGuestAdapters);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(fastItemAdapter);
        }

    }

    private void initTableCb150r() {
        TabelCb150r tabelCb150r =  new TabelCb150r();
        mapTabelCb150r = tabelCb150r.getMapTableCb150r();
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
