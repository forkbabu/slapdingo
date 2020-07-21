package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zztl extends PushbackInputStream {
    private final /* synthetic */ zztg zzbvn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zztl(zztg zztg, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbvn = zztg;
    }

    @Override // java.io.FilterInputStream, java.io.PushbackInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final synchronized void close() throws IOException {
        this.zzbvn.zzbvg.disconnect();
        super.close();
    }
}
