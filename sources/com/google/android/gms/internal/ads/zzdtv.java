package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdtv<V, X extends Throwable> extends zzdtt<V, X, zzdrx<? super X, ? extends V>, V> {
    zzdtv(zzdvf<? extends V> zzdvf, Class<X> cls, zzdrx<? super X, ? extends V> zzdrx) {
        super(zzdvf, cls, zzdrx);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtt
    public final void setResult(@NullableDecl V v) {
        set(v);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtt
    @NullableDecl
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        return ((zzdrx) obj).apply(th);
    }
}
