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

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {

    private final JarakRepository jarakRepository;
    private MutableLiveData<Jarak> jarak;
    private final CompositeDisposable compositeDisposable;

    public MainViewModel(JarakRepository jarakRepository) {
        this.jarakRepository = jarakRepository;
        jarak = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();

        fetchJarak();
    }

    private void fetchJarak() {
        Disposable disposable = jarakRepository.getJarak()
                .subscribe(this.jarak::postValue, throwable -> {
                    this.jarak.postValue(null);
                    throwable.printStackTrace();
                });
        compositeDisposable.add(disposable);
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

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
