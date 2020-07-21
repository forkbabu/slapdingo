package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnw implements zzela<zzbyg<zzbwd>> {
    private final zzbnj zzfnw;
    private final zzelj<zzbus> zzfoa;

    public zzbnw(zzbnj zzbnj, zzelj<zzbus> zzelj) {
        this.zzfnw = zzbnj;
        this.zzfoa = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(new zzbnl(this.zzfoa.get()), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
