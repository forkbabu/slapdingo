package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdx implements zzela<zzcdo> {
    private final zzelj<zzcgr> zzewj;
    private final zzelj<zzccs> zzewp;
    private final zzelj<zzchw> zzfzg;
    private final zzelj<zzbmh> zzfzh;

    public zzcdx(zzelj<zzchw> zzelj, zzelj<zzcgr> zzelj2, zzelj<zzbmh> zzelj3, zzelj<zzccs> zzelj4) {
        this.zzfzg = zzelj;
        this.zzewj = zzelj2;
        this.zzfzh = zzelj3;
        this.zzewp = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcdo(this.zzfzg.get(), this.zzewj.get(), this.zzfzh.get(), this.zzewp.get());
    }
}
