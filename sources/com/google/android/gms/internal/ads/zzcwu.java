package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcwu implements Runnable {
    private final zzcxb zzgpj;

    private zzcwu(zzcxb zzcxb) {
        this.zzgpj = zzcxb;
    }

    static Runnable zzb(zzcxb zzcxb) {
        return new zzcwu(zzcxb);
    }

    public final void run() {
        this.zzgpj.onAdLoaded();
    }
}
