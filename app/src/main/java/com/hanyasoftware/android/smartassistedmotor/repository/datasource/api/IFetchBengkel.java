package com.hanyasoftware.android.smartassistedmotor.repository.datasource.api;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.BengkelResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Bengkel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IFetchBengkel {

    @FormUrlEncoded
    @POST("api/listbengkelwithradius")
    Single<List<BengkelResponse>> fetchBengkelBukaWithRadius(@Field("lat") String latitude,
                                                             @Field("long") String longitude,
                                                             @Field("radius") String radius);

}
