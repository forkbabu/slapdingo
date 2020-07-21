package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcjx implements zzela<zzcjq> {
    private final zzelj<zzdir> zzexv;
    private final zzelj<zztm> zzgdq;

    private zzcjx(zzelj<zztm> zzelj, zzelj<zzdir> zzelj2) {
        this.zzgdq = zzelj;
        this.zzexv = zzelj2;
    }

    public static zzcjx zzag(zzelj<zztm> zzelj, zzelj<zzdir> zzelj2) {
        return new zzcjx(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcjq(this.zzgdq.get(), this.zzexv.get());
    }
}
