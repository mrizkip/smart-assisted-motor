package com.hanyasoftware.android.smartassistedmotor.guest;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.smartassistedmotor.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends AbstractItem<GuestAdapter, GuestAdapter.ViewHolder> {

    private String kilometer;

    public GuestAdapter() {
    }

    public GuestAdapter(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    @NonNull
    @Override
    public GuestAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.guestAdapter_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_guest_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<GuestAdapter>{

        @BindView(R.id.guestAdapter_textKm)
        TextView tvKilometer;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(GuestAdapter item, List<Object> payloads) {
            tvKilometer.setText(item.getKilometer());
        }

        @Override
        public void unbindView(GuestAdapter item) {
            tvKilometer.setText(null);
        }
    }
}
