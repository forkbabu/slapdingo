package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctx implements zzela<zzctu> {
    private final zzelj<zzcis> zzero;
    private final zzelj<zzdli> zzesx;
    private final zzelj<zzckx> zzesy;

    private zzctx(zzelj<zzdli> zzelj, zzelj<zzcis> zzelj2, zzelj<zzckx> zzelj3) {
        this.zzesx = zzelj;
        this.zzero = zzelj2;
        this.zzesy = zzelj3;
    }

    public static zzctx zzp(zzelj<zzdli> zzelj, zzelj<zzcis> zzelj2, zzelj<zzckx> zzelj3) {
        return new zzctx(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzctu(this.zzesx.get(), this.zzero.get(), this.zzesy.get());
    }
}
