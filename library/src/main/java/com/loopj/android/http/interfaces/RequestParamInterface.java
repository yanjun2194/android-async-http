package com.loopj.android.http.interfaces;

import java.io.Serializable;

public interface RequestParamInterface<T> extends Serializable {

    T getValue();
    void setValue(T value);
    String getJsonValue();
    String getMultipartValue();
    String getFormValue();

}
