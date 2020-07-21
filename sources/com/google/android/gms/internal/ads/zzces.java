package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzces implements zzdrx<zzy, Bitmap> {
    private final /* synthetic */ double zzfzz;
    private final /* synthetic */ boolean zzgaa;
    private final /* synthetic */ zzcet zzgab;

    zzces(zzcet zzcet, double d, boolean z) {
        this.zzgab = zzcet;
        this.zzfzz = d;
        this.zzgaa = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdrx
    public final /* synthetic */ Bitmap apply(zzy zzy) {
        return this.zzgab.zza(zzy.data, this.zzfzz, this.zzgaa);
    }
}
