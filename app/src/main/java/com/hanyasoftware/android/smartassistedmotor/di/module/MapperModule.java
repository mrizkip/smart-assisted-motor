package com.hanyasoftware.android.smartassistedmotor.di.module;

import com.hanyasoftware.android.smartassistedmotor.repository.transformer.JarakResponseToJarak;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.KendaraanApiToKendaraan;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.KendaraanToMotorAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    @Singleton
    public JarakResponseToJarak provideJarakResponseToJarak() {
        return new JarakResponseToJarak();
    }

    @Provides
    @Singleton
    public KendaraanApiToKendaraan provideKendaraanApiToKendaraan() {
        return new KendaraanApiToKendaraan();
    }

    @Provides
    @Singleton
    public KendaraanToMotorAdapter provideKendaraanToMotorAdapter() {
        return new KendaraanToMotorAdapter();
    }
}
