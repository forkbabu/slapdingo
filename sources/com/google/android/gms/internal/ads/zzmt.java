package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmt implements Runnable {
    private final /* synthetic */ zzmp zzbdd;
    private final /* synthetic */ IOException zzbej;

    zzmt(zzmp zzmp, IOException iOException) {
        this.zzbdd = zzmp;
        this.zzbej = iOException;
    }

    public final void run() {
        this.zzbdd.zzbdf.zzb(this.zzbej);
    }
}
