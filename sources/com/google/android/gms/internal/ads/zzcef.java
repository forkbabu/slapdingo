package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcef implements zzela<zzcdw> {
    private final zzelj<zzcgr> zzewj;
    private final zzelj<zzchw> zzfzg;

    public zzcef(zzelj<zzchw> zzelj, zzelj<zzcgr> zzelj2) {
        this.zzfzg = zzelj;
        this.zzewj = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcdw(this.zzfzg.get(), this.zzewj.get());
    }
}
