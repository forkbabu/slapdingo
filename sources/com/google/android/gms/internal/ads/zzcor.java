package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcor implements zzduh {
    static final zzduh zzboi = new zzcor();

    private zzcor() {
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return zzdux.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
