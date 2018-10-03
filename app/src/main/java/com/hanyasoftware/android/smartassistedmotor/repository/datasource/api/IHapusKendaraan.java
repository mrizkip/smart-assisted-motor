package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.HapusKendaraanResponse;

import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface IHapusKendaraan {

    @DELETE("api/delkendaraan/{kendaraanId}")
    Single<HapusKendaraanResponse> hapusKendaraan(@Path("kendaraanId") String kendaraanId);
}
