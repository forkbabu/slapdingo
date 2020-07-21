package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcs implements zzela<zzdcp> {
    private final zzelj<PackageInfo> zzfrb;
    private final zzelj<ApplicationInfo> zzggq;

    private zzdcs(zzelj<ApplicationInfo> zzelj, zzelj<PackageInfo> zzelj2) {
        this.zzggq = zzelj;
        this.zzfrb = zzelj2;
    }

    public static zzdcs zzbd(zzelj<ApplicationInfo> zzelj, zzelj<PackageInfo> zzelj2) {
        return new zzdcs(zzelj, zzelj2);
    }

    public static zzdcp zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdcp(applicationInfo, packageInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzggq.get(), this.zzfrb.get());
    }
}
