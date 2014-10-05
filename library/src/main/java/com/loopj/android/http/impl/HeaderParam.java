package com.loopj.android.http.impl;

import com.loopj.android.http.interfaces.RequestParamInterface;

import org.apache.http.HeaderElement;

public class HeaderParam implements RequestParamInterface<HeaderElement> {

    @Override
    public HeaderElement getValue() {
        return null;
    }

    @Override
    public void setValue(HeaderElement value) {

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
