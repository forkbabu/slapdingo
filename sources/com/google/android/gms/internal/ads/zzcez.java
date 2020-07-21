package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcez implements zzela<zzceu> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzcey> zzgat;
    private final zzelj<zzcfi> zzgau;

    public zzcez(zzelj<zzdvi> zzelj, zzelj<zzcey> zzelj2, zzelj<zzcfi> zzelj3) {
        this.zzerc = zzelj;
        this.zzgat = zzelj2;
        this.zzgau = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzceu(this.zzerc.get(), this.zzgat.get(), this.zzgau.get());
    }
}
