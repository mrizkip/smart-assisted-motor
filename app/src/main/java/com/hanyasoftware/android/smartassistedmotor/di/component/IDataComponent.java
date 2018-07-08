package com.hanyasoftware.android.smartassistedmotor.di.component;

import com.hanyasoftware.android.smartassistedmotor.bengkel.BengkelViewModel;
import com.hanyasoftware.android.smartassistedmotor.di.module.DataModule;
import com.hanyasoftware.android.smartassistedmotor.login.LoginViewModel;
import com.hanyasoftware.android.smartassistedmotor.main.MainViewModel;
import com.hanyasoftware.android.smartassistedmotor.pengaturan.TambahKendaraanViewModel;
import com.hanyasoftware.android.smartassistedmotor.pilihmotor.PilihMotorViewModel;
import com.hanyasoftware.android.smartassistedmotor.register.RegisterViewModel;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.JarakRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.KendaraanRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.ServisRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;
import com.hanyasoftware.android.smartassistedmotor.riwayat.TambahRiwayatServisViewModel;
import com.hanyasoftware.android.smartassistedmotor.ubahpassword.UbahPasswordViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataModule.class})
public interface IDataComponent {

    JarakRepository getJarakRepository();

    MainViewModel.MainViewModelFactory getMainViewModelFactory();

    BengkelRepository getBengkelRepository();

    BengkelViewModel.BengkelViewModelFactory getBengkelViewModelFactory();

    SharedPrefsRepository getSharedPrefsRepository();

    UserRepository getUserRepository();

    LoginViewModel.LoginViewModelFactory getLoginViewModelFactory();

    RegisterViewModel.RegisterViewModelFactory getRegisterViewModelFactory();

    KendaraanRepository getKendaraanRepository();

    TambahKendaraanViewModel.TambahKendaraanViewModelFactory getTambahKendaraanViewModelFactory();

    ServisRepository getServisRepository();

    PilihMotorViewModel.PilihMotorViewModelFactory getPilihMotorViewModelFactory();

    UbahPasswordViewModel.UbahPasswordViewModelFactory getUbahPasswordViewModelFactory();

    TambahRiwayatServisViewModel.TambahRiwayatServisViewModelFactory getTambahRiwayatServisViewModelFactory();

}
