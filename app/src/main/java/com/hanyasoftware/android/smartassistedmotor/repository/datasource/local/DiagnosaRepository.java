package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IDiagnosa;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.DiagnosaResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DiagnosaRepository {

    private final IDiagnosa iDiagnosa;
    private final SharedPrefsRepository sharedPrefsRepository;

    @Inject
    public DiagnosaRepository(IDiagnosa iDiagnosa, SharedPrefsRepository sharedPrefsRepository) {
        this.iDiagnosa = iDiagnosa;
        this.sharedPrefsRepository = sharedPrefsRepository;
    }

    public Observable<DiagnosaResponse> getDiagnosa() {
        String kendaraanId = sharedPrefsRepository.getKendaraanFromPrefs().getKnd_id();
        return iDiagnosa.getDiagnosa(kendaraanId)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
