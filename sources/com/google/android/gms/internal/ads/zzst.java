package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzst implements Runnable {
    private final /* synthetic */ zzsq zzbuu;

    zzst(zzsq zzsq) {
        this.zzbuu = zzsq;
    }

    public final void run() {
        this.zzbuu.disconnect();
    }
}
