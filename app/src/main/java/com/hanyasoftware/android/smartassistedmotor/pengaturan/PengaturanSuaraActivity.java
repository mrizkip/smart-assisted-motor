package com.hanyasoftware.android.smartassistedmotor.pengaturan;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.kevalpatel.ringtonepicker.RingtonePickerDialog;
import com.kevalpatel.ringtonepicker.RingtonePickerListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PengaturanSuaraActivity extends AppCompatActivity {
    @BindView(R.id.suara_suara)
    TextView tvPilihRingtone;
    @BindView(R.id.suara_ringtone)
    TextView tvRingtone;
    @BindView(R.id.suara_buttonSimpan)
    Button btnSimpan;
    @BindView(R.id.suara_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private RingtonePickerDialog.Builder ringtonePicker;
    private Ringtone ringtone;
    private Uri ringtoneUri;
    private String ringtoneName;

    private SharedPrefsRepository sharedPrefsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_suara);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Pengaturan Suara");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // get ringtone from shared preference
        sharedPrefsRepository = SAMApplication.getDataComponent().getSharedPrefsRepository();
        String savedUriString = sharedPrefsRepository.getRingtoneUriFromPrefs();
        String savedRingtoneName = sharedPrefsRepository.getRingtoneNameFromPrefs();
        if (savedUriString == null || savedRingtoneName == null) {
            ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            ringtoneName = "Default";
        } else {
            ringtoneUri = Uri.parse(savedUriString);
            ringtoneName = savedRingtoneName;
        }
        tvRingtone.setText(ringtoneName);
        ringtone = RingtoneManager.getRingtone(this, ringtoneUri);

        // Ringtone picker builder
        buildRingtonePicker();

        // set ringtone
        tvPilihRingtone.setOnClickListener(v -> {
            ringtone.stop();
            ringtonePicker.show();
        });

        // simpan
        btnSimpan.setOnClickListener(v -> {
            ringtone.stop();
            String uriString = String.valueOf(ringtoneUri);
            String nameString = ringtoneName;
            sharedPrefsRepository.saveRingtoneToPrefs(uriString, nameString);
            Toast.makeText(this, "Ringtone berhasil disimpan", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private void buildRingtonePicker() {
        ringtonePicker = new RingtonePickerDialog.Builder(PengaturanSuaraActivity.this, getSupportFragmentManager());
        ringtonePicker.setTitle("Pilih Ringtone");
        ringtonePicker.displayDefaultRingtone(true);
        ringtonePicker.setPositiveButtonText("PILIH");
        ringtonePicker.setCancelButtonText("BATAL");
        ringtonePicker.addRingtoneType(RingtonePickerDialog.Builder.TYPE_ALARM);
        ringtonePicker.addRingtoneType(RingtonePickerDialog.Builder.TYPE_NOTIFICATION);
        ringtonePicker.addRingtoneType(RingtonePickerDialog.Builder.TYPE_RINGTONE);
        ringtonePicker.setListener((RingtonePickerListener) (ringtoneName, ringtoneUri) -> {
            tvRingtone.setText(ringtoneName);
            this.ringtoneName = ringtoneName;
            this.ringtoneUri = ringtoneUri;
            ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
            ringtone.play();
        });
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
