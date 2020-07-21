package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcig implements zzbyw {
    private final zzbfn zzeot;

    private zzcig(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    static zzbyw zzn(zzbfn zzbfn) {
        return new zzcig(zzbfn);
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzakc() {
        this.zzeot.destroy();
    }
}
