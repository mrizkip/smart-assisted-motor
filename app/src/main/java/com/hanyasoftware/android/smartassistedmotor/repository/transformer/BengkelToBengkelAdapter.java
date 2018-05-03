package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.bengkel.BengkelAdapter;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Bengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class BengkelToBengkelAdapter extends BaseLayerDataTransformer<Bengkel, BengkelAdapter> {

    @Inject
    public BengkelToBengkelAdapter() {
    }

    @Override
    public BengkelAdapter transform(Bengkel from) {
        BengkelAdapter bengkel = new BengkelAdapter();
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
        bengkel.setDistance(from.getDistance().substring(0,3));
        return bengkel;
    }
}
