package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzddz;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzday<S extends zzddz<?>> implements zzdec<S> {
    private final Clock zzbqd;
    private final AtomicReference<zzdax<S>> zzgss = new AtomicReference<>();
    private final zzdec<S> zzgst;
    private final long zzgsu;

    public zzday(zzdec<S> zzdec, long j, Clock clock) {
        this.zzbqd = clock;
        this.zzgst = zzdec;
        this.zzgsu = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<S> zzaqm() {
        zzdax<S> zzdax = this.zzgss.get();
        if (zzdax == null || zzdax.hasExpired()) {
            zzdax = new zzdax<>(this.zzgst.zzaqm(), this.zzgsu, this.zzbqd);
            this.zzgss.set(zzdax);
        }
        return zzdax.zzgsq;
    }
}
