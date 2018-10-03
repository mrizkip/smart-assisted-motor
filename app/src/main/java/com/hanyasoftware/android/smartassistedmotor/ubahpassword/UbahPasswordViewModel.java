package com.hanyasoftware.android.smartassistedmotor.ubahpassword;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.UbahPasswordResponse;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class UbahPasswordViewModel extends ViewModel {

    private final UserRepository userRepository;
    private MutableLiveData<UbahPasswordResponse> liveData;
    private final CompositeDisposable compositeDisposable;
    private final SharedPrefsRepository sharedPrefsRepository;

    public UbahPasswordViewModel(UserRepository userRepository, SharedPrefsRepository sharedPrefsRepository) {
        this.userRepository = userRepository;
        this.sharedPrefsRepository = sharedPrefsRepository;
        this.liveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    public LiveData<UbahPasswordResponse> ubahPassword(String password) {
        String idUser = sharedPrefsRepository.getUserFromPrefs().getUsr_id();
        Disposable disposable = userRepository.ubahPassword(idUser, password)
                .subscribe(this.liveData::postValue, throwable -> {
                    UbahPasswordResponse response = new UbahPasswordResponse();
                    response.setInd(0);
                    this.liveData.postValue(response);
                });
        compositeDisposable.add(disposable);
        return liveData;
    }

    public static class UbahPasswordViewModelFactory implements ViewModelProvider.Factory {

        private final UserRepository userRepository;
        private final SharedPrefsRepository sharedPrefsRepository;

        @Inject
        public UbahPasswordViewModelFactory(UserRepository userRepository, SharedPrefsRepository sharedPrefsRepository) {
            this.userRepository = userRepository;
            this.sharedPrefsRepository = sharedPrefsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new UbahPasswordViewModel(userRepository, sharedPrefsRepository);
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
