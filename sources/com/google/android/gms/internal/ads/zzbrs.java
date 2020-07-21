package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrs implements zzela<zzbrq> {
    private final zzelj<zzaxx> zzexy;
    private final zzelj<zzdeb<Bundle>> zzfau;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<zzdou> zzfoc;
    private final zzelj<ApplicationInfo> zzfqy;
    private final zzelj<String> zzfqz;
    private final zzelj<List<String>> zzfra;
    private final zzelj<PackageInfo> zzfrb;
    private final zzelj<zzdvf<String>> zzfrc;
    private final zzelj<String> zzfrd;

    private zzbrs(zzelj<zzdou> zzelj, zzelj<zzbbd> zzelj2, zzelj<ApplicationInfo> zzelj3, zzelj<String> zzelj4, zzelj<List<String>> zzelj5, zzelj<PackageInfo> zzelj6, zzelj<zzdvf<String>> zzelj7, zzelj<zzaxx> zzelj8, zzelj<String> zzelj9, zzelj<zzdeb<Bundle>> zzelj10) {
        this.zzfoc = zzelj;
        this.zzfmh = zzelj2;
        this.zzfqy = zzelj3;
        this.zzfqz = zzelj4;
        this.zzfra = zzelj5;
        this.zzfrb = zzelj6;
        this.zzfrc = zzelj7;
        this.zzexy = zzelj8;
        this.zzfrd = zzelj9;
        this.zzfau = zzelj10;
    }

    public static zzbrs zza(zzelj<zzdou> zzelj, zzelj<zzbbd> zzelj2, zzelj<ApplicationInfo> zzelj3, zzelj<String> zzelj4, zzelj<List<String>> zzelj5, zzelj<PackageInfo> zzelj6, zzelj<zzdvf<String>> zzelj7, zzelj<zzaxx> zzelj8, zzelj<String> zzelj9, zzelj<zzdeb<Bundle>> zzelj10) {
        return new zzbrs(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9, zzelj10);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbrq(this.zzfoc.get(), this.zzfmh.get(), this.zzfqy.get(), this.zzfqz.get(), this.zzfra.get(), this.zzfrb.get(), zzekx.zzat(this.zzfrc), this.zzexy.get(), this.zzfrd.get(), this.zzfau.get());
    }
}
