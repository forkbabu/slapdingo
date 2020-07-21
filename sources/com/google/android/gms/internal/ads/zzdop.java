package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdop implements zzduu<O> {
    private final /* synthetic */ zzdod zzhfu;
    private final /* synthetic */ zzdom zzhfv;

    zzdop(zzdom zzdom, zzdod zzdod) {
        this.zzhfv = zzdom;
        this.zzhfu = zzdod;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void onSuccess(O o) {
        this.zzhfv.zzhfp.zzhfn.zzc(this.zzhfu);
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        this.zzhfv.zzhfp.zzhfn.zza(this.zzhfu, th);
    }
}
