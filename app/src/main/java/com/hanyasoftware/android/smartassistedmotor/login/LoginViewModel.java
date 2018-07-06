package com.hanyasoftware.android.smartassistedmotor.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.SharedPrefsRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.UserRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.UserApiToUser;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";

    private final UserRepository userRepository;
    private final SharedPrefsRepository sharedPrefsRepository;
    private final UserApiToUser userApiToUser;
    private MutableLiveData<Boolean> loginStatus;

    private final CompositeDisposable compositeDisposable;

    public LoginViewModel(UserRepository userRepository, SharedPrefsRepository sharedPrefsRepository, UserApiToUser userApiToUser) {
        this.userRepository = userRepository;
        this.sharedPrefsRepository = sharedPrefsRepository;
        this.userApiToUser = userApiToUser;
        this.compositeDisposable = new CompositeDisposable();
        loginStatus = new MutableLiveData<>();
    }

    public LiveData<Boolean> login(String username, String psasword) {
        Disposable disposable = userRepository.loginUser(username, psasword)
                .subscribe(loginResponse -> {
                    if (loginResponse.getValid()) {
                        loginStatus.postValue(loginResponse.getValid());
                        sharedPrefsRepository.saveUserToPrefs(userApiToUser.transform(loginResponse.getUserApi()));
                    } else {
                        loginStatus.postValue(loginResponse.getValid());
                    }
                }, throwable -> loginStatus.postValue(false));
        compositeDisposable.add(disposable);
        return loginStatus;
    }

    public static class LoginViewModelFactory implements ViewModelProvider.Factory {

        private final UserRepository userRepository;
        private final SharedPrefsRepository sharedPrefsRepository;
        private final UserApiToUser userApiToUser;

        @Inject
        public LoginViewModelFactory(UserRepository userRepository, SharedPrefsRepository sharedPrefsRepository, UserApiToUser userApiToUser) {
            this.userRepository = userRepository;
            this.sharedPrefsRepository = sharedPrefsRepository;
            this.userApiToUser = userApiToUser;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new LoginViewModel(userRepository, sharedPrefsRepository, userApiToUser);
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
