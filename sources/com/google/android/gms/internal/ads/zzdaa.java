package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdaa implements zzdec<zzddz<Bundle>> {
    private final Executor executor;
    private final zzaxh zzbpz;

    zzdaa(Executor executor2, zzaxh zzaxh) {
        this.executor = executor2;
        this.zzbpz = zzaxh;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqk)).booleanValue()) {
            return zzdux.zzaf(null);
        }
        return zzdux.zzb(this.zzbpz.zzwf(), zzczz.zzdvt, this.executor);
    }
}
