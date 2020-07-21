package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdun<T> extends zzdve<T> {
    private final /* synthetic */ zzdul zzhof;
    private final Executor zzhoj;
    boolean zzhok = true;

    zzdun(zzdul zzdul, Executor executor) {
        this.zzhof = zzdul;
        this.zzhoj = (Executor) zzdsh.checkNotNull(executor);
    }

    /* access modifiers changed from: package-private */
    public abstract void setValue(T t);

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final boolean isDone() {
        return this.zzhof.isDone();
    }

    /* access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zzhoj.execute(this);
        } catch (RejectedExecutionException e) {
            if (this.zzhok) {
                this.zzhof.setException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final void zzb(T t, Throwable th) {
        zzdun unused = this.zzhof.zzhog = null;
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzhof.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzhof.cancel(false);
        } else {
            this.zzhof.setException(th);
        }
    }
}
