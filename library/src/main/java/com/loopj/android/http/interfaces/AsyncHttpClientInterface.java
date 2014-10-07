package com.loopj.android.http.interfaces;

import org.apache.http.client.methods.HttpUriRequest;

import java.util.concurrent.ExecutorService;

public interface AsyncHttpClientInterface {

    // Configuration

    AsyncHttpClientInterface setDefaultRequestOptions(
            RequestOptionsInterface defaultRequestOptions
    );

    RequestOptionsInterface getDefaultRequestOptions();

    AsyncHttpClientInterface setThreadPool(ExecutorService threadPool);

    ExecutorService getUsedThreadPool();

    AsyncHttpRequestInterface getConfiguredAsyncHttpRequest(HttpUriRequest request, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface);

    // HTTP methods

    RequestHandleInterface get(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface post(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface head(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface put(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface delete(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface trace(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface options(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface patch(
            String targetEndpoint,
            RequestParamsInterface requestParamsInterface,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

    RequestHandleInterface executeRawRequest(
            HttpUriRequest request,
            RequestOptionsInterface requestOptionsInterface,
            ResponseHandlerInterface responseHandlerInterface
    );

}
