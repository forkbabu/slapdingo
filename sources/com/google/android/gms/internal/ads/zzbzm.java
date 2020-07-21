package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbzm implements zzbwd {
    private final zzbfn zzeot;

    zzbzm(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzahv() {
        zzbfn zzbfn = this.zzeot;
        if (zzbfn.zzaav() != null) {
            zzbfn.zzaav().close();
        }
    }
}
