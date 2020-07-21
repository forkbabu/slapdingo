package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbln implements zzduu<String> {
    private final /* synthetic */ String zzflb;
    private final /* synthetic */ zzblk zzflc;

    zzbln(zzblk zzblk, String str) {
        this.zzflc = zzblk;
        this.zzflb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        this.zzflc.zzfkp.zza(this.zzflc.zzfkn, this.zzflc.zzfko, false, this.zzflb, null, this.zzflc.zzfko.zzdig);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(String str) {
        this.zzflc.zzfkp.zza(this.zzflc.zzfkn, this.zzflc.zzfko, false, this.zzflb, str, this.zzflc.zzfko.zzdig);
    }
}
