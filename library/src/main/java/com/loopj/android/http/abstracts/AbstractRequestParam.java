package com.loopj.android.http.abstracts;

import com.loopj.android.http.interfaces.RequestParamInterface;

abstract public class AbstractRequestParam<T> implements RequestParamInterface<T> {

    public AbstractRequestParam(T value) {
        setValue(value);
    }

}
