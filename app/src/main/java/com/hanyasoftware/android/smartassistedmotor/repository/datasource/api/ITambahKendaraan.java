package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.KendaraanApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahKendaraanResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ITambahKendaraan {

    @FormUrlEncoded
    @POST("api/registerkendaraan")
    Single<TambahKendaraanResponse> tambahKendaraan(@Field("iduser") String idUser, @Field("nopol") String nopol,
                                                    @Field("pemilik") String pemilik, @Field("tipe") String tipe,
                                                    @Field("tahun") String tahun, @Field("lcmesin") String lcmesin,
                                                    @Field("ukuranban") String ukuranban);
}
