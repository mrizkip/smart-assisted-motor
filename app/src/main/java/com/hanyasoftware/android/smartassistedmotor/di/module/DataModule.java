package com.hanyasoftware.android.smartassistedmotor.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hanyasoftware.android.smartassistedmotor.login.LoginViewModel;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchBengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchJarak;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ILogin;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IRegister;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.JarakRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.BengkelResponseToBengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.JarakResponseToJarak;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private final String baseUrl;

    public DataModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                                    RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                    OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public IFetchJarak provideIFetchJarak(Retrofit retrofit) {
        return retrofit.create(IFetchJarak.class);
    }

    @Provides
    @Singleton
    public JarakRepository provideJarakRepository(IFetchJarak iFetchJarak, JarakResponseToJarak jarakResponseToJarak) {
        return new JarakRepository(iFetchJarak, jarakResponseToJarak);
    }

    @Provides
    @Singleton
    public IFetchBengkel provideIFetchBengkel(Retrofit retrofit) {
        return retrofit.create(IFetchBengkel.class);
    }

    @Provides
    @Singleton
    public BengkelRepository provideBengkelRepository(IFetchBengkel iFetchBengkel, BengkelResponseToBengkel bengkelResponseToBengkel) {
        return new BengkelRepository(iFetchBengkel, bengkelResponseToBengkel);
    }

    @Provides
    @Singleton
    public SharedPrefsRepository provideSharedPrefsRepository() {
        return new SharedPrefsRepository();
    }

    @Provides
    public ILogin provideILogin(Retrofit retrofit) {
        return retrofit.create(ILogin.class);
    }

    @Provides
    public IRegister provideIRegister(Retrofit retrofit) {
        return retrofit.create(IRegister.class);
    }

    @Provides
    public UserRepository provideUserRepository(ILogin iLogin, IRegister iRegister) {
        return new UserRepository(iLogin, iRegister);
    }
}
