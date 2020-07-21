package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcya implements Callable {
    private final Uri zzdzt;
    private final zzcxz zzgqm;
    private final IObjectWrapper zzgqo;

    zzcya(zzcxz zzcxz, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zzgqm = zzcxz;
        this.zzdzt = uri;
        this.zzgqo = iObjectWrapper;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgqm.zzb(this.zzdzt, this.zzgqo);
    }
}
