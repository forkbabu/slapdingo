package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbov implements zzela<zzbos> {
    private final zzelj<zzdkk> zzfkx;
    private final zzelj<zzbtc> zzfou;
    private final zzelj<zzbue> zzfov;

    private zzbov(zzelj<zzdkk> zzelj, zzelj<zzbtc> zzelj2, zzelj<zzbue> zzelj3) {
        this.zzfkx = zzelj;
        this.zzfou = zzelj2;
        this.zzfov = zzelj3;
    }

    public static zzbov zzf(zzelj<zzdkk> zzelj, zzelj<zzbtc> zzelj2, zzelj<zzbue> zzelj3) {
        return new zzbov(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbos(this.zzfkx.get(), this.zzfou.get(), this.zzfov.get());
    }
}
