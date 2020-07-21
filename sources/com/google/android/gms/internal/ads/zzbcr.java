package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcr implements Runnable {
    private final /* synthetic */ zzbco zzefq;
    private final /* synthetic */ boolean zzeft;

    zzbcr(zzbco zzbco, boolean z) {
        this.zzefq = zzbco;
        this.zzeft = z;
    }

    public final void run() {
        this.zzefq.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzeft));
    }
}
