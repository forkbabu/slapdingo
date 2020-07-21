package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvv extends zzdve<V> {
    private final Callable<V> zzhoe;
    private final /* synthetic */ zzdvt zzhpg;

    zzdvv(zzdvt zzdvt, Callable<V> callable) {
        this.zzhpg = zzdvt;
        this.zzhoe = (Callable) zzdsh.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final boolean isDone() {
        return this.zzhpg.isDone();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final V zzaxb() throws Exception {
        return this.zzhoe.call();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzhpg.set(v);
        } else {
            this.zzhpg.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final String zzaxc() {
        return this.zzhoe.toString();
    }
}
