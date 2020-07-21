package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcru implements zzcam {
    private final zzbbn zzbvh;

    zzcru(zzbbn zzbbn) {
        this.zzbvh = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) {
        zzbbn zzbbn = this.zzbvh;
        try {
            zzq.zzkv();
            zzn.zza(context, (AdOverlayInfoParcel) zzbbn.get(), true);
        } catch (Exception unused) {
        }
    }
}
