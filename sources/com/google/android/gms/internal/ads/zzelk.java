package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzelk<T> implements zzelj<T> {
    private static final Object zzips = new Object();
    private volatile Object zzeby = zzips;
    private volatile zzelj<T> zzipt;

    private zzelk(zzelj<T> zzelj) {
        this.zzipt = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final T get() {
        T t = this.zzeby;
        if (t != zzips) {
            return t;
        }
        zzelj<T> zzelj = this.zzipt;
        if (zzelj == null) {
            return this.zzeby;
        }
        T t2 = zzelj.get();
        this.zzeby = t2;
        this.zzipt = null;
        return t2;
    }

    public static <P extends zzelj<T>, T> zzelj<T> zzas(P p) {
        return ((p instanceof zzelk) || (p instanceof zzekx)) ? p : new zzelk((zzelj) zzelg.checkNotNull(p));
    }
}
