package com.loopj.android.http.interfaces;

import com.loopj.android.http.impl.AsyncHttpClientOptions;

import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public interface AsyncHttpClientOptionsInterface {

    HttpClient getHttpClient();

    AsyncHttpClientOptionsInterface setHttpClient(HttpClient httpClient);

    RequestOptionsInterface getDefaultRequestOptions();

    AsyncHttpClientOptionsInterface setDefaultRequestOptions(RequestOptionsInterface defaultRequestOptions);

    AsyncHttpClientOptionsInterface setThreadPool(ExecutorService threadPool);

    ExecutorService getThreadPool();

    Class<? extends AsyncHttpRequestInterface> getAsyncHttpRequestClass();

    AsyncHttpClientOptionsInterface setAsyncHttpRequestClass(Class<? extends AsyncHttpRequestInterface> requestClass);

    AsyncHttpClientOptionsInterface enableLogging();
    AsyncHttpClientOptionsInterface disableLogging();
    AsyncHttpClientOptionsInterface setLoggingVerbosity(int logVerbosity);

    boolean isLoggingEnabled();
    int getLoggingVerbosity();
}
