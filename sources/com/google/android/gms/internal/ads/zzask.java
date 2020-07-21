package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzask implements Runnable {
    private final OutputStream zzdso;
    private final byte[] zzdsp;

    zzask(OutputStream outputStream, byte[] bArr) {
        this.zzdso = outputStream;
        this.zzdsp = bArr;
    }

    public final void run() {
        zzash.zza(this.zzdso, this.zzdsp);
    }
}
