/*
    Android Asynchronous Http Client
    Copyright (c) 2011 James Smith <james@loopj.com>
    http://loopj.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.loopj.android.http;

import com.loopj.android.http.impl.AsyncHttpClientOptions;
import com.loopj.android.http.interfaces.AsyncHttpClientInterface;
import com.loopj.android.http.interfaces.AsyncHttpClientOptionsInterface;
import com.loopj.android.http.interfaces.AsyncHttpRequestInterface;
import com.loopj.android.http.interfaces.RequestHandleInterface;
import com.loopj.android.http.interfaces.RequestOptionsInterface;
import com.loopj.android.http.interfaces.RequestParamsInterface;
import com.loopj.android.http.interfaces.ResponseHandlerInterface;
import com.loopj.android.http.utils.Logger;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpHeadHC4;
import org.apache.http.client.methods.HttpOptionsHC4;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.client.methods.HttpPutHC4;
import org.apache.http.client.methods.HttpTraceHC4;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.concurrent.ExecutorService;

public class AsyncHttpClient implements AsyncHttpClientInterface {

    public static final String LOG_TAG = "AsyncHttpClient";

    private volatile static AsyncHttpClientInterface DEFAULT_INSTANCE;

    private final HttpClient httpClient;
    private RequestOptionsInterface defaultRequestOptions;
    private ExecutorService threadPool;
    private Class<? extends AsyncHttpRequestInterface> requestClass;

    /**
     * Retrieves static instance of AsyncHttpClientInterface, if not yet configured, will configure it with default values
     *
     * @see com.loopj.android.http.interfaces.AsyncHttpClientOptionsInterface
     * @see com.loopj.android.http.impl.AsyncHttpClientOptions
     */
    public static AsyncHttpClientInterface getDefaultInstance() {
        return getDefaultInstance(new AsyncHttpClientOptions());
    }

    public static AsyncHttpClientInterface getDefaultInstance(AsyncHttpClientOptionsInterface options) {
        if (DEFAULT_INSTANCE == null) {
            synchronized (AsyncHttpClient.class) {
                if (DEFAULT_INSTANCE == null) {
                    DEFAULT_INSTANCE = new AsyncHttpClient(options);
                }
            }
        }
        return DEFAULT_INSTANCE;
    }

    public AsyncHttpClient(AsyncHttpClientOptionsInterface options) {
        httpClient = options.getHttpClient();
        defaultRequestOptions = options.getDefaultRequestOptions();
        threadPool = options.getThreadPool();
        requestClass = options.getAsyncHttpRequestClass();
        Logger.setLogVerbosity(options.getLoggingVerbosity());
        if (options.isLoggingEnabled()) {
            Logger.enableLogging();
        } else {
            Logger.disableLogging();
        }
    }

    @Override
    public AsyncHttpClientInterface setDefaultRequestOptions(RequestOptionsInterface defaultRequestOptions) {
        this.defaultRequestOptions = defaultRequestOptions;
        return this;
    }

    @Override
    public RequestOptionsInterface getDefaultRequestOptions() {
        return defaultRequestOptions;
    }

    @Override
    public AsyncHttpClientInterface setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
        return this;
    }

    @Override
    public ExecutorService getUsedThreadPool() {
        return threadPool;
    }

    @Override
    public AsyncHttpRequestInterface getConfiguredAsyncHttpRequest(HttpUriRequest request, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        AsyncHttpRequestInterface asyncRequest;
        try {
            asyncRequest = requestClass.newInstance();
        } catch (Exception e) {
            Logger.e(LOG_TAG, "getConfiguredAsyncHttpRequest", e);
            return null;
        }
        asyncRequest.setHttpClient(this.httpClient);
        asyncRequest.setHttpRequest(request);
        asyncRequest.setResponseHandler(responseHandlerInterface);
        return asyncRequest;
    }

    @Override
    public RequestHandleInterface get(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpGetHC4 uriRequest = new HttpGetHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface post(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpPostHC4 uriRequest = new HttpPostHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface head(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpHeadHC4 uriRequest = new HttpHeadHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface put(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpPutHC4 uriRequest = new HttpPutHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface delete(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpPostHC4 uriRequest = new HttpPostHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface trace(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpTraceHC4 uriRequest = new HttpTraceHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface options(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpOptionsHC4 uriRequest = new HttpOptionsHC4(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface patch(String targetEndpoint, RequestParamsInterface requestParamsInterface, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        HttpPatch uriRequest = new HttpPatch(targetEndpoint);
        return executeRawRequest(uriRequest, requestOptionsInterface, responseHandlerInterface);
    }

    @Override
    public RequestHandleInterface executeRawRequest(HttpUriRequest request, RequestOptionsInterface requestOptionsInterface, ResponseHandlerInterface responseHandlerInterface) {
        AsyncHttpRequestInterface asyncRequest = getConfiguredAsyncHttpRequest(request, requestOptionsInterface, responseHandlerInterface);
        threadPool.submit(asyncRequest);
        return new RequestHandle(asyncRequest);
    }

}
