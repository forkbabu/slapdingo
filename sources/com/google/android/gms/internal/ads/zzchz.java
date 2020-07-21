package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzi;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzchz implements zzi {
    private final /* synthetic */ zzchw zzgcp;

    zzchz(zzchw zzchw) {
        this.zzgcp = zzchw;
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzkd() {
        this.zzgcp.zzgcl.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzke() {
        this.zzgcp.zzgcl.onResume();
    }
}
