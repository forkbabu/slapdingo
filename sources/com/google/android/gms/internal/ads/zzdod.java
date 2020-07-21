package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdod<E, V> implements zzdvf<V> {
    private final E zzhfj;
    private final String zzhfk;
    private final zzdvf<V> zzhfl;

    public zzdod(E e, String str, zzdvf<V> zzdvf) {
        this.zzhfj = e;
        this.zzhfk = str;
        this.zzhfl = zzdvf;
    }

    @Override // com.google.android.gms.internal.ads.zzdvf
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhfl.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzhfl.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhfl.get();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhfl.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzhfl.isCancelled();
    }

    public final boolean isDone() {
        return this.zzhfl.isDone();
    }

    public final E zzaup() {
        return this.zzhfj;
    }

    public final String zzauq() {
        return this.zzhfk;
    }

    public final String toString() {
        String str = this.zzhfk;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
