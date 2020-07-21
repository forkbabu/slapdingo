package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbfg implements Runnable {
    private final boolean zzefs;
    private final long zzeiu;
    private final zzbdb zzeld;

    zzbfg(zzbdb zzbdb, boolean z, long j) {
        this.zzeld = zzbdb;
        this.zzefs = z;
        this.zzeiu = j;
    }

    public final void run() {
        this.zzeld.zza(this.zzefs, this.zzeiu);
    }
}
