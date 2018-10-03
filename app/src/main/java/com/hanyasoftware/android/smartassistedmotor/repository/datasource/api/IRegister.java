package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.RegisterResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRegister {

    @FormUrlEncoded
    @POST("api/register")
    Single<RegisterResponse> registerUser(@Field("name") String nama, @Field("username") String username, @Field("password") String password);
}
