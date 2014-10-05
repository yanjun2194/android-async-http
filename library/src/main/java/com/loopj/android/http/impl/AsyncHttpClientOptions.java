package com.loopj.android.http.impl;

import android.util.Log;

import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.interfaces.AsyncHttpClientOptionsInterface;
import com.loopj.android.http.interfaces.AsyncHttpRequestInterface;
import com.loopj.android.http.interfaces.RequestOptionsInterface;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpClientOptions implements AsyncHttpClientOptionsInterface {

    HttpClient httpClient;
    RequestOptionsInterface defaultRequestOptions;
    ExecutorService threadPool;
    boolean loggingEnabled = true;
    int loggingVerbosity = Log.WARN;
    Class<? extends AsyncHttpRequestInterface> requestClass;

    @Override
    public HttpClient getHttpClient() {
        return httpClient == null ? HttpClients.createDefault() : httpClient;
    }

    @Override
    public AsyncHttpClientOptionsInterface setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    @Override
    public RequestOptionsInterface getDefaultRequestOptions() {
        return defaultRequestOptions == null ? new AsyncHttpRequestOptions() : defaultRequestOptions;
    }

    @Override
    public AsyncHttpClientOptionsInterface setDefaultRequestOptions(RequestOptionsInterface defaultRequestOptions) {
        this.defaultRequestOptions = defaultRequestOptions;
        return this;
    }

    @Override
    public AsyncHttpClientOptionsInterface setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
        return this;
    }

    @Override
    public ExecutorService getThreadPool() {
        return threadPool == null ? Executors.newCachedThreadPool() : threadPool;
    }

    @Override
    public Class<? extends AsyncHttpRequestInterface> getAsyncHttpRequestClass() {
        return requestClass == null ? AsyncHttpRequest.class : requestClass;
    }

    @Override
    public AsyncHttpClientOptionsInterface setAsyncHttpRequestClass(Class<? extends AsyncHttpRequestInterface> requestClass) {
        this.requestClass = requestClass;
        return this;
    }

    @Override
    public AsyncHttpClientOptionsInterface enableLogging() {
        loggingEnabled = true;
        return this;
    }

    @Override
    public AsyncHttpClientOptionsInterface disableLogging() {
        loggingEnabled = false;
        return this;
    }

    @Override
    public AsyncHttpClientOptionsInterface setLoggingVerbosity(int logVerbosity) {
        loggingVerbosity = logVerbosity;
        return this;
    }

    @Override
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    @Override
    public int getLoggingVerbosity() {
        return loggingVerbosity;
    }
}
