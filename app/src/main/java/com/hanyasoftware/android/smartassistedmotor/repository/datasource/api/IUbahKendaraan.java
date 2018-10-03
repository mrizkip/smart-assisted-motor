package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.EditKendaraanResponse;

import io.reactivex.Single;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IUbahKendaraan {

    @FormUrlEncoded
    @POST("api/editkendaraan")
    Single<EditKendaraanResponse> editKendaraan(String idKendaraan, String nopol,
                                                String pemilik, String ukuranBan);
}
