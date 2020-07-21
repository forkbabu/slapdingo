package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxu implements Runnable {
    private final zzuy zzgpo;
    private final zzcxs zzgql;

    zzcxu(zzcxs zzcxs, zzuy zzuy) {
        this.zzgql = zzcxs;
        this.zzgpo = zzuy;
    }

    public final void run() {
        this.zzgql.zzgqk.zzgqg.zzaqd().onAdFailedToLoad(this.zzgpo.errorCode);
    }
}
