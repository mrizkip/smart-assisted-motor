package com.hanyasoftware.android.smartassistedmotor.guest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabelCb150r {

    private final Map<MapKeyPerawatan, List<DetailGuestAdapter>> mapTableCb150r = new HashMap<>();
    private List<DetailGuestAdapter> perawatan1km;
    private List<DetailGuestAdapter> perawatan6km;
    private List<DetailGuestAdapter> perawatan12km;
    private List<DetailGuestAdapter> perawatan18km;
    private List<DetailGuestAdapter> perawatan24km;
    private List<DetailGuestAdapter> perawatan30km;
    private List<DetailGuestAdapter> perawatan36km;
    private List<DetailGuestAdapter> perawatan42km;
    private List<DetailGuestAdapter> perawatan48km;
    private List<DetailGuestAdapter> perawatan54km;
    

    public TabelCb150r() {
        perawatan1km = new ArrayList<>();
        perawatan6km = new ArrayList<>();
        perawatan12km = new ArrayList<>();
        perawatan18km = new ArrayList<>();
        perawatan24km = new ArrayList<>();
        perawatan30km = new ArrayList<>();
        perawatan36km = new ArrayList<>();
        perawatan42km = new ArrayList<>();
        perawatan48km = new ArrayList<>();
        perawatan54km = new ArrayList<>();
        
        // init tabel
        initTablePerawatan();
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "1.000 Km"), perawatan1km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "6.000 Km"), perawatan6km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "12.000 Km"), perawatan12km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "18.000 Km"), perawatan18km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "24.000 Km"), perawatan24km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "30.000 Km"), perawatan30km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "36.000 Km"), perawatan36km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "42.000 Km"), perawatan42km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "48.000 Km"), perawatan48km);
        mapTableCb150r.put(new MapKeyPerawatan("CB 150R", "54.000 Km"), perawatan54km);
    }

    public Map<MapKeyPerawatan, List<DetailGuestAdapter>> getMapTableCb150r() {
        return mapTableCb150r;
    }

    private void initTablePerawatan() {
        // DetailPerawatan
        DetailGuestAdapter saluranBahanBakar = new DetailGuestAdapter();
        saluranBahanBakar.setPerawatan("Saluran Bahan Bakar");
        saluranBahanBakar.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
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
        jarakKlep.setPerawatan("Jarak Renggang Klep");
        jarakKlep.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter oliMesin = new DetailGuestAdapter();
        oliMesin.setPerawatan("Oli Mesin");
        oliMesin.setKeterangan("Ganti.");
        DetailGuestAdapter saringanOliMesin = new DetailGuestAdapter();
        saringanOliMesin.setPerawatan("Saringan Kasa Oli Mesin");
        saringanOliMesin.setKeterangan("Bersihkan.");
        DetailGuestAdapter cairanRadiator = new DetailGuestAdapter();
        cairanRadiator.setPerawatan("Cairan Pendingin Radiator");
        cairanRadiator.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter putaranMesin = new DetailGuestAdapter();
        putaranMesin.setPerawatan("Putaran Stasioner Mesin");
        putaranMesin.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter sistemPendingin = new DetailGuestAdapter();
        sistemPendingin.setPerawatan("Sistem Pendingin");
        sistemPendingin.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter rantaiRoda = new DetailGuestAdapter();
        rantaiRoda.setPerawatan("Rantai Roda");
        rantaiRoda.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu). Lumasi.");
        DetailGuestAdapter minyakRem = new DetailGuestAdapter();
        minyakRem.setPerawatan("Minyak Rem");
        minyakRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter kampasRem = new DetailGuestAdapter();
        kampasRem.setPerawatan("Keausan Kampas Rem");
        kampasRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter sistemRem = new DetailGuestAdapter();
        sistemRem.setPerawatan("Sistem Rem");
        sistemRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter switchLampuRem = new DetailGuestAdapter();
        switchLampuRem.setPerawatan("Switch Lampu Rem");
        switchLampuRem.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter arahLampuDepan = new DetailGuestAdapter();
        arahLampuDepan.setPerawatan("Arah Sinar Lampu Depan");
        arahLampuDepan.setKeterangan("Periksa (bersihkan, setel, lumasi, atau ganti bila perlu).");
        DetailGuestAdapter sistemKopling = new DetailGuestAdapter();
        sistemKopling.setPerawatan("Sistem Kopling");
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
        // 1000 km
        perawatan1km.add(oliMesin);
        perawatan1km.add(putaranMesin);
        perawatan1km.add(rantaiRoda);
        perawatan1km.add(sistemRem);
        perawatan1km.add(sistemKopling);
        perawatan1km.add(murBautPengencang);
        
        // 6000 km
        perawatan6km.add(saluranBahanBakar);
        perawatan6km.add(gasTangan);
        perawatan6km.add(bakMesin);
        perawatan6km.add(busiPeriksa);
        perawatan6km.add(oliMesin);
        perawatan6km.add(putaranMesin);
        perawatan6km.add(rantaiRoda);
        perawatan6km.add(minyakRem);
        perawatan6km.add(kampasRem);
        perawatan6km.add(sistemRem);
        perawatan6km.add(switchLampuRem);
        perawatan6km.add(arahLampuDepan);
        perawatan6km.add(sistemKopling);
        perawatan6km.add(standarSamping);
        perawatan6km.add(suspensi);
        perawatan6km.add(rodaBan);
        
        // 12000 km
        perawatan12km.add(saluranBahanBakar);
        perawatan12km.add(gasTangan);
        perawatan12km.add(bakMesin);
        perawatan12km.add(busiGanti);
        perawatan12km.add(oliMesin);
        perawatan12km.add(saringanOliMesin);
        perawatan12km.add(putaranMesin);
        perawatan12km.add(cairanRadiator);
        perawatan12km.add(sistemPendingin);
        perawatan12km.add(rantaiRoda);
        perawatan12km.add(minyakRem);
        perawatan12km.add(kampasRem);
        perawatan12km.add(sistemRem);
        perawatan12km.add(switchLampuRem);
        perawatan12km.add(arahLampuDepan);
        perawatan12km.add(sistemKopling);
        perawatan12km.add(standarSamping);
        perawatan12km.add(suspensi);
        perawatan12km.add(murBautPengencang);
        perawatan12km.add(rodaBan);
        perawatan12km.add(bantalanKepalaKemudi);
        
        // 18000 km
        perawatan18km.add(saluranBahanBakar);
        perawatan18km.add(gasTangan);
        perawatan18km.add(bakMesin);
        perawatan18km.add(busiPeriksa);
        perawatan18km.add(oliMesin);
        perawatan18km.add(putaranMesin);
        perawatan18km.add(rantaiRoda);
        perawatan18km.add(minyakRem);
        perawatan18km.add(kampasRem);
        perawatan18km.add(sistemRem);
        perawatan18km.add(switchLampuRem);
        perawatan18km.add(arahLampuDepan);
        perawatan18km.add(sistemKopling);
        perawatan18km.add(standarSamping);
        perawatan18km.add(suspensi);
        perawatan18km.add(rodaBan);
        
        // 24000 km
        perawatan24km.add(saluranBahanBakar);
        perawatan24km.add(gasTangan);
        perawatan24km.add(bakMesin);
        perawatan24km.add(busiGanti);
        perawatan24km.add(oliMesin);
        perawatan24km.add(saringanOliMesin);
        perawatan24km.add(putaranMesin);
        perawatan24km.add(cairanRadiator);
        perawatan24km.add(sistemPendingin);
        perawatan24km.add(rantaiRoda);
        perawatan24km.add(minyakRem);
        perawatan24km.add(kampasRem);
        perawatan24km.add(sistemRem);
        perawatan24km.add(switchLampuRem);
        perawatan24km.add(arahLampuDepan);
        perawatan24km.add(sistemKopling);
        perawatan24km.add(standarSamping);
        perawatan24km.add(suspensi);
        perawatan24km.add(murBautPengencang);
        perawatan24km.add(rodaBan);
        perawatan24km.add(bantalanKepalaKemudi);

        // 30000 km
        perawatan30km.add(saluranBahanBakar);
        perawatan30km.add(gasTangan);
        perawatan30km.add(bakMesin);
        perawatan30km.add(busiPeriksa);
        perawatan30km.add(oliMesin);
        perawatan30km.add(putaranMesin);
        perawatan30km.add(rantaiRoda);
        perawatan30km.add(minyakRem);
        perawatan30km.add(kampasRem);
        perawatan30km.add(sistemRem);
        perawatan30km.add(switchLampuRem);
        perawatan30km.add(arahLampuDepan);
        perawatan30km.add(sistemKopling);
        perawatan30km.add(standarSamping);
        perawatan30km.add(suspensi);
        perawatan30km.add(rodaBan);

        // 36000 km
        perawatan36km.add(saluranBahanBakar);
        perawatan36km.add(gasTangan);
        perawatan36km.add(bakMesin);
        perawatan36km.add(busiGanti);
        perawatan36km.add(oliMesin);
        perawatan36km.add(saringanOliMesin);
        perawatan36km.add(putaranMesin);
        perawatan36km.add(cairanRadiator);
        perawatan36km.add(sistemPendingin);
        perawatan36km.add(rantaiRoda);
        perawatan36km.add(minyakRem);
        perawatan36km.add(kampasRem);
        perawatan36km.add(sistemRem);
        perawatan36km.add(switchLampuRem);
        perawatan36km.add(arahLampuDepan);
        perawatan36km.add(sistemKopling);
        perawatan36km.add(standarSamping);
        perawatan36km.add(suspensi);
        perawatan36km.add(murBautPengencang);
        perawatan36km.add(rodaBan);
        perawatan36km.add(bantalanKepalaKemudi);

        // 42000 km
        perawatan42km.add(saluranBahanBakar);
        perawatan42km.add(gasTangan);
        perawatan42km.add(bakMesin);
        perawatan42km.add(busiPeriksa);
        perawatan42km.add(oliMesin);
        perawatan42km.add(putaranMesin);
        perawatan42km.add(rantaiRoda);
        perawatan42km.add(minyakRem);
        perawatan42km.add(kampasRem);
        perawatan42km.add(sistemRem);
        perawatan42km.add(switchLampuRem);
        perawatan42km.add(arahLampuDepan);
        perawatan42km.add(sistemKopling);
        perawatan42km.add(standarSamping);
        perawatan42km.add(suspensi);
        perawatan42km.add(rodaBan);

        // 48000 km
        perawatan48km.add(saluranBahanBakar);
        perawatan48km.add(gasTangan);
        perawatan48km.add(bakMesin);
        perawatan48km.add(busiGanti);
        perawatan48km.add(oliMesin);
        perawatan48km.add(saringanOliMesin);
        perawatan48km.add(putaranMesin);
        perawatan48km.add(cairanRadiator);
        perawatan48km.add(sistemPendingin);
        perawatan48km.add(rantaiRoda);
        perawatan48km.add(minyakRem);
        perawatan48km.add(kampasRem);
        perawatan48km.add(sistemRem);
        perawatan48km.add(switchLampuRem);
        perawatan48km.add(arahLampuDepan);
        perawatan48km.add(sistemKopling);
        perawatan48km.add(standarSamping);
        perawatan48km.add(suspensi);
        perawatan48km.add(murBautPengencang);
        perawatan48km.add(rodaBan);
        perawatan48km.add(bantalanKepalaKemudi);

        // 54000 km
        perawatan54km.add(saluranBahanBakar);
        perawatan54km.add(gasTangan);
        perawatan54km.add(bakMesin);
        perawatan54km.add(busiPeriksa);
        perawatan54km.add(oliMesin);
        perawatan54km.add(putaranMesin);
        perawatan54km.add(rantaiRoda);
        perawatan54km.add(minyakRem);
        perawatan54km.add(kampasRem);
        perawatan54km.add(sistemRem);
        perawatan54km.add(switchLampuRem);
        perawatan54km.add(arahLampuDepan);
        perawatan54km.add(sistemKopling);
        perawatan54km.add(standarSamping);
        perawatan54km.add(suspensi);
        perawatan54km.add(rodaBan);
    }
}
