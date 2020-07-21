package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdus<V> extends zzdut<V> implements zzdvf<V> {
    protected zzdus() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaxd */
    public abstract zzdvf<? extends V> zzaxe();

    @Override // com.google.android.gms.internal.ads.zzdvf
    public void addListener(Runnable runnable, Executor executor) {
        zzaxe().addListener(runnable, executor);
    }
}
