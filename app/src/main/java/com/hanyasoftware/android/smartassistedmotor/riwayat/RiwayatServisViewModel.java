package com.hanyasoftware.android.smartassistedmotor.riwayat;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.ServisRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.ServisApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.TambahServisResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RiwayatServisViewModel extends ViewModel {

    private final ServisRepository servisRepository;
    private final SharedPrefsRepository sharedPrefsRepository;
    private MutableLiveData<TambahServisResponse> tambahServisLiveData;
    private MutableLiveData<List<ServisApi>> listServisLiveData;
    private final CompositeDisposable compositeDisposable;

    public RiwayatServisViewModel(ServisRepository servisRepository, SharedPrefsRepository sharedPrefsRepository) {
        this.servisRepository = servisRepository;
        this.sharedPrefsRepository = sharedPrefsRepository;
        this.tambahServisLiveData = new MutableLiveData<>();
        this.listServisLiveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    public LiveData<TambahServisResponse> tambahRiwayatServis(String tanggal, String keterangan) {
        String idKendaraan = sharedPrefsRepository.getKendaraanFromPrefs().getKnd_id();
        Disposable disposable = servisRepository.tambahServis(idKendaraan, tanggal, keterangan)
                .subscribe(this.tambahServisLiveData::postValue, throwable -> {
                    TambahServisResponse response = new TambahServisResponse();
                    response.setInd(0);
                    this.tambahServisLiveData.postValue(response);
                });
        compositeDisposable.add(disposable);
        return tambahServisLiveData;
    }

    public LiveData<List<ServisApi>> getListServis() {
        String idKendaraan = sharedPrefsRepository.getKendaraanFromPrefs().getKnd_id();
        Disposable disposable = servisRepository.getListServis(idKendaraan)
                .subscribe(this.listServisLiveData::postValue, throwable -> {
                    this.listServisLiveData.postValue(null);
                });
        compositeDisposable.add(disposable);
        return listServisLiveData;
    }

    public static class RiwayatServisViewModelFactory implements ViewModelProvider.Factory {

        private final ServisRepository servisRepository;
        private final SharedPrefsRepository sharedPrefsRepository;

        @Inject
        public RiwayatServisViewModelFactory(ServisRepository servisRepository, SharedPrefsRepository sharedPrefsRepository) {
            this.servisRepository = servisRepository;
            this.sharedPrefsRepository = sharedPrefsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new RiwayatServisViewModel(servisRepository, sharedPrefsRepository);
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
