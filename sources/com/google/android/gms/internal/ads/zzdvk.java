package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvk implements Executor {
    boolean zzhov = true;
    private final /* synthetic */ Executor zzhow;
    private final /* synthetic */ zzdtu zzhox;

    zzdvk(Executor executor, zzdtu zzdtu) {
        this.zzhow = executor;
        this.zzhox = zzdtu;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zzhow.execute(new zzdvj(this, runnable));
        } catch (RejectedExecutionException e) {
            if (this.zzhov) {
                this.zzhox.setException(e);
            }
        }
    }
}
