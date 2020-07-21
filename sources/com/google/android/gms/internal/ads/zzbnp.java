package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnp implements zzela<zzboy> {
    private final zzbnj zzfnw;

    public zzbnp(zzbnj zzbnj) {
        this.zzfnw = zzbnj;
    }

    public static zzboy zzc(zzbnj zzbnj) {
        return (zzboy) zzelg.zza(zzbnj.zzaht(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzc(this.zzfnw);
    }
}
