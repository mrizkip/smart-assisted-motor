package com.hanyasoftware.android.smartassistedmotor.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServisApi {

    @Expose
    @SerializedName("rws_knd_id")
    private String rws_knd_id;
    @Expose
    @SerializedName("rws_keterangan")
    private String rws_keterangan;
    @Expose
    @SerializedName("rws_tanggal")
    private String rws_tanggal;
    @Expose
    @SerializedName("rws_id")
    private String rws_id;

    public String getRws_knd_id() {
        return rws_knd_id;
    }

    public void setRws_knd_id(String rws_knd_id) {
        this.rws_knd_id = rws_knd_id;
    }

    public String getRws_keterangan() {
        return rws_keterangan;
    }

    public void setRws_keterangan(String rws_keterangan) {
        this.rws_keterangan = rws_keterangan;
    }

    public String getRws_tanggal() {
        return rws_tanggal;
    }

    public void setRws_tanggal(String rws_tanggal) {
        this.rws_tanggal = rws_tanggal;
    }

    public String getRws_id() {
        return rws_id;
    }

    public void setRws_id(String rws_id) {
        this.rws_id = rws_id;
    }
}
