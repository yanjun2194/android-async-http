package com.loopj.android.http.interfaces;

import org.apache.http.client.CookieStore;
import org.apache.http.client.RedirectHandler;

import java.io.Serializable;

/**
 * Each set method returns self instance, see Fluent interface principle
 */
public interface RequestOptionsInterface extends Serializable, Cloneable {

    /**
     * Will merge self options with provided options
     */
    RequestOptionsInterface mergeWithRequestOptions(
            RequestOptionsInterface anotherOptions
    );

    boolean getIgnoreInvalidSSLCertificate();

    RequestOptionsInterface setIgnoreInvalidSSLCertificate(
            boolean ignoreInvalidSSLCertificate
    );

    int getHttpPort();

    RequestOptionsInterface setHttpPort(
            int httpPort
    );

    int getHttpsPort();

    RequestOptionsInterface setHttpsPort(
            int httpsPort
    );

    CookieStore getCookieStore();

    RequestOptionsInterface setCookieStore(
            CookieStore cookieStore
    );

    boolean getAllowRedirects();

    RequestOptionsInterface setAllowRedirects(
            boolean allowRedirects
    );

    boolean getAllowCircularRedirects();

    RequestOptionsInterface setAllowCircularRedirects(
            boolean allowCircularRedirects
    );

    boolean getAllowRelativeRedirects();

    RequestOptionsInterface setAllowRelativeRedirects(
            boolean allowRelativeRedirects
    );

    RequestOptionsInterface setAllowedRedirects(
            boolean enableRedirects,
            boolean enableRelativeRedirects,
            boolean enableCircularRedirects
    );

    RedirectHandler getRedirectHandler();

    RequestOptionsInterface setRedirectHandler(
            RedirectHandler handler
    );

    String getUserAgent();

    RequestOptionsInterface setUserAgent(
            String userAgent
    );

    int getConnectTimeout();

    RequestOptionsInterface setConnectTimeout(
            int connectTimeout
    );

    int getResponseTimeout();

    RequestOptionsInterface setResponseTimeout(
            int responseTimeout
    );

    int getMaxAllowedRetries();

    RequestOptionsInterface setMaxAllowedRetries(
            int maxRetries
    );

    boolean getGzipSupportEnabled();

    RequestOptionsInterface setGzipSupportEnabled(
            boolean gzipSupportEnabled
    );

    RequestOptionsInterface setUseSynchronous(
            boolean useSynchronous
    );

    boolean getUseSynchronous();

}
