package com.hanyasoftware.android.smartassistedmotor.repository.transformer;

import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.JarakResponse;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.Jarak;
import com.hanyasoftware.android.smartassistedmotor.repository.utils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class JarakResponseToJarak extends BaseLayerDataTransformer<JarakResponse, Jarak> {

    @Inject
    public JarakResponseToJarak() {
    }

    @Override
    public Jarak transform(JarakResponse from) {
        Jarak jarak = new Jarak();
        jarak.setId(from.getId());
        jarak.setJarak(from.getJarak());
        return jarak;
    }
}
