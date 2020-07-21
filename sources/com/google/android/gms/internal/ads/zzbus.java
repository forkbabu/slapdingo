package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbus extends zzbwv<zzbuw> {
    private final Clock zzbqd;
    private boolean zzflv = false;
    private final ScheduledExecutorService zzfmo;
    private long zzfmq = -1;
    private long zzfmr = -1;
    private ScheduledFuture<?> zzfrz;

    public zzbus(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfmo = scheduledExecutorService;
        this.zzbqd = clock;
    }

    public final synchronized void onPause() {
        if (!this.zzflv) {
            if (this.zzfrz == null || this.zzfrz.isCancelled()) {
                this.zzfmr = -1;
            } else {
                this.zzfrz.cancel(true);
                this.zzfmr = this.zzfmq - this.zzbqd.elapsedRealtime();
            }
            this.zzflv = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzflv) {
            if (this.zzfmr > 0 && this.zzfrz.isCancelled()) {
                zzfe(this.zzfmr);
            }
            this.zzflv = false;
        }
    }

    public final synchronized void zzajd() {
        this.zzflv = false;
        zzfe(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdu(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0043 }
            long r1 = (long) r7     // Catch:{ all -> 0x0043 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.zzflv     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfmr     // Catch:{ all -> 0x0043 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfmr     // Catch:{ all -> 0x0043 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfmr     // Catch:{ all -> 0x0043 }
        L_0x0021:
            r6.zzfmr = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbqd
            long r2 = r7.elapsedRealtime()
            long r4 = r6.zzfmq
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            long r2 = r6.zzfmq
            com.google.android.gms.common.util.Clock r7 = r6.zzbqd
            long r4 = r7.elapsedRealtime()
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
        L_0x003e:
            r6.zzfe(r0)
        L_0x0041:
            monitor-exit(r6)
            return
        L_0x0043:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbus.zzdu(int):void");
    }

    private final synchronized void zzfe(long j) {
        if (this.zzfrz != null && !this.zzfrz.isDone()) {
            this.zzfrz.cancel(true);
        }
        this.zzfmq = this.zzbqd.elapsedRealtime() + j;
        this.zzfrz = this.zzfmo.schedule(new zzbut(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public final void zzaje() {
        zza(zzbur.zzfrq);
    }
}
