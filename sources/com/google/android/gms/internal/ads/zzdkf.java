package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdkf implements zzela<zzdke> {
    private final zzelj<zzdkv> zzfim;
    private final zzelj<zzdjq> zzgwt;
    private final zzelj<zzdiu> zzgwu;

    public zzdkf(zzelj<zzdjq> zzelj, zzelj<zzdiu> zzelj2, zzelj<zzdkv> zzelj3) {
        this.zzgwt = zzelj;
        this.zzgwu = zzelj2;
        this.zzfim = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdke(this.zzgwt.get(), this.zzgwu.get(), this.zzfim.get());
    }
}
