package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdck implements zzela<zzdcd> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzaxx> zzexy;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<PackageInfo> zzfrb;

    public zzdck(zzelj<zzdvi> zzelj, zzelj<zzdla> zzelj2, zzelj<PackageInfo> zzelj3, zzelj<zzaxx> zzelj4) {
        this.zzerc = zzelj;
        this.zzfnz = zzelj2;
        this.zzfrb = zzelj3;
        this.zzexy = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdcd(this.zzerc.get(), this.zzfnz.get(), this.zzfrb.get(), this.zzexy.get());
    }
}
