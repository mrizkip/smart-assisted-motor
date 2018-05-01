package com.hanyasoftware.android.smartassistedmotor.di.component;

import android.content.Context;

import com.hanyasoftware.android.smartassistedmotor.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface IAppComponent {

    Context getApplicationContext();
}
