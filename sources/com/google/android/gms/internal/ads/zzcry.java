package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcry implements Runnable {
    private final zzdkk zzfnu;
    private final zzdkw zzgao;
    private final zzcrw zzgld;

    zzcry(zzcrw zzcrw, zzdkw zzdkw, zzdkk zzdkk) {
        this.zzgld = zzcrw;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
    }

    public final void run() {
        this.zzgld.zzd(this.zzgao, this.zzfnu);
    }
}
