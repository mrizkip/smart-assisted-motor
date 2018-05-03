package com.hanyasoftware.android.smartassistedmotor.guest;

import java.util.ArrayList;
import java.util.List;

public class PerawatanMotor {

    private String motor;
    private String kilometer;
    private List<DetailGuestAdapter> perawatanAdapters;

    public PerawatanMotor() {
        perawatanAdapters = new ArrayList<>();
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public List<DetailGuestAdapter> getPerawatanAdapters() {
        return perawatanAdapters;
    }

    public void setPerawatanAdapters(List<DetailGuestAdapter> perawatanAdapters) {
        this.perawatanAdapters = perawatanAdapters;
    }
}
