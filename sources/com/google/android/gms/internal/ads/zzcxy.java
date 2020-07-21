package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxy implements Callable {
    private final zzcxz zzgqm;
    private final List zzgqn;
    private final IObjectWrapper zzgqo;

    zzcxy(zzcxz zzcxz, List list, IObjectWrapper iObjectWrapper) {
        this.zzgqm = zzcxz;
        this.zzgqn = list;
        this.zzgqo = iObjectWrapper;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgqm.zza(this.zzgqn, this.zzgqo);
    }
}
