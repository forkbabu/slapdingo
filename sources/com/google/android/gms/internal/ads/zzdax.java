package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzddz;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdax<S extends zzddz<?>> {
    private final Clock zzbqd;
    public final zzdvf<S> zzgsq;
    private final long zzgsr;

    public zzdax(zzdvf<S> zzdvf, long j, Clock clock) {
        this.zzgsq = zzdvf;
        this.zzbqd = clock;
        this.zzgsr = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgsr < this.zzbqd.elapsedRealtime();
    }
}
