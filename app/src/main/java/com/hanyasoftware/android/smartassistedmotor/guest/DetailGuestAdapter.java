package com.hanyasoftware.android.smartassistedmotor.guest;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;

public class DetailGuestAdapter extends AbstractItem<DetailGuestAdapter, DetailGuestAdapter.ViewHolder> {

    private String perawatan;
    private String keterangan;

    public String getPerawatan() {
        return perawatan;
    }

    public void setPerawatan(String perawatan) {
        this.perawatan = perawatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @NonNull
    @Override
    public DetailGuestAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.detailGuest_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_detail_guest_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<DetailGuestAdapter>{

        @BindView(R.id.itemDetailGuest_no)
        TextView nomor;
        @BindView(R.id.itemDetailGuest_namaBarang)
        TextView namaPerawatan;
        @BindView(R.id.itemDetailGuest_keteranggan)
        TextView keterangan;


        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindView(DetailGuestAdapter item, List<Object> payloads) {
            nomor.setText(String.valueOf(getAdapterPosition() + 1));
            namaPerawatan.setText(item.getPerawatan());
            keterangan.setText(item.getKeterangan());
        }

        @Override
        public void unbindView(DetailGuestAdapter item) {
            nomor.setText(null);
            namaPerawatan.setText(null);
            keterangan.setText(null);
        }
    }
}
