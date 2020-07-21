package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcwx implements Runnable {
    private final zzcwv zzgpn;
    private final zzuy zzgpo;

    zzcwx(zzcwv zzcwv, zzuy zzuy) {
        this.zzgpn = zzcwv;
        this.zzgpo = zzuy;
    }

    public final void run() {
        this.zzgpn.zzgpl.zzgpa.onAdFailedToLoad(this.zzgpo.errorCode);
    }
}
