package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmy implements zzela<PackageInfo> {
    private final zzelj<Context> zzere;
    private final zzelj<ApplicationInfo> zzggq;

    private zzcmy(zzelj<Context> zzelj, zzelj<ApplicationInfo> zzelj2) {
        this.zzere = zzelj;
        this.zzggq = zzelj2;
    }

    public static zzcmy zzaq(zzelj<Context> zzelj, zzelj<ApplicationInfo> zzelj2) {
        return new zzcmy(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzcmo.zza(this.zzere.get(), this.zzggq.get());
    }
}
