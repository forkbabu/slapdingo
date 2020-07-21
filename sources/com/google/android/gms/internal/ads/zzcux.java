package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcux implements zzcam {
    private final zzcqv zzgku;

    zzcux(zzcqv zzcqv) {
        this.zzgku = zzcqv;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) {
        zzcqv zzcqv = this.zzgku;
        try {
            zzcqv.zzdka.setImmersiveMode(z);
            zzcqv.zzdka.showVideo();
        } catch (zzdlg e) {
            zzaxv.zzd("Cannot show rewarded video.", e);
            throw new zzcap(e.getCause());
        }
    }
}
