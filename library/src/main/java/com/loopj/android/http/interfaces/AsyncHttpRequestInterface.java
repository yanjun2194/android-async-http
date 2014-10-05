package com.loopj.android.http.interfaces;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public interface AsyncHttpRequestInterface extends Runnable {

    void setHttpClient(HttpClient client);

    void setHttpRequest(HttpUriRequest request);

    void setResponseHandler(ResponseHandlerInterface responseHandlerInterface);

    void preProcessRequest();

    void postProcessRequest();

    void sendCancelNotification();

    boolean isDone();

    boolean isCancelled();

    boolean cancel(boolean mayInterruptIfRunning);

}
