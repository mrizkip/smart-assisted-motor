package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchJarak;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Jarak;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.JarakResponseToJarak;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class JarakRepository {

    private static final String TAG = "JarakRepository";

    private final IFetchJarak iFetchJarak;
    private final JarakResponseToJarak jarakResponseToJarak;
    private final SharedPrefsRepository sharedPrefsRepository;

    @Inject
    public JarakRepository(IFetchJarak iFetchJarak, JarakResponseToJarak jarakResponseToJarak, SharedPrefsRepository sharedPrefsRepository) {
        this.iFetchJarak = iFetchJarak;
        this.jarakResponseToJarak = jarakResponseToJarak;
        this.sharedPrefsRepository = sharedPrefsRepository;
    }

    public Observable<Jarak> getJarak() {
        String id = sharedPrefsRepository.getKendaraanFromPrefs().getKnd_id();
        return iFetchJarak.fetchJarak(id)
                .toObservable()
                .map(jarakResponseToJarak::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
