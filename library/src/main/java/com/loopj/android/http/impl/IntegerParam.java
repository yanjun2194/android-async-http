package com.loopj.android.http.impl;

import com.loopj.android.http.abstracts.AbstractRequestParam;

import org.jetbrains.annotations.Nullable;

public class IntegerParam extends AbstractRequestParam<Integer> {

    Integer value;

    public IntegerParam(Integer value) {
        super(value);
    }

    @Nullable
    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }

    @Nullable
    @Override
    public String getStringValue() {
        return value == null ? null : value.toString();
    }
}
