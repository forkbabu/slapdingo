package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchr implements zzela<zzcqt<zzchj>> {
    private final zzelj<zzcve<zzchj, zzdlm, zzcsc>> zzfmd;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzcve<zzchj, zzdlm, zzcsd>> zzgci;

    public zzchr(zzelj<zzcve<zzchj, zzdlm, zzcsc>> zzelj, zzelj<zzcve<zzchj, zzdlm, zzcsd>> zzelj2, zzelj<zzdla> zzelj3) {
        this.zzfmd = zzelj;
        this.zzgci = zzelj2;
        this.zzfnz = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzcqt zzcqt;
        zzelj<zzcve<zzchj, zzdlm, zzcsc>> zzelj = this.zzfmd;
        zzelj<zzcve<zzchj, zzdlm, zzcsd>> zzelj2 = this.zzgci;
        if (zzcho.zzgch[this.zzfnz.get().zzhbf.zzhaj - 1] != 1) {
            zzcqt = zzelj2.get();
        } else {
            zzcqt = zzelj.get();
        }
        return (zzcqt) zzelg.zza(zzcqt, "Cannot return null from a non-@Nullable @Provides method");
    }
}
