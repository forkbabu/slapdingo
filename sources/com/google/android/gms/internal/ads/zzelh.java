package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzelh<T> {
    private final List<zzelj<T>> zzipy;
    private final List<zzelj<Collection<T>>> zzipz;

    private zzelh(int i, int i2) {
        this.zzipy = zzekv.zzhx(i);
        this.zzipz = zzekv.zzhx(i2);
    }

    public final zzelh<T> zzau(zzelj<? extends T> zzelj) {
        this.zzipy.add(zzelj);
        return this;
    }

    public final zzelh<T> zzav(zzelj<? extends Collection<? extends T>> zzelj) {
        this.zzipz.add(zzelj);
        return this;
    }

    public final zzelf<T> zzbjh() {
        return new zzelf<>(this.zzipy, this.zzipz);
    }
}
