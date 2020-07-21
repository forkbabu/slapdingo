package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzawk implements Callable {
    private final Context zzcjz;
    private final zzavy zzdwu;

    zzawk(zzavy zzavy, Context context) {
        this.zzdwu = zzavy;
        this.zzcjz = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzdwu.zzak(this.zzcjz);
    }
}
