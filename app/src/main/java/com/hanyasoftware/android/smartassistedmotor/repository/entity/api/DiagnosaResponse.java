package com.hanyasoftware.android.smartassistedmotor.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiagnosaResponse {


    @Expose
    @SerializedName("diagnosa")
    private String diagnosa;
    @Expose
    @SerializedName("ind")
    private int ind;

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }
}
