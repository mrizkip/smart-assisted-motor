package com.hanyasoftware.android.smartassistedmotor.guest;

public class MapKeyPerawatan {

    private String motor;
    private String kilometer;

    public MapKeyPerawatan() {
    }

    public MapKeyPerawatan(String motor, String kilometer) {
        this.motor = motor;
        this.kilometer = kilometer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyPerawatan that = (MapKeyPerawatan) o;

        if (motor != null ? !motor.equals(that.motor) : that.motor != null) return false;
        return kilometer != null ? kilometer.equals(that.kilometer) : that.kilometer == null;
    }

    @Override
    public int hashCode() {
        int result = motor != null ? motor.hashCode() : 0;
        result = 31 * result + (kilometer != null ? kilometer.hashCode() : 0);
        return result;
    }
}
