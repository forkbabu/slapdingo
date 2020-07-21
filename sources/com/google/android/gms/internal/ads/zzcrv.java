package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcrv implements zzduh {
    private final Uri zzdzt;
    private final zzdkk zzfzn;
    private final zzcrs zzgky;
    private final zzdkw zzgkz;

    zzcrv(zzcrs zzcrs, Uri uri, zzdkw zzdkw, zzdkk zzdkk) {
        this.zzgky = zzcrs;
        this.zzdzt = uri;
        this.zzgkz = zzdkw;
        this.zzfzn = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzgky.zza(this.zzdzt, this.zzgkz, this.zzfzn, obj);
    }
}
