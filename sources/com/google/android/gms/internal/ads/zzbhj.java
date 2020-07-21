package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbhj implements zzo {
    private zzo zzdoe;
    private zzbfn zzeme;

    public zzbhj(zzbfn zzbfn, zzo zzo) {
        this.zzeme = zzbfn;
        this.zzdoe = zzo;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzue() {
        zzo zzo = this.zzdoe;
        if (zzo != null) {
            zzo.zzue();
        }
        this.zzeme.zzuq();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzud() {
        zzo zzo = this.zzdoe;
        if (zzo != null) {
            zzo.zzud();
        }
        this.zzeme.zzaas();
    }
}
