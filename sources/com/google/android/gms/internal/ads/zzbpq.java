package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpq implements zzela<zzdkk> {
    private final zzbpr zzfpo;

    private zzbpq(zzbpr zzbpr) {
        this.zzfpo = zzbpr;
    }

    public static zzbpq zza(zzbpr zzbpr) {
        return new zzbpq(zzbpr);
    }

    public static zzdkk zzb(zzbpr zzbpr) {
        return (zzdkk) zzelg.zza(zzbpr.zzain(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfpo);
    }
}
