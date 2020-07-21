package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtu;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
class zzdvc<V> implements zzdvf<V> {
    private static final Logger zzhnb = Logger.getLogger(zzdvc.class.getName());
    static final zzdvf<?> zzhop = new zzdvc(null);
    @NullableDecl
    private final V value;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zza<V> extends zzdtu.zzj<V> {
        zza(Throwable th) {
            setException(th);
        }
    }

    zzdvc(@NullableDecl V v) {
        this.value = v;
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdvf
    public void addListener(Runnable runnable, Executor executor) {
        zzdsh.checkNotNull(runnable, "Runnable was null.");
        zzdsh.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhnb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdsh.checkNotNull(timeUnit);
        return get();
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 27 + String.valueOf(valueOf).length());
        sb.append(obj);
        sb.append("[status=SUCCESS, result=[");
        sb.append(valueOf);
        sb.append("]]");
        return sb.toString();
    }
}
