package com.loopj.android.http.interfaces;

import com.loopj.android.http.impl.FileParam;
import com.loopj.android.http.impl.StreamParam;

import org.apache.http.HeaderElement;

import java.io.Serializable;
import java.util.List;

public interface RequestParamsInterface extends Serializable {

    RequestParamsInterface add(RequestParamInterface param);

    RequestParamsInterface remove(RequestParamInterface param);

    List<RequestParamsInterface> getAllParams();

    RequestParamsInterface addHeader(HeaderElement header);

    RequestParamsInterface addHeaders(HeaderElement... headers);

    RequestParamsInterface removeHeader(HeaderElement header);

    RequestParamsInterface addFile(FileParam fileParam);

    RequestParamsInterface addFiles(FileParam... fileParams);

    RequestParamsInterface removeFile(FileParam fileParam);

    RequestParamsInterface addStream(StreamParam streamParam);

    RequestParamsInterface addStreams(StreamParam... streamParams);

    RequestParamsInterface removeStream(StreamParam streamParam);

}
