package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcre implements zzboy {
    private final zzbfn zzeot;

    private zzcre(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    static zzboy zzp(zzbfn zzbfn) {
        return new zzcre(zzbfn);
    }

    @Override // com.google.android.gms.internal.ads.zzboy
    public final zzyi getVideoController() {
        return this.zzeot.zzzj();
    }
}
