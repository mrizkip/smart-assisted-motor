package com.hanyasoftware.android.smartassistedmotor.repository.utils;

import java.util.Collection;

/**
 * Created by mrizk on 16/01/2018.
 */

public interface ILayerDataTransformer<F, T> {
    T transform(F from);

    Collection<T> transform(Collection<F> from);
}
