package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddz;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcn<S extends zzddz<?>> implements zzdec<S> {
    private final ScheduledExecutorService zzfmo;
    private final zzdec<S> zzgst;
    private final long zzgtk;

    public zzdcn(zzdec<S> zzdec, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgst = zzdec;
        this.zzgtk = j;
        this.zzfmo = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<S> zzaqm() {
        zzdvf<S> zzaqm = this.zzgst.zzaqm();
        long j = this.zzgtk;
        if (j > 0) {
            zzaqm = zzdux.zza(zzaqm, j, TimeUnit.MILLISECONDS, this.zzfmo);
        }
        return zzdux.zzb(zzaqm, Throwable.class, zzdcq.zzboi, zzbbf.zzedm);
    }
}
