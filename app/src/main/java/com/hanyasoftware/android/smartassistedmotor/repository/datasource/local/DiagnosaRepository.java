package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.api.IDiagnosa;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.DiagnosaResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DiagnosaRepository {

    private final IDiagnosa iDiagnosa;

    @Inject
    public DiagnosaRepository(IDiagnosa iDiagnosa) {
        this.iDiagnosa = iDiagnosa;
    }

    // TODO: Diagnosa kendaraan
}
