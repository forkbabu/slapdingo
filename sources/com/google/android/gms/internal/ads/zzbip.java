package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbip implements zzela<zzbbd> {
    private final zzbie zzeqy;

    public zzbip(zzbie zzbie) {
        this.zzeqy = zzbie;
    }

    public static zzbbd zzb(zzbie zzbie) {
        return (zzbbd) zzelg.zza(zzbie.zzadb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzeqy);
    }
}
