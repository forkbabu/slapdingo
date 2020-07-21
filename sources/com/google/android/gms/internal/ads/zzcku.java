package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcku implements zzela<zzckv> {
    private final zzelj<zzclc> zzery;

    private zzcku(zzelj<zzclc> zzelj) {
        this.zzery = zzelj;
    }

    public static zzcku zzab(zzelj<zzclc> zzelj) {
        return new zzcku(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzckv(this.zzery.get());
    }
}
