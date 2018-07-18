package com.hanyasoftware.android.smartassistedmotor.diagnosis;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.smartassistedmotor.repository.datasource.local.DiagnosaRepository;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.api.DiagnosaResponse;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DiagnosaViewModel extends ViewModel {

    private final DiagnosaRepository diagnosaRepository;
    private MutableLiveData<DiagnosaResponse> diagnosaLiveData;
    private final CompositeDisposable compositeDisposable;

    public DiagnosaViewModel(DiagnosaRepository diagnosaRepository) {
        this.diagnosaRepository = diagnosaRepository;
        this.diagnosaLiveData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();

        fetchDiagnosa();
    }

    private void fetchDiagnosa() {
        Disposable disposable = diagnosaRepository.getDiagnosa()
                .subscribe(diagnosaLiveData::postValue,
                        throwable -> diagnosaLiveData.postValue(null));
        compositeDisposable.add(disposable);
    }


    public LiveData<DiagnosaResponse> getDiagnosa() {
        return diagnosaLiveData;
    }

    public static class DiagnosaViewModelFactory implements ViewModelProvider.Factory {

        private final DiagnosaRepository diagnosaRepository;

        @Inject
        public DiagnosaViewModelFactory(DiagnosaRepository diagnosaRepository) {
            this.diagnosaRepository = diagnosaRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new DiagnosaViewModel(diagnosaRepository);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
