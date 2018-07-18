package com.hanyasoftware.android.smartassistedmotor.motor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.KendaraanRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Kendaraan;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MotorViewModel extends ViewModel {

    private final KendaraanRepository kendaraanRepository;
    private MutableLiveData<Kendaraan> kendaraanLiveData;
    private final CompositeDisposable compositeDisposable;

    public MotorViewModel(KendaraanRepository kendaraanRepository) {
        this.kendaraanRepository = kendaraanRepository;
        this.kendaraanLiveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
        fetchKendaraan();
    }

    private void fetchKendaraan() {
        Disposable disposable = kendaraanRepository.getKendaraan().subscribe(kendaraanLiveData::postValue,
                throwable -> kendaraanLiveData.postValue(null));

        compositeDisposable.add(disposable);
    }

    public LiveData<Kendaraan> getKendaraan() {
        return kendaraanLiveData;
    }

    public static class MotorViewModelFactory implements ViewModelProvider.Factory {

        private final KendaraanRepository kendaraanRepository;

        @Inject
        public MotorViewModelFactory(KendaraanRepository kendaraanRepository) {
            this.kendaraanRepository = kendaraanRepository;
        }


        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MotorViewModel(kendaraanRepository);
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
