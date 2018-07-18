package com.hanyasoftware.android.smartassistedmotor.repository.entity.local;

public class Diagnosa {

    private String no;
    private String perawatan;
    private String keterrangan;
    private int biaya;

    public Diagnosa() {
    }

    public Diagnosa(String no, String perawatan, String keterrangan, int biaya) {
        this.no = no;
        this.perawatan = perawatan;
        this.keterrangan = keterrangan;
        this.biaya = biaya;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPerawatan() {
        return perawatan;
    }

    public void setPerawatan(String perawatan) {
        this.perawatan = perawatan;
    }

    public String getKeterrangan() {
        return keterrangan;
    }

    public void setKeterrangan(String keterrangan) {
        this.keterrangan = keterrangan;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
}
