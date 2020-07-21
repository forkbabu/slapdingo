package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgc implements zzdec<zzdfz> {
    private ScheduledExecutorService zzfkm;
    private zzaqq zzgvw;
    private Context zzvr;

    public zzdgc(zzaqq zzaqq, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgvw = zzaqq;
        this.zzfkm = scheduledExecutorService;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfz> zzaqm() {
        return zzdux.zzb(zzdux.zza(this.zzgvw.zzr(this.zzvr), ((Long) zzwg.zzpw().zzd(zzaav.zzcsc)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm), zzdgb.zzdvt, zzbbf.zzedh);
    }
}
