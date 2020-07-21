package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzde<T> implements zzcz<T> {
    @NullableDecl
    private T value;
    private volatile zzcz<T> zzlv;
    private volatile boolean zzlw;

    zzde(zzcz<T> zzcz) {
        this.zzlv = (zzcz) zzcy.checkNotNull(zzcz);
    }

    @Override // com.google.android.gms.internal.vision.zzcz
    public final T get() {
        if (!this.zzlw) {
            synchronized (this) {
                if (!this.zzlw) {
                    T t = this.zzlv.get();
                    this.value = t;
                    this.zzlw = true;
                    this.zzlv = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzlv;
        if (obj == null) {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
