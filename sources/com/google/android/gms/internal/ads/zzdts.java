package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdts<V, X extends Throwable> extends zzdtt<V, X, zzduh<? super X, ? extends V>, zzdvf<? extends V>> {
    zzdts(zzdvf<? extends V> zzdvf, Class<X> cls, zzduh<? super X, ? extends V> zzduh) {
        super(zzdvf, cls, zzduh);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtt
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdvf) obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtt
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzduh zzduh = (zzduh) obj;
        zzdvf zzf = zzduh.zzf(th);
        zzdsh.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzduh);
        return zzf;
    }
}
