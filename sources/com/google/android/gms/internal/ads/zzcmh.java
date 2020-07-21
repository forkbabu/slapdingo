package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmh implements Runnable {
    private final String zzdfg;
    private final zzcme zzgga;

    zzcmh(zzcme zzcme, String str) {
        this.zzgga = zzcme;
        this.zzdfg = str;
    }

    public final void run() {
        zzcme zzcme = this.zzgga;
        zzcme.zzgfv.zzgk(this.zzdfg);
    }
}
