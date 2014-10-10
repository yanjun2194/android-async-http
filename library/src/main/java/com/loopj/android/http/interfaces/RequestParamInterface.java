package com.loopj.android.http.interfaces;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public interface RequestParamInterface<T> extends Serializable {

    @Nullable
    T getValue();

    void setValue(T value);

    @Nullable
    String getStringValue();

}
