package com.hanyasoftware.android.smartassistedmotor.guest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabelVario125 {

    private final Map<MapKeyPerawatan, List<DetailGuestAdapter>> mapTableVario125 = new HashMap<>();
    private List<DetailGuestAdapter> perawatan1km;
    private List<DetailGuestAdapter> perawatan4km;
    private List<DetailGuestAdapter> perawatan8km;
    private List<DetailGuestAdapter> perawatan12km;
    private List<DetailGuestAdapter> perawatan16km;
    private List<DetailGuestAdapter> perawatan20km;
    private List<DetailGuestAdapter> perawatan24km;
    private List<DetailGuestAdapter> perawatan28km;
    private List<DetailGuestAdapter> perawatan32km;
    private List<DetailGuestAdapter> perawatan36km;
    private List<DetailGuestAdapter> perawatan40km;
    private List<DetailGuestAdapter> perawatan44km;
    private List<DetailGuestAdapter> perawatan48km;
    private List<DetailGuestAdapter> perawatan52km;

    public TabelVario125() {
        perawatan1km = new ArrayList<>();
        perawatan4km = new ArrayList<>();
        perawatan8km = new ArrayList<>();
        perawatan12km = new ArrayList<>();
        perawatan16km = new ArrayList<>();
        perawatan20km = new ArrayList<>();
        perawatan24km = new ArrayList<>();
        perawatan28km = new ArrayList<>();
        perawatan32km = new ArrayList<>();
        perawatan36km = new ArrayList<>();
        perawatan40km = new ArrayList<>();
        perawatan44km = new ArrayList<>();
        perawatan48km = new ArrayList<>();
        perawatan52km = new ArrayList<>();

        // init tabel
        initTablePerawatan();
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "1.000 Km"), perawatan1km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "4.000 Km"), perawatan4km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "8.000 Km"), perawatan8km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "12.000 Km"), perawatan12km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "16.000 Km"), perawatan16km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "20.000 Km"), perawatan20km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "24.000 Km"), perawatan24km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "28.000 Km"), perawatan28km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "32.000 Km"), perawatan32km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "36.000 Km"), perawatan36km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "40.000 Km"), perawatan40km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "44.000 Km"), perawatan44km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "48.000 Km"), perawatan48km);
        mapTableVario125.put(new MapKeyPerawatan("Vario 125", "52.000 Km"), perawatan52km);
    }

    public Map<MapKeyPerawatan, List<DetailGuestAdapter>> getMapTableVario125() {
        return mapTableVario125;
    }

    private void initTablePerawatan() {
        // DetailPerawatan
        DetailGuestAdapter saluranBahanBakar = new DetailGuestAdapter();
        saluranBahanBakar.setPerawatan("Saluran Bahan Bakar");
        saluranBahanBakar.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter saringanBahanBakar = new DetailGuestAdapter();
        saringanBahanBakar.setPerawatan("Saluran Bahan Bakar");
        saringanBahanBakar.setKeterangan("Ganti setiap 48.000 Km.");
        DetailGuestAdapter gasTangan = new DetailGuestAdapter();
        gasTangan.setPerawatan("Cara Kerja Gas Tangan");
        gasTangan.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter saringanUdara = new DetailGuestAdapter();
        saringanUdara.setPerawatan("Saringan Udara");
        saringanUdara.setKeterangan("Ganti.");
        DetailGuestAdapter bakMesin = new DetailGuestAdapter();
        bakMesin.setPerawatan("Pernapasan Bak Mesin");
        bakMesin.setKeterangan("Bersihkan.");
        DetailGuestAdapter busiPeriksa = new DetailGuestAdapter();
        busiPeriksa.setPerawatan("Busi");
        busiPeriksa.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter busiGanti = new DetailGuestAdapter();
        busiGanti.setPerawatan("Busi");
        busiGanti.setKeterangan("Ganti.");
        DetailGuestAdapter jarakKlep = new DetailGuestAdapter();
        jarakKlep.setPerawatan("Jarak Renggang Valve");
        jarakKlep.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter oliMesin = new DetailGuestAdapter();
        oliMesin.setPerawatan("Oli Mesin");
        oliMesin.setKeterangan("Ganti.");
        DetailGuestAdapter saringanOliMesin = new DetailGuestAdapter();
        saringanOliMesin.setPerawatan("Saringan Kasa Oli Mesin");
        saringanOliMesin.setKeterangan("Bersihkan.");
        DetailGuestAdapter putaranMesin = new DetailGuestAdapter();
        putaranMesin.setPerawatan("Putaran Stasioner Mesin");
        putaranMesin.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter cairanRadiatorPeriksa = new DetailGuestAdapter();
        cairanRadiatorPeriksa.setPerawatan("Cairan Pendingin Radiator");
        cairanRadiatorPeriksa.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter cairanRadiatorGanti = new DetailGuestAdapter();
        cairanRadiatorGanti.setPerawatan("Cairan Pendingin Radiator");
        cairanRadiatorGanti.setKeterangan("Ganti.");
        DetailGuestAdapter sistemPendingin = new DetailGuestAdapter();
        sistemPendingin.setPerawatan("Sistem Pendingin");
        sistemPendingin.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter driveBeltPeriksa = new DetailGuestAdapter();
        driveBeltPeriksa.setPerawatan("Drive Belt");
        driveBeltPeriksa.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu). Lumasi.");
        DetailGuestAdapter driveBeltGanti = new DetailGuestAdapter();
        driveBeltGanti.setPerawatan("Drive Belt");
        driveBeltGanti.setKeterangan("Ganti.");
        DetailGuestAdapter oliFinalDrive = new DetailGuestAdapter();
        oliFinalDrive.setPerawatan("Oli Final Drive (Transmisi)");
        oliFinalDrive.setKeterangan("Ganti.");
        DetailGuestAdapter minyakRem = new DetailGuestAdapter();
        minyakRem.setPerawatan("Minyak Rem");
        minyakRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter kampasRem = new DetailGuestAdapter();
        kampasRem.setPerawatan("Keausan Pads Rem");
        kampasRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter sistemRem = new DetailGuestAdapter();
        sistemRem.setPerawatan("Sistem Rem");
        sistemRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter switchLampuRem = new DetailGuestAdapter();
        switchLampuRem.setPerawatan("Switch Lampu Rem");
        switchLampuRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter sistemKopling = new DetailGuestAdapter();
        sistemKopling.setPerawatan("Keausan Kanvas Kopling");
        sistemKopling.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter standarSamping = new DetailGuestAdapter();
        standarSamping.setPerawatan("Standar Samping");
        standarSamping.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter suspensi = new DetailGuestAdapter();
        suspensi.setPerawatan("Suspensi");
        suspensi.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter murBautPengencang = new DetailGuestAdapter();
        murBautPengencang.setPerawatan("Mur, Baut, Pengencang");
        murBautPengencang.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter rodaBan = new DetailGuestAdapter();
        rodaBan.setPerawatan("Roda/Ban");
        rodaBan.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter bantalanKepalaKemudi = new DetailGuestAdapter();
        bantalanKepalaKemudi.setPerawatan("Bantalan Kepala Kemudi");
        bantalanKepalaKemudi.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");

        // add to per kilometer
        // 1.000 km
        perawatan1km.add(saluranBahanBakar);
        perawatan1km.add(gasTangan);
        perawatan1km.add(bakMesin);
        perawatan1km.add(busiPeriksa);
        perawatan1km.add(jarakKlep);
        perawatan1km.add(oliMesin);
        perawatan1km.add(putaranMesin);
        perawatan1km.add(sistemRem);
        perawatan1km.add(murBautPengencang);
        perawatan1km.add(bantalanKepalaKemudi);

        // 4.000 km
        perawatan4km.add(saluranBahanBakar);
        perawatan4km.add(gasTangan);
        perawatan4km.add(bakMesin);
        perawatan4km.add(busiGanti);
        perawatan4km.add(jarakKlep);
        perawatan4km.add(oliMesin);
        perawatan4km.add(putaranMesin);
        perawatan4km.add(sistemRem);
        perawatan4km.add(minyakRem);
        perawatan4km.add(kampasRem);
        perawatan4km.add(switchLampuRem);
        perawatan4km.add(standarSamping);
        perawatan4km.add(suspensi);
        perawatan4km.add(rodaBan);

        // 8.000 km
        perawatan8km.add(saluranBahanBakar);
        perawatan8km.add(gasTangan);
        perawatan8km.add(bakMesin);
        perawatan8km.add(busiPeriksa);
        perawatan8km.add(jarakKlep);
        perawatan8km.add(oliMesin);
        perawatan8km.add(putaranMesin);
        perawatan8km.add(sistemRem);
        perawatan8km.add(minyakRem);
        perawatan8km.add(kampasRem);
        perawatan8km.add(switchLampuRem);
        perawatan8km.add(standarSamping);
        perawatan8km.add(suspensi);
        perawatan8km.add(rodaBan);
        perawatan8km.add(saringanOliMesin);
        perawatan8km.add(cairanRadiatorPeriksa);
        perawatan8km.add(sistemPendingin);
        perawatan8km.add(driveBeltPeriksa);
        perawatan8km.add(oliFinalDrive);
        perawatan8km.add(sistemKopling);
        perawatan8km.add(murBautPengencang);

        // 12.000 km
        perawatan12km.add(saluranBahanBakar);
        perawatan12km.add(gasTangan);
        perawatan12km.add(bakMesin);
        perawatan12km.add(busiGanti);
        perawatan12km.add(jarakKlep);
        perawatan12km.add(oliMesin);
        perawatan12km.add(putaranMesin);
        perawatan12km.add(sistemRem);
        perawatan12km.add(minyakRem);
        perawatan12km.add(kampasRem);
        perawatan12km.add(switchLampuRem);
        perawatan12km.add(standarSamping);
        perawatan12km.add(suspensi);
        perawatan12km.add(rodaBan);
        perawatan12km.add(cairanRadiatorGanti);
        perawatan12km.add(sistemPendingin);
        perawatan12km.add(bantalanKepalaKemudi);

        // 16.000 km
        perawatan16km.add(saluranBahanBakar);
        perawatan16km.add(gasTangan);
        perawatan16km.add(saringanUdara);
        perawatan16km.add(bakMesin);
        perawatan16km.add(busiPeriksa);
        perawatan16km.add(jarakKlep);
        perawatan16km.add(oliMesin);
        perawatan16km.add(putaranMesin);
        perawatan16km.add(sistemRem);
        perawatan16km.add(minyakRem);
        perawatan16km.add(kampasRem);
        perawatan16km.add(switchLampuRem);
        perawatan16km.add(standarSamping);
        perawatan16km.add(suspensi);
        perawatan16km.add(rodaBan);
        perawatan16km.add(saringanOliMesin);
        perawatan16km.add(cairanRadiatorPeriksa);
        perawatan16km.add(sistemPendingin);
        perawatan16km.add(driveBeltPeriksa);
        perawatan16km.add(oliFinalDrive);
        perawatan16km.add(sistemKopling);
        perawatan16km.add(murBautPengencang);

        // 20.000 km
        perawatan20km.add(saluranBahanBakar);
        perawatan20km.add(gasTangan);
        perawatan20km.add(bakMesin);
        perawatan20km.add(busiGanti);
        perawatan20km.add(jarakKlep);
        perawatan20km.add(oliMesin);
        perawatan20km.add(putaranMesin);
        perawatan20km.add(sistemRem);
        perawatan20km.add(minyakRem);
        perawatan20km.add(kampasRem);
        perawatan20km.add(switchLampuRem);
        perawatan20km.add(standarSamping);
        perawatan20km.add(suspensi);
        perawatan20km.add(rodaBan);
        perawatan20km.add(sistemPendingin);

        // 24.000 km
        perawatan24km.add(saluranBahanBakar);
        perawatan24km.add(gasTangan);
        perawatan24km.add(bakMesin);
        perawatan24km.add(busiPeriksa);
        perawatan24km.add(jarakKlep);
        perawatan24km.add(oliMesin);
        perawatan24km.add(putaranMesin);
        perawatan24km.add(sistemRem);
        perawatan24km.add(minyakRem);
        perawatan24km.add(kampasRem);
        perawatan24km.add(switchLampuRem);
        perawatan24km.add(standarSamping);
        perawatan24km.add(suspensi);
        perawatan24km.add(rodaBan);
        perawatan24km.add(saringanOliMesin);
        perawatan24km.add(cairanRadiatorGanti);
        perawatan24km.add(sistemPendingin);
        perawatan24km.add(driveBeltGanti);
        perawatan24km.add(oliFinalDrive);
        perawatan24km.add(sistemKopling);
        perawatan24km.add(murBautPengencang);
        perawatan24km.add(bantalanKepalaKemudi);

        // 28.000 km
        perawatan28km.add(saluranBahanBakar);
        perawatan28km.add(gasTangan);
        perawatan28km.add(bakMesin);
        perawatan28km.add(busiGanti);
        perawatan28km.add(jarakKlep);
        perawatan28km.add(oliMesin);
        perawatan28km.add(putaranMesin);
        perawatan28km.add(sistemRem);
        perawatan28km.add(minyakRem);
        perawatan28km.add(kampasRem);
        perawatan28km.add(switchLampuRem);
        perawatan28km.add(standarSamping);
        perawatan28km.add(suspensi);
        perawatan28km.add(rodaBan);
        perawatan28km.add(sistemPendingin);

        // 32.000 km
        perawatan32km.add(saluranBahanBakar);
        perawatan32km.add(gasTangan);
        perawatan32km.add(saringanUdara);
        perawatan32km.add(bakMesin);
        perawatan32km.add(busiPeriksa);
        perawatan32km.add(jarakKlep);
        perawatan32km.add(oliMesin);
        perawatan32km.add(putaranMesin);
        perawatan32km.add(sistemRem);
        perawatan32km.add(minyakRem);
        perawatan32km.add(kampasRem);
        perawatan32km.add(switchLampuRem);
        perawatan32km.add(standarSamping);
        perawatan32km.add(suspensi);
        perawatan32km.add(rodaBan);
        perawatan32km.add(saringanOliMesin);
        perawatan32km.add(cairanRadiatorPeriksa);
        perawatan32km.add(sistemPendingin);
        perawatan32km.add(driveBeltPeriksa);
        perawatan32km.add(oliFinalDrive);
        perawatan32km.add(sistemKopling);
        perawatan32km.add(murBautPengencang);

        // 36.000 km
        perawatan36km.add(saluranBahanBakar);
        perawatan36km.add(gasTangan);
        perawatan36km.add(bakMesin);
        perawatan36km.add(busiGanti);
        perawatan36km.add(jarakKlep);
        perawatan36km.add(oliMesin);
        perawatan36km.add(putaranMesin);
        perawatan36km.add(sistemRem);
        perawatan36km.add(minyakRem);
        perawatan36km.add(kampasRem);
        perawatan36km.add(switchLampuRem);
        perawatan36km.add(standarSamping);
        perawatan36km.add(suspensi);
        perawatan36km.add(rodaBan);
        perawatan36km.add(cairanRadiatorGanti);
        perawatan36km.add(sistemPendingin);
        perawatan36km.add(bantalanKepalaKemudi);

        // 40.000 km
        perawatan40km.add(saluranBahanBakar);
        perawatan40km.add(gasTangan);
        perawatan40km.add(saringanUdara);
        perawatan40km.add(bakMesin);
        perawatan40km.add(busiPeriksa);
        perawatan40km.add(jarakKlep);
        perawatan40km.add(oliMesin);
        perawatan40km.add(putaranMesin);
        perawatan40km.add(sistemRem);
        perawatan40km.add(minyakRem);
        perawatan40km.add(kampasRem);
        perawatan40km.add(switchLampuRem);
        perawatan40km.add(standarSamping);
        perawatan40km.add(suspensi);
        perawatan40km.add(rodaBan);
        perawatan40km.add(saringanOliMesin);
        perawatan40km.add(cairanRadiatorPeriksa);
        perawatan40km.add(sistemPendingin);
        perawatan40km.add(driveBeltPeriksa);
        perawatan40km.add(oliFinalDrive);
        perawatan40km.add(sistemKopling);
        perawatan40km.add(murBautPengencang);

        // 44.000 km
        perawatan44km.add(saluranBahanBakar);
        perawatan44km.add(gasTangan);
        perawatan44km.add(bakMesin);
        perawatan44km.add(busiGanti);
        perawatan44km.add(jarakKlep);
        perawatan44km.add(oliMesin);
        perawatan44km.add(putaranMesin);
        perawatan44km.add(sistemRem);
        perawatan44km.add(minyakRem);
        perawatan44km.add(kampasRem);
        perawatan44km.add(switchLampuRem);
        perawatan44km.add(standarSamping);
        perawatan44km.add(suspensi);
        perawatan44km.add(rodaBan);
        perawatan44km.add(sistemPendingin);

        // 48.000 km
        perawatan48km.add(saluranBahanBakar);
        perawatan48km.add(saringanBahanBakar);
        perawatan48km.add(gasTangan);
        perawatan48km.add(bakMesin);
        perawatan48km.add(busiPeriksa);
        perawatan48km.add(jarakKlep);
        perawatan48km.add(oliMesin);
        perawatan48km.add(putaranMesin);
        perawatan48km.add(sistemRem);
        perawatan48km.add(minyakRem);
        perawatan48km.add(kampasRem);
        perawatan48km.add(switchLampuRem);
        perawatan48km.add(standarSamping);
        perawatan48km.add(suspensi);
        perawatan48km.add(rodaBan);
        perawatan48km.add(saringanOliMesin);
        perawatan48km.add(cairanRadiatorGanti);
        perawatan48km.add(sistemPendingin);
        perawatan48km.add(driveBeltGanti);
        perawatan48km.add(oliFinalDrive);
        perawatan48km.add(sistemKopling);
        perawatan48km.add(murBautPengencang);
        perawatan48km.add(bantalanKepalaKemudi);

        // 52.000 km
        perawatan52km.add(saluranBahanBakar);
        perawatan52km.add(gasTangan);
        perawatan52km.add(bakMesin);
        perawatan52km.add(busiGanti);
        perawatan52km.add(jarakKlep);
        perawatan52km.add(oliMesin);
        perawatan52km.add(putaranMesin);
        perawatan52km.add(sistemRem);
        perawatan52km.add(minyakRem);
        perawatan52km.add(kampasRem);
        perawatan52km.add(switchLampuRem);
        perawatan52km.add(standarSamping);
        perawatan52km.add(suspensi);
        perawatan52km.add(rodaBan);
        perawatan52km.add(sistemPendingin);
    }
}
