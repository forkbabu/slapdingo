package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcup implements zzbtd {
    private final zzbfn zzeot;

    zzcup(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        zzbfn zzbfn = this.zzeot;
        if (zzbfn.zzaaz() != null) {
            zzbfn.zzaaz().zzaby();
        }
    }
}
