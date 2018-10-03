package com.hanyasoftware.android.smartassistedmotor.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @Expose
    @SerializedName("result")
    private UserApi result;
    @Expose
    @SerializedName("valid")
    private boolean valid;

    public UserApi getUserApi() {
        return result;
    }

    public void setUserApi(UserApi result) {
        this.result = result;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
