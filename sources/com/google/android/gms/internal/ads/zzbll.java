package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbll implements zzbsq {
    private final zzdkw zzfkn;
    private final zzdpd zzfkp;
    private final zzdkm zzfku;

    public zzbll(zzdkw zzdkw, zzdpd zzdpd) {
        this.zzfkn = zzdkw;
        this.zzfkp = zzdpd;
        this.zzfku = zzdkw.zzhau.zzhar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        this.zzfkp.zza(this.zzfkn, null, this.zzfku.zzdii);
    }
}
