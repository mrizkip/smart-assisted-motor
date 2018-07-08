package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahServisResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TambahServis {

    @FormUrlEncoded
    @POST("api/saveservis")
    Single<TambahServisResponse> tambahServis(@Field("idkendaraan") String idKendaraan,
                                              @Field("tanggal") String tanggalServis,
                                              @Field("keterangan") String keterangan);
}
