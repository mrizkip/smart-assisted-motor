package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.DiagnosaResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDiagnosa {

    @GET("api/diagnosa/{kendaraanId}")
    Single<DiagnosaResponse> getDiagnosa(@Path("kendaraanId") String kendaraanId);
}
