package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbv implements zzela<zzccs> {
    private final zzcbr zzfvs;
    private final zzelj<zzcbk> zzfvu;

    public zzcbv(zzcbr zzcbr, zzelj<zzcbk> zzelj) {
        this.zzfvs = zzcbr;
        this.zzfvu = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzccs) zzelg.zza(this.zzfvu.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
