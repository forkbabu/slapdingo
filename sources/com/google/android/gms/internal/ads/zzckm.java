package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckm implements zzela<zzckn> {
    private final zzelj<zzclc> zzery;
    private final zzelj<zzckv> zzeyb;

    private zzckm(zzelj<zzckv> zzelj, zzelj<zzclc> zzelj2) {
        this.zzeyb = zzelj;
        this.zzery = zzelj2;
    }

    public static zzckm zzai(zzelj<zzckv> zzelj, zzelj<zzclc> zzelj2) {
        return new zzckm(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzckn(this.zzeyb.get(), this.zzery.get());
    }
}
