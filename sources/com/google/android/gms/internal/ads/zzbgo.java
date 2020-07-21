package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbgo implements Runnable {
    private final String zzdfg;
    private final zzbgm zzeow;

    zzbgo(zzbgm zzbgm, String str) {
        this.zzeow = zzbgm;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzeow.zzft(this.zzdfg);
    }
}
