package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdll<T> {
    private final zzdvi zzgad;
    private final Deque<zzdvf<T>> zzhbk = new LinkedBlockingDeque();
    private final Callable<T> zzhbl;

    public zzdll(Callable<T> callable, zzdvi zzdvi) {
        this.zzhbl = callable;
        this.zzgad = zzdvi;
    }

    public final synchronized void zzeb(int i) {
        int size = i - this.zzhbk.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzhbk.add(this.zzgad.zze(this.zzhbl));
        }
    }

    public final synchronized zzdvf<T> zzass() {
        zzeb(1);
        return this.zzhbk.poll();
    }

    public final synchronized void zzd(zzdvf<T> zzdvf) {
        this.zzhbk.addFirst(zzdvf);
    }
}
