package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcp implements zzddz<Bundle>, zzdec<zzddz<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdpk;

    zzdcp(ApplicationInfo applicationInfo2, PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdpk = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        return zzdux.zzaf(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdpk;
        String str2 = null;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcva)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdpk;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}
