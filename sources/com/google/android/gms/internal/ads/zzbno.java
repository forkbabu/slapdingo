package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbno implements zzela<zzbnc> {
    private final zzelj<zzbne> zzfgf;
    private final zzbnj zzfnw;

    public zzbno(zzbnj zzbnj, zzelj<zzbne> zzelj) {
        this.zzfnw = zzbnj;
        this.zzfgf = zzelj;
    }

    public static zzbnc zza(zzbnj zzbnj, Object obj) {
        return (zzbnc) zzelg.zza((zzbne) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw, this.zzfgf.get());
    }
}
