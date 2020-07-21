package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpi {
    private final Executor executor;
    private volatile boolean zzaeu = true;
    private final ScheduledExecutorService zzfkm;
    private final zzdvf<zzbph> zzfph;

    public zzbpi(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdvf<zzbph> zzdvf) {
        this.executor = executor2;
        this.zzfkm = scheduledExecutorService;
        this.zzfph = zzdvf;
    }

    public final void zza(zzduu<zzbpb> zzduu) {
        zzdux.zza(this.zzfph, new zzbpp(this, zzduu), this.executor);
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzdvf<? extends zzbpb>> list, zzduu<zzbpb> zzduu) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new zzbpl(zzduu));
            return;
        }
        zzdvf zzaf = zzdux.zzaf(null);
        Iterator<? extends zzdvf<? extends zzbpb>> it2 = list.iterator();
        while (it2.hasNext()) {
            zzaf = zzdux.zzb(zzdux.zzb(zzaf, Throwable.class, new zzbpk(zzduu), this.executor), new zzbpn(this, zzduu, (zzdvf) it2.next()), this.executor);
        }
        zzdux.zza(zzaf, new zzbpo(this, zzduu), this.executor);
    }

    public final boolean isLoading() {
        return this.zzaeu;
    }

    /* access modifiers changed from: private */
    public final void zzaik() {
        zzbbf.zzedl.execute(new zzbpm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzail() {
        this.zzaeu = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzduu zzduu, zzdvf zzdvf, zzbpb zzbpb) throws Exception {
        if (zzbpb != null) {
            zzduu.onSuccess(zzbpb);
        }
        return zzdux.zza(zzdvf, zzacu.zzdbi.get().longValue(), TimeUnit.MILLISECONDS, this.zzfkm);
    }
}
