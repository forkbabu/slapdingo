package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdvh {
    public static Executor zzaxf() {
        return zzdum.INSTANCE;
    }

    public static zzdvi zza(ExecutorService executorService) {
        if (executorService instanceof zzdvi) {
            return (zzdvi) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzdvl((ScheduledExecutorService) executorService);
        }
        return new zzdvm(executorService);
    }

    static Executor zza(Executor executor, zzdtu<?> zzdtu) {
        zzdsh.checkNotNull(executor);
        zzdsh.checkNotNull(zzdtu);
        if (executor == zzdum.INSTANCE) {
            return executor;
        }
        return new zzdvk(executor, zzdtu);
    }
}
