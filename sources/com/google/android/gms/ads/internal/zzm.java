package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzm implements Callable<zzeg> {
    private final /* synthetic */ zzl zzbox;

    zzm(zzl zzl) {
        this.zzbox = zzl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzeg call() throws Exception {
        return new zzeg(zzed.zzb(this.zzbox.zzboy.zzbpn, this.zzbox.zzvr, false));
    }
}
