package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcav implements zzela<zzcas> {
    private final zzelj<zzbtf> zzfug;

    private zzcav(zzelj<zzbtf> zzelj) {
        this.zzfug = zzelj;
    }

    public static zzcav zzx(zzelj<zzbtf> zzelj) {
        return new zzcav(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcas(this.zzfug.get());
    }
}
