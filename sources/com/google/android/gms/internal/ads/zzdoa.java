package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdoa implements zzela<ScheduledExecutorService> {
    private final zzelj<ThreadFactory> zzhfh;

    public zzdoa(zzelj<ThreadFactory> zzelj) {
        this.zzhfh = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzelg.zza(new ScheduledThreadPoolExecutor(1, this.zzhfh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
