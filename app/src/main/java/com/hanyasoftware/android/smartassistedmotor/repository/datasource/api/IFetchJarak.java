package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.JarakResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IFetchJarak {

    @GET("apijarak/jarak_byid")
    Single<JarakResponse> fetchJarak(@Query("data1") String id);
}
