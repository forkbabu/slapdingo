package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnm implements zzela<zzdkj> {
    private final zzbnj zzfnw;

    public zzbnm(zzbnj zzbnj) {
        this.zzfnw = zzbnj;
    }

    public static zzdkj zza(zzbnj zzbnj) {
        return (zzdkj) zzelg.zza(zzbnj.zzahu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw);
    }
}
