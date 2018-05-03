package com.hanyasoftware.android.smartassistedmotor.bengkel;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BengkelAdapter extends AbstractItem<BengkelAdapter, BengkelAdapter.ViewHolder> {

    private String bngId;
    private String bngNama;
    private String bngAlamat;
    private String bngLatitude;
    private String bngLongitude;
    private String bngHariBuka;
    private String bngJamBuka;
    private String bngJamTutup;
    private String bngKtgId;
    private String ktgId;
    private String ktgNama;
    private String distance;

    public String getBngId() {
        return bngId;
    }

    public void setBngId(String bngId) {
        this.bngId = bngId;
    }

    public String getBngNama() {
        return bngNama;
    }

    public void setBngNama(String bngNama) {
        this.bngNama = bngNama;
    }

    public String getBngAlamat() {
        return bngAlamat;
    }

    public void setBngAlamat(String bngAlamat) {
        this.bngAlamat = bngAlamat;
    }

    public String getBngLatitude() {
        return bngLatitude;
    }

    public void setBngLatitude(String bngLatitude) {
        this.bngLatitude = bngLatitude;
    }

    public String getBngLongitude() {
        return bngLongitude;
    }

    public void setBngLongitude(String bngLongitude) {
        this.bngLongitude = bngLongitude;
    }

    public String getBngHariBuka() {
        return bngHariBuka;
    }

    public void setBngHariBuka(String bngHariBuka) {
        this.bngHariBuka = bngHariBuka;
    }

    public String getBngJamBuka() {
        return bngJamBuka;
    }

    public void setBngJamBuka(String bngJamBuka) {
        this.bngJamBuka = bngJamBuka;
    }

    public String getBngJamTutup() {
        return bngJamTutup;
    }

    public void setBngJamTutup(String bngJamTutup) {
        this.bngJamTutup = bngJamTutup;
    }

    public String getBngKtgId() {
        return bngKtgId;
    }

    public void setBngKtgId(String bngKtgId) {
        this.bngKtgId = bngKtgId;
    }

    public String getKtgId() {
        return ktgId;
    }

    public void setKtgId(String ktgId) {
        this.ktgId = ktgId;
    }

    public String getKtgNama() {
        return ktgNama;
    }

    public void setKtgNama(String ktgNama) {
        this.ktgNama = ktgNama;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.itemBengkel_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_bengkel_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<BengkelAdapter> {

        @BindView(R.id.itemBengkel_merk)
        TextView merk;
        @BindView(R.id.itemBengkel_alamatBengkel)
        TextView alamat;
        @BindView(R.id.itemBengkel_jarak)
        TextView jarak;
        @BindView(R.id.itemBengkel_namaBengkel)
        TextView nama;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(BengkelAdapter item, List<Object> payloads) {
            nama.setText(item.bngNama);
            alamat.setText(item.bngAlamat);
            jarak.setText(String.valueOf(item.getDistance()) + " Km");
            if (item.getKtgNama().equalsIgnoreCase("HONDA")) {
                merk.setText("HONDA");
                merk.setBackgroundResource(R.drawable.label_honda);
            } else if (item.getKtgNama().equalsIgnoreCase("YAMAHA")) {
                merk.setText("YAMAHA");
                merk.setBackgroundResource(R.drawable.label_yamaha);
            } else if (item.getKtgNama().equalsIgnoreCase("KAWASAKI")) {
                merk.setText("KAWASAKI");
                merk.setBackgroundResource(R.drawable.label_kawasaki);
            } else if (item.getKtgNama().equalsIgnoreCase("SUZUKI")) {
                merk.setText("SUZUKI");
                merk.setBackgroundResource(R.drawable.label_suzuki);
            } else {
                merk.setText("OTHER");
                merk.setBackgroundResource(R.drawable.label_other);
            }
        }

        @Override
        public void unbindView(BengkelAdapter item) {
            nama.setText(null);
            alamat.setText(null);
            jarak.setText(null);
            merk.setText(null);
            merk.setBackgroundResource(R.drawable.label_other);
        }
    }
}
