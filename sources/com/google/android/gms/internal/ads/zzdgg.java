package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgg implements zzela<String> {
    private final zzdgd zzgvx;

    public zzdgg(zzdgd zzdgd) {
        this.zzgvx = zzdgd;
    }

    public static String zzc(zzdgd zzdgd) {
        return (String) zzelg.zza(zzdgd.zzarh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzc(this.zzgvx);
    }
}
