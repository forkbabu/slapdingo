package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbwv<ListenerT> {
    private final Map<ListenerT, Executor> zzfsp = new HashMap();

    protected zzbwv(Set<zzbyg<ListenerT>> set) {
        zzb(set);
    }

    public final synchronized void zza(zzbyg<ListenerT> zzbyg) {
        zza(zzbyg.zzfti, zzbyg.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfsp.put(listenert, executor);
    }

    private final synchronized void zzb(Set<zzbyg<ListenerT>> set) {
        for (zzbyg<ListenerT> zzbyg : set) {
            zza(zzbyg);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbwx<ListenerT> zzbwx) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzfsp.entrySet()) {
            entry.getValue().execute(new zzbwy(zzbwx, entry.getKey()));
        }
    }
}
