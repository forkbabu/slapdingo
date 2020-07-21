package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbdj implements Runnable {
    private final String zzdfg;
    private final zzbdi zzeii;

    zzbdj(zzbdi zzbdi, String str) {
        this.zzeii = zzbdi;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzeii.zzfj(this.zzdfg);
    }
}
