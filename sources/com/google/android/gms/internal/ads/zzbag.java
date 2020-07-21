package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbag {
    private final Object lock = new Object();
    private long zzebz;
    private long zzeca = Long.MIN_VALUE;

    public zzbag(long j) {
        this.zzebz = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzq.zzld().elapsedRealtime();
            if (this.zzeca + this.zzebz > elapsedRealtime) {
                return false;
            }
            this.zzeca = elapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzebz = j;
        }
    }
}
