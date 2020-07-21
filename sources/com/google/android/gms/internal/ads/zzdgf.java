package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgf implements zzela<ApplicationInfo> {
    private final zzdgd zzgvx;

    public zzdgf(zzdgd zzdgd) {
        this.zzgvx = zzdgd;
    }

    public static ApplicationInfo zzb(zzdgd zzdgd) {
        return (ApplicationInfo) zzelg.zza(zzdgd.zzarm(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzgvx);
    }
}
