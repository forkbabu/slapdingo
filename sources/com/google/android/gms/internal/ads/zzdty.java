package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdty<I, O> extends zzdtw<I, O, zzdrx<? super I, ? extends O>, O> {
    zzdty(zzdvf<? extends I> zzdvf, zzdrx<? super I, ? extends O> zzdrx) {
        super(zzdvf, zzdrx);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtw
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdtw
    @NullableDecl
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdrx) obj).apply(obj2);
    }
}
