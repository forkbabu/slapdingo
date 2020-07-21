package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmt implements Callable {
    private final Context zzcjz;
    private final zzeg zzggp;

    zzcmt(zzeg zzeg, Context context) {
        this.zzggp = zzeg;
        this.zzcjz = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzeg zzeg = this.zzggp;
        return zzeg.zzcb().zzb(this.zzcjz);
    }
}
