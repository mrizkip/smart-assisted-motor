package com.hanyasoftware.android.smartassistedmotor.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IDiagnosa;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchBengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IFetchJarak;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IHapusKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IHapusServis;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IListKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IListServis;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ILogin;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IRegister;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ITambahKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ITambahServis;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IUbahKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IUbahPassword;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.DiagnosaRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.JarakRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.KendaraanRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.ServisRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.BengkelResponseToBengkel;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.JarakResponseToJarak;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.KendaraanApiToKendaraan;

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
    public JarakRepository provideJarakRepository(IFetchJarak iFetchJarak, JarakResponseToJarak jarakResponseToJarak, SharedPrefsRepository sharedPrefsRepository) {
        return new JarakRepository(iFetchJarak, jarakResponseToJarak, sharedPrefsRepository);
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
    public UserRepository provideUserRepository(ILogin iLogin, IRegister iRegister, IUbahPassword iUbahPassword) {
        return new UserRepository(iLogin, iRegister, iUbahPassword);
    }

    @Provides
    public ITambahKendaraan provideITambahKendaraan(Retrofit retrofit) {
        return retrofit.create(ITambahKendaraan.class);
    }

    @Provides
    @Singleton
    public KendaraanRepository provideKendaraanRepository(ITambahKendaraan iTambahKendaraan, IListKendaraan iListKendaraan,
                                                          SharedPrefsRepository sharedPrefsRepository, KendaraanApiToKendaraan kendaraanApiToKendaraan,
                                                          IUbahKendaraan iUbahKendaraan, IHapusKendaraan iHapusKendaraan) {
        return new KendaraanRepository(iTambahKendaraan, iListKendaraan,
                sharedPrefsRepository, kendaraanApiToKendaraan,
                iUbahKendaraan, iHapusKendaraan);
    }

    @Provides
    public IUbahPassword provideIUbahPassword(Retrofit retrofit) {
        return retrofit.create(IUbahPassword.class);
    }

    @Provides
    public IListKendaraan provideIListKendaraan(Retrofit retrofit) {
        return retrofit.create(IListKendaraan.class);
    }

    @Provides
    public IUbahKendaraan provideIUbahKendaraan(Retrofit retrofit) {
        return  retrofit.create(IUbahKendaraan.class);
    }

    @Provides
    public IHapusKendaraan provideIHapusKendaraan(Retrofit retrofit) {
        return retrofit.create(IHapusKendaraan.class);
    }

    @Provides
    public ITambahServis provideITambahServis(Retrofit retrofit) {
        return retrofit.create(ITambahServis.class);
    }

    @Provides
    public IListServis provideIListServis(Retrofit retrofit) {
        return retrofit.create(IListServis.class);
    }

    @Provides
    public IHapusServis provideIHapusServis(Retrofit retrofit) {
        return retrofit.create(IHapusServis.class);
    }

    @Provides
    public ServisRepository provideServisRepository(ITambahServis iTambahServis, IListServis iListServis, IHapusServis iHapusServis) {
        return new ServisRepository(iTambahServis, iListServis, iHapusServis);
    }

    @Provides
    public IDiagnosa provideIDiagnosa(Retrofit retrofit) {
        return retrofit.create(IDiagnosa.class);
    }

    @Provides
    public DiagnosaRepository provideDiagnosaRepository(IDiagnosa iDiagnosa, SharedPrefsRepository sharedPrefsRepository) {
        return new DiagnosaRepository(iDiagnosa, sharedPrefsRepository);
    }

}
