package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcuz implements Runnable {
    private final zzdkk zzfnu;
    private final zzdkw zzgao;
    private final zzcuw zzgnh;
    private final zzcqv zzgni;

    zzcuz(zzcuw zzcuw, zzdkw zzdkw, zzdkk zzdkk, zzcqv zzcqv) {
        this.zzgnh = zzcuw;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
        this.zzgni = zzcqv;
    }

    public final void run() {
        zzcuw zzcuw = this.zzgnh;
        zzcuu.zzc(this.zzgao, this.zzfnu, this.zzgni);
    }
}
