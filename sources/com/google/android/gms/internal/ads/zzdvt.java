package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvt<V> extends zzdur<V> implements RunnableFuture<V> {
    private volatile zzdve<?> zzhpf;

    static <V> zzdvt<V> zzf(Callable<V> callable) {
        return new zzdvt<>(callable);
    }

    static <V> zzdvt<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzdvt<>(Executors.callable(runnable, v));
    }

    private zzdvt(Callable<V> callable) {
        this.zzhpf = new zzdvv(this, callable);
    }

    zzdvt(zzduf<V> zzduf) {
        this.zzhpf = new zzdvw(this, zzduf);
    }

    public final void run() {
        zzdve<?> zzdve = this.zzhpf;
        if (zzdve != null) {
            zzdve.run();
        }
        this.zzhpf = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void afterDone() {
        zzdve<?> zzdve;
        super.afterDone();
        if (wasInterrupted() && (zzdve = this.zzhpf) != null) {
            zzdve.interruptTask();
        }
        this.zzhpf = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String pendingToString() {
        zzdve<?> zzdve = this.zzhpf;
        if (zzdve == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdve);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }
}
