package com.hanyasoftware.android.smartassistedmotor.di.component;

import com.hanyasoftware.android.smartassistedmotor.bengkel.BengkelViewModel;
import com.hanyasoftware.android.smartassistedmotor.di.module.DataModule;
import com.hanyasoftware.android.smartassistedmotor.main.MainViewModel;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.JarakRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataModule.class})
public interface IDataComponent {

    JarakRepository getJarakRepository();

    MainViewModel.MainViewModelFactory getMainViewModelFactory();

    BengkelRepository getBengkelRepository();

    BengkelViewModel.BengkelViewModelFactory getBengkelViewModelFactory();

}
