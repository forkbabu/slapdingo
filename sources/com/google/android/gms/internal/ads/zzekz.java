package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzekz<T> implements zzeku<T>, zzela<T> {
    private static final zzekz<Object> zzipv = new zzekz<>(null);
    private final T zzeby;

    public static <T> zzela<T> zzba(T t) {
        return new zzekz(zzelg.zza(t, "instance cannot be null"));
    }

    public static <T> zzela<T> zzbb(T t) {
        if (t == null) {
            return zzipv;
        }
        return new zzekz(t);
    }

    private zzekz(T t) {
        this.zzeby = t;
    }

    @Override // com.google.android.gms.internal.ads.zzeku, com.google.android.gms.internal.ads.zzelj
    public final T get() {
        return this.zzeby;
    }
}
