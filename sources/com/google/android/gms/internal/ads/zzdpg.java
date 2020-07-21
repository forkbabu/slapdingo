package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdpg implements Runnable {
    private final String zzdfg;
    private final zzdpd zzhhb;

    zzdpg(zzdpd zzdpd, String str) {
        this.zzhhb = zzdpd;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzhhb.zzgy(this.zzdfg);
    }
}
