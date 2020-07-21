package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcaf implements zzela<zzcac> {
    private final zzelj<zzbui> zzevu;
    private final zzelj<zzbyc> zzfih;

    private zzcaf(zzelj<zzbui> zzelj, zzelj<zzbyc> zzelj2) {
        this.zzevu = zzelj;
        this.zzfih = zzelj2;
    }

    public static zzcaf zzv(zzelj<zzbui> zzelj, zzelj<zzbyc> zzelj2) {
        return new zzcaf(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcac(this.zzevu.get(), this.zzfih.get());
    }
}
