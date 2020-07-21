package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcyf implements zzdrx {
    private final Uri zzdzt;
    private final zzcxz zzgqm;

    zzcyf(zzcxz zzcxz, Uri uri) {
        this.zzgqm = zzcxz;
        this.zzdzt = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        return zzcxz.zzc(this.zzdzt, (String) obj);
    }
}
