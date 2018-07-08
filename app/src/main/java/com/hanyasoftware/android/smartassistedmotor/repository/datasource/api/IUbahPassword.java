package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.UbahPasswordResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IUbahPassword {

    @FormUrlEncoded
    @POST("api/chpass")
    Single<UbahPasswordResponse> ubahPassword(@Field("iduser") String idUser, @Field("password") String password);
}
