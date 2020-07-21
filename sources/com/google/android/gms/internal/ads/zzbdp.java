package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbdp implements Runnable {
    private final int zzeak;
    private final zzbdi zzeii;

    zzbdp(zzbdi zzbdi, int i) {
        this.zzeii = zzbdi;
        this.zzeak = i;
    }

    public final void run() {
        this.zzeii.zzdp(this.zzeak);
    }
}
