package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.ServisApi;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IListServis {

    @GET("api/listservis/{kendaraanId}")
    Single<List<ServisApi>> getListServis(@Path("kendaraanId") String kendaraanId);
}
