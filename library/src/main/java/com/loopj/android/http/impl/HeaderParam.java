package com.loopj.android.http.impl;

import com.loopj.android.http.abstracts.AbstractRequestParam;

import org.apache.http.HeaderElement;
import org.jetbrains.annotations.Nullable;

public class HeaderParam extends AbstractRequestParam<HeaderElement> {

    HeaderElement value;

    public HeaderParam(HeaderElement value) {
        super(value);
    }

    @Nullable
    @Override
    public HeaderElement getValue() {
        return value;
    }

    @Override
    public void setValue(HeaderElement value) {
        this.value = value;
    }

    @Nullable
    @Override
    public String getStringValue() {
        return value == null ? null : String.format("%s: %s", value.getName(), value.getValue());
    }
}
