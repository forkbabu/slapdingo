package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvp<V> extends zzdur<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdvf<V> zzhpc;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzhpd;

    static <V> zzdvf<V> zzb(zzdvf<V> zzdvf, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdvp zzdvp = new zzdvp(zzdvf);
        zzdvr zzdvr = new zzdvr(zzdvp);
        zzdvp.zzhpd = scheduledExecutorService.schedule(zzdvr, j, timeUnit);
        zzdvf.addListener(zzdvr, zzdum.INSTANCE);
        return zzdvp;
    }

    private zzdvp(zzdvf<V> zzdvf) {
        this.zzhpc = (zzdvf) zzdsh.checkNotNull(zzdvf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String pendingToString() {
        zzdvf<V> zzdvf = this.zzhpc;
        ScheduledFuture<?> scheduledFuture = this.zzhpd;
        if (zzdvf == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdvf);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhpc);
        ScheduledFuture<?> scheduledFuture = this.zzhpd;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhpc = null;
        this.zzhpd = null;
    }
}
