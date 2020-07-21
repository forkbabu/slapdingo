package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbml implements zzrj {
    private final Clock zzbqd;
    private Runnable zzdyr = null;
    private final ScheduledExecutorService zzfmo;
    private ScheduledFuture<?> zzfmp;
    private long zzfmq = -1;
    private long zzfmr = -1;
    private boolean zzfms = false;

    public zzbml(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfmo = scheduledExecutorService;
        this.zzbqd = clock;
        zzq.zzkz().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzrj
    public final void zzp(boolean z) {
        if (z) {
            zzagy();
        } else {
            zzagx();
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzdyr = runnable;
        long j = (long) i;
        this.zzfmq = this.zzbqd.elapsedRealtime() + j;
        this.zzfmp = this.zzfmo.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzagx() {
        if (!this.zzfms) {
            if (this.zzfmp == null || this.zzfmp.isDone()) {
                this.zzfmr = -1;
            } else {
                this.zzfmp.cancel(true);
                this.zzfmr = this.zzfmq - this.zzbqd.elapsedRealtime();
            }
            this.zzfms = true;
        }
    }

    private final synchronized void zzagy() {
        if (this.zzfms) {
            if (this.zzfmr > 0 && this.zzfmp != null && this.zzfmp.isCancelled()) {
                this.zzfmp = this.zzfmo.schedule(this.zzdyr, this.zzfmr, TimeUnit.MILLISECONDS);
            }
            this.zzfms = false;
        }
    }
}
