package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcyg implements zzduh {
    private final String zzdia;
    private final zzcxz zzgqm;
    private final zzcgr[] zzgqv;

    zzcyg(zzcxz zzcxz, zzcgr[] zzcgrArr, String str) {
        this.zzgqm = zzcxz;
        this.zzgqv = zzcgrArr;
        this.zzdia = str;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzgqm.zza(this.zzgqv, this.zzdia, (zzcgr) obj);
    }
}
