package com.loopj.android.http.utils;

import android.util.Log;

public class Logger {

    private static volatile boolean loggingEnabled = false;
    private static volatile int logVerbosity = Log.WARN;

    public static void enableLogging() {
        Logger.loggingEnabled = true;
    }

    public static void disableLogging() {
        Logger.loggingEnabled = false;
    }

    public static void setLogVerbosity(int logVerbosity) {
        if (logVerbosity < Log.VERBOSE) logVerbosity = Log.VERBOSE;
        else if (logVerbosity > Log.ASSERT) logVerbosity = Log.ASSERT;
        Logger.logVerbosity = logVerbosity;
    }

    public static void e(String LOG_TAG, String message) {
        e(LOG_TAG, message, null);
    }

    public static void e(String LOG_TAG, String message, Throwable t) {
        if (loggingEnabled && logVerbosity >= Log.ERROR) {
            Log.e(LOG_TAG, message, t);
        }
    }

    public static void i(String LOG_TAG, String message) {
        i(LOG_TAG, message, null);
    }

    public static void i(String LOG_TAG, String message, Throwable t) {
        if (loggingEnabled && logVerbosity >= Log.INFO) {
            Log.i(LOG_TAG, message, t);
        }
    }

    public static void w(String LOG_TAG, String message) {
        w(LOG_TAG, message, null);
    }

    public static void w(String LOG_TAG, String message, Throwable t) {
        if (loggingEnabled && logVerbosity >= Log.WARN) {
            Log.w(LOG_TAG, message, t);
        }
    }

    public static void d(String LOG_TAG, String message) {
        d(LOG_TAG, message, null);
    }

    public static void d(String LOG_TAG, String message, Throwable t) {
        if (loggingEnabled && logVerbosity >= Log.DEBUG) {
            Log.d(LOG_TAG, message, t);
        }
    }

    public static void v(String LOG_TAG, String message) {
        v(LOG_TAG, message, null);
    }

    public static void v(String LOG_TAG, String message, Throwable t) {
        if (loggingEnabled && logVerbosity >= Log.VERBOSE) {
            Log.d(LOG_TAG, message, t);
        }
    }

}
