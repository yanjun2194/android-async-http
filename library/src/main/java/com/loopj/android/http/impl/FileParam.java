package com.loopj.android.http.impl;

import com.loopj.android.http.interfaces.RequestParamInterface;

import java.io.File;

public class FileParam implements RequestParamInterface<File> {

    @Override
    public File getValue() {
        return null;
    }

    @Override
    public void setValue(File value) {

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
