package com.hanyasoftware.android.smartassistedmotor.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KendaraanApi {

    @Expose
    @SerializedName("knd_usr_id")
    private String knd_usr_id;
    @Expose
    @SerializedName("knd_ukuranban")
    private String knd_ukuranban;
    @Expose
    @SerializedName("knd_lcmesin")
    private String knd_lcmesin;
    @Expose
    @SerializedName("knd_tahun")
    private String knd_tahun;
    @Expose
    @SerializedName("knd_tipe")
    private String knd_tipe;
    @Expose
    @SerializedName("knd_pemilik")
    private String knd_pemilik;
    @Expose
    @SerializedName("knd_nopol")
    private String knd_nopol;
    @Expose
    @SerializedName("knd_id")
    private String knd_id;

    public String getKnd_usr_id() {
        return knd_usr_id;
    }

    public void setKnd_usr_id(String knd_usr_id) {
        this.knd_usr_id = knd_usr_id;
    }

    public String getKnd_ukuranban() {
        return knd_ukuranban;
    }

    public void setKnd_ukuranban(String knd_ukuranban) {
        this.knd_ukuranban = knd_ukuranban;
    }

    public String getKnd_lcmesin() {
        return knd_lcmesin;
    }

    public void setKnd_lcmesin(String knd_lcmesin) {
        this.knd_lcmesin = knd_lcmesin;
    }

    public String getKnd_tahun() {
        return knd_tahun;
    }

    public void setKnd_tahun(String knd_tahun) {
        this.knd_tahun = knd_tahun;
    }

    public String getKnd_tipe() {
        return knd_tipe;
    }

    public void setKnd_tipe(String knd_tipe) {
        this.knd_tipe = knd_tipe;
    }

    public String getKnd_pemilik() {
        return knd_pemilik;
    }

    public void setKnd_pemilik(String knd_pemilik) {
        this.knd_pemilik = knd_pemilik;
    }

    public String getKnd_nopol() {
        return knd_nopol;
    }

    public void setKnd_nopol(String knd_nopol) {
        this.knd_nopol = knd_nopol;
    }

    public String getKnd_id() {
        return knd_id;
    }

    public void setKnd_id(String knd_id) {
        this.knd_id = knd_id;
    }
}
