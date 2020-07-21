package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcgu implements zzduu<zzbfn> {
    private final /* synthetic */ String zzemd;
    private final /* synthetic */ zzahc zzgbt;

    zzcgu(zzcgr zzcgr, String str, zzahc zzahc) {
        this.zzemd = str;
        this.zzgbt = zzahc;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbfn zzbfn) {
        zzbfn.zzb(this.zzemd, this.zzgbt);
    }
}
