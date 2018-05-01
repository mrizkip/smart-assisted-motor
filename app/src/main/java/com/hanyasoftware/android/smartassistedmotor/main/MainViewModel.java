package com.hanyasoftware.android.smartassistedmotor.main;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.JarakRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Jarak;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    private final JarakRepository jarakRepository;
    private final MutableLiveData<Jarak> jarak;

    public MainViewModel(JarakRepository jarakRepository) {
        this.jarakRepository = jarakRepository;
        jarak = new MutableLiveData<>();

        fetchJarak();
    }

    @SuppressLint("CheckResult")
    private void fetchJarak() {
        jarakRepository.getJarak()
                .subscribe(this.jarak::postValue, throwable -> {
                    Log.e(TAG, "fetchJarak: Error");
                });
    }

    public LiveData<Jarak> getJarak() {
        return jarak;
    }

    public static class MainViewModelFactory implements ViewModelProvider.Factory {

        private final JarakRepository jarakRepository;

        @Inject
        public MainViewModelFactory(JarakRepository jarakRepository) {
            this.jarakRepository = jarakRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(jarakRepository);
        }
    }
}
