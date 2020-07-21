package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvo<V> extends zzduv<V> implements zzdvf<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzhpb;

    public zzdvo(zzdvf<V> zzdvf, ScheduledFuture<?> scheduledFuture) {
        super(zzdvf);
        this.zzhpb = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdut
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zzhpb.cancel(z);
        }
        return cancel;
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zzhpb.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzhpb.compareTo((Delayed) obj);
    }
}
