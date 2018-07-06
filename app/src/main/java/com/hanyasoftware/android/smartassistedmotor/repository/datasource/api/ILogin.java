package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ILogin {

    @FormUrlEncoded
    @POST("api/login")
    Single<LoginResponse> loginUser(@Field("username") String username, @Field("password") String password);
}
