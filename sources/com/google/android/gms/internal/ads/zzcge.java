package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcge implements zzela<zzcgd> {
    private final zzelj<zzcck> zzfvp;
    private final zzelj<zzccd> zzgbk;

    private zzcge(zzelj<zzccd> zzelj, zzelj<zzcck> zzelj2) {
        this.zzgbk = zzelj;
        this.zzfvp = zzelj2;
    }

    public static zzcge zzy(zzelj<zzccd> zzelj, zzelj<zzcck> zzelj2) {
        return new zzcge(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcgd(this.zzgbk.get(), this.zzfvp.get());
    }
}
