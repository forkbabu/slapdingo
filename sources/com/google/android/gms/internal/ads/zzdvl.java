package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvl extends zzdvm implements zzdvi, ScheduledExecutorService {
    private final ScheduledExecutorService zzhoy;

    zzdvl(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzhoy = (ScheduledExecutorService) zzdsh.checkNotNull(scheduledExecutorService);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdvn zzdvn = new zzdvn(runnable);
        return new zzdvo(zzdvn, this.zzhoy.scheduleWithFixedDelay(zzdvn, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdvn zzdvn = new zzdvn(runnable);
        return new zzdvo(zzdvn, this.zzhoy.scheduleAtFixedRate(zzdvn, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzdvt zzf = zzdvt.zzf(callable);
        return new zzdvo(zzf, this.zzhoy.schedule(zzf, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzdvt zza = zzdvt.zza(runnable, (Object) null);
        return new zzdvo(zza, this.zzhoy.schedule(zza, j, timeUnit));
    }
}
