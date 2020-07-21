package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbps implements zzela<zzdkw> {
    private final zzbpr zzfpo;

    private zzbps(zzbpr zzbpr) {
        this.zzfpo = zzbpr;
    }

    public static zzbps zzc(zzbpr zzbpr) {
        return new zzbps(zzbpr);
    }

    public static zzdkw zzd(zzbpr zzbpr) {
        return (zzdkw) zzelg.zza(zzbpr.zzaim(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzd(this.zzfpo);
    }
}
