package com.loopj.android.http.impl;

import com.loopj.android.http.abstracts.AbstractRequestParam;

import org.jetbrains.annotations.Nullable;

public class StringParam extends AbstractRequestParam<String> {

    String value;

    public StringParam(String value) {
        super(value);
    }

    @Nullable
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Nullable
    @Override
    public String getStringValue() {
        return value;
    }
}
