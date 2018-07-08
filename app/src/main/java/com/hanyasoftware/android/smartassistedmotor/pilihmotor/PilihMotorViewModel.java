package com.hanyasoftware.android.smartassistedmotor.pilihmotor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.KendaraanRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class PilihMotorViewModel extends ViewModel {

    private final KendaraanRepository kendaraanRepository;
    private MutableLiveData<List<Kendaraan>> listKendaraanLiveData;
    private final CompositeDisposable compositeDisposable;

    public PilihMotorViewModel(KendaraanRepository kendaraanRepository) {
        this.kendaraanRepository = kendaraanRepository;
        this.listKendaraanLiveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();

        listKendaraan();
    }

    private void listKendaraan() {
        Disposable disposable = kendaraanRepository.getListKendaraan()
                .subscribe(listKendaraanLiveData::postValue, throwable -> listKendaraanLiveData.postValue(null));
        compositeDisposable.add(disposable);
    }

    public LiveData<List<Kendaraan>> getListKendaraan() {
        return listKendaraanLiveData;
    }

    public static class PilihMotorViewModelFactory implements ViewModelProvider.Factory {

        private final KendaraanRepository kendaraanRepository;

        @Inject
        public PilihMotorViewModelFactory(KendaraanRepository kendaraanRepository) {
            this.kendaraanRepository = kendaraanRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new PilihMotorViewModel(kendaraanRepository);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
