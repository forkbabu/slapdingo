package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcsp implements zzcam {
    private final zzcqv zzgku;

    zzcsp(zzcqv zzcqv) {
        this.zzgku = zzcqv;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) {
        zzcqv zzcqv = this.zzgku;
        try {
            zzcqv.zzdka.setImmersiveMode(z);
            zzcqv.zzdka.showInterstitial();
        } catch (zzdlg e) {
            zzaxv.zzfc("Cannot show interstitial.");
            throw new zzcap(e.getCause());
        }
    }
}
