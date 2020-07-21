package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrk implements zzela<zzbyg<zzbva>> {
    private final zzelj<zzbrj> zzfmj;
    private final zzbrl zzfqr;

    private zzbrk(zzbrl zzbrl, zzelj<zzbrj> zzelj) {
        this.zzfqr = zzbrl;
        this.zzfmj = zzelj;
    }

    public static zzbrk zza(zzbrl zzbrl, zzelj<zzbrj> zzelj) {
        return new zzbrk(zzbrl, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmj.get(), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
