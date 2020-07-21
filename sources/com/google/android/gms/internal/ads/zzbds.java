package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbds implements Runnable {
    private final boolean zzefs;
    private final zzbdi zzeii;
    private final long zzeiu;

    zzbds(zzbdi zzbdi, boolean z, long j) {
        this.zzeii = zzbdi;
        this.zzefs = z;
        this.zzeiu = j;
    }

    public final void run() {
        this.zzeii.zzc(this.zzefs, this.zzeiu);
    }
}
