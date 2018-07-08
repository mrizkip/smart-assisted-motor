package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IHapusServis;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IListServis;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ITambahServis;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.HapusServisResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.ServisApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahServisResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServisRepository {

    private final ITambahServis iTambahServis;
    private final IListServis iListServis;
    private final IHapusServis iHapusServis;

    @Inject
    public ServisRepository(ITambahServis iTambahServis, IListServis iListServis, IHapusServis iHapusServis) {
        this.iTambahServis = iTambahServis;
        this.iListServis = iListServis;
        this.iHapusServis = iHapusServis;
    }

    public Observable<TambahServisResponse> tambahServis(String idKendaraan, String tanggal, String keterangan) {
        return iTambahServis.tambahServis(idKendaraan, tanggal, keterangan)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<ServisApi>> getListServis(String idKendaraan) {
        return iListServis.getListServis(idKendaraan)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<HapusServisResponse> hapusServis(String idServis) {
        return iHapusServis.hapusServis(idServis)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
