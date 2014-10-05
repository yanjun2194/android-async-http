package com.loopj.android.http.impl;

import com.loopj.android.http.interfaces.RequestParamInterface;

import java.io.InputStream;

public class StreamParam implements RequestParamInterface<InputStream> {

    @Override
    public InputStream getValue() {
        return null;
    }

    @Override
    public void setValue(InputStream value) {

    }

    @Override
    public String getJsonValue() {
        return null;
    }

    @Override
    public String getMultipartValue() {
        return null;
    }

    @Override
    public String getFormValue() {
        return null;
    }
}
