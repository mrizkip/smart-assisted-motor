package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.KendaraanApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class KendaraanApiToKendaraan extends BaseLayerDataTransformer<KendaraanApi, Kendaraan> {

    @Inject
    public KendaraanApiToKendaraan() {
    }

    @Override
    public Kendaraan transform(KendaraanApi from) {
        Kendaraan kendaraan = new Kendaraan();
        kendaraan.setKnd_id(from.getKnd_id());
        kendaraan.setKnd_nopol(from.getKnd_nopol());
        kendaraan.setKnd_pemilik(from.getKnd_pemilik());
        kendaraan.setKnd_tahun(from.getKnd_tahun());
        kendaraan.setKnd_tipe(from.getKnd_tipe());
        kendaraan.setKnd_lcmesin(from.getKnd_lcmesin());
        kendaraan.setKnd_ukuranban(from.getKnd_ukuranban());
        kendaraan.setKnd_usr_id(from.getKnd_usr_id());
        return kendaraan;
    }
}
