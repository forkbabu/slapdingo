package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqc implements zzela<zzcqd> {
    private final zzelj<zzcqi> zzgjd;

    private zzcqc(zzelj<zzcqi> zzelj) {
        this.zzgjd = zzelj;
    }

    public static zzcqc zzag(zzelj<zzcqi> zzelj) {
        return new zzcqc(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcqd(this.zzgjd.get());
    }
}
