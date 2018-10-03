package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.UserApi;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.User;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class UserApiToUser extends BaseLayerDataTransformer<UserApi, User> {

    @Inject
    public UserApiToUser() {
    }

    @Override
    public User transform(UserApi from) {
        User user = new User();
        user.setUsr_id(from.getUsr_id());
        user.setUsr_name(from.getUsr_name());
        user.setUsr_username(from.getUsr_username());
        user.setUsr_password(from.getUsr_password());
        user.setUsr_level(from.getUsr_level());
        return user;
    }
}
