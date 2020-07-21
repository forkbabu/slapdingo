package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbe implements zzdec<zzdbb> {
    private ApplicationInfo applicationInfo;
    private zzaxx zzdyn;
    private ScheduledExecutorService zzfkm;
    zzdla zzfpv;
    private zzame zzgsw;

    public zzdbe(zzame zzame, ScheduledExecutorService scheduledExecutorService, zzaxx zzaxx, ApplicationInfo applicationInfo2, zzdla zzdla) {
        this.zzgsw = zzame;
        this.zzfkm = scheduledExecutorService;
        this.zzdyn = zzaxx;
        this.applicationInfo = applicationInfo2;
        this.zzfpv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdbb> zzaqm() {
        zzdvf zzdvf;
        if (!zzaca.zzcyv.get().booleanValue()) {
            zzdvf = zzdux.zzaf(null);
        } else if (!this.zzdyn.zzwx()) {
            zzdvf = zzdux.zzaf(null);
        } else {
            zzdvf = zzdux.zzb(zzdux.zza(this.zzgsw.zza(this.applicationInfo), ((Long) zzwg.zzpw().zzd(zzaav.zzcru)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm), Throwable.class, zzdbf.zzboi, zzbbf.zzedm);
        }
        return zzdux.zzb(zzdux.zzb(zzdvf, new zzdbg(this), this.zzfkm), zzdbd.zzdvt, zzbbf.zzedh);
    }
}
