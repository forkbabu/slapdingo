package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgd {
    private final zzasm zzghk;
    private final int zzgvi;

    public zzdgd(zzasm zzasm, int i) {
        this.zzghk = zzasm;
        this.zzgvi = i;
    }

    public final String zzarh() {
        return this.zzghk.packageName;
    }

    public final String zzari() {
        return this.zzghk.zzdsq.getString("ms");
    }

    public final PackageInfo zzarj() {
        return this.zzghk.zzdpk;
    }

    public final boolean zzark() {
        return this.zzghk.zzdsr;
    }

    public final List<String> zzarl() {
        return this.zzghk.zzdpu;
    }

    public final ApplicationInfo zzarm() {
        return this.zzghk.applicationInfo;
    }

    public final String zzarn() {
        return this.zzghk.zzdss;
    }

    public final int zzaro() {
        return this.zzgvi;
    }
}
