package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcvh implements zzdoe {
    private final zzdkk zzfnu;
    private final zzdkw zzgao;
    private final zzcqv zzgni;
    private final zzcve zzgno;

    zzcvh(zzcve zzcve, zzdkw zzdkw, zzdkk zzdkk, zzcqv zzcqv) {
        this.zzgno = zzcve;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
        this.zzgni = zzcqv;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final void run() {
        this.zzgno.zzd(this.zzgao, this.zzfnu, this.zzgni);
    }
}
