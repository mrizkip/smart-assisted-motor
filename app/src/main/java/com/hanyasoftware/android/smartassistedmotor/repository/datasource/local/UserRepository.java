package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.ILogin;
import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IRegister;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.LoginResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.RegisterResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private final ILogin iLogin;
    private final IRegister iRegister;

    @Inject
    public UserRepository(ILogin iLogin, IRegister iRegister) {
        this.iLogin = iLogin;
        this.iRegister = iRegister;
    }

    public Observable<LoginResponse> loginUser(String username, String password) {
        return iLogin.loginUser(username, password)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<RegisterResponse> registerUser(String nama, String username, String password) {
        return iRegister.registerUser(nama, username, password)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
