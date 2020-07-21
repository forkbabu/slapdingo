package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcgx implements zzduu<zzbfn> {
    private final /* synthetic */ String zzgbu;
    private final /* synthetic */ Map zzgbv;

    zzcgx(zzcgr zzcgr, String str, Map map) {
        this.zzgbu = str;
        this.zzgbv = map;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbfn zzbfn) {
        zzbfn.zza(this.zzgbu, this.zzgbv);
    }
}
