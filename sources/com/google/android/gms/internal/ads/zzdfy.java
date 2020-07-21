package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfy implements zzdec<zzdfv> {
    private ApplicationInfo applicationInfo;
    private boolean zzdsr;
    private ScheduledExecutorService zzfkm;
    private zzame zzgsw;

    public zzdfy(zzame zzame, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo2) {
        this.zzgsw = zzame;
        this.zzfkm = scheduledExecutorService;
        this.zzdsr = z;
        this.applicationInfo = applicationInfo2;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfv> zzaqm() {
        if (!zzaca.zzcyw.get().booleanValue()) {
            return zzdux.immediateFailedFuture(new Exception("Auto Collect Location by gms is disabled."));
        }
        if (!this.zzdsr) {
            return zzdux.immediateFailedFuture(new Exception("Auto Collect Location is false."));
        }
        return zzdux.zzb(zzdux.zza(this.zzgsw.zza(this.applicationInfo), ((Long) zzwg.zzpw().zzd(zzaav.zzcru)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm), zzdfx.zzdvt, zzbbf.zzedh);
    }
}
