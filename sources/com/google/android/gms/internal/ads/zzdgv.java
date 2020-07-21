package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdgv implements Runnable {
    private final zzuy zzgpo;
    private final zzdgw zzgwe;

    zzdgv(zzdgw zzdgw, zzuy zzuy) {
        this.zzgwe = zzdgw;
        this.zzgpo = zzuy;
    }

    public final void run() {
        this.zzgwe.zzgwg.zzgwb.onAdFailedToLoad(this.zzgpo.errorCode);
    }
}
