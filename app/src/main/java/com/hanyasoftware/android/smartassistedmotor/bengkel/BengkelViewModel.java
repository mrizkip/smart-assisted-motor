package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.BengkelToBengkelAdapter;

import java.util.List;

import javax.inject.Inject;

public class BengkelViewModel extends ViewModel {
    private static final String TAG = "BengkelViewModel";

    private final BengkelRepository bengkelRepository;
    private final BengkelToBengkelAdapter bengkelToBengkelAdapter;
    private MutableLiveData<List<BengkelAdapter>> listBengkel;

    public BengkelViewModel(BengkelRepository bengkelRepository, BengkelToBengkelAdapter bengkelToBengkelAdapter) {
        this.bengkelRepository = bengkelRepository;
        this.bengkelToBengkelAdapter = bengkelToBengkelAdapter;
        listBengkel = new MutableLiveData<>();
    }

    public LiveData<List<BengkelAdapter>> getBengkelList(String latitude, String longitude) {
        bengkelRepository.fetchBengkel(latitude, longitude)
                .subscribe(bengkels -> {
                    listBengkel.postValue(bengkelToBengkelAdapter.transform(bengkels));
                }, throwable -> {
                    Log.e(TAG, "fetchBengkel: Error");
                });
        return listBengkel;
    }

    public static class BengkelViewModelFactory implements ViewModelProvider.Factory {
        private final BengkelRepository bengkelRepository;
        private final BengkelToBengkelAdapter bengkelToBengkelAdapter;

        @Inject
        public BengkelViewModelFactory(BengkelRepository bengkelRepository, BengkelToBengkelAdapter bengkelToBengkelAdapter) {
            this.bengkelRepository = bengkelRepository;
            this.bengkelToBengkelAdapter = bengkelToBengkelAdapter;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new BengkelViewModel(bengkelRepository, bengkelToBengkelAdapter);
        }
    }
}
