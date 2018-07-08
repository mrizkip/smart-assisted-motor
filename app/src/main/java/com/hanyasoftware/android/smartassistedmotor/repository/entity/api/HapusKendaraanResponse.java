package com.hanyasoftware.android.smartassistedmotor.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HapusKendaraanResponse {

    @Expose
    @SerializedName("ind")
    private int ind;

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }
}
