package com.hanyasoftware.android.smartassistedmotor.pilihmotor;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MotorAdapter extends AbstractItem<MotorAdapter, MotorAdapter.ViewHolder> {

    private String idKendaraan;
    private String nopol;
    private String pemilik;
    private String tipe;

    public String getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(String idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @NonNull
    @Override
    public MotorAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.itemMotor_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_pilih_motor;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<MotorAdapter>{

        @BindView(R.id.itemMotor_nopol)
        TextView tvNopol;
        @BindView(R.id.itemMotor_pemilik)
        TextView tvPemilik;
        @BindView(R.id.itemMotor_tipe)
        TextView tvTipe;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(MotorAdapter item, List<Object> payloads) {
            tvNopol.setText(item.getNopol());
            tvPemilik.setText(item.getPemilik());
            String tipe = item.getTipe();
            if (tipe.equalsIgnoreCase("cb150r")) {
                tipe = "CB 150R";
            } else if (tipe.equalsIgnoreCase("vario125")) {
                tipe = "Vario 125";
            }
            tvTipe.setText(tipe);
        }

        @Override
        public void unbindView(MotorAdapter item) {
            tvNopol.setText(null);
            tvPemilik.setText(null);
            tvTipe.setText(null);
        }
    }
}
