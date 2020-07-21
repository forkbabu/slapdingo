package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcij implements zzbhc {
    private final zzbbn zzbvh;

    zzcij(zzbbn zzbbn) {
        this.zzbvh = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzak(boolean z) {
        zzbbn zzbbn = this.zzbvh;
        if (z) {
            zzbbn.set(null);
        } else {
            zzbbn.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
