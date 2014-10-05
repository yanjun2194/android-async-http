package com.loopj.android.http.interfaces;

public interface RequestHandleInterface {

    boolean cancelRequest(boolean mayInterruptIfRunning);

    boolean isFinished();

    boolean isCancelled();

    boolean gc();

}
