package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdew implements zzdec<zzdet> {
    private final Executor executor;
    private final PackageInfo zzdpk;
    private final zzaxd zzguy;
    private final String zzgvb;

    public zzdew(zzaxd zzaxd, Executor executor2, String str, PackageInfo packageInfo) {
        this.zzguy = zzaxd;
        this.executor = executor2;
        this.zzgvb = str;
        this.zzdpk = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdet> zzaqm() {
        return zzdux.zzb(zzdux.zzb(this.zzguy.zza(this.zzgvb, this.zzdpk), zzdev.zzdvt, this.executor), Throwable.class, new zzdey(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzg(Throwable th) throws Exception {
        return zzdux.zzaf(new zzdet(this.zzgvb));
    }
}
