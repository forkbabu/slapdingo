package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzduk extends zzdun<V> {
    private final Callable<V> zzhoe;
    private final /* synthetic */ zzdul zzhof;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzduk(zzdul zzdul, Callable<V> callable, Executor executor) {
        super(zzdul, executor);
        this.zzhof = zzdul;
        this.zzhoe = (Callable) zzdsh.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final V zzaxb() throws Exception {
        this.zzhok = false;
        return this.zzhoe.call();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdun
    public final void setValue(V v) {
        this.zzhof.set(v);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final String zzaxc() {
        return this.zzhoe.toString();
    }
}
