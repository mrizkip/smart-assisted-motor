package com.hanyasoftware.android.smartassistedmotor.pengaturan;

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

public class TambahKendaraanViewModel extends ViewModel {

    private final KendaraanRepository kendaraanRepository;
    private MutableLiveData<Integer> responseLiveData;

    private final CompositeDisposable compositeDisposable;

    public TambahKendaraanViewModel(KendaraanRepository kendaraanRepository) {
        this.kendaraanRepository = kendaraanRepository;
        this.responseLiveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    public LiveData<Integer> tambahKendaraan(Kendaraan kendaraan) {
        Disposable disposable = kendaraanRepository.tambahKendaraan(kendaraan)
                .subscribe(tambahKendaraanResponse -> responseLiveData.postValue(tambahKendaraanResponse.getInd()),
                        throwable -> responseLiveData.postValue(0));
        compositeDisposable.add(disposable);
        return responseLiveData;
    }

    public static class TambahKendaraanViewModelFactory implements ViewModelProvider.Factory {

        private final KendaraanRepository kendaraanRepository;

        @Inject
        public TambahKendaraanViewModelFactory(KendaraanRepository kendaraanRepository) {
            this.kendaraanRepository = kendaraanRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new TambahKendaraanViewModel(kendaraanRepository);
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
