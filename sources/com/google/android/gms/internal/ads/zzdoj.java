package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdoj implements Callable {
    private final zzdoe zzhfq;

    zzdoj(zzdoe zzdoe) {
        this.zzhfq = zzdoe;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.zzhfq.run();
        return null;
    }
}
