package com.hanyasoftware.android.smartassistedmotor.repository.entity.local;

/**
 * Created by mrizk on 28/03/2018.
 */

public class Motor {
    private int id;
    private String nopol;
    private String tipe;
    private String tahun;
    private String lcMesin;
    private String ukuranRoda;

    public Motor() {
    }

    public Motor(int id, String nopol, String tipe, String tahun, String lcMesin, String ukuranRoda) {
        this.id = id;
        this.nopol = nopol;
        this.tipe = tipe;
        this.tahun = tahun;
        this.lcMesin = lcMesin;
        this.ukuranRoda = ukuranRoda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getLcMesin() {
        return lcMesin;
    }

    public void setLcMesin(String lcMesin) {
        this.lcMesin = lcMesin;
    }

    public String getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(String ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }
}
