package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbbu<T> {
    private final zzbbn<T> zzedu = new zzbbn<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzedv = new AtomicInteger(0);

    public zzbbu() {
        zzdux.zza(this.zzedu, new zzbbt(this), zzbbf.zzedm);
    }

    @Deprecated
    public final void zza(zzbbr<T> zzbbr, zzbbp zzbbp) {
        zzdux.zza(this.zzedu, new zzbbw(this, zzbbr, zzbbp), zzbbf.zzedm);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzedu.set(t);
    }

    @Deprecated
    public final void reject() {
        this.zzedu.setException(new Exception());
    }

    @Deprecated
    public final int getStatus() {
        return this.zzedv.get();
    }
}
