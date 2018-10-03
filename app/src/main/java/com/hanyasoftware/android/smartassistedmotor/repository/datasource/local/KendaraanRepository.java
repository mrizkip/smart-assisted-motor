package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IHapusKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IListKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ITambahKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IUbahKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.EditKendaraanResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.HapusKendaraanResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.KendaraanApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahKendaraanResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.KendaraanApiToKendaraan;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class KendaraanRepository {
    private final ITambahKendaraan iTambahKendaraan;
    private final IListKendaraan iListKendaraan;
    private final SharedPrefsRepository sharedPrefsRepository;
    private final KendaraanApiToKendaraan kendaraanApiToKendaraan;
    private final IUbahKendaraan iUbahKendaraan;
    private final IHapusKendaraan iHapusKendaraan;

    @Inject
    public KendaraanRepository(ITambahKendaraan iTambahKendaraan, IListKendaraan iListKendaraan,
                               SharedPrefsRepository sharedPrefsRepository, KendaraanApiToKendaraan kendaraanApiToKendaraan,
                               IUbahKendaraan iUbahKendaraan, IHapusKendaraan iHapusKendaraan) {
        this.iTambahKendaraan = iTambahKendaraan;
        this.iListKendaraan = iListKendaraan;
        this.sharedPrefsRepository = sharedPrefsRepository;
        this.kendaraanApiToKendaraan = kendaraanApiToKendaraan;
        this.iUbahKendaraan = iUbahKendaraan;
        this.iHapusKendaraan = iHapusKendaraan;
    }

    public Observable<TambahKendaraanResponse> tambahKendaraan(Kendaraan kendaraan) {
        return iTambahKendaraan.tambahKendaraan(kendaraan.getKnd_usr_id(), kendaraan.getKnd_nopol(),
                kendaraan.getKnd_pemilik(), kendaraan.getKnd_tipe(), kendaraan.getKnd_tahun(),
                kendaraan.getKnd_lcmesin(), kendaraan.getKnd_ukuranban())
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Kendaraan>> getListKendaraan() {
        String userId = sharedPrefsRepository.getUserFromPrefs().getUsr_id();
        return iListKendaraan.getListKendaraan(userId)
                .toObservable()
                .map(kendaraanApiToKendaraan::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<EditKendaraanResponse> editKendaraan(String idKendaraan, String nopol,
                                                           String pemilik, String ukuranBan) {
        return iUbahKendaraan.editKendaraan(idKendaraan, nopol, pemilik, ukuranBan)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<HapusKendaraanResponse> hapusKendaraan(String idKendaraan) {
        return iHapusKendaraan.hapusKendaraan(idKendaraan)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Kendaraan> getKendaraan() {
        String kendaraanId = sharedPrefsRepository.getKendaraanFromPrefs().getKnd_id();
        return iListKendaraan.getKendaraan(kendaraanId)
                .toObservable()
                .map(kendaraanApiToKendaraan::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
