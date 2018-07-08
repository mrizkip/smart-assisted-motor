package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ITambahKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahKendaraanResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class KendaraanRepository {
    private final ITambahKendaraan iTambahKendaraan;

    @Inject
    public KendaraanRepository(ITambahKendaraan iTambahKendaraan) {
        this.iTambahKendaraan = iTambahKendaraan;
    }

    public Observable<TambahKendaraanResponse> tambahKendaraan(Kendaraan kendaraan) {
        return iTambahKendaraan.tambahKendaraan(kendaraan.getKnd_usr_id(), kendaraan.getKnd_nopol(),
                kendaraan.getKnd_pemilik(), kendaraan.getKnd_tipe(), kendaraan.getKnd_tahun(),
                kendaraan.getKnd_lcmesin(), kendaraan.getKnd_ukuranban())
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
