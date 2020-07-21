package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbbf {
    public static final zzdvi zzedh = zza(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzfg("Default")));
    public static final zzdvi zzedi;
    public static final zzdvi zzedj;
    public static final ScheduledExecutorService zzedk = new ScheduledThreadPoolExecutor(3, zzfg("Schedule"));
    public static final zzdvi zzedl = zza(new zzbbh());
    public static final zzdvi zzedm = zza(zzdvh.zzaxf());

    private static ThreadFactory zzfg(String str) {
        return new zzbbi(str);
    }

    private static zzdvi zza(Executor executor) {
        return new zzbbk(executor, null);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfg("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzedi = zza(threadPoolExecutor);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfg("Activeview"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        zzedj = zza(threadPoolExecutor2);
    }
}
