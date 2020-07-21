package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnd implements zzela<zzbus> {
    private final zzelj<Clock> zzfmf;
    private final zzelj<ScheduledExecutorService> zzfnh;

    public zzbnd(zzelj<ScheduledExecutorService> zzelj, zzelj<Clock> zzelj2) {
        this.zzfnh = zzelj;
        this.zzfmf = zzelj2;
    }

    public static zzbus zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbus) zzelg.zza(new zzbus(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnh.get(), this.zzfmf.get());
    }
}
