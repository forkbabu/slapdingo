package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkf implements zzela<zzame> {
    private final zzbkb zzfjq;

    public zzbkf(zzbkb zzbkb) {
        this.zzfjq = zzbkb;
    }

    public static zzame zzb(zzbkb zzbkb) {
        return (zzame) zzelg.zza(zzbkb.zzaed(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfjq);
    }
}
