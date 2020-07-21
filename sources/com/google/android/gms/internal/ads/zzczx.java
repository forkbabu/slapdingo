package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczx implements zzela<zzczv> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzdla> zzfnz;

    private zzczx(zzelj<zzdvi> zzelj, zzelj<zzdla> zzelj2) {
        this.zzerc = zzelj;
        this.zzfnz = zzelj2;
    }

    public static zzczx zzax(zzelj<zzdvi> zzelj, zzelj<zzdla> zzelj2) {
        return new zzczx(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzczv(this.zzerc.get(), this.zzfnz.get());
    }
}
