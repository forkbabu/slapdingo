package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzekx<T> implements zzeku<T>, zzelj<T> {
    private static final Object zzips = new Object();
    private volatile Object zzeby = zzips;
    private volatile zzelj<T> zzipt;

    private zzekx(zzelj<T> zzelj) {
        this.zzipt = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzeku, com.google.android.gms.internal.ads.zzelj
    public final T get() {
        T t = this.zzeby;
        if (t == zzips) {
            synchronized (this) {
                t = this.zzeby;
                if (t == zzips) {
                    t = this.zzipt.get();
                    T t2 = this.zzeby;
                    if (t2 != zzips && !(t2 instanceof zzeld)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzeby = t;
                    this.zzipt = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzelj<T>, T> zzelj<T> zzas(P p) {
        zzelg.checkNotNull(p);
        if (p instanceof zzekx) {
            return p;
        }
        return new zzekx(p);
    }

    public static <P extends zzelj<T>, T> zzeku<T> zzat(P p) {
        if (p instanceof zzeku) {
            return p;
        }
        return new zzekx((zzelj) zzelg.checkNotNull(p));
    }
}
