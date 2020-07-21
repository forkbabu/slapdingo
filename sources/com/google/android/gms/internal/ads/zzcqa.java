package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqa implements zzela<zzcpz> {
    private final zzelj<zzcpx> zzfaw;
    private final zzelj<zzdvi> zzgjb;

    private zzcqa(zzelj<zzcpx> zzelj, zzelj<zzdvi> zzelj2) {
        this.zzfaw = zzelj;
        this.zzgjb = zzelj2;
    }

    public static zzcqa zzav(zzelj<zzcpx> zzelj, zzelj<zzdvi> zzelj2) {
        return new zzcqa(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcpz(this.zzfaw.get(), this.zzgjb.get());
    }
}
