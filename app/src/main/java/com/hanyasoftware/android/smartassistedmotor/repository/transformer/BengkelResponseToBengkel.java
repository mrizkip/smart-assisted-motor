package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.BengkelResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Bengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class BengkelResponseToBengkel extends BaseLayerDataTransformer<BengkelResponse, Bengkel> {

    @Inject
    public BengkelResponseToBengkel() {
    }

    @Override
    public Bengkel transform(BengkelResponse from) {
        Bengkel bengkel = new Bengkel();
        bengkel.setBngId(from.getBngId());
        bengkel.setBngNama(from.getBngNama());
        bengkel.setBngAlamat(from.getBngAlamat());
        bengkel.setBngHariBuka(from.getBngHariBuka());
        bengkel.setBngJamBuka(from.getBngJamBuka());
        bengkel.setBngJamTutup(from.getBngJamTutup());
        bengkel.setBngLatitude(from.getBngLatitude());
        bengkel.setBngLongitude(from.getBngLongitude());
        bengkel.setBngKtgId(from.getBngKtgId());
        bengkel.setKtgId(from.getKtgId());
        bengkel.setKtgNama(from.getKtgNama());
        bengkel.setDistance(from.getDistance());
        return bengkel;
    }
}
