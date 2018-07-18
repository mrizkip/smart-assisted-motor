package com.hanyasoftware.android.smartassistedmotor.diagnosis;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiagnosaAdapter extends AbstractItem<DiagnosaAdapter, DiagnosaAdapter.ViewHolder> {

    private String nomor;
    private String perawatan;
    private String keterangan;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

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
    public DiagnosaAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.diagnosa_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_diagnosa_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<DiagnosaAdapter> {

        @BindView(R.id.itemDiagnosa_no)
        TextView nomor;
        @BindView(R.id.itemDiagnosa_namaBarang)
        TextView namaPerawatan;
        @BindView(R.id.itemDiagnosa_keteranggan)
        TextView keterangan;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(DiagnosaAdapter item, List<Object> payloads) {
            nomor.setText(String.valueOf(getAdapterPosition() + 1));
            namaPerawatan.setText(item.getPerawatan());
            keterangan.setText(item.getKeterangan());
        }

        @Override
        public void unbindView(DiagnosaAdapter item) {
            nomor.setText(null);
            namaPerawatan.setText(null);
            keterangan.setText(null);
        }
    }
}
