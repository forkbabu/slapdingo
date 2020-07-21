package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcip implements zzbtg {
    private final zzbfn zzdfp;

    zzcip(zzbfn zzbfn) {
        this.zzdfp = !((Boolean) zzwg.zzpw().zzd(zzaav.zzcnv)).booleanValue() ? null : zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzca(Context context) {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            zzbfn.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcb(Context context) {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            zzbfn.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcc(Context context) {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            zzbfn.destroy();
        }
    }
}
