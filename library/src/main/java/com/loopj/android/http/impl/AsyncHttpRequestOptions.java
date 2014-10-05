package com.loopj.android.http.impl;

import com.loopj.android.http.interfaces.RequestOptionsInterface;

import org.apache.http.client.CookieStore;
import org.apache.http.client.RedirectHandler;

public class AsyncHttpRequestOptions implements RequestOptionsInterface {

    boolean ignoreInvalidSSLCertificate = false;
    boolean allowRedirects = true;
    boolean allowCircularRedirects = false;
    boolean allowRelativeRedirects = true;
    int httpPort = 80;
    int httpsPort = 443;
    int maxAllowedRetries = 5;
    String userAgent = null;
    boolean useSynchronous = false;
    CookieStore cookieStore = null;
    RedirectHandler redirectHandler = null;
    int connectTimeout = 60;
    int responseTimeout = 60;
    boolean gzipEnabled = true;

    public AsyncHttpRequestOptions() {

    }

    public AsyncHttpRequestOptions(RequestOptionsInterface copyFrom) {
        mergeWithRequestOptions(copyFrom);
    }

    @Override
    public RequestOptionsInterface mergeWithRequestOptions(RequestOptionsInterface b) {
        setAllowCircularRedirects(b.getAllowCircularRedirects());
        setAllowRedirects(b.getAllowRedirects());
        setAllowRelativeRedirects(b.getAllowRelativeRedirects());
        setConnectTimeout(b.getConnectTimeout());
        setResponseTimeout(b.getResponseTimeout());
        setCookieStore(b.getCookieStore());
        setHttpPort(b.getHttpPort());
        setHttpsPort(b.getHttpsPort());
        setIgnoreInvalidSSLCertificate(b.getIgnoreInvalidSSLCertificate());
        setMaxAllowedRetries(b.getMaxAllowedRetries());
        setRedirectHandler(b.getRedirectHandler());
        setUserAgent(b.getUserAgent());
        setUseSynchronous(b.getUseSynchronous());
        return this;
    }

    @Override
    public boolean getIgnoreInvalidSSLCertificate() {
        return ignoreInvalidSSLCertificate;
    }

    @Override
    public RequestOptionsInterface setIgnoreInvalidSSLCertificate(boolean ignoreInvalidSSLCertificate) {
        this.ignoreInvalidSSLCertificate = ignoreInvalidSSLCertificate;
        return this;
    }

    @Override
    public int getHttpPort() {
        return httpPort;
    }

    @Override
    public RequestOptionsInterface setHttpPort(int httpPort) {
        this.httpPort = httpPort;
        return this;
    }

    @Override
    public int getHttpsPort() {
        return httpsPort;
    }

    @Override
    public RequestOptionsInterface setHttpsPort(int httpsPort) {
        this.httpsPort = httpsPort;
        return this;
    }

    @Override
    public CookieStore getCookieStore() {
        return cookieStore;
    }

    @Override
    public RequestOptionsInterface setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    @Override
    public boolean getAllowRedirects() {
        return allowRedirects;
    }

    @Override
    public RequestOptionsInterface setAllowRedirects(boolean allowRedirects) {
        this.allowRedirects = allowRedirects;
        return this;
    }

    @Override
    public boolean getAllowCircularRedirects() {
        return allowCircularRedirects;
    }

    @Override
    public RequestOptionsInterface setAllowCircularRedirects(boolean allowCircularRedirects) {
        this.allowCircularRedirects = allowCircularRedirects;
        return this;
    }

    @Override
    public boolean getAllowRelativeRedirects() {
        return allowRelativeRedirects;
    }

    @Override
    public RequestOptionsInterface setAllowRelativeRedirects(boolean allowRelativeRedirects) {
        this.allowRelativeRedirects = allowRelativeRedirects;
        return this;
    }

    @Override
    public RequestOptionsInterface setAllowedRedirects(boolean enableRedirects, boolean enableRelativeRedirects, boolean enableCircularRedirects) {
        setAllowCircularRedirects(allowCircularRedirects);
        setAllowRedirects(allowRedirects);
        setAllowRelativeRedirects(allowRelativeRedirects);
        return this;
    }

    @Override
    public RedirectHandler getRedirectHandler() {
        return redirectHandler;
    }

    @Override
    public RequestOptionsInterface setRedirectHandler(RedirectHandler handler) {
        this.redirectHandler = handler;
        return this;
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public RequestOptionsInterface setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    @Override
    public int getConnectTimeout() {
        return connectTimeout;
    }

    @Override
    public RequestOptionsInterface setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    @Override
    public int getResponseTimeout() {
        return responseTimeout;
    }

    @Override
    public RequestOptionsInterface setResponseTimeout(int responseTimeout) {
        this.responseTimeout = responseTimeout;
        return this;
    }

    @Override
    public int getMaxAllowedRetries() {
        return maxAllowedRetries;
    }

    @Override
    public RequestOptionsInterface setMaxAllowedRetries(int maxRetries) {
        return null;
    }

    @Override
    public boolean getGzipSupportEnabled() {
        return gzipEnabled;
    }

    @Override
    public RequestOptionsInterface setGzipSupportEnabled(boolean gzipSupportEnabled) {
        this.gzipEnabled = gzipSupportEnabled;
        return this;
    }

    @Override
    public RequestOptionsInterface setUseSynchronous(boolean useSynchronous) {
        this.useSynchronous = useSynchronous;
        return this;
    }

    @Override
    public boolean getUseSynchronous() {
        return useSynchronous;
    }

}
