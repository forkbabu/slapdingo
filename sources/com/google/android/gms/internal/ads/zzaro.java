package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzaro implements Runnable {
    private final String zzdfg;
    private final zzbbe zzdpg;

    zzaro(zzbbe zzbbe, String str) {
        this.zzdpg = zzbbe;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzdpg.zzer(this.zzdfg);
    }
}
