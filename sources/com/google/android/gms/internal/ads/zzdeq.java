package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdeq implements zzdec<zzden> {
    private final Executor executor;
    private final ScheduledExecutorService zzfkm;
    private final zzaxd zzguy;
    private final Context zzvr;

    public zzdeq(zzaxd zzaxd, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzguy = zzaxd;
        this.zzvr = context;
        this.zzfkm = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzden> zzaqm() {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcoe)).booleanValue()) {
            return zzdux.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzduo.zzg(this.zzguy.zzal(this.zzvr)).zza(zzdep.zzdvt, this.executor).zza(((Long) zzwg.zzpw().zzd(zzaav.zzcof)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm).zza(Throwable.class, new zzdes(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzden zzf(Throwable th) {
        zzwg.zzps();
        return new zzden(null, zzbaq.zzbo(this.zzvr));
    }
}
