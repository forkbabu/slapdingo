package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcs implements Runnable {
    private final /* synthetic */ zzbco zzefq;

    zzbcs(zzbco zzbco) {
        this.zzefq = zzbco;
    }

    public final void run() {
        this.zzefq.zzd("surfaceDestroyed", new String[0]);
    }
}
