package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczg implements zzdec<Object> {
    private final Executor executor;
    private final zzdvf<String> zzgrn;

    public zzczg(zzdvf<String> zzdvf, Executor executor2) {
        this.zzgrn = zzdvf;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<Object> zzaqm() {
        return zzdux.zzb(this.zzgrn, zzczf.zzboi, this.executor);
    }
}
