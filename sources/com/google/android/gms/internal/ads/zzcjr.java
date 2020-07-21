package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcjr implements zzela<Set<zzbyg<zzdpa>>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzckh> zzfmj;

    private zzcjr(zzelj<Executor> zzelj, zzelj<zzckh> zzelj2) {
        this.zzerc = zzelj;
        this.zzfmj = zzelj2;
    }

    public static zzcjr zzaf(zzelj<Executor> zzelj, zzelj<zzckh> zzelj2) {
        return new zzcjr(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.zzerc.get();
        zzckh zzckh = this.zzfmj.get();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcte)).booleanValue()) {
            set = Collections.singleton(new zzbyg(zzckh, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelg.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
