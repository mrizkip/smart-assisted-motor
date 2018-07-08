package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.pilihmotor.MotorAdapter;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class KendaraanToMotorAdapter extends BaseLayerDataTransformer<Kendaraan, MotorAdapter>{

    @Inject
    public KendaraanToMotorAdapter() {
    }

    @Override
    public MotorAdapter transform(Kendaraan from) {
        MotorAdapter motor = new MotorAdapter();
        motor.setIdKendaraan(from.getKnd_id());
        motor.setNopol(from.getKnd_nopol());
        motor.setPemilik(from.getKnd_pemilik());
        motor.setTipe(from.getKnd_tipe());
        return motor;
    }
}
