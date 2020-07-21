package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcwf implements zze {
    private final /* synthetic */ zzbzl zzgol;

    zzcwf(zzcwa zzcwa, zzbzl zzbzl) {
        this.zzgol = zzbzl;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjz() {
        this.zzgol.zzaej().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzka() {
        this.zzgol.zzaek().onAdImpression();
        this.zzgol.zzael().zzakb();
    }
}
