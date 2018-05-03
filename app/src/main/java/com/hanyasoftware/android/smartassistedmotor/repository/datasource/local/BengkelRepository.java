package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchBengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Bengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.BengkelResponseToBengkel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BengkelRepository {

    private final IFetchBengkel iFetchBengkel;
    private final BengkelResponseToBengkel bengkelResponseToBengkel;

    @Inject
    public BengkelRepository(IFetchBengkel iFetchBengkel, BengkelResponseToBengkel bengkelResponseToBengkel) {
        this.iFetchBengkel = iFetchBengkel;
        this.bengkelResponseToBengkel = bengkelResponseToBengkel;
    }

    public Observable<List<Bengkel>> fetchBengkel() {
        String latitude = "";
        String longitude = "";
        String radius = "3";
        return iFetchBengkel.fetchBengkelBukaWithRadius(latitude, longitude, radius)
                .toObservable()
                .map(bengkelResponseToBengkel::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
