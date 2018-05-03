package com.hanyasoftware.android.smartassistedmotor.guest;

import java.util.ArrayList;
import java.util.List;

public class TabelPerawatan {

    private List<PerawatanMotor> perawatanMotorList;

    public TabelPerawatan() {
        perawatanMotorList = new ArrayList<>();
        initTabelPerawatanCb150r();
    }

    private void initTabelPerawatanCb150r() {
        PerawatanMotor cb150r1km = new PerawatanMotor();
        cb150r1km.setMotor("CB 150R");
        cb150r1km.setKilometer("1.000 Km");

        DetailGuestAdapter perawatan1 = new DetailGuestAdapter();
        perawatan1.setPerawatan("Oli Mesin");
        perawatan1.setKeterangan("Ganti");
        DetailGuestAdapter perawatan2 = new DetailGuestAdapter();
        perawatan2.setPerawatan("Oli Mesin");
        perawatan2.setKeterangan("Ganti");
    }
}
