package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpt implements zzela<String> {
    private final zzbpr zzfpo;

    private zzbpt(zzbpr zzbpr) {
        this.zzfpo = zzbpr;
    }

    public static zzbpt zze(zzbpr zzbpr) {
        return new zzbpt(zzbpr);
    }

    public static String zzf(zzbpr zzbpr) {
        return (String) zzelg.zza(zzbpr.zzaio(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzf(this.zzfpo);
    }
}
