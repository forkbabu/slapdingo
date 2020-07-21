package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcvj implements zzbtw {
    private boolean zzgnq = false;
    private final /* synthetic */ zzbbn zzgnr;

    zzcvj(zzcve zzcve, zzbbn zzbbn) {
        this.zzgnr = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzbtw
    public final void onAdFailedToLoad(int i) {
        if (!this.zzgnq) {
            zzg(i, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtw
    public final synchronized void zzf(int i, String str) {
        this.zzgnq = true;
        zzg(i, str);
    }

    private final void zzg(int i, String str) {
        int i2 = zzdls.zzhbq;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuc)).booleanValue()) {
            i2 = zzdls.zzhbs;
        }
        this.zzgnr.setException(new zzcqx(i2, i, str));
    }

    @Override // com.google.android.gms.internal.ads.zzbtw
    public final synchronized void onAdLoaded() {
        this.zzgnr.set(null);
    }
}
