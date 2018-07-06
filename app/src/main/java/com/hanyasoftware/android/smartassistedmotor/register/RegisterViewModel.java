package com.hanyasoftware.android.smartassistedmotor.register;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RegisterViewModel extends ViewModel {

    private final UserRepository userRepository;
    private MutableLiveData<Integer> liveData;

    private CompositeDisposable compositeDisposable;

    public RegisterViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.liveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    public LiveData<Integer> registerUser(String nama, String username, String password) {
        Disposable disposable = userRepository.registerUser(nama, username, password)
                .subscribe(registerResponse -> {
                    liveData.postValue(registerResponse.getInd());
                }, throwable -> {
                    liveData.postValue(0);
                });
        compositeDisposable.add(disposable);
        return liveData;
    }

    public static class RegisterViewModelFactory implements ViewModelProvider.Factory {

        private final UserRepository userRepository;

        @Inject
        public RegisterViewModelFactory(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new RegisterViewModel(userRepository);
        }
    }
}
