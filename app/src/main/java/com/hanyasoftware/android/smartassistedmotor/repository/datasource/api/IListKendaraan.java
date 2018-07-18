package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.KendaraanApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IListKendaraan {

    @GET("api/listkendaraan/{userId}")
    Single<List<KendaraanApi>> getListKendaraan(@Path("userId") String userId);

    @GET("api/getkendaraan/{kendaraanId}")
    Single<KendaraanApi> getKendaraan(@Path("kendaraanId") String kendaraanId);
}
