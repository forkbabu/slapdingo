package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbcq implements Runnable {
    private final zzbco zzefr;
    private final boolean zzefs;

    zzbcq(zzbco zzbco, boolean z) {
        this.zzefr = zzbco;
        this.zzefs = z;
    }

    public final void run() {
        this.zzefr.zzau(this.zzefs);
    }
}
