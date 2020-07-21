package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdtz<I, O> extends zzdtw<I, O, zzduh<? super I, ? extends O>, zzdvf<? extends O>> {
    zzdtz(zzdvf<? extends I> zzdvf, zzduh<? super I, ? extends O> zzduh) {
        super(zzdvf, zzduh);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtw
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdvf) obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtw
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        zzduh zzduh = (zzduh) obj;
        zzdvf<O> zzf = zzduh.zzf(obj2);
        zzdsh.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzduh);
        return zzf;
    }
}
