package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.HapusServisResponse;

import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface IHapusServis {

    @DELETE("api/delservis/{idServis}")
    Single<HapusServisResponse> hapusServis(@Path("idServis") String idServis);
}
