package com.loopj.android.http.impl;

import com.loopj.android.http.abstracts.AbstractRequestParam;

import org.jetbrains.annotations.Nullable;

public class DoubleParam extends AbstractRequestParam<Double> {

    Double value;

    public DoubleParam(Double value) {
        super(value);
    }

    @Nullable
    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value;
    }

    @Nullable
    @Override
    public String getStringValue() {
        return value == null ? null : value.toString();
    }
}
