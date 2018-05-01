package com.hanyasoftware.android.smartassistedmotor;

import android.app.Application;

import com.hanyasoftware.android.smartassistedmotor.di.component.DaggerIAppComponent;
import com.hanyasoftware.android.smartassistedmotor.di.component.DaggerIDataComponent;
import com.hanyasoftware.android.smartassistedmotor.di.component.DaggerIMapperComponent;
import com.hanyasoftware.android.smartassistedmotor.di.component.IAppComponent;
import com.hanyasoftware.android.smartassistedmotor.di.component.IDataComponent;
import com.hanyasoftware.android.smartassistedmotor.di.component.IMapperComponent;
import com.hanyasoftware.android.smartassistedmotor.di.module.AppModule;
import com.hanyasoftware.android.smartassistedmotor.di.module.DataModule;

public class SAMApplication extends Application {

    private static IAppComponent applicationComponent;
    private static IDataComponent dataComponent;
    private static IMapperComponent mapperComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        dataComponent = DaggerIDataComponent.builder()
                .dataModule(new DataModule("http://sambengkel.com/"))
                .build();

        mapperComponent = DaggerIMapperComponent.create();

    }

    public static IAppComponent getApplicationComponent() {return applicationComponent;}
    public static IDataComponent getDataComponent() { return dataComponent; }
    public static IMapperComponent getMapperComponent() { return mapperComponent; }
}
