package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbod implements zzela<zzcqt<zzbnc>> {
    private final zzelj<zzcve<zzbnc, zzdlm, zzcsd>> zzfbm;
    private final zzelj<Boolean> zzfgt;
    private final zzelj<zzctm> zzfgv;

    public zzbod(zzelj<Boolean> zzelj, zzelj<zzctm> zzelj2, zzelj<zzcve<zzbnc, zzdlm, zzcsd>> zzelj3) {
        this.zzfgt = zzelj;
        this.zzfgv = zzelj2;
        this.zzfbm = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfgt.get().booleanValue();
        zzctm zzctm = this.zzfgv.get();
        zzcve<zzbnc, zzdlm, zzcsd> zzcve = this.zzfbm.get();
        if (!booleanValue) {
            zzctm = zzcve;
        }
        return (zzcqt) zzelg.zza(zzctm, "Cannot return null from a non-@Nullable @Provides method");
    }
}
