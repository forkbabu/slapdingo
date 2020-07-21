package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    public DataBufferResponse() {
    }

    public DataBufferResponse(R r) {
        super(r);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        return getResult().getCount();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public T get(int i) {
        return getResult().get(i);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle getMetadata() {
        return getResult().getMetadata();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getResult().close();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public boolean isClosed() {
        return getResult().isClosed();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        return getResult().iterator();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return getResult().singleRefIterator();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        getResult().release();
    }
}
