package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvt<AdT> implements zzcqt<AdT> {
    private final zzdou zzfpw;
    private final zzdvi zzgnn;
    private final zzabo zzgnt;
    /* access modifiers changed from: private */
    public final zzcvu<AdT> zzgoc;

    public zzcvt(zzdou zzdou, zzdvi zzdvi, zzabo zzabo, zzcvu<AdT> zzcvu) {
        this.zzfpw = zzdou;
        this.zzgnn = zzdvi;
        this.zzgnt = zzabo;
        this.zzgoc = zzcvu;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (this.zzgnt == null || zzdkk.zzgzr == null || zzdkk.zzgzr.zzdoh == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<AdT> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        zzbbn zzbbn = new zzbbn();
        zzcwb zzcwb = new zzcwb();
        zzcwb.zza(new zzcvv(this, zzbbn, zzdkw, zzdkk, zzcwb));
        return this.zzfpw.zzu(zzdor.CUSTOM_RENDER_SYN).zza(new zzcvs(this, new zzabl(zzcwb, zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh)), this.zzgnn).zzw(zzdor.CUSTOM_RENDER_ACK).zze(zzbbn).zzaus();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzabl zzabl) throws Exception {
        this.zzgnt.zza(zzabl);
    }
}
