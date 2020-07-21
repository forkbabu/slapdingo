package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdki {
    private final Object lock = new Object();
    private final Clock zzbqd;
    private volatile long zzdyg = 0;
    private volatile int zzgzi = zzdkh.zzgze;

    public zzdki(Clock clock) {
        this.zzbqd = clock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzr(int r5, int r6) {
        /*
            r4 = this;
            r4.zzasd()
            com.google.android.gms.common.util.Clock r0 = r4.zzbqd
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzgzi     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzgzi = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzgzi     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzdkh.zzgzg     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzdyg = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdki.zzr(int, int):void");
    }

    private final void zzasd() {
        long currentTimeMillis = this.zzbqd.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzgzi == zzdkh.zzgzg) {
                if (this.zzdyg + ((Long) zzwg.zzpw().zzd(zzaav.zzcvc)).longValue() <= currentTimeMillis) {
                    this.zzgzi = zzdkh.zzgze;
                }
            }
        }
    }

    public final void zzbn(boolean z) {
        if (z) {
            zzr(zzdkh.zzgze, zzdkh.zzgzf);
        } else {
            zzr(zzdkh.zzgzf, zzdkh.zzgze);
        }
    }

    public final boolean zzase() {
        boolean z;
        synchronized (this.lock) {
            zzasd();
            z = this.zzgzi == zzdkh.zzgzf;
        }
        return z;
    }

    public final boolean zzasf() {
        boolean z;
        synchronized (this.lock) {
            zzasd();
            z = this.zzgzi == zzdkh.zzgzg;
        }
        return z;
    }

    public final void zzwa() {
        zzr(zzdkh.zzgzf, zzdkh.zzgzg);
    }
}
