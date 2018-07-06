package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ILogin;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private final ILogin iLogin;

    @Inject
    public UserRepository(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public Observable<LoginResponse> loginUser(String username, String password) {
        return iLogin.loginUser(username, password)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
