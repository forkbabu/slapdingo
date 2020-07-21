package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbkj implements Runnable {
    private final zzbkg zzfjw;
    private final Runnable zzfjx;

    zzbkj(zzbkg zzbkg, Runnable runnable) {
        this.zzfjw = zzbkg;
        this.zzfjx = runnable;
    }

    public final void run() {
        zzbbf.zzedl.execute(new zzbki(this.zzfjw, this.zzfjx));
    }
}
