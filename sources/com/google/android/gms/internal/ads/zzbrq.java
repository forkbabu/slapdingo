package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrq {
    private final String packageName;
    private final zzbbd zzbov;
    private final PackageInfo zzdpk;
    private final List<String> zzdpu;
    private final String zzdss;
    private final zzaxx zzdyn;
    private final zzdou zzfpw;
    private final ApplicationInfo zzfqu;
    private final zzeku<zzdvf<String>> zzfqv;
    private final zzdeb<Bundle> zzfqw;

    public zzbrq(zzdou zzdou, zzbbd zzbbd, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeku<zzdvf<String>> zzeku, zzaxx zzaxx, String str2, zzdeb<Bundle> zzdeb) {
        this.zzfpw = zzdou;
        this.zzbov = zzbbd;
        this.zzfqu = applicationInfo;
        this.packageName = str;
        this.zzdpu = list;
        this.zzdpk = packageInfo;
        this.zzfqv = zzeku;
        this.zzdyn = zzaxx;
        this.zzdss = str2;
        this.zzfqw = zzdeb;
    }

    public final zzdvf<Bundle> zzais() {
        return this.zzfpw.zzu(zzdor.SIGNALS).zze(this.zzfqw.zzt(new Bundle())).zzaus();
    }

    public final zzdvf<zzasm> zzait() {
        zzdvf<Bundle> zzais = zzais();
        return this.zzfpw.zza(zzdor.REQUEST_PARCEL, zzais, this.zzfqv.get()).zzb(new zzbrt(this, zzais)).zzaus();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzasm zzc(zzdvf zzdvf) throws Exception {
        return new zzasm((Bundle) zzdvf.get(), this.zzbov, this.zzfqu, this.packageName, this.zzdpu, this.zzdpk, this.zzfqv.get().get(), this.zzdyn.zzwx(), this.zzdss, null, null);
    }
}
