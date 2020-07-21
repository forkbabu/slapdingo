package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdih implements zzdrx<zzcop, zzdij> {
    private final /* synthetic */ zzdif zzgyf;

    zzdih(zzdif zzdif) {
        this.zzgyf = zzdif;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdrx
    @NullableDecl
    public final /* synthetic */ zzdij apply(@NullableDecl zzcop zzcop) {
        zzbba.zzc("", zzcop);
        zzaxv.zzeh("Failed to get a cache key, reverting to legacy flow.");
        zzdif zzdif = this.zzgyf;
        zzdij unused = zzdif.zzgyd = new zzdij(null, zzdif.zzasb(), null);
        return this.zzgyf.zzgyd;
    }
}
