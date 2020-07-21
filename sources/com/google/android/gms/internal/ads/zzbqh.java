package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqh implements zzela<zzbyg<zzbsl>> {
    private final zzbqf zzfqh;
    private final zzelj<zzbqk> zzfqi;

    private zzbqh(zzbqf zzbqf, zzelj<zzbqk> zzelj) {
        this.zzfqh = zzbqf;
        this.zzfqi = zzelj;
    }

    public static zzbqh zzc(zzbqf zzbqf, zzelj<zzbqk> zzelj) {
        return new zzbqh(zzbqf, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfqi.get(), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
