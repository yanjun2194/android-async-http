package com.loopj.android.http.impl;

import com.loopj.android.http.abstracts.AbstractRequestParam;

import org.jetbrains.annotations.Nullable;

import java.io.InputStream;

public class StreamParam extends AbstractRequestParam<InputStream> {

    InputStream value;

    public StreamParam(InputStream value) {
        super(value);
    }

    @Nullable
    @Override
    public InputStream getValue() {
        return value;
    }

    @Override
    public void setValue(InputStream value) {
        this.value = value;
    }

    @Nullable
    @Override
    public String getStringValue() {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}
