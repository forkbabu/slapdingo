package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcuw implements zzbyx {
    private final /* synthetic */ zzdkk zzgmm;
    private final /* synthetic */ zzdkw zzgna;
    private final /* synthetic */ zzcqv zzgnb;
    final /* synthetic */ zzcuu zzgnc;

    zzcuw(zzcuu zzcuu, zzdkw zzdkw, zzdkk zzdkk, zzcqv zzcqv) {
        this.zzgnc = zzcuu;
        this.zzgna = zzdkw;
        this.zzgmm = zzdkk;
        this.zzgnb = zzcqv;
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final void onInitializationSucceeded() {
        this.zzgnc.zzflp.execute(new zzcuz(this, this.zzgna, this.zzgmm, this.zzgnb));
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final void zzdv(int i) {
        String valueOf = String.valueOf(this.zzgnb.zzfpp);
        zzaxv.zzfd(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
