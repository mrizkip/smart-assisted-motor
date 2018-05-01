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

    private int idBengkel;
    private String nama;
    private String alamat;
    private double jarak;
    private String merk;
    private String latitude;
    private String longitude;

    public int getIdBengkel() {
        return idBengkel;
    }

    public void setIdBengkel(int idBengkel) {
        this.idBengkel = idBengkel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
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
            nama.setText(item.getNama());
            alamat.setText(item.getAlamat());
            jarak.setText(String.valueOf(item.getJarak()) + " Km");
            if (item.getMerk().equalsIgnoreCase("HONDA")) {
                merk.setText("HONDA");
                merk.setBackgroundResource(R.drawable.label_honda);
            } else if (item.getMerk().equalsIgnoreCase("YAMAHA")) {
                merk.setText("YAMAHA");
                merk.setBackgroundResource(R.drawable.label_yamaha);
            } else if (item.getMerk().equalsIgnoreCase("KAWASAKI")) {
                merk.setText("KAWASAKI");
                merk.setBackgroundResource(R.drawable.label_kawasaki);
            } else if (item.getMerk().equalsIgnoreCase("SUZUKI")) {
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
