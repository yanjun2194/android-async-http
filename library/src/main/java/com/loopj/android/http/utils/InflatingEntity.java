package com.loopj.android.http.utils;

import com.loopj.android.http.AsyncHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapperHC4;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.GZIPInputStream;

public class InflatingEntity extends HttpEntityWrapperHC4 {

    public InflatingEntity(HttpEntity wrapped) {
        super(wrapped);
    }

    InputStream wrappedStream;
    PushbackInputStream pushbackStream;
    GZIPInputStream gzippedStream;

    @Override
    public InputStream getContent() throws IOException {
        wrappedStream = wrappedEntity.getContent();
        pushbackStream = new PushbackInputStream(wrappedStream, 2);
        if (isInputStreamGZIPCompressed(pushbackStream)) {
            gzippedStream = new GZIPInputStream(pushbackStream);
            return gzippedStream;
        } else {
            return pushbackStream;
        }
    }

    @Override
    public long getContentLength() {
        return wrappedEntity == null ? 0 : wrappedEntity.getContentLength();
    }

    /**
     * Checks the InputStream if it contains  GZIP compressed data
     *
     * @param inputStream InputStream to be checked
     * @return true or false if the stream contains GZIP compressed data
     * @throws java.io.IOException
     */
    public static boolean isInputStreamGZIPCompressed(final PushbackInputStream inputStream) throws IOException {
        if (inputStream == null)
            return false;

        byte[] signature = new byte[2];
        int readStatus = inputStream.read(signature);
        inputStream.unread(signature);
        int streamHeader = ((int) signature[0] & 0xff) | ((signature[1] << 8) & 0xff00);
        return readStatus == 2 && GZIPInputStream.GZIP_MAGIC == streamHeader;
    }
}